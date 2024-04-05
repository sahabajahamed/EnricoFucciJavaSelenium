package SuperAdmin;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import DataFolder.Data;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class Superadmin {

    WebDriver driver;
    
    static long RanPhone = Data.getRandomPhoneNumber();
    

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
        
        driver.get("https://dev-test.groundmetrx.com/masterAdmin/login");
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
        driver.findElement(By.id("name")).sendKeys(Data.RandomCompanyname);
        driver.findElement(By.id("email")).sendKeys(Data.RandomCompanyUsernameEmail + Data.CompanyEmail); 
        driver.findElement(By.id("companyAdminUsername")).sendKeys(Data.RandomCompanyUsernameEmail);
        driver.findElement(By.id("phone")).sendKeys(Long.toString(RanPhone));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('submitCompanyModalBtn').click()");
        


    }
}
