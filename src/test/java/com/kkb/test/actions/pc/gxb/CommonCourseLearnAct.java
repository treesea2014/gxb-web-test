package com.kkb.test.actions.pc.gxb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.kkb.test.pages.pc.gxb.CourseDetailsPage;
import com.kkb.test.pages.pc.gxb.CourseLearnPage;
import com.kkb.test.pages.pc.gxb.CoursePage;



/**
 * @author sh.deng
 * @description 高校帮 课程学习动作
 * @date 2015.10.12
 */
public class CommonCourseLearnAct  extends CommonCourseDetailsAct{
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(CommonCourseLearnAct.class);

	private CourseLearnPage courseLearnPage;
	private CoursePage coursePage;

	
	/**
	 * 
	 * @param driver
	 */
	public CommonCourseLearnAct(WebDriver driver) {
		super(driver);
		courseLearnPage = new CourseLearnPage(driver);
		coursePage = new CoursePage(driver);
	}
	
	/**
	 * 开始学习
	 */
	public  void clickStartLearn() {
		logger.info("点击left开始学习");
		click(courseLearnPage.startLearn);
	}
	
	public  String clickCourse() {
		List<WebElement> courseNameList = coursePage.courseNameList ;
		StringBuilder errorCourse = new StringBuilder("");
		for(int i = 0 ;i<courseNameList.size() ; i++){
			//logger.info("*********{}********",i);
			//logger.info("课程名称:{}",getText(courseNameList.get(i)));
			/*logger.info("课程类型:{}",getText(coursePage.courseType.get(i)));
			logger.info("课程信息:{}",getText(coursePage.bodyCourseInfo.get(i)));
			logger.info("课程简介:{}",getText(coursePage.bodyCoursentro.get(i)));
			logger.info("课程星级评价:{}",getText(coursePage.bodyCourseStars.get(i)));
			logger.info("参与人数:{}",getText(coursePage.bodyCoursePeoples.get(i)));*/
			courseNameList = driver.findElements(By.xpath("//div[@class='caption guide']/div/h4"));
			String courseName = courseNameList.get(i).getText();
			if(courseName.contains("形势与政策")){
				continue;
			}
			logger.info(courseName);
			courseNameList.get(i).click();
			//显示所有章节
			//commonCourseLearnAct.dispalyAllChapter();
			snapshot();
			//点击开始/继续学习
			clickStartStudy();
			snapshot();
			//等待30s
			pause(10);
			snapshot();
			//点击左侧学习
			clickStartLearn();
			snapshot();
			//获取所有章节
			allChapters(courseName,errorCourse);
			this.clickCourseBar();
			this.clickCourseBar();

		}
		//点击第一门课程
	
		Reporter.log(errorCourse.toString());
		return errorCourse.toString() ;
	}
	
	public  String clickCourse2() {
		logger.info("下一页");
		pause(3);
		click(coursePage.nextPage);
		pause(3);
		List<WebElement> courseNameList = coursePage.courseNameList ;
		StringBuilder errorCourse = new StringBuilder("");
		for(int i = 0 ;i<courseNameList.size() ; i++){
			//logger.info("*********{}********",i);
			//logger.info("课程名称:{}",getText(courseNameList.get(i)));
			/*logger.info("课程类型:{}",getText(coursePage.courseType.get(i)));
			logger.info("课程信息:{}",getText(coursePage.bodyCourseInfo.get(i)));
			logger.info("课程简介:{}",getText(coursePage.bodyCoursentro.get(i)));
			logger.info("课程星级评价:{}",getText(coursePage.bodyCourseStars.get(i)));
			logger.info("参与人数:{}",getText(coursePage.bodyCoursePeoples.get(i)));*/
			courseNameList = driver.findElements(By.xpath("//div[@class='caption guide']/div/h4"));
			String courseName = courseNameList.get(i).getText();
			if(courseName.contains("形势与政策")){
				continue;
			}
			logger.info(courseName);
			courseNameList.get(i).click();
			//显示所有章节
			//commonCourseLearnAct.dispalyAllChapter();
			snapshot();
			//点击开始/继续学习
			clickStartStudy();
			snapshot();
			//等待30s
			pause(10);
			snapshot();
			//点击左侧学习
			clickStartLearn();
			snapshot();
			//获取所有章节
			allChapters(courseName,errorCourse);
			this.clickCourseBar();
			this.clickCourseBar();
			logger.info("下一页");
			click(driver.findElement(By.xpath("//span[text()='下一页']")));
			pause(3);

		}
		//点击第一门课程
	

		return errorCourse.toString() ;
	}
	
	public  String clickCourse3() {
		logger.info("下一页");
		pause(3);
		click(coursePage.nextPage);
		pause(3);

		click(coursePage.nextPage);
		pause(3);
		List<WebElement> courseNameList = coursePage.courseNameList ;
		StringBuilder errorCourse = new StringBuilder("");
		for(int i = 0 ;i<courseNameList.size() ; i++){
			//logger.info("*********{}********",i);
			//logger.info("课程名称:{}",getText(courseNameList.get(i)));
			/*logger.info("课程类型:{}",getText(coursePage.courseType.get(i)));
			logger.info("课程信息:{}",getText(coursePage.bodyCourseInfo.get(i)));
			logger.info("课程简介:{}",getText(coursePage.bodyCoursentro.get(i)));
			logger.info("课程星级评价:{}",getText(coursePage.bodyCourseStars.get(i)));
			logger.info("参与人数:{}",getText(coursePage.bodyCoursePeoples.get(i)));*/
			courseNameList = driver.findElements(By.xpath("//div[@class='caption guide']/div/h4"));
			String courseName = courseNameList.get(i).getText();
			if(courseName.contains("形势与政策【新生必修")){
				continue;
			}
			logger.info(courseName);
			courseNameList.get(i).click();
			//显示所有章节
			//commonCourseLearnAct.dispalyAllChapter();
			snapshot();
			//点击开始/继续学习
			clickStartStudy();
			snapshot();
			//等待30s
			pause(10);
			snapshot();
			//点击左侧学习
			clickStartLearn();
			snapshot();
			//获取所有章节
			allChapters(courseName,errorCourse);
			this.clickCourseBar();
			this.clickCourseBar();
			logger.info("下一页");
			click(driver.findElement(By.xpath("//span[text()='下一页']")));
			pause(3);
			click(driver.findElement(By.xpath("//span[text()='下一页']")));
			pause(3);
		}
		//点击第一门课程
	

		return errorCourse.toString() ;
	}
	/**
	 * 所有的章节列表
	 * @param errorCourse 
	 * @return 
	 */
	public List<WebElement> allChapters(String course, StringBuilder errorCourse){
		List<WebElement> chapterList = driver.findElements(By.xpath("//*[@id='units_list']/div/div/h4/span[2]"));
		for(int j = 0; j < chapterList.size(); j++){
			WebElement chapter = driver.findElement(By.xpath("(//*[@id='units_list']/div/div/h4/span[2])["+(j+1)+"]"));
			String chapterTitle = course+"--"+getText(chapter);
			logger.info(chapterTitle);
			click(chapter);
			if(this.isElementExist("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]", 3)){
				List<WebElement> courseList = driver.findElements(By.xpath("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]"));;
				for(int i = 0 ; i < courseList.size() ; i++){
					WebElement e = driver.findElement(By.xpath("(//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')])["+(i+1)+"]"));
					String courseName =chapterTitle+"--"+ e.getText(); 
					e.click();
					if(!checkPlayError(courseName,errorCourse)){
						
	/*					pause(5);
						clickVideoPlay();
						pause(8);
						clickVideoPause();*/
						logger.info(courseName+"  播放正常！");
						clickVideoBack();
					}else{
						
						clickVideoBack();
					}
				}
			}
			chapter = driver.findElement(By.xpath("(//*[@id='units_list']/div/div/h4/span[2])["+(j+1)+"]"));
			click(chapter);

		}
		return chapterList;
	}
	
	/**
	 * 所有章节下课程
	 * @return 
	 */
	public List<WebElement> dispalyAllCourse(){
		List<WebElement> courseList = courseLearnPage.courseList;
		for(WebElement course : courseList){
			logger.info(getText(course));
		}
		return courseList;
	}
	
	/**
	 * 点击视频返回按钮
	 */
	public void clickVideoBack(){
		//logger.info("点击视频返回按钮");
		click(courseLearnPage.videoBack);
	}
	
	/**
	 * 点击视频播放按钮
	 */
	public void clickVideoPlay(){
		//logger.info("点击视频播放按钮");
		click(courseLearnPage.videoPlayBtn);
	}
	
	/**
	 * 点击视频暂停按钮
	 */
	public void clickVideoPause(){
		//logger.info("点击视频暂停按钮");
		click(courseLearnPage.videoPauseBtn);
	}
	
	/**
	 * 获取本次视频播放进度
	 */
	public void currentPlayTime(){
		String time = getText(courseLearnPage.currentPlayTime);
		logger.info(" 获取本次视频播放进度：{}",time);
	}
	
	
	/**
	 * 获取历史视频播放进度
	 */
	public void historyPlayTime(){
		String time = getText(courseLearnPage.historyPlayTime);
		logger.info(" 获取历史视频播放进度：{}",time);
	}
	 
	/**
	 * 判断视频是否播放出错
	 * @param errorCourse 
	 */
	public boolean checkPlayError(String courseName, StringBuilder errorCourse ){
		//boolean re = isElementExist("//div[@class='vjs-error-display']/*", 5);
		String errorMsg = courseLearnPage.playError.getText();
		if(null==errorMsg||"".equals(errorMsg))
			return false;
		else{
			logger.error("{}，视频播放出错！-》{}",courseName,courseLearnPage.playError.getText());
			this.snapshot(courseName);
			errorCourse.append(courseName+"\n");
			return true;

		}
			
	}
	
}
