package test.java.com.wikia;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Wikia_LogIn_Steps {

	public static WebDriver driver= null;
	LoginPage loginpage = null;
	HomePage homepage = null;
	
	@Given("^User navigates to Wiki Home page$")
	public void user_navigates_to_Wiki_Home_page() throws Throwable {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://qm-homework.wikia.com");
	}

	@When("^User hovers mouse over Log In label$")
	public void user_hovers_mouse_over_Log_In_label() throws Throwable {
	    loginpage = new LoginPage(driver);
	    loginpage.navigateToLogin();
	}

	@When("^User enters \"(.*?)\" and \"(.*?)\" and clicks Log In button$")
	public void user_enters_and_and_clicks_Log_In_button(String uname, String pwd) throws Throwable {
		homepage = loginpage.enterCredentialsAndLogin(uname, pwd);
	}

	@Then("^User is successfully logged in, \"(.*?)\" is displayed$")
	public void user_is_successfully_logged_in_is_displayed(String uname) throws Throwable {
		homepage.successfulLogin(uname);
	    driver.quit();
	}
}
