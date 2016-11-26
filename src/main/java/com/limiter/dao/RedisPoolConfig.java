/**
 * 
 */
package com.limiter.dao;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author braj.kishore
 *
 */
public class RedisPoolConfig {

	private JedisPoolConfig poolConfig=null;
	public RedisPoolConfig(Integer maxTotal,Integer maxIdle,Long maxWaitMillis){
		  poolConfig=new JedisPoolConfig();
		  poolConfig.setMaxWaitMillis(maxWaitMillis);
		  poolConfig.setMaxTotal(maxTotal);
		  poolConfig.setMaxIdle(maxIdle);		  
		  poolConfig.setMinIdle(1);
		  poolConfig.setTestOnBorrow(true);
		  poolConfig.setTestOnReturn(true);
		  poolConfig.setTestWhileIdle(true);
		  poolConfig.setNumTestsPerEvictionRun(10);
		  poolConfig.setTimeBetweenEvictionRunsMillis(60000);
	}
	
	
	
	public JedisPoolConfig getConfig(){
		return this.poolConfig;
	}
}
