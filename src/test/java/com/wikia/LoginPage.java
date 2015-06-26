package test.java.com.wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage navigateToLogin() throws Throwable {
	    Actions act = new Actions(driver);
	    WebElement accountNav = driver.findElement(By.id("AccountNavigation"));
	    act.moveToElement(accountNav).click().build().perform();
	    return this;
	}
	
	public HomePage enterCredentialsAndLogin(String uname, String pwd) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usernameInput")));
	    
	    driver.findElement(By.id("usernameInput")).sendKeys(uname);
	    driver.findElement(By.id("passwordInput")).sendKeys(pwd);
	    driver.findElement(By.className("login-button")).submit();
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AccountNavigation")));
	    return new HomePage(driver);
	}
}
