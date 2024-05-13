package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverLogin {
   //initialization

	public DriverLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="//input[@placeholder='Enter your username']") private WebElement userName;
    @FindBy(xpath ="//input[@placeholder='Enter password']") private WebElement passWord;
    @FindBy(xpath = "//button[@class='btn full-btn']") private WebElement LoginButton;

    public WebElement getuserName() {
		return userName;
	}
	public WebElement getpassWord() {
		return passWord;
	}
	public WebElement getLoginButton() {
		return LoginButton;

}
    public void userVerifiedValidLoginCred(String Username, String paswd)

    {
        userName.sendKeys(Username);
        passWord.sendKeys(paswd);
        LoginButton.click();

    }
}
