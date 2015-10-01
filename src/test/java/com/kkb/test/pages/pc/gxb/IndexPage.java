package com.kkb.test.pages.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 首页 page
 * @date 2015.09.14
 */
public class IndexPage extends Page {

	public IndexPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(linkText = "首页")
	public WebElement mianPage;

	@FindBy(linkText = "课程")
	public WebElement course;

	@FindBy(linkText = "个人中心")
	public WebElement personCenter;

	@FindBy(linkText = "管理员入口")
	public WebElement adminLogin;

	@FindBy(linkText = "登录/注册")
	public WebElement tologinBtn;
	
	/**
	 * 首页轮播图
	 */
	@FindBy(className = "imgContent")
	public WebElement imgContent;
	/**
	 * 学院名称
	 */
	@FindBy(xpath = "//div[@class='schoolIntroduce']/h1")
	public WebElement introduceTitle;
	/**
	 * 学院名称详细
	 */
	@FindBy(xpath = "//div[@class='schoolIntroduce']/p")
	public WebElement introduceDetails;
	
	/**
	 * 公告标题
	 */
	@FindBy(xpath = "//div[@class='layout-row02']/div/ul/li[2]/h1/a")
	public List<WebElement> noticeTitle;
	
	/**
	 * 精品课程
	 */
	@FindBy(xpath = "//div[@class='listenContent']")
	public List<WebElement> perfectCourse;
	
	/**
	 * 教师风采
	 */
	@FindBy(xpath = "//div[@class='teacher']/ul/li")
	public List<WebElement> teachersInfo;
	
	/**
	 * 学院介绍
	 */
	@FindBy(xpath = "//div[@class='introduce']")
	public WebElement introduce;
	
	/**
	 * 学院照片
	 */
	@FindBy(xpath = "//div[@class='teacher']/ul/li")
	public List<WebElement> demeanour;
	
	/**
	 * 学院新闻动态
	 */
	@FindBy(xpath = "//div[@class='introduce']")
	public WebElement news;
	
	

	/**
	 * 用户信息 用于判断是否登录
	 */
	@FindBy(xpath = "//div[@id='userInfo']/a")
	public WebElement loginInfo;

}
