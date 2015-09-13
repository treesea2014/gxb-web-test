package com.kkb.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
	  	this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(finder, this);
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
