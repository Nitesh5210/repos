package com.Zurich.Genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	int count=0;
	int maxretry=4;
	@Override
	public boolean retry(ITestResult result) {
if (count<maxretry) {
	count++;
	return true;
}		return false;
	}

}
