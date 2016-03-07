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
		//获取章节列表
		List<WebElement> chapterList = courseLearnPage.chapterList;
		for(int j = 0; j < chapterList.size(); j++){
			WebElement chapter = driver.findElement(By.xpath("("+courseLearnPage.chapterListXpath+")["+(j+1)+"]"));
			String chapterTitle = course+"--"+getText(chapter);
			logger.info(chapterTitle);
			//点击章节 展开课程列表
			click(chapter);
			if(this.isElementExist(courseLearnPage.courseListXpath, 5)){
				List<WebElement> courseList = driver.findElements(By.xpath(courseLearnPage.courseListXpath));;
				for(int i = 0 ; i < courseList.size() ; i++){
					WebElement e = driver.findElement(By.xpath("("+courseLearnPage.courseListXpath+")["+(i+1)+"]"));
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
			chapter = driver.findElement(By.xpath("("+courseLearnPage.chapterListXpath+")["+(j+1)+"]"));
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

	/**
	 * 获取所有章节下的视频video , unitId , chapterId
	 * @param courseName
     */
	public TreeMap<Integer,String[] >  getItems(String courseName){
		TreeMap<Integer,String[] >  videoMap = new TreeMap<Integer,String[] >();
		int key = 0;

		if(isElementExist(courseLearnPage.activeChapterXpath,10)){
			//点击已展开的列表,便于统一遍历
			logger.info("点击已展开的列表");
			click(courseLearnPage.ActiveChapter);
		}
		//获取所有的unitId
		List<WebElement> unitIdList = courseLearnPage.unitIdList;
		//获取第一级,逐个张开
		List<WebElement> chapterList = courseLearnPage.chapterList;
		int unitKey = 0;
		for(WebElement e1 :chapterList){
			//logger.info("点击第一级:{}",e1.getText());
			e1.click();
			String unitId = unitIdList.get(unitKey++).getAttribute("data-unit-id");
			//获取第二级,逐个张开
			List<WebElement> chapterList2 = courseLearnPage.chapterList2;
			for(WebElement e2 :chapterList2){
				logger.info("点击第二级:{}",e2.getText());
				e2.click();
				//获取第三级中的video视频,逐个存入map
				List<WebElement> chapterList3 = courseLearnPage.chapterList3;
					for(WebElement e3 : chapterList3){
						String [] item = {courseName+"="+e1.getText()+"="+e2.getText()+"="+e3.getText(),
											e3.getAttribute("chapter_id"),
											unitId};
						//logger.info("item:{}, {} ,{}",item[0],item[1] ,item[2]);
						//e3.click();
						videoMap.put(key++,item);
					}
				//关闭第一级
				//logger.info("关闭第二级:{}",e2.getText());
				click(e2);
			}
			//关闭第一级
			//logger.info("关闭第一级:{}",e1.getText());
			click(e1);
			//logger.info("videoMap:{}",videoMap);
		}
		return  videoMap;
	}

	/**
	 * 进行视频检测
	 * @param courseName
     */
	public String checkVideoPlay(String courseName){
		StringBuilder  errorVideo = new StringBuilder();
		//手机视频信息
		TreeMap<Integer,String[] >  videoMap = getItems(courseName);
		String url = driver.getCurrentUrl();
		WebDriver driver2 = driver;
		String errMsg ="";
		for(int i = 0 ;i< videoMap.size();i++){
			String videoPlayPath = url+"/" + videoMap.get(i)[2] +"/chapter/" +videoMap.get(i)[1];
			driver.navigate().to(videoPlayPath);
			
			this.refresh();
			//this.driver = driver2;
			pause(10);
			//WebElement e = driver.findElement(By.xpath(courseLearnPage.videoPlayXpath));
			//e.click();
			
			String palyState = driver.findElement(By.xpath(courseLearnPage.videoPlayXpath)).getAttribute("class");
			pause(5);
			//e.click();
			logger.info("palyState:{}" , palyState);
			if(isElementExist(courseLearnPage.errorVideoTitleXpath,5)){
				 errMsg = courseLearnPage.errorVideoTitle.getText();
				logger.info("errMsg:{}",errMsg);
			}
			if(palyState.trim().contains("error")||errMsg.toLowerCase().contains("错误")){
				String videoSrc = driver.findElement(By.xpath(courseLearnPage.videoXpath)).getAttribute("src");
				errorVideo.append("课程名称:"+videoMap.get(i)[0]+",访问地址:"+videoPlayPath+", mp4地址:"+videoSrc+"\n");
				snapshot(videoMap.get(i)[0]);
				logger.error("检查课程:{},视频有误!" , videoMap.get(i)[0]);
				errMsg="";

			/*}else if(palyState.trim().contains("buffering")){
				snapshot("视频超时:"+videoMap.get(i)[0]);
				logger.error("检查课程:{},视频超时!" , videoMap.get(i)[0]);

			*/}else{
				snapshot();
				logger.info("检查课程:{},测试通过!" , videoMap.get(i)[0]);

			}

		}
		return errorVideo.toString();
	}
	
	public  String  all(StringBuilder errorVideo,String course) throws AWTException{
		List<WebElement> chapterList = courseLearnPage.chapterList;
		TreeMap<Integer,String[] >  chapterMap = new TreeMap<Integer,String[] >();
		String chapterTitle = "";
		Robot robot;
		//记录视频数量
		int key = 0;
		for(WebElement chapter : chapterList){
			//获取章节名称
			 chapterTitle = course+"--"+chapter.getText();
			 //依次点击章节
			 chapter.click();
			 pause(3);
			 //检查是否存在视频链接
			 if(this.isElementExist(courseLearnPage.courseListXpath, 5)){
				 List<WebElement> courseList = driver.findElements(By.xpath(courseLearnPage.courseListXpath));
					for(WebElement courseUrl : courseList){
						String [] urlInfo = new String[3];
						//存放视频名称  课程--章节--第N讲
						urlInfo[0] = chapterTitle+"--"+ courseUrl.getText();
						//存放视频连接
						urlInfo[1] = courseUrl.getAttribute("href");
						//视频信息存储在map，用于遍历播放
						chapterMap.put(key++, urlInfo);
					}
			 }
			 //点击章节名称，合上展开的列表，
			 chapter.click();

		}
		
		 if(key<1){
			 Assert.fail("点击左侧开始学习，打不开课程列表，或者该课程下没有视频课程。");
		 }
		 //遍历视频，检查error box 是否为空
		for(int i = 0;i<chapterMap.size() ;i++){
			//点击开始学习
			clickStartLearn();
			pause(3);
			driver.navigate().to(chapterMap.get(i)[1]);
			pause(5);
			if(!this.isElementExist(courseLearnPage.videoLocationXpath, 4)){
				this.refresh();
				driver.navigate().to(chapterMap.get(i)[1]);

			}
			if(!checkPlayError(chapterMap.get(i)[0],errorVideo)){
				pause(3);
				//获取视频盒子坐标
				driver.findElement(By.xpath(courseLearnPage.videoLocationXpath)).click();
				int x= driver.findElement(By.xpath(courseLearnPage.videoLocationXpath)).getLocation().getX();
				int y= driver.findElement(By.xpath(courseLearnPage.videoLocationXpath)).getLocation().getY();
				robot = new Robot();
				robot.mouseMove(x+200, y+200);
				robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键
			    robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键
			    pause(10);
				//clickVideoPause();
				logger.info(chapterMap.get(i)[0]+"  播放正常！");
				//clickVideoBack();
			}else{
				//logger.error(chapterMap.get(i)[0]);
				//clickVideoBack();
			}
		}
		return errorVideo.toString();

	}
	
	/**
	 * 判断视频是否播放出错
	 * @param errorCourse 
	 */
	public boolean checkPlayError(String courseName, StringBuilder errorCourse ){
		pause(5);
	
		boolean f = this.isElementExist(courseLearnPage.playErrorXpath, 5);
		if(f){
			String errorMsg = driver.findElement(By.xpath(courseLearnPage.playErrorXpath)).getText();
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
