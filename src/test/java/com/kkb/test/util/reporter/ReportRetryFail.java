package com.kkb.test.util.reporter;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReportRetryFail implements IRetryAnalyzer{
	/**
	 * slf4j logback
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(ReportRetryFail.class);
	private static String m_maxRetries = "";
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("selenium");
		m_maxRetries = bundle.getString("m_maxRetries");
	}
	 
     private final int m_sleepBetweenRetries = 1000;
     private int currentTry;
     private String previousTest = null;
     private String currentTest = null;
     public ReportRetryFail()
     {
         currentTry = 0;
     }

     @Override
     public boolean retry(final ITestResult result)
     {
         // If a testcase has succeeded, this function is not called.        
         boolean retValue = false;        
         
         // Getting the max retries from suite.
        // String maxRetriesStr = result.getTestContext().getCurrentXmlTest().getParameter("maxRetries");
        String maxRetriesStr = result.getTestContext().getSuite().getParameter("maxRetries");
         int maxRetries = Integer.parseInt(m_maxRetries);
         if(maxRetriesStr != null)
         {
             try        
             {
                 maxRetries = Integer.parseInt(maxRetriesStr);
             }
             catch (final NumberFormatException e)
             {
                logger.info("NumberFormatException while parsing maxRetries from suite file." + e);
             }
         }
        
         // Getting the sleep between retries from suite.you can from the suite parameter 
         String sleepBetweenRetriesStr = result.getTestContext().getSuite().getParameter("sleepBetweenRetries");
         int sleepBetweenRetries = m_sleepBetweenRetries;
         if(sleepBetweenRetriesStr != null)
         {
             try        
             {
                 sleepBetweenRetries = Integer.parseInt(sleepBetweenRetriesStr);
             }
             catch (final NumberFormatException e)
             {
            	 logger.info("NumberFormatException while parsing sleepBetweenRetries from suite file." + e);
             }
         }
         
         currentTest = result.getTestContext().getCurrentXmlTest().getName();
         
         if (previousTest == null)
         {
             previousTest = currentTest;
         }
         if(!(previousTest.equals(currentTest)))
         {
             currentTry = 0;
         }
        
         if (currentTry < maxRetries &&!result.isSuccess())
         {
             try
             {
                 Thread.sleep(sleepBetweenRetries);
             }
             catch (final InterruptedException e)
             {
                 e.printStackTrace();
             }
             currentTry++;  
             result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
             retValue = true;
                       
         }
         else
         {
             currentTry = 0;
         }
         previousTest = currentTest;
         // if this method returns true, it will rerun the test once again.
         
      
         return retValue;
     }
	
}
