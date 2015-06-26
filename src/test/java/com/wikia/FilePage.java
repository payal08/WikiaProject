package test.java.com.wikia;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilePage {
	
	private WebDriver driver;
	
	public FilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public FilePage verifyFileName(String msg) throws Throwable {
	    String filename = driver.findElement(By.xpath("//div[@class='header-column header-title']/h1")).getText();
	    Assert.assertEquals(msg, filename);
	    return this;
	}
}
