import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import DataFolder.Data;

public class Register 
{
  WebDriver driver;
  static long RanPhone = Data.getRandomPhoneNumber();

  // Initializing driver & Closing after task executed
@BeforeSuite	
	public void OpenBrowser() 
	{
	// ChromeOptions options = new ChromeOptions();
	// options.addArguments("--headless");
	
		// WebDriverManager.safaridriver().setup();
		// driver = new SafariDriver();	


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.get("https://dev-test.groundmetrx.com/company/register");
		
	}
	
@AfterSuite 
  public void Closebrowser()
  {
	driver.quit();
  }




  @Test

  public void Signup() throws InterruptedException
  {     

        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(3000);
        driver.findElement(By.name("name")).sendKeys(Data.RandomCompanyname);
		    driver.findElement(By.name("email")).sendKeys(Data.RandomCompanyUsernameEmail + Data.CompanyEmail);
		   
        // driver.findElement(By.id("usernameInputSec")).sendKeys("TestUser");   //////////////////////Putting static username for timebeinng, Random Username is below
        driver.findElement(By.id("usernameInputSec")).sendKeys(Data.RandomCompanyUsernameEmail);
        driver.findElement(By.id("exampleInputPassword")).sendKeys("Test@1234");
        driver.findElement(By.id("exampleInputConfirmPassword")).sendKeys("Test@1234");
        driver.findElement(By.name("phone")).sendKeys(Long.toString(RanPhone));
        JavascriptExecutor checkboxjs = (JavascriptExecutor) driver;
        checkboxjs.executeScript("document.getElementById('exampleCheck1').click()");
        
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();

        // Stopping to check the Successfull response
        Thread.sleep(5000);
        
  }

 

    
}
