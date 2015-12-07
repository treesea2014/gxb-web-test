package com.kkb.test.actions.pc.gxb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.kkb.test.pages.pc.gxb.CourseDetailsPage;
import com.kkb.test.pages.pc.gxb.CourseLearnPage;
import com.kkb.test.pages.pc.gxb.CoursePage;



/**
 * @author sh.deng
 * @description 高校帮 课程学习动作
 * @date 2015.10.12
 */
public class CommonCourseQuizAct  extends CommonCourseDetailsAct{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(CommonCourseQuizAct.class);

	private CourseLearnPage courseLearnPage;

	
	/**
	 *          
	 * @param driver
	 */
	public CommonCourseQuizAct(WebDriver driver) {
		super(driver);
		courseLearnPage = new CourseLearnPage(driver);
	}
	/**
	 * 点击左侧测验
	 */
	public void clickQuiz(){
		logger.info("点击左侧测验");
		click(courseLearnPage.quizz);
	}
	
	/**
	 * 获取测验链接
	 * @return 
	 */
	public  ArrayList<String> quizList(){
		List<WebElement> goToTestList =  courseLearnPage.goToTest;
		ArrayList<String> quizUrls = new ArrayList<String>() ;
		for(WebElement gotoTest : goToTestList){
			quizUrls.add(gotoTest.getAttribute("gotoTest"));
		}
		logger.info("获取测验链接："+quizUrls.toString());
		return quizUrls;
	}
	
	/**
	 * 开始测试
	 */
	public void clickStartTest(){
		logger.info("点击开始测验按钮");
		click(courseLearnPage.startTest);
	}
	
	/**
	 * 开始测试
	 */
	public void showQuizTitle(String courseName){
		String quizTitle = courseName+"--"+getText(courseLearnPage.quizTitle).substring(3);
		logger.info("测验名称：{}",quizTitle);

	}
	
	/**
	 * 全选A B C D
	 */
	public void selectOption( String option){
		switch(option!=null?option.toUpperCase():""){
		case "A":
			logger.info("选择A");
			for(WebElement e : courseLearnPage.option_A ){
				click(e);
			};
			break;
		case "B":
			logger.info("选择B");

			for(WebElement e : courseLearnPage.option_B ){
				click(e);
			};
			break;

		case "C":
			logger.info("选择C");

			for(WebElement e : courseLearnPage.option_C ){
				click(e);
			};
			break;

		case "D":
			logger.info("选择D");

			for(WebElement e : courseLearnPage.option_D ){
				click(e);
			};
			break;

		default:
			logger.info("选择默认A");

			for(WebElement e : courseLearnPage.option_A ){
			click(e);
		};
		break;
		}
	}
	
	/**
	 * 点击保存按钮
	 */
	public void clickSaveQuiz(){
		logger.info("点击保存测验按钮");
		click(courseLearnPage.quizSave);
	}
	/**
	 * 点击提交测验按钮
	 */
	public void clickSubmitQuiz(){
		logger.info("点击提交测验按钮");
		click(courseLearnPage.quizSave);
	}
	
	/**
	 * 检查测验
	 */
	public void quizCheck(String courseName){
		//获取前往测试按钮的个数
		int size = courseLearnPage.goToTest.size();
		for(int i = 0 ; i<size ;i++){
			//考虑到页面变化 最好重新获取一遍
			List<WebElement> testBtns  = driver.findElements(By.xpath(courseLearnPage.goToTestXpath));
			List<WebElement> quizTitleList  = driver.findElements(By.xpath(courseLearnPage.quizNameXpath));
			logger.info("测验名称：{}",quizTitleList.get(i).getText());
			//点击前往测试按钮
			click(testBtns.get(i));
			//点击开始测验
			click(courseLearnPage.startTest);
			//判断测验提交按钮是否存在
			if(isElementExist(courseLearnPage.quizSaveXpath, 5)){
				//showQuizTitle(courseName);
				//全部选择A
				this.selectOption("A");
				//点击保存
				this.clickSaveQuiz();
				pause(1);
				//截图
				this.snapshot();
			}else{
				//截图
				this.snapshot();
			}
			goback();
		
		}
			

	}
}
