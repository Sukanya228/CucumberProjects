package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
    
    @FindBy(name="username")
    private WebElement txt_username;
    
    @FindBy(name="password")
    private WebElement txt_password;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement login_Btn;
    
    @FindBy(xpath="//h6[text()='Dashboard']")
    private WebElement userDashboard;
    
    @FindBy(xpath="//*[@class='orangehrm-login-error']")
    private WebElement invalidCred;
    
    @FindBy(xpath="//span[text()='Required']")
	private WebElement requiredCred;


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void enterUsername(String username) {
		txt_username.clear();
		txt_username.sendKeys(username);

	}

	public void enterPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}

	public void clickLoginButton() {
		login_Btn.click();
	}

	public String getdashBoardtxt() {
		String actualTxt=userDashboard.getText();
		return actualTxt;

	}

	public String invalidCredentials() throws InterruptedException {

		invalidCred.isDisplayed(); 
		Thread.sleep(2000); 
		String invalid_actualTxt=invalidCred.getText();

		return invalid_actualTxt;

	}

	public String getrequiredField() {
		String requiredCredTxt=requiredCred.getText();
		return requiredCredTxt;
	}
}



