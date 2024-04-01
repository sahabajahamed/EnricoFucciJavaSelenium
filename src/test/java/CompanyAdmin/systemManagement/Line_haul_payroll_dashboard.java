package CompanyAdmin.systemManagement;

import java.text.CollationElementIterator;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Line_haul_payroll_dashboard {
    WebDriver driver;
	

// Initializing driver & Closing after task executed
@BeforeMethod	
	public void OpenBrowser() 
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.get("https://dev.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("DHL");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("DHL@123456");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
   
}
@AfterMethod
public void closedBrowser()
{
    driver.quit();
    
}

/**
 * @throws InterruptedException
 */
@Test
    public void approveTimecard() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[normalize-space()='System Management']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Time Dashboard']")).click();
       List <WebElement> listApprovedata =driver.findElements(By.xpath("//div[@id='nav-tabContent']//tr/td[9]"));
      
  
       for (WebElement webElement : listApprovedata) {
        Thread.sleep(2000);
        webElement.click();

      

        

    }
}
}