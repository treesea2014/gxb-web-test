package com.kkb.test.pages.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 课程page
 * @date 2015.09.14
 */
public class CoursePage extends Page {

	public CoursePage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * 课程信息
	 */
	@FindBy(xpath = "//div[@class='courseInfo']/div/h3")
	public WebElement headCourseInfo;
	
	/**
	 * 课程名称
	 */
//	@FindBy(xpath = "//div[@class='caption guide']/div/h4")
	@FindBy(xpath = "//div[@class='caption']/div/h2")
	public List<WebElement> courseNameList;
    public String courseNameListXpath ="//div[@class='caption']/div/h2";

	/**
	 * 下一页
	 */
//	@FindBy(xpath = "//span[text()='下一页']")
	@FindBy(xpath = "//*[@id='pagination']/div/ul/li[text()='下一页']")
	public WebElement nextPage;


	/**
	 * 判断下一页是否可以点击
	 */
//	public String nextPageIsEnableXpath = "//*[@class='pagination']/li[last()]";
	public String nextPageIsEnableXpath = "//*[@id='pagination']/div/ul/li[last()]";
	/**
	 * 课程类型
	 */
	@FindBy(xpath = "//div[@class='course-type']")
	public List<WebElement> courseType;
	
	/**
	 * 课程信息
	 */
	@FindBy(xpath = "//div[@class='course-info']")
	public List<WebElement> bodyCourseInfo;
	
	/**
	 * 课程简介
	 */
	@FindBy(xpath = "//div[@class='course-intro']")
	public List<WebElement> bodyCoursentro;
	
	/**
	 * 课程星级评价
	 */
	@FindBy(xpath = "//div[@class='course-review']/span[1]/span[2]")
	public List<WebElement> bodyCourseStars;
	
	/**
	 * 参与人数
	 */
	@FindBy(xpath = "//div[@class='course-review']/span[2]/span")
	public List<WebElement> bodyCoursePeoples;
	
	/**
	 * 合作课程信息
	 */
	@FindBy(xpath = "//div[@class='row']/div/a/div/div[2]")
	public List<WebElement> cooperationCourse;
	
	/**
	 * 课程查询输入框
	 */
	@FindBy(xpath = "//div[@class='search-box']/input")
	public WebElement searchInput;
	
	/**
	 * 查询
	 */
	@FindBy(xpath = "//div[@class='search-box']/i")
	public WebElement searchBth;
	
	/**
	 * 点击搜索的课程
	 */
	@FindBy(xpath = "(//div[@class='caption']/div/h2)[1]")
	public WebElement searchResult;
	
}
