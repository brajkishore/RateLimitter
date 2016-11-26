/**
 * 
 */
package com.limiter.dao;

/**
 * @author braj.kishore
 *
 */
public interface LimiterDao {
	String getValue(String key);
	boolean setValue(String key,String value);
	long increament(String key,long incr);
	boolean setExpire(String key,long timeout);
}
