package com.learn.limiter;

import com.limiter.util.SpringUtil;

/**
 * Hello world!
 *
 */
public class App 
{
		
    public static void main( String[] args ) throws InterruptedException
    {
    	SpringUtil.init();
    	String key="braj";
    	
    	for(int i=0;i<1000;i++){
    		SpringUtil.getServiceBean().checkLimit(key);
    		Thread.sleep(100);
    	}
    	
    }
}
