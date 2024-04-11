package CompanyAdmin.SystemManagement;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Time_dashboard {

    WebDriver driver;

    /**
     * 
     */
    @BeforeMethod
    public void browserOpen()
    {
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
		driver.get("https://dev-test.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("DHL");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("DHL@123456");
        driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);


    }

    @AfterMethod
    public void closedBrowser()
    {
        driver.quit();
    }


   @Test
   public void nevigateTotimeDashboard()
   {
        driver.findElement(By.xpath("//a[normalize-space()='System Management']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Time Dashboard']")).click();
        String tittle = driver.getTitle();
        String expectedTittle= "Time Dashboard";
        
       AssertJUnit.assertEquals(tittle , expectedTittle,"Time Dashboard");
       



   }
}
