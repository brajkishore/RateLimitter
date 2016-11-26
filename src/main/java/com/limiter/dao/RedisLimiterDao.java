/**
 * 
 */
package com.limiter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisPool;

/**
 * @author braj.kishore
 *
 */

@Repository("limiterDao")
public class RedisLimiterDao implements LimiterDao {

	@Autowired
	private JedisPool jedisPool;

	public String getValue(String key) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().get(key);		
	}

	public boolean setValue(String key,String value) {
		// TODO Auto-generated method stub
		String s= jedisPool.getResource().set(key, value);
		if(s!=null)
			return true;
				
		return false;
	}

	public boolean setExpire(String key, long timeout) {
		// TODO Auto-generated method stub
		
		long l=jedisPool.getResource().pexpire(key, timeout);
		if(l>0)
		return true;
		
		return false;
	}

	public long increament(String key, long incr) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().incrBy(key, incr);		
	}
}