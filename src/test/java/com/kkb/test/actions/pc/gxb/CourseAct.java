package com.kkb.test.actions.pc.gxb;

import java.util.List;

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

}
