package CompanyAdmin.LineHaul;

import java.time.Duration;
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

// Importing manual created class for Code-Reusability

import DataFolder.Data;


public class TerminalSpot extends Data
{
    
    WebDriver driver;
	String msg = "AVR has been successfully inserted";

	static int RanTermi = Data.getRandomNumber();

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
    public void AddTerminal()
    {   
		driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
		driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
		driver.findElement(By.linkText("Add New Terminal")).click();

		driver.findElement(By.id("terminal_number")).sendKeys(Integer.toString(RanTermi));
		driver.findElement(By.id("terminal_name")).sendKeys(Data.Term + Data.str); 
        driver.findElement(By.id("abbreviation")).sendKeys(Data.str);
		driver.findElement(By.id("email")).sendKeys("tdemo@yopmail.com");
		driver.findElement(By.id("phone")).sendKeys("7456378293");
		driver.findElement(By.id("terminal_address")).sendKeys("pawn");
		// driver.findElement(By.xpath("//button[@class='w-100 btn btn-primary']")).click();
		
		
    }
    
	public static void main(String[] args) {
		System.out.println(Integer.toString(RanTermi));
		
	}

}
