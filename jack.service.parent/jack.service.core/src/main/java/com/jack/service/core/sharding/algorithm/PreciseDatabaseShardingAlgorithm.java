package com.jack.service.core.sharding.algorithm;

import java.util.Collection;

import org.springframework.stereotype.Component;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

/**
 * 
 * @ClassName: PreciseDatabaseShardingAlgorithm
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 16:24:55
 */
@Component
public class PreciseDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
		return "jackdb";
	}
}
