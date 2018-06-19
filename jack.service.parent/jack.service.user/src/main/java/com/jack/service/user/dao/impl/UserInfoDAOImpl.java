package com.jack.service.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.jack.service.api.user.model.UserInfo;
import com.jack.service.common.exception.JdbcException;
import com.jack.service.common.jdbc.BaseJdbcTemplate;
import com.jack.service.common.sqlconfig.SqlConfig;
import com.jack.service.user.dao.UserInfoDAO;

/**
 * 
 * @ClassName: UserInfoDAOImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:28:46
 */
@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private BaseJdbcTemplate baseJdbcTemplate;

	@Autowired
	@Qualifier("sql_userinfo")
	private SqlConfig sqlConfig;

	/**
	 * 
	 * @Description:
	 * @param userInfo
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-08 15:25:13
	 */
	@Override
	public boolean register(UserInfo userInfo) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", userInfo.getId());
		paramMap.put("NAME", userInfo.getName());
		paramMap.put("PASSWORD", userInfo.getPassword());
		paramMap.put("PHONE", userInfo.getPhone());
		paramMap.put("MAIL", userInfo.getMail());
		String sql = sqlConfig.getSql("register");
		if (StringUtils.isNotEmpty(sql)) {
			DataSource dataSource = baseJdbcTemplate.getDataSource();
			Connection conn = DataSourceUtils.getConnection(dataSource);
			try {
				conn.setAutoCommit(false);
				baseJdbcTemplate.jdbcExect(conn, sql, paramMap);
				conn.commit();
				return true;
			} catch (Exception exception) {
				try {
					conn.rollback();
				} catch (SQLException sqlException) {

				}
				DataSourceUtils.releaseConnection(conn, dataSource);
				conn = null;
				throw new JdbcException(exception.getMessage());
			} finally {
				DataSourceUtils.releaseConnection(conn, dataSource);
				conn = null;
			}
		}
		return false;
	}

	/**
	 * 
	 * @Description:
	 * @param sql
	 * @param param
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-08 14:55:36
	 */
	private UserInfo doGetUserInfo(String sql, String param) {
		try {
			if (StringUtils.isNotEmpty(sql)) {
				sql = StringUtils.replaceOnce(sql, "?", param);
				List<UserInfo> userInfos = baseJdbcTemplate.query(sql, new UserInfoRowMapper());
				if (CollectionUtils.isNotEmpty(userInfos)) {
					return userInfos.get(0);
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 
	 * @Description:
	 * @param name
	 * @param password
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-07 14:29:00
	 */
	@Override
	public UserInfo getUserInfoByName(String name) {
		return doGetUserInfo(sqlConfig.getSql("getUserInfoByName"), name);
	}

	/**
	 * 
	 * @Description:
	 * @param name
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-08 13:34:34
	 */
	@Override
	public UserInfo getUserInfoByMail(String mail) {
		return doGetUserInfo(sqlConfig.getSql("getUserInfoByMail"), mail);
	}

	/**
	 * 
	 * @Description:
	 * @param name
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-08 13:33:00
	 */
	@Override
	public UserInfo getUserInfoByPhone(String phone) {
		return doGetUserInfo(sqlConfig.getSql("getUserInfoByPhone"), phone);
	}

	/**
	 * 
	 * @ClassName: UserInfoRowMapper
	 * @Description:
	 * @author lksoulman
	 * @date 2018-06-08 15:00:37
	 */
	public class UserInfoRowMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo userInfo = new UserInfo();
			userInfo.setId(rs.getLong("ID"));
			userInfo.setName(rs.getString("NAME"));
			userInfo.setPassword(rs.getString("PASSWORD"));
			userInfo.setPhone(rs.getString("PHONE"));
			userInfo.setMail(rs.getString("MAIL"));
			return userInfo;
		}
	}
}
