/**
 * 
 */
package com.limiter.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.limiter.services.RateLimiterService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author braj.kishore
 *
 */
public class SpringUtil {

	private static final String JEDIS_POOL = "jedisPool";
	private static final String RATE_LIMITER_SERVICE = "rateLimiterService";
	private static ApplicationContext context=null;
	private static Jedis jedis;
	
	private static final String contextPath="C:\\Users\\braj.kishore\\Documents\\nroutes-workspace\\rate-limiter\\resources\\app-context.xml";	
	public static boolean init(){
			context = new FileSystemXmlApplicationContext(contextPath);
			JedisPool pool=context.getBean(JEDIS_POOL,JedisPool.class);
			jedis=pool.getResource();
		return true;
	}
	
	public static Jedis getJedis(){
		return jedis;
	}
	
	public static RateLimiterService getServiceBean(){
		return context.getBean(RATE_LIMITER_SERVICE,RateLimiterService.class);
	}
	
}
