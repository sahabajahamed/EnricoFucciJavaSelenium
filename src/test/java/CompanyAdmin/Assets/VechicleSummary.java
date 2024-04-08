package CompanyAdmin.Assets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



import DataFolder.Data;



public class VechicleSummary {
   

	WebDriver driver;
	String msg = "AVR has been successfully inserted";

    static int RanTruck = Data.getRandomTruckNumber();
    static int RanTruckYear = Data.getRandomTruckYear();

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
	
		driver.get("https://dev-test.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("qademo");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
	}
	
@AfterSuite (enabled = false)
  public void Closebrowser()
  {
	driver.quit();
  }

    


  @Test 
  public void AddAssets()
  {
    driver.findElement(By.xpath("//a[normalize-space()='Assets']")).click();
    driver.findElement(By.xpath("//a[normalize-space()='Vehicle Summary']")).click();
    driver.findElement(By.xpath("//a[@data-bs-target='#add-asset-modal']")).click();

    driver.findElement(By.id("truck_number")).sendKeys(Integer.toString(RanTruck));
    Select Entity = new Select(driver.findElement(By.id("entity_id")));
    Entity.selectByVisibleText("DHL");
    driver.findElement(By.id("make")).sendKeys(Data.RandomTruckMake);
    driver.findElement(By.id("make")).sendKeys(Integer.toString(RanTruckYear));
    driver.findElement(By.id("asset_type")).sendKeys(Data.RandTerminalStr); 
    Select Department = new Select(driver.findElement(By.id("team")));
    Department.selectByVisibleText("Line Haul");
    Select Ownership = new Select(driver.findElement(By.id("ownership")));
    Ownership.selectByVisibleText("Finance");
    
    

  }


  public static void main(String[] args) {
    System.out.println();
    
  }


}
