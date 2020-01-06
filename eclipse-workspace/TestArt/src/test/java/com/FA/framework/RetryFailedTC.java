/**
 * 
 */
package com.FA.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.FA.framework.TestNGListeners.resultStatus;

/**
 * @author ajp16088
 *
 */
public class RetryFailedTC implements IRetryAnalyzer {
	
	private int retryCount;
    private int maxRetryCount;
    
	public RetryFailedTC() {
		
		retryCount = 0;
		maxRetryCount = 1;
	}	

	@Override
	public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {            
            retryCount++;
            System.out.println(" ******----****** Retrying test " + result.getName() +" with status " + resultStatus(result.getStatus()) + " for the " + (retryCount) + " time(s). ******----****** ");
            return true;
        }
		return false;
	}

}
