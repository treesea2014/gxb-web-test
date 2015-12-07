/**
 * 
 */
package com.kkb.test.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.google.common.base.Function;
import com.jayway.restassured.RestAssured;

/**
 * @author treesa888@icloud.com
 * 
 */
public class Action {
	/**
	 * slf4j
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(Action.class);
	/**
	 * selenium WebElement
	 */
	private WebElement element;

	/**
	 * selenium WebDriver
	 */
	protected WebDriver driver;

	/**
	 * normal wait
	 * 
	 */
	private int second = 1;

	/**
	 * 
	 */
	private int waitSencond = 30;

	/**
	 * 
	 * @param driver
	 */
	public Action(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 打开浏览器
	 * 
	 * @param url
	 */
	public void open(String url) {
		open(url, second);
	}

	/**
	 * 打开浏览器
	 * 
	 * @param url
	 * @param second
	 */
	public void open(String url, int second) {
		this.driver.get(url);
		waitForPageLoad(driver);
	}

	/**
	 * 输入
	 * 
	 * @param element
	 * @param text
	 */
	public void type(WebElement element, String text) {
		type(element, text, second);
	}
	/**
	 * 高亮对象
	 * @param element
	 */
	public void higthLight(WebElement element){
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        String js = "element = arguments[0];" +
             "original_style = element.getAttribute('style');" +
             "element.setAttribute('style', original_style + \";" +
             "background: green; border: 2px solid red;\");" +
             "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);"; 
        jsExecutor(js ,element);
	}
	
	/**
	 * 输入
	 * 
	 * @param element
	 * @param text
	 * @param second
	 */
	public void type(WebElement element, String text, int second) {
		this.element = element;
		//higthLight(element);
		this.element.clear();
		this.element.sendKeys(text);
	}

	/**
	 * 点击
	 * 
	 * @param element
	 */
	public void click(WebElement element, Object... objects) {
		this.element = element;
		//higthLight(element);
		this.element.click();
		//this.pause(second);
	}

	/**
	 * 点击
	 * 
	 * @param element
	 * @param second
	 */

	public void click(WebElement element) {
		//waitForPageLoad(driver);
		this.element = element;
		//higthLight(element);
		this.element.click();

		//this.pause(second);
	}

	/**
	 * 获取文本
	 * 
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {
		String text = null;
		text = element.getText();
		//logger.info("{}", text);
		return text;
	}

	/**
	 * 获取value 值
	 * 
	 * @param element
	 * @return
	 */
	public String getValue(WebElement element) {
		String value = null;
		value = element.getAttribute("value");
		logger.info("{}", value);
		return value;
	}

	/**
	 * 获取元素数量个数
	 * 
	 * @param element
	 * @return
	 */
	public int getElementsNum(List<WebElement> element) {
		int number;
		number = element.size();
		logger.info("{}", number);
		return number;
	}

	/**
	 * select
	 * 
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
		logger.info("Select {}", option);
	}

	/**
	 * select
	 * 
	 * @param element
	 * @param option
	 */
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		logger.info("Select {}", index);
	}

	/**
	 * 控制Alert的确认与取消
	 * 
	 * @param flag
	 *            根据传递的参数accept、dismiss，进行相应的操作
	 */
	public void confirmAlert(boolean flag) {
		try {
			Alert alert = driver.switchTo().alert();
			if (alert == null) {
				return;
			}
			if (flag) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			defaultContent();
		} catch (NoAlertPresentException e) {
			return;
		}
	}

	/**
	 * 进入iframe
	 * 
	 * @param element
	 */
	public void enterFrame(WebElement element) {
		driver.switchTo().frame(element);
		logger.info("Entered iframe");
	}

	/**
	 * 进入iframe
	 * 
	 * @param element
	 */
	public void enterFrame(String arg0) {
		driver.switchTo().frame(arg0);
		logger.info("Entered iframe");
	}

	/**
	 * 返回默认Content
	 * 
	 */
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 将焦点跳转到指定的window下
	 * 
	 * @param windowTitle
	 *            要跳转的window的title
	 * @return true/false
	 */
	public boolean switchToWindow(String windowTitle) {
		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driver.switchTo().window(s);
					if (driver.getTitle().contains(windowTitle)) {
						flag = true;
						logger.info("Switch to window: " + windowTitle
								+ " successfully!");
						break;
					} else
						continue;
				}
			}
			logger.info("Switch to window {} ", windowTitle);
		} catch (NoSuchWindowException e) {
			logger.info("Failed to switch to window {} ", windowTitle);
			throw new NoSuchFrameException("Failed to switch to window "
					+ windowTitle);
		}
		return flag;
	}

	/**
	 * 程序暂停 time * 1000ms
	 * 
	 * @param time
	 *            要暂停的时间
	 */
	public void pause(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			logger.error("wait loading error ", e);
			return;
		}
	}

	/**
	 * 浏览器刷新
	 */
	public void refresh() {
		try {
			driver.navigate().refresh();
			waitForPageLoad(driver);
			logger.info("Refresh Browser!");
		} catch (WebDriverException e) {
			logger.info("Faile to refresh browser!");
			throw new WebDriverException("Faile to refresh browser!", e);
		}
	}

	/**
	 * 判断页面是否加载完成
	 * 
	 * @return
	 */
	protected Function<WebDriver, Boolean> isPageLoaded() {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
	}

	/**
	 * 等待页面加载完成
	 */
	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, waitSencond);
		wait.until(isPageLoaded());
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	private Function<WebDriver, Boolean> haveMoreThanOneOption(
			final WebElement element, final String tag) {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (element == null) {
					return false;
				} else {
					int size = element.findElements(By.tagName(tag)).size();
					return size >= 1;
				}
			}
		};
	}

	/**
	 * 如果页面有Ajax操作，需要写一个Wait方法等待Ajax操作完成
	 */
	public void waitForDropDownListLoaded(WebElement element, String tag) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(haveMoreThanOneOption(element, tag));
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @param by
	 */
	public boolean isElementPresent(final WebElement element) {

		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		// WebDriverWait wait = (new WebDriverWait(driver, waitSencond));
		// wait.until(new ExpectedCondition<Boolean>() {
		// public Boolean apply(WebDriver d) {
		// boolean loadcomplete = element.isDisplayed();
		// return loadcomplete;
		// }
		// });
	}

	/**
	 * 在time内查找元素 是否存在
	 * 
	 * @param xpath
	 * @param time
	 * @return
	 */
	public boolean isElementExist(String xpath, int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			logger.debug("在规定时间{}s内，未找到该元素:{}", time, xpath);
			return false;
		}
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @param by
	 */
	public boolean isElementPresent(final WebElement element, final String text) {
		if (element.isDisplayed()) {
			logger.info("{} == {}", text, element.getText());
			return text.equals(element.getText());
		} else {
			logger.info("{} != {}", text, element.getText());
			return false;
		}
		// WebDriverWait wait = (new WebDriverWait(driver, waitSencond));
		// wait.until(new ExpectedCondition<Boolean>() {
		// public Boolean apply(WebDriver d) {
		// if(element.isDisplayed()){
		// return text.equals(element.getText());
		// }else{
		// return false;
		// }
		// }
		// });
	}

	/**
	 * 执行js
	 * 
	 * @param js
	 * @param element
	 */
	public void jsExecutor(String js, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(js, element);
	}

	/**
	 * 关闭浏览器
	 * 
	 * @param browserType
	 * @throws IOException
	 * @throws AWTException
	 */
	public void closeAllBrowser(int browserType) throws IOException,
			AWTException {
		if (browserType == 2) {
			try {
				Runtime.getRuntime().exec("taskkill /f /im firefox.exe");
			} catch (IOException e) {
				logger.info("close firefox browser IO Exception");
				throw new IOException("close firefox browser IO Exception");
			}
		}
		this.pressKeyboard(KeyEvent.VK_ENTER);

	}

	/**
	 * 键盘输入
	 * 
	 * @param keyCode
	 *            例如： KeyEvent.VK_TAB, KeyEvent.VK_F11
	 * @throws AWTException
	 */
	public void pressKeyboard(int keyCode) throws AWTException {
		Robot rb = null;
		try {
			rb = new Robot();
			rb.keyPress(keyCode); // press key
			rb.delay(100); // delay 100ms
			rb.keyRelease(keyCode); // release key
			logger.info("Pressed key with code " + keyCode);
		} catch (AWTException e) {
			logger.info("Failed to pressKeyboard {} ", keyCode);
			throw new AWTException("Failed to pressKeyboard " + keyCode);
		}
	}

	/**
	 * 彻底浏览器
	 */
	public void quit() {
		try {
			//driver.close();
			driver.quit();
			logger.info("quite browser!");
		} catch (WebDriverException e) {
			logger.info("Faile to quite browser!");
			throw new WebDriverException("Faile to quite browser!", e);
		}
	}


	/**
	 * 自动化上传图片
	 */
	public void robotUpload() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// robotEnter();

		String exe = "upload.exe";
		Runtime rn = Runtime.getRuntime();
		try {
			String classpath = ClassLoader.getSystemResource("").getPath();
			File file = new File(classpath + exe);
			if (!file.exists()) {
				classpath = new File(classpath).getParentFile().getPath()
						+ "\\classes\\";
			}
			Process p = rn.exec("\"" + classpath + exe + "\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动化上传图片 num{1,19}
	 */
	public void uploadImg(int num) {
		String exe = "upload.exe";
		Robot robot = null;
		try {
			robot = new Robot();
			setImgPath2Clipboard(num);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		String os = System.getProperties().getProperty("os.name");
		if(os.equals("Windows Server 2008 R2")){
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}else if(os.equals("Windows 7")){
			Runtime rn = Runtime.getRuntime();
			try {
				String classpath = ClassLoader.getSystemResource("").getPath();
				File file = new File(classpath + exe);
				if (!file.exists()) {
					classpath = new File(classpath).getParentFile().getPath()
							+ "\\classes\\";
				}
				Process p = rn.exec("\"" + classpath + exe + "\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 拷贝
	 */
	public void robotCopy() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		this.pause(1);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		this.pause(1);
	}

	/**
	 * 用例执行成功/失败时 进行截图
	 * 
	 * @param desc
	 *            截图名称描述
	 */
	/*public void failScreenShot(String desc) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		logger.info("开始截图，名称{}", desc + ".jpg");
		File screenshot = new File("test-output/html" + File.separator
				+ "failScreenShot" + File.separator + desc + ".jpg");
		try {
			FileUtils.copyFile(scrFile, screenshot);
		} catch (IOException e) {
			logger.error("截图操作失败" + e.getMessage());
		}

	}*/
	/**
	 * 截图操作
	 */
	public void snapshot(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String fileName = mDateTime ;
		//
		String imgUrl = "screenshot\\" + fileName + ".jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("test-output/html" + File.separator
				+ imgUrl);
		try {
			FileUtils.copyFile(scrFile, screenshot);
		} catch (IOException e) {
			logger.error("截图操作失败" + e.getMessage());
		}
		//Reporter.log(imgUrl+"\n");
		Reporter.log("<a href=\""+imgUrl+"\""+" target=\""+"_blank\""+">\n");
		Reporter.log("<img height=\"200px\" width=\"200px\" src=\"" +imgUrl  + "\"/></a>\n");
	}
	/**
	 * 截图操作
	 */
	public void snapshot(String title){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String fileName = mDateTime ;
		//
		String imgUrl = "screenshot\\" + fileName + ".jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("test-output/html" + File.separator
				+ imgUrl);
		try {
			FileUtils.copyFile(scrFile, screenshot);
		} catch (IOException e) {
			logger.error("截图操作失败" + e.getMessage());
		}
		Reporter.log( "<div style=\"width:200px;height:200px;background-color:red;\"><h3>"+title+"【看后面截图】"+"</h3></div>\n");
		Reporter.log("<a href=\""+imgUrl+"\""+" target=\""+"_blank\""+">\n");
		Reporter.log("<img height=\"200px\" width=\"200px\" src=\"" +imgUrl  + "\"/></a>\n");
	}
	/**
	 * 通过Xpath查找元素集合
	 * 
	 * @param Xpath
	 * @return
	 */
	public List<WebElement> getElementsByXpath(String Xpath) {

		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(Xpath));
			logger.info("Elements exist by xpath {} ", Xpath);
		} catch (NoSuchElementException e) {
			logger.info("Elements not found by xpath {} ", Xpath);
		}
		return elements;

	}

	/**
	 * 获取工程img文件夹中，jpg的文件列表，将路径名存入数组
	 * 
	 * @return
	 */

	public String[] getImgPaths() {
		// 获取img所在路径
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\img";
		int i = 0;
		// 表示要遍历的文件夹为当前文件夹
		File f = new File(path);
		// 将文件夹中的文件名放入数组中
		File[] sf = f.listFiles();
		String paths[] = f.list();
		// 开始遍历文件夹
		for (File s : sf) {
			// 打印文件名
			String[] p = s.getName().split("\\.");
			// 判断文件有无扩展名
			if (p.length > 0) {
				// 判断文件扩展名
				if ("jpg".equals(p[p.length - 1])) {
					paths[i] = s.getPath();
				} else {
					continue;
				}
			}
			i++;
		}
		return paths;
	}

	/*
	 * 将图片路径放在剪切板
	 * 
	 * max {1,19}
	 */
	public void setImgPath2Clipboard(int max) {
		String[] imgPaths = getImgPaths();
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < max; i++) {
			sb.append("\"").append(imgPaths[i]).append("\"");
		}
		StringSelection ss = new StringSelection(sb.toString());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(""), null);
		clipboard.setContents(ss, null);
	}


	public String closeAlertAndGetItsText() {
		boolean acceptNextAlert = isAlertPresent();
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	/**
	 * 点击返回上一步
	 */
	public void goback(){
		//返回
		driver.navigate().back();
		logger.info("点击返回上一步");
	}
	
	/**
	 * 测试API
	 */
	public void setUp() {
	    RestAssured.baseURI= "http://10.46.28.193";
	    RestAssured.port = 8080;
	    RestAssured.basePath = "/service/v1";
	}
}
