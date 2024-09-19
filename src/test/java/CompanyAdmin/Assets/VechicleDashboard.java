package CompanyAdmin.Assets;


    import java.time.Duration;
import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class VechicleDashboard {
     WebDriver driver;
	

// Initializing driver & Closing after task executed
@BeforeSuite	
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

@Test
public void printTableData()
{
      
        driver .findElement(By.xpath("//a[normalize-space()='Assets']")).click();
        driver.findElement(By.xpath("//a[@href='https://dev.groundmetrx.com/inventory/vehicle-summary']")).click();
         List <WebElement>  tableAData=driver.findElements(By.xpath("  //div[@id='vehicle_summary_list_table_wrapper']//tr/td"));
         List <String> orginalList =tableAData.stream().map(s->s.getText()).collect(Collectors.toList());
         System.out.print(orginalList + " \t ");
         System.out.println();
}

}

