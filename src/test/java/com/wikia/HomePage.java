package test.java.com.wikia;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage successfulLogin(String uname) throws Throwable {
	    
	  WebElement login_usr =driver.findElement(By.xpath("//a[@class='ajaxLogin table-cell' and @title='"+uname+" - My page']"));
	  Assert.assertTrue(login_usr.isDisplayed());
	  return this;
	}
	
	public HomePage clickContribute() throws Throwable {
	    driver.findElement(By.className("wikia-menu-button")).click();
	    return this;
	}
	
	public AddVideoPage clickAddVideo() throws Throwable {
		driver.findElement(By.linkText("Add a Video")).click();
		return new AddVideoPage(driver);
	}
}
