package com.kkb.test.pages.pc.gxb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.kkb.test.pages.Page;

/**
 * @author sh.deng
 * @description 高校帮 课程学习page
 * @date 2015.10.12
 */
public class CourseLearnPage extends Page {

	public CourseLearnPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	/*******************************左侧边栏start******************************/
	/**
	 * 课程公告
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[2]/a/span[2]")
	public WebElement announcements;
	
	/**
	 * 开始学习
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[2]/a/span[2]")
	public WebElement startLearn;
	
	/**
	 * 测验
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[3]/a/span[2]")
	public WebElement quizz;
	
	/**
	 * 作业
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[4]/a/span[2]")
	public WebElement assignments;
	
	/**
	 * 讨论区
	 */
	@FindBy(xpath = "//*[@id='menus_list']/li[5]/a/span[2]")
	public WebElement forums;

	/*******************************左侧边栏end******************************/
	
	/**
	 * 1级所有章节名称
	 */
	@FindBy(xpath = "//div[@class='unit-list']/h4[@class='gxb-cur-point']/span/parent::h4")
	public List<WebElement> chapterList;
	
	public String chapterListXpath = "//div[@class='unit-list']/h4[@class='gxb-cur-point']/span/parent::h4";


	/**
	 * 1级章打开的
	 */
	@FindBy(xpath = "//span[@class='gxb-icon-toggle toggle-chapter active']")
	public WebElement ActiveChapter;

	public String activeChapterXpath = "//span[@class='gxb-icon-toggle toggle-chapter active']";

	/**
	 * 第一级下所有的unitId
	 */
	@FindBy(xpath = "//div[@class='unit-list']")
	public List<WebElement> unitIdList;

	/**
	 * 2级所有章节名称
	 */
	@FindBy(xpath = "//div[@class='unit-list']/div[@style='display: block;']/h4")
	public List<WebElement> chapterList2;

	public String chapterList2Xpath = "//div[@class='unit-list']/div[@style='display: block;']/h4";

	/**
	 * 3级所有章节下的video类型的item
	 */
	@FindBy(xpath = "//*[@id='unitList']/div/div/ul[@style='display: block;']/li/h5/a[@content_type='Video']")
	public List<WebElement> chapterList3;

	/**
	 * 视频播放页面
	 */
	@FindBy(xpath = "//div[@class='player-video']/div[1]")
	public WebElement videoPlay;
	public String videoPlayXpath = "//div[@class='player-video']/div[1]";

	public String videoXpath = "//video";

	@FindBy(xpath = "//div[@class='jw-title jw-reset']/div[1]")
	public WebElement errorVideoTitle;
	/**
	 * 视频标题是否存在
	 */
	public String errorVideoTitleXpath = "//div[@class='jw-title jw-reset']/div[1]";





	/**
	 * 所有章节下课程
	 */
	@FindBy(xpath = "//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression']")
	@CacheLookup
	public List<WebElement> courseList;
	/**
	 * 所有章节下课程XPath
	 */
	public String courseListXpath = "//*[@class='panel active']/div[2]/div/div/ul/li/a[contains(@href,'#/chapters')][@data-type='Video']";
	/**
	 * 视频播放返回
	 */
	@FindBy(xpath = "//*[@href='#/units/index'][@class='back-btn']")
	public WebElement videoBack;

	/**
	 * 视频-播放按钮
	 */
	@FindBy(xpath = "//*[@id='home_video']/div[5]")
	public WebElement videoPlayBtn;
	/**
	 * 视频-暂停按钮
	 */
	@FindBy(id = "home_video_html5_api")
	public WebElement videoPauseBtn;
	
	
	/**
	 * 视频-本次观看时间%
	 */
	@FindBy(xpath = "//*[@id='vlog-box']/table/tbody/tr[@class='current']/td[2]")
	public WebElement currentPlayTime;
	
	/**
	 * 视频-历史观看时间%
	 */
	@FindBy(xpath = "//*[@id='vlog-box']/table/tbody/tr[@class='history']/td[2]")
	public WebElement historyPlayTime;
	
	/**
	 * 视频-播放出错
	 */
	@FindBy(xpath = "//div[@class='vjs-error-display']/*")
	public WebElement playError;
	/**
	 * 视频-播放出错xpath
	 */
	public String playErrorXpath= "//div[@class='vjs-error-display']/*";
	
	/**
	 * 视频坐标xpath
	 */
	public String videoLocationXpath = "//*[@id='home_video']";
	
	/*********************************测验**********************/

	/**
	 * 前往测试按钮
	 */
	@FindBy(xpath = "//div[@class='panel active']/descendant::button")
	public List<WebElement> goToTest;
	/**
	 * 前往测试的xpath
	 */
	public String goToTestXpath = "//div[@class='panel active']/descendant::button";
	
	/**
	 * 开始测验按钮
	 */
	@FindBy(xpath = "//button[text()='开始测验']")
	public WebElement startTest;
	
	/**
	 * 取消
	 */
	@FindBy(xpath = "//button[text()='取消']")
	public WebElement cancelTest;
	
	
	/**
	 * 测验名称
	 */
	@FindBy(xpath = "//div[@class='panel active']/descendant::span[2]")
	public List<WebElement> quizName;
	
	/**
	 * 测验名称XPath
	 */
	public String quizNameXpath = "//div[@class='panel active']/descendant::span[2]";
	
	/**
	 * 测验名称
	 */
	@FindBy(xpath = "//*[@id='page-content']/div/div[1]/h3")
	public WebElement quizTitle;
	
	
	
	/**
	 * 选项A
	 */
	@FindBy(xpath = "//*[@id='quiz_questions_list']/div/ul/li[1]/p[1]/span")
	public List<WebElement> option_A;
	
	/**
	 * 选项B
	 */
	@FindBy(xpath = "//*[@id='quiz_questions_list']/div/ul/li[2]/p[1]/span")
	public List<WebElement> option_B;
	
	/**
	 * 选项C
	 */
	@FindBy(xpath = "//*[@id='quiz_questions_list']/div/ul/li[3]/p[1]/span")
	public List<WebElement> option_C;
	
	/**
	 * 选项D
	 */
	@FindBy(xpath = "//*[@id='quiz_questions_list']/div/ul/li[4]/p[1]/span")
	public List<WebElement> option_D;
	
	/**
	 * 测验保存按钮
	 */
	@FindBy(id = "save_quiz_submission")
	public WebElement quizSave;
	/**
	 * 测验保存按钮xpath
	 */
	public String quizSaveXpath = "//*[@id='save_quiz_submission']";
	
	/**
	 * 测验提交按钮
	 */
	@FindBy(id = "submit_quiz_submission")
	public WebElement quizSubmit;
	
	/**
	 * 保存成功提示
	 */
	@FindBy(className = "submit-job")
	public WebElement submitTips;
	
}
