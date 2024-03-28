package SuperAdmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Superadmin {

    WebDriver driver;


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
        
        driver.get("https://dev.groundmetrx.com/masterAdmin/login");
        driver.findElement(By.id("email")).sendKeys("rpr5@getnada.com");
        driver.findElement(By.id("password")).sendKeys("gm@123");
        driver.findElement(By.xpath("//button[@class='btn btnBlue rounded']")).click();

    }


    @AfterSuite (enabled = false)
  public void Closebrowser()
  {
	driver.quit();
  }



    

    @Test
    public void AddNewCompany()
    {
        driver.findElement(By.xpath("//a[normalize-space()='Companies']")).click();
        driver.findElement(By.id("addCompanyModal")).click();
        driver.findElement(By.id("name")).sendKeys("Flipkart");
        driver.findElement(By.id("email")).sendKeys("payd@yopmail.com"); 
        driver.findElement(By.id("companyAdminUsername")).sendKeys("Comadmin");
        driver.findElement(By.id("phone")).sendKeys("8563214521");
        driver.findElement(By.xpath("//input[@id='submitCompanyModalBtn']")).click();

    }
}
