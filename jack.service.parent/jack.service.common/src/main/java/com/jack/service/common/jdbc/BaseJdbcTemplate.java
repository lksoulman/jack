package com.jack.service.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.Assert;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.ObjectUtils;

import com.jack.service.common.exception.JdbcException;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * 
 * @ClassName: BaseJdbcTemplate
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:19:02
 */
public class BaseJdbcTemplate extends NamedParameterJdbcTemplate {

	private DataSource dataSource;

	@Override
	public JdbcOperations getJdbcOperations() {
		return super.getJdbcOperations();
	}

	/**
	 * @param dataSource
	 */
	public BaseJdbcTemplate(DataSource dataSource) {
		super(dataSource);
		this.dataSource = dataSource;
	}

	public int jdbcExect(Connection conn, String sql, Map<String, Object> paramMap) throws JdbcException {
		PreparedStatement ps = null;
		try {
			PreparedStatementCreator psc = getPreparedStatementCreator(sql, new MapSqlParameterSource(paramMap));
			ps = psc.createPreparedStatement(conn);
			int rows = ps.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtils.closeStatement(ps);
			ps = null;
			if (e instanceof SQLServerException) {
				SQLServerException sqlex = (SQLServerException) e;
				throw new JdbcException(sqlex.getMessage());
			} else if (e instanceof DataAccessException) {
				throw new JdbcException(e.getMessage());
			}
		} finally {
			JdbcUtils.closeStatement(ps);
		}
		return 0;
	}

	public boolean jdbcQuery(Connection conn, String sql) throws JdbcException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			PreparedStatementCreator psc = new SimplePreparedStatementCreator(sql);
			ps = psc.createPreparedStatement(conn);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			ps = null;
			if (e instanceof SQLServerException) {
				SQLServerException sqlex = (SQLServerException) e;
				throw new JdbcException(sqlex.getMessage());
			}
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
		}
		return true;
	}

	public Map<String, Object> jdbcQueryMap(Connection conn, String sql) throws JdbcException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			PreparedStatementCreator psc = new SimplePreparedStatementCreator(sql);
			ps = psc.createPreparedStatement(conn);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			Map<String, Object> mapOfColValues = createColumnMap(columnCount);
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
					Object obj = getColumnValue(rs, i);
					mapOfColValues.put(key, obj);
				}
			}
			return mapOfColValues;
		} catch (Exception e) {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			ps = null;
			if (e instanceof SQLServerException) {
				SQLServerException sqlex = (SQLServerException) e;
				throw new JdbcException(sqlex.getMessage());
			}
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
		}
		return null;
	}

	protected Map<String, Object> createColumnMap(int columnCount) {
		return new LinkedCaseInsensitiveMap<Object>(columnCount);
	}

	protected String getColumnKey(String columnName) {
		return columnName;
	}

	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

	public int jdbcSimpleExect(Connection conn, String sql, Object... args) throws JdbcException {
		PreparedStatement ps = null;
		try {
			PreparedStatementSetter pss = newArgPreparedStatementSetter(args);
			PreparedStatementCreator psc = new SimplePreparedStatementCreator(sql);
			ps = psc.createPreparedStatement(conn);
			if (pss != null) {
				pss.setValues(ps);
			}
			int rows = ps.executeUpdate();
			return rows;
		} catch (Exception e) {
			JdbcUtils.closeStatement(ps);
			ps = null;
			if (e instanceof SQLServerException) {
				SQLServerException sqlex = (SQLServerException) e;
				throw new JdbcException(sqlex.getMessage());
			} else if (e instanceof DataAccessException) {
				throw new JdbcException(e.getMessage());
			}
		} finally {
			JdbcUtils.closeStatement(ps);
		}
		return 0;
	}

	private static class SimplePreparedStatementCreator implements PreparedStatementCreator, SqlProvider {
		private final String sql;

		public SimplePreparedStatementCreator(String sql) {
			Assert.notNull(sql, "SQL must not be null");
			this.sql = sql;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			return con.prepareStatement(this.sql);
		}

		@Override
		public String getSql() {
			return this.sql;
		}
	}

	protected PreparedStatementSetter newArgPreparedStatementSetter(Object[] args) {
		return new ArgumentPreparedStatementSetter(args);
	}

	/**
	 * @param sql
	 * @param args
	 * @return
	 * @throws DataAccessException
	 * @datetime 2016年7月27日/上午9:25:57
	 * @author wanghui
	 * @desc 使用prpt方式查询返回list
	 */
	public List<Map<String, Object>> queryForList(String sql, Object... args) throws DataAccessException {
		return (ObjectUtils.isEmpty(args) ? getJdbcOperations().queryForList(sql)
				: getJdbcOperations().queryForList(sql, getArguments(args)));
	}

	/**
	 * @param sql
	 * @param args
	 * @return
	 * @throws DataAccessException
	 * @datetime 2016年7月27日/上午9:27:45
	 * @author wanghui
	 * @desc 使用prpt方式修改
	 */
	public int update(String sql, Object... args) throws DataAccessException {
		return (ObjectUtils.isEmpty(args) ? getJdbcOperations().update(sql)
				: getJdbcOperations().update(sql, getArguments(args)));
	}

	private Object[] getArguments(Object[] varArgs) {
		if (varArgs.length == 1 && varArgs[0] instanceof Object[]) {
			return (Object[]) varArgs[0];
		} else {
			return varArgs;
		}
	}

	/**
	 * @author denghc
	 */
	public int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder) throws DataAccessException {
		return getJdbcOperations().update(psc, generatedKeyHolder);
	}

	/**
	 * @author denghc
	 */
	public <T> T query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse) throws DataAccessException {
		return getJdbcOperations().query(sql, pss, rse);
	}

	public void execute(final String sql) throws DataAccessException {
		getJdbcOperations().execute(sql);
	}

	public SqlRowSet queryForRowSet(String sql) throws DataAccessException {
		return query(sql, new SqlRowSetResultSetExtractor());
	}

	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
		List<T> results = query(sql, rowMapper);
		return DataAccessUtils.requiredSingleResult(results);
	}

	public Map<String, Object> queryForMap(String sql, Object[] args, int[] argTypes) throws DataAccessException {
		return getJdbcOperations().queryForMap(sql, args, argTypes);
	}

	public Map<String, Object> queryForMap(String sql, Object... args) throws DataAccessException {
		return getJdbcOperations().queryForMap(sql, args);
	}

	public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
		return getJdbcOperations().queryForObject(sql, requiredType);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws DataAccessException {
		return getJdbcOperations().batchUpdate(sql, batchArgs, new int[0]);
	}

	public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
		return getJdbcOperations().query(sql, rse);
	}

	public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
		return getJdbcOperations().execute(action);
	}

	public <T> T query(String sql, Object[] args, ResultSetExtractor<T> rse) throws DataAccessException {
		return getJdbcOperations().query(sql, args, rse);
	}

	public <T> T execute(String callString, CallableStatementCallback<T> action) throws DataAccessException {
		return getJdbcOperations().execute(callString, action);
	}

	public <T> List<T> queryForList(String sql, Class<T> clazz) throws DataAccessException {
		return getJdbcOperations().queryForList(sql, clazz);
	}

	public <T> T queryForObject(String sql, Class<T> requiredType, Object... args) throws DataAccessException {
		return getJdbcOperations().queryForObject(sql, requiredType, args);
	}

	public int updateKey(String sql, Map<String, ?> paramMap) throws DataAccessException {
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		update(sql, new MapSqlParameterSource(paramMap), generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}
}
