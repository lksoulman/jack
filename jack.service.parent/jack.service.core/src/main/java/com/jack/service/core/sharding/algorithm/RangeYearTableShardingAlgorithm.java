package com.jack.service.core.sharding.algorithm;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Component;

import com.google.common.collect.Range;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;

/**
 * 
 * @ClassName: RangeYearTableShardingAlgorithm
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 16:30:36
 */
@Component
public class RangeYearTableShardingAlgorithm implements RangeShardingAlgorithm<Timestamp> {

	@Override
	public Collection<String> doSharding(Collection<String> availableTargetNames,
			RangeShardingValue<Timestamp> shardingValue) {
		Range<Timestamp> range = shardingValue.getValueRange();
		Collection<String> result = new ArrayList<String>();
		Date lower = null;
		Date upper = null;
		Object lowerObj = range.lowerEndpoint();
		Object upperObj = range.upperEndpoint();
		try {
			if (lowerObj instanceof Date) {
				lower = (Date) lowerObj;
			} else {
				lower = doParseDate("yyyy", lowerObj.toString());
			}
			if (upperObj instanceof Date) {
				upper = (Date) upperObj;
			} else {
				upper = doParseDate("yyyy", upperObj.toString());
			}
		} catch (Exception e) {

			return availableTargetNames;
		}
		Calendar calendar = Calendar.getInstance();// 定义日期实例
		calendar.setTime(lower);
		while (calendar.getTime().before(upper) || calendar.getTime().equals(upper)) {
			String value = DateFormatUtils.format(calendar, "yyyy");
			availableTargetNames.forEach(v -> {
				if (v.endsWith(value)) {
					result.add(v);
				}
			});
			calendar.add(Calendar.YEAR, 1);
		}
		return result;
	}

	private Date doParseDate(String pattern, String str) throws ParseException {
		return FastDateFormat.getInstance(pattern).parse(str);
	}
}
