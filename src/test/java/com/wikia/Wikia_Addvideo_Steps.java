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

public class Wikia_Addvideo_Steps {
	
	public static WebDriver driver = null;
	
	LoginPage loginpage = null;
	HomePage homepage = null;
	AddVideoPage addvideopage = null;
	VideosPage videospage = null;
	FilePage filepage = null;
	
	@Given("^User user is logged in with username \"(.*?)\" and password \"(.*?)\"$")
	public void user_user_is_logged_in_with_username_and_password(String uname, String pwd) throws Throwable {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://qm-homework.wikia.com");
	    
	    loginpage = new LoginPage(driver);
	    loginpage.navigateToLogin();
	   
	    homepage = loginpage.enterCredentialsAndLogin(uname, pwd);
	}

	@When("^User Left clicks Contribute button$")
	public void user_Left_clicks_Contribute_button() throws Throwable {
	    homepage.clickContribute();
	}

	@When("^User Left clicks Add a video button$")
	public void user_Left_clicks_Add_a_video_button() throws Throwable {
		addvideopage = homepage.clickAddVideo();
	}

	@When("^User types video url \"(.*?)\" from youtube into the Video URL field$")
	public void user_types_video_url_from_youtube_into_the_Video_URL_field(String url) throws Throwable {
	    addvideopage.enterVideoUrl(url);
	}

	@When("^User Left clicks Add button$")
	public void user_Left_clicks_Add_button() throws Throwable {
		videospage = addvideopage.clickAdd();
	}

	@When("^User Left clicks link to file \"(.*?)\" on the flash message$")
	public void user_Left_clicks_link_to_file_on_the_flash_message(String filename) throws Throwable {
		filepage = videospage.clickFileLink(filename);
	}

	@Then("^Verify \"(.*?)\" and flash message matches$")
	public void verify_and_flash_message_matches(String msg) throws Throwable {
	    filepage.verifyFileName(msg);
	    
	    driver.quit();
	}
}
