package com.limiter.model;

public class LimiterChain {

	private LimitCheckable limiters;

	/**
	 * @return the limiters
	 */
	public LimitCheckable getLimiters() {
		return limiters;
	}

	/**
	 * @param limiters the limiters to set
	 */
	public void setLimiters(LimitCheckable limiters) {
		this.limiters = limiters;
	}

	

}
