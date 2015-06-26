package test.java.com.wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideosPage {

	private WebDriver driver;
	
	public VideosPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public FilePage clickFileLink(String filename) throws Throwable {
	    driver.findElement(By.linkText(filename)).click();
	    return new FilePage(driver);
	}
}
