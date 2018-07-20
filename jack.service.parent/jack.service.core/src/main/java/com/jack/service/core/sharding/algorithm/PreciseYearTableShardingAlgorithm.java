package com.jack.service.core.sharding.algorithm;

import java.sql.Timestamp;
import java.util.Collection;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

/**
 * 
 * @ClassName: PreciseYearTableShardingAlgorithm 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-25 16:24:45
 */
@Component
public class PreciseYearTableShardingAlgorithm implements PreciseShardingAlgorithm<Timestamp> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Timestamp> shardingValue) {
		String value = DateFormatUtils.format(shardingValue.getValue(), "yyyy");
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(value)) {
				return tableName;
			}
		}

		throw new UnsupportedOperationException();
	}

}
