/**
 * 
 */
package com.limiter.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.limiter.dao.LimiterDao;

/**
 * @author braj.kishore
 *
 */
public class LimiterInfo implements LimitCheckable {
	
	@Autowired
	@Qualifier("limiterDao")
	private LimiterDao limiterDao;
	
	private String type;
	private long maxLimit;
	private long expDurationMillis;
	private LimitCheckable nextChecker;

	/**
	 * @return the maxLimit
	 */
	public long getMaxLimit() {
		return maxLimit;
	}

	/**
	 * @param maxLimit the maxLimit to set
	 */
	public void setMaxLimit(long maxLimit) {
		this.maxLimit = maxLimit;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String checkLimit(String key) {
		// TODO Auto-generated method stub
		String res="";
		if(nextChecker!=null)
				res=nextChecker.checkLimit(key);
					if(!res.isEmpty())
							return res;
							
		String formattedKey=key+type;
		long cLimit=limiterDao.increament(formattedKey,1);
		
		if(cLimit==1)
			limiterDao.setExpire(formattedKey, expDurationMillis);
		
		if(cLimit>maxLimit)
			return type+":Limit crossed";
		
		System.out.println("key->"+formattedKey+"->cLimit->"+cLimit);
		
		return "";
	}

	/**
	 * @return the expDurationMillis
	 */
	public long getExpDurationMillis() {
		return expDurationMillis;
	}

	/**
	 * @param expDurationMillis the expDurationMillis to set
	 */
	public void setExpDurationMillis(long expDurationMillis) {
		this.expDurationMillis = expDurationMillis;
	}

	/**
	 * @return the nextChecker
	 */
	public LimitCheckable getNextChecker() {
		return nextChecker;
	}

	/**
	 * @param nextChecker the nextChecker to set
	 */
	public void setNextChecker(LimitCheckable nextChecker) {
		this.nextChecker = nextChecker;
	}
	
}
