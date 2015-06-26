package test.java.com.wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVideoPage {

	private WebDriver driver;
	public AddVideoPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public AddVideoPage enterVideoUrl(String url) throws Throwable {
	    driver.findElement(By.id("wpWikiaVideoAddUrl")).sendKeys(url);
	    return this;
	}
	
	public VideosPage clickAdd() throws Throwable {
	    driver.findElement(By.className("submits")).submit();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("banner-notification")));
	    return new VideosPage(driver);
	}
}
