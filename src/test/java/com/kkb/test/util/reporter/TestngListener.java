package com.kkb.test.util.reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.kkb.test.steps.BaseStep;


public class TestngListener  extends TestListenerAdapter {
	/**
	 * slf4j logback
	 */
	private final  Logger logger = LoggerFactory.getLogger(TestngListener.class);
	public  final String CONFIG = "config.properties";

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
		takeScreenShot(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
	}


	/**
	 * 自动截图，保存图片到本地以及html结果文件中
	 * 
	 * @param tr
	 */
	private void takeScreenShot(ITestResult tr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String fileName = mDateTime + "_" +tr.getName();
		//
		String imgUrl = "screenshot/" + fileName + ".jpg";
		File scrFile = ((TakesScreenshot)(BaseStep.driver)).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("test-output/html" + File.separator
				+ imgUrl);
		try {
			FileUtils.copyFile(scrFile, screenshot);
		} catch (IOException e) {
			logger.error("截图操作失败" + e.getMessage());
		}
		Reporter.setCurrentTestResult(tr);
		//Reporter.log(imgUrl+"\n");
		Reporter.log("<a href=\""+imgUrl+"\""+" target=\""+"_blank\""+">\n");
		Reporter.log("<img height=\"200px\" width=\"200px\" src=\"" +imgUrl  + "\"/></a>\n");


	}

}