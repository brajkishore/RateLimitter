/**
 * 
 */
package com.limiter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.limiter.model.LimiterChain;

/**
 * @author braj.kishore
 *
 */

@Service("rateLimiterService")
public class RateLimiterService {


	@Autowired
	@Qualifier("limiters")
	private LimiterChain limiters;
		
	public boolean checkLimit(String key){
		
	
		String s=limiters.getLimiters().checkLimit(key);
		if(!s.isEmpty()){
			System.out.println(s);
			return false;
		}
		
		return false;	
	}	
}
