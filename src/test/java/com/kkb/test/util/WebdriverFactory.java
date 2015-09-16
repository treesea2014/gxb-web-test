package com.kkb.test.util;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author treesea888@icloud.com
 *
 */
public class WebdriverFactory {

	/**
	 * slf4j logback
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(WebdriverFactory.class);


	public final String DEFAULT_DRIVER = "firefox";
	public final String FIRFOX_DRIVER = "firefox";
	public final String CHROME_DRIVER = "chrome";
	public final String SAFARI_DRIVER = "safari";

	public final String IE_DRIVER = "ie";
	public final String IPHONE_DRIVER = "iphone";
	public final String ANDROID_DRIVER = "android";

	public final String FIRFOX_DRIVER_PATH = "selenium.browser.firefox";
	public final String CHROME_DRIVER_PATH = "selenium.browser.chrome.driver";
	public final String SAFARI_DRIVER_PATH = "selenium.browser.safari.driver";
	public final String IE_DRIVER_PATH = "selenium.browser.ie.driver.32";

	private int timeout = 60;
	private static String classpath = "";
	private Properties props;

	/**
	 * 
	 * @param config
	 */
	public WebdriverFactory() {

	}

	/**
	 * instance browser
	 * 
	 * @param browserType
	 * @param browserPath
	 * @return
	 */
	public WebDriver newInstanceOf(String browser , Properties p) {
		props = p;
		classpath = ClassLoader.getSystemResource("").getPath();
		WebDriver webDriver;
		if (FIRFOX_DRIVER.equals(browser)) {
			webDriver = firefoxBrowserInstance(classpath);
		} else if (CHROME_DRIVER.equals(browser)) {
			webDriver = chromeBrowserInstance(classpath);
		} else if (IE_DRIVER.equals(browser)) {
			webDriver = ieBrowserInstance(classpath);
		} else if (SAFARI_DRIVER.equals(browser)) {
			webDriver = safariBrowserInstance(classpath);
		} else if (IPHONE_DRIVER.equals(browser)) {
			webDriver = Iphone_chromeBrowserInstance(classpath);
		} else if (ANDROID_DRIVER.equals(browser)) {
			webDriver = Android_chromeBrowserInstance(classpath);
		} else {
			webDriver = firefoxBrowserInstance(classpath);
		}

		/*webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		webDriver.manage().timeouts()
				.pageLoadTimeout(timeout, TimeUnit.SECONDS);
		webDriver.manage().timeouts()
				.setScriptTimeout(timeout, TimeUnit.SECONDS);*/
		webDriver.manage().deleteAllCookies();
		webDriver.manage().window().maximize();
		return webDriver;
	}

	/**
	 * Chrome browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver chromeBrowserInstance(String classpath) {
		String browserPath = classpath
				+ props.getProperty(CHROME_DRIVER_PATH);
		File file = new File(browserPath);
		if (!file.exists()) {
			browserPath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\"
					+ props.getProperty(CHROME_DRIVER_PATH);		}
		System.setProperty("webdriver.chrome.driver", browserPath);
		WebDriver driver = new ChromeDriver();
		logger.info("启动Chrome浏览器   [{}]", browserPath);
		return driver;
	}

	/**
	 * safari browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver safariBrowserInstance(String classpath) {
		String browserPath = classpath
				+ props.getProperty(SAFARI_DRIVER_PATH);
		File file = new File(browserPath);
		if (!file.exists()) {
			browserPath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\"
					+ props.getProperty(SAFARI_DRIVER_PATH);		}
		//System.setProperty("webdriver.safari.driver", browserPath);
		WebDriver driver = new SafariDriver();
		logger.info("启动Safari浏览器   [{}]", browserPath);
		return driver;
	}
	/**
	 * Firefox browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver firefoxBrowserInstance(String classpath) {
		WebDriver driver = null;
		classpath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\";
		File pathToFirefoxBinary = new File(props.getProperty(FIRFOX_DRIVER_PATH));
		FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		/*firefoxProfile.addExtension(new File(classpath
				+ "browser\\firebug-1.9.0.xpi"));
		firefoxProfile.addExtension(new File(classpath
				+ "browser\\firepath-0.9.7-fx.xpi"));
		firefoxProfile.setPreference("extensions.firebug.currentVersion",
				"1.9.2");
		firefoxProfile.setPreference("extensions.firepath.currentVersion",
				"0.9.7");*/
		driver = new FirefoxDriver(firefoxbin, firefoxProfile,
				null);
		logger.info("启动Firefox浏览器   [{}]", props.getProperty(FIRFOX_DRIVER_PATH));

		return driver;
	}

	/**
	 * IE browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver ieBrowserInstance(String classpath) {
		String browserPath = classpath
				+props.getProperty(IE_DRIVER_PATH);
		File file = new File(browserPath);
		if (!file.exists()) {
			browserPath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\"
					+ props.getProperty(IE_DRIVER_PATH);		
			}

		System.setProperty("webdriver.ie.driver", browserPath);
		InternetExplorerDriverService service = InternetExplorerDriverService
				.createDefaultService();
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
				"about:blank");
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,
				true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
				true);
		capabilities.setCapability(
				InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		WebDriver driver = new InternetExplorerDriver(service, capabilities);
		logger.info("启动IE浏览器   [{}]", browserPath);
		return driver;
	}
	
	/**
	 * iphone_Chrome browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver Iphone_chromeBrowserInstance(String classpath) {
		String browserPath = classpath
				+ props.getProperty(CHROME_DRIVER_PATH);
		File file = new File(browserPath);
		if (!file.exists()) {
			browserPath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\"
					+ props.getProperty(CHROME_DRIVER_PATH);		}
		System.setProperty("webdriver.chrome.driver", browserPath);
		 String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4";
		 ChromeOptions co = new ChromeOptions();
		 co.addArguments("--user-agent=" + userAgent);
		 DesiredCapabilities cap = DesiredCapabilities.chrome();
		 cap.setCapability(ChromeOptions.CAPABILITY , co);
		 WebDriver driver = new ChromeDriver(cap);
		 
		logger.info("启动Chrome浏览器   [{}]", browserPath);
		return driver;
	}
	
	/**
	 * Android4.3_Chrome browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver Android_chromeBrowserInstance(String classpath) {
		String browserPath = classpath
				+ props.getProperty(CHROME_DRIVER_PATH);
		File file = new File(browserPath);
		if (!file.exists()) {
			browserPath = new File(classpath).getParentFile().getPath()
					+ "\\classes\\"
					+ props.getProperty(CHROME_DRIVER_PATH);		}
		System.setProperty("webdriver.chrome.driver", browserPath);
		 String userAgent = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
		 ChromeOptions co = new ChromeOptions();
		 co.addArguments("--user-agent=" + userAgent);
		 DesiredCapabilities cap = DesiredCapabilities.chrome();
		 cap.setCapability(ChromeOptions.CAPABILITY , co);
		 WebDriver driver = new ChromeDriver(cap);
		 
		logger.info("启动Chrome浏览器   [{}]", browserPath);
		return driver;
	}

}
