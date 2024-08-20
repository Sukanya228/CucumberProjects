package StepDefinations;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import base.BrowserFactory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	static WebDriver driver;
	LoginPage loginPage;

	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		driver=BrowserFactory.setUpBrowser(driver, "chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getCurrentUrl());
		System.out.println("***User is on Login Page***");
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_username_and_password(String username,String password)  {
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		System.out.println("***User enters username & password***");
		
	}

	
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
		System.out.println("***User clicks on Login button***");
	}

	
	@Then("User should see {string}")
	public void user_should_see(String result) throws InterruptedException{
		if (result.equals("Dashboard")) {
			loginPage.getdashBoardtxt().equals("Dashboard");
			Assert.assertTrue(loginPage.getdashBoardtxt().contains(result));
			System.out.println("***User should be redirected to the Home Page***");

		}else if(result.equals("Invalid credentials")) {
			Assert.assertTrue(loginPage.invalidCredentials().contains(result));
			System.out.println("***Invalid credentials***");
		}else if(result.equals("Required")) {
			Assert.assertTrue(loginPage.getrequiredField().contains(result));
			System.out.println("***Required Credentials***");
		}
		driver.quit();	

	}

}

	


