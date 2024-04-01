package LineHaul;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TerminalSpot
{
    
    WebDriver driver;
	String msg = "AVR has been successfully inserted";

// Initializing driver & Closing after task executed
@BeforeSuite	
	public void OpenBrowser() 
	{
        //	ChromeOptions options = new ChromeOptions();
        //	options.addArguments("--headless");
	
		// WebDriverManager.safaridriver().setup();
		// driver = new SafariDriver();	


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.get("https://dev-test.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("DHL");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("DHL@123456");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);

    }



    @Test
    public void SearchByDateDispatch()
    {
       driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
       driver.findElement(By.xpath("//a[normalize-space()='Dispatch Form']")).click(); 	
       driver.findElement(By.id("daterange")).click();
       WebElement apply =  driver.findElement(By.id("daterange"));   apply.sendKeys("03/01/2024 - 03/30/2024");///////////////////////////////Dynamic data   apply.sendKeys(Keys.ENTER);
      
    }
    

}
