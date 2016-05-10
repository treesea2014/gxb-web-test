package com.kkb.test.actions.pc.gxb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.kkb.test.pages.pc.gxb.CoursePage;



/**
 * @author sh.deng
 * @description 首页页面动作
 * @date 2015.09.14
 */
public class CourseAct  extends IndexAct{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(CourseAct.class);
	/**
	 *高校帮登陆页面
	 */
	private CoursePage coursePage;
	
	/**
	 * 
	 * @param driver
	 */
	public CourseAct(WebDriver driver) {
		super(driver);
		coursePage= new CoursePage(driver);
	}
	
	/**
	 * 获取课程列表信息 
	 * 点击第一门课程
	 * @return 
	 */
	public  String clickFirstCourse() {
		List<WebElement> courseNameList = coursePage.courseNameList ;
		for(int i = 0 ;i<courseNameList.size() ; i++){
			//logger.info("*********{}********",i);
			//logger.info("课程名称:{}",getText(courseNameList.get(i)));
			/*logger.info("课程类型:{}",getText(coursePage.courseType.get(i)));
			logger.info("课程信息:{}",getText(coursePage.bodyCourseInfo.get(i)));
			logger.info("课程简介:{}",getText(coursePage.bodyCoursentro.get(i)));
			logger.info("课程星级评价:{}",getText(coursePage.bodyCourseStars.get(i)));
			logger.info("参与人数:{}",getText(coursePage.bodyCoursePeoples.get(i)));*/
		}
		//点击第一门课程
		String firstCourse = getText(courseNameList.get(1));
		click(courseNameList.get(1));
		return firstCourse ;
	}
	
	public void inputSearchContent(String name){
		logger.info("搜索框内输入课程名称：{}",name);
		type(coursePage.searchInput,name);
		logger.info("点击搜索",name);
		this.pause(5);
		click(coursePage.searchBth);
		this.pause(5);
		boolean flag = this.isElementExist("//div[@class='course-content']/h1", 5);
		if(flag){
			click(coursePage.searchResult);
		}else{
			Assert.fail("课程不存在：【"+name);
		}
	}

	/***
	 * 逐页查找课程名
	 * @param searchcourseName
     */
	public void searchCourseNameByPerPage(String searchcourseName){
		boolean falg = false;
		while (!falg){
			falg = searchCourseName(searchcourseName);
			//如果未找到
			if(!falg){
				WebElement e  = driver.findElement(By.xpath(coursePage.nextPageIsEnableXpath));
				String nextPageClass = e.getAttribute("class");
				//判断是否到达最后一页,如果是最后一页还没有找到的话,就是找不到了 哈哈
				if(nextPageClass.contains("disabled")){
					Assert.fail("课程不存在：【"+searchcourseName);
					break;
				}else{
					pause(2);
					click(coursePage.nextPage);
					pause(1);
				}
			}else {
				//找到了就break
				break;

			}
		}
	}

	/**
	 * 查询课程名称.
	 * @param searchCourseName
	 * @return
     */
	public boolean searchCourseName(String searchCourseName){
		List<WebElement> courselist = driver.findElements(By.xpath(coursePage.courseNameListXpath));
		WebElement webElement;
		boolean found  = false ;
		if(courselist.size()>0){
			for (int i = 0; i < courselist.size() ;i++){
				courselist = driver.findElements(By.xpath(coursePage.courseNameListXpath));
				 webElement = courselist.get(i);
				//webElement = getStaleElemt(By.xpath("(//div[@class='caption guide']/div/h4)["+(i+1)+"]"));
				String courseName = webElement.getText();
				logger.info("查找课程名称:{}=={}",searchCourseName,courseName);
				if(courseName.toString().trim().contains(searchCourseName.trim())){
					logger.info("已找到:{}=={}",searchCourseName,courseName);
//					click(driver.findElement(By.xpath("(//div[@class='caption guide']/div/h4)["+(i+1)+"]")));
					click(driver.findElement(By.xpath("(//div[@class='caption']/div/h2)["+(i+1)+"]")));
					found = true;
					break;
				}
			}
		}
		return found;
	}


	/***
	 * 根据课程名称搜索
	 * @param searchcourseName
	 */
	public void searchCourseNameBySearchText(String searchcourseName){
		logger.info("搜索框内输入课程名称：{}",searchcourseName);
		String courseName = coursePage.searchInput.getText();
		type(coursePage.searchInput,searchcourseName);
		this.pause(5);
		click(coursePage.searchBth);
		logger.info("已找到:{}=={}",searchcourseName,courseName);
		this.pause(5);
		boolean flag = this.isElementExist("(//div[@class='caption']/div/h2)[1]", 5);
		if(flag){
			click(coursePage.searchResult);
		}else{
			Assert.fail("课程不存在：【"+searchcourseName + "】");
		}
	}
}
