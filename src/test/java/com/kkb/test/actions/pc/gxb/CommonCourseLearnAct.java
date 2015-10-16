package com.kkb.test.actions.pc.gxb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
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
		try {
			logger.info("点击left开始学习");
			click(courseLearnPage.startLearn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail("点击开始学习后，等待超时！");
		}
	}
	
	
	public  String clickCourse(String course) {
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
	public StringBuilder allChapters(String course, StringBuilder errorCourse){
		List<WebElement> chapterList = driver.findElements(By.xpath("//*[@id='units_list']/div/div/h4/span[2]"));
		for(int j = 0; j < chapterList.size(); j++){
			WebElement chapter = driver.findElement(By.xpath("(//*[@id='units_list']/div/div/h4/span[2])["+(j+1)+"]"));
			String chapterTitle = course+"--"+getText(chapter);
			logger.info(chapterTitle);
			click(chapter);
			if(this.isElementExist("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]", 5)){
				List<WebElement> courseList = driver.findElements(By.xpath("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]"));;
				for(int i = 0 ; i < courseList.size() ; i++){
					WebElement e = driver.findElement(By.xpath("(//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')])["+(i+1)+"]"));
					String courseName =chapterTitle+"--"+ e.getText(); 
					e.click();

					pause(5);
					if(!checkPlayError(courseName,errorCourse)){
						pause(5);
						clickVideoPlay();
						pause(5);
						//clickVideoPause();
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
		return errorCourse;
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
		logger.info("点击视频返回按钮");
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
	 
	
	
	public  String  all(StringBuilder errorVideo,String course) throws AWTException{
		List<WebElement> chapterList = driver.findElements(By.xpath("//*[@id='units_list']/div/div/h4/span[2]"));
		TreeMap<Integer,String[] >  chapterMap = new TreeMap<Integer,String[] >();
		String chapterTitle = "";
		 int key = 0;
		// String learnPage = driver.getWindowHandle();
		for(WebElement chapter : chapterList){
			//获取章节名称
			 chapterTitle = course+"--"+chapter.getText();
			 chapter.click();
			 pause(3);
			 if(this.isElementExist("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]", 5)){
				 List<WebElement> courseList = driver.findElements(By.xpath("//*[@class='panel active']/div[2]/div/div/ul/li/a[@class='learn_proggression study_progression'][contains(@href,'#/chapters')]"));
					for(WebElement courseUrl : courseList){
					
						String [] urlInfo = new String[3];
						urlInfo[0] = chapterTitle+"--"+ courseUrl.getText();
						urlInfo[1] = courseUrl.getAttribute("href");
						chapterMap.put(key++, urlInfo);
					}
			 }
			 chapter.click();

		}
		Robot robot;
		
		for(int i = 0;i<chapterMap.size() ;i++){
			//System.out.println(chapterMap.get(i)[0]);
			clickStartLearn();
			//driver.findElement(By.linkText("帮助"));
			pause(3);
			driver.navigate().to(chapterMap.get(i)[1]);
			//driver.switchTo().window(driver.getTitle());

			pause(5);
			if(!this.isElementExist("//*[@id='home_video']", 4)){
				this.refresh();
				driver.navigate().to(chapterMap.get(i)[1]);

			}
			if(!checkPlayError(chapterMap.get(i)[0],errorVideo)){
				//logger.info(chapterMap.get(i)[0]+"  播放正常！");
				pause(3);
				//driver.switchTo().window(driver.getTitle());
			//	if(this.isElementExist("//*[@id='home_video']/div[5]", 3))
				//	clickVideoPlay();
				//Action a =new Action(driver);
				//System.out.println(driver.getPageSource());
				
				driver.findElement(By.xpath("//*[@id='home_video']")).click();
				int x= driver.findElement(By.xpath("//*[@id='home_video']")).getLocation().getX();
				int y= driver.findElement(By.xpath("//*[@id='home_video']")).getLocation().getY();

				 robot = new Robot();
				robot.mouseMove(x+200, y+200);
				robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键

			    robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键

			   // robot.delay(100);//停顿100毫秒,即0.1秒

			    //robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键
//
			    //robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键
				pause(10);
				//clickVideoPause();
				logger.info(chapterMap.get(i)[0]+"  播放正常！");
				//clickVideoBack();
			}else{
				//logger.error(chapterMap.get(i)[0]);
				//clickVideoBack();
			}
			
			
			/*Set<String> handles = 	driver.getWindowHandles();
			for(String s :handles){
				if(!s.equals(learnPage)){
					driver.switchTo().window(s);
					driver.close();
				}
				
			}*/
			
			//driver.getWindowHandles();
			//driver.navigate().back();
			//this.switchToWindow(learnPage);
		}
		return errorVideo.toString();

	}
	
	/**
	 * 判断视频是否播放出错
	 * @param errorCourse 
	 */
	public boolean checkPlayError(String courseName, StringBuilder errorCourse ){
		pause(5);
	
		boolean f = this.isElementExist("//div[@class='vjs-error-display']/*", 5);
		if(f){
			String errorMsg = driver.findElement(By.xpath("//div[@class='vjs-error-display']/*")).getText();
			/*		if(null==errorMsg||"".equals(errorMsg))
						return false;
					else{
						logger.error("{}，视频播放出错！-》{}",courseName,errorMsg);
						this.snapshot(courseName);
						errorCourse.append(courseName+"\n");
						return true;

					}*/
					if(null!=errorMsg&&errorMsg.length()>1){
						logger.error("{}，视频播放出错！-》{}",courseName,errorMsg);
						this.snapshot(courseName);
						errorCourse.append(courseName+"\n");
						return true;
					}else{
						return false;
					}
					
		}
		
	return false;
			
	}
	
}
