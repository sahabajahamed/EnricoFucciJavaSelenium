package CompanyAdmin.Adminstration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import org.testng.annotations.Test;

import DataFolder.Data;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {
     WebDriver driver;
	
     static Integer RndFedex = Data.RandomFedexID(); 

// Initializing driver & Closing after task executed
@BeforeMethod	
	public void OpenBrowser() 
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.get("https://dev.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("qademo");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
   
}
@AfterMethod (enabled = false)
public void closedBrowser()
{
    driver.quit();
}



@Test
    public void AddEmployee()
    {        
    driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
    driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
    driver.findElement(By.xpath("//a[@data-bs-target='#ProfileUpdateModal']")).click();

    driver.findElement(By.id("driver_id")).sendKeys(Integer.toString(RndFedex));
    driver.findElement(By.id("password")).sendKeys(Integer.toString(RndFedex));
    driver.findElement(By.id("first_name")).sendKeys(Data.RandTerminalStr);
    driver.findElement(By.id("last_name")).sendKeys(Data.RandSpotStr);
    driver.findElement(By.id("usernameInputSec")).sendKeys(Data.RandomUsername);
    driver.findElement(By.id("manager_name")).sendKeys("null");
    driver.findElement(By.id("phone")).sendKeys(Long.toString(Data.getRandomPhoneNumber()));
    driver.findElement(By.id("home_terminal")).sendKeys(Data.ReadSpecificTerminalColumnExcel());
    driver.findElement(By.name("department")).sendKeys(Data.RandomEmployeeDepartmentArray());
    driver.findElement(By.id("card_expiration")).sendKeys(Data.RandomDate());
    driver.findElement(By.id("driver_type")).sendKeys(Data.RandomEmployeeTypeArray());
    driver.findElement(By.id("license_expiration")).sendKeys(Data.RandomDate());
    Select shift = new Select(driver.findElement(By.id("shift_time")));
    shift.selectByVisibleText(Data.RandomShiftArray());


    ///////// Getting Value of Entity from web & using it as input
    ////////////////////////////////////////////////////////////////////////////////
    WebElement dropdown = driver.findElement(By.name("entity_id"));

        // Get all options from the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Create a list to store dropdown values
        List<String> dropdownValues = new ArrayList<>();

        // Add each option's text to the dropdownValues list
        for (WebElement option : options) {
            dropdownValues.add(option.getText());
        }

        // Generate a random index to select a random value from the dropdownValues list
        Random random = new Random();
        int randomIndex = random.nextInt(dropdownValues.size());

        // Get the random value from the dropdownValues list
        String randomValue = dropdownValues.get(randomIndex);


    driver.findElement(By.id("entity_id")).sendKeys(randomValue);    





        
    }









//div[@id='activetab']//div[@class='common-listing-table']//tr/th[2]
@Test
public void employeeFedEX_Id_Sorting()
{
    driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
    driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
    driver.findElement(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/th[2]"));
    List <WebElement>listFedxID=driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[2]"));
    List <String> orginalList =listFedxID.stream().map(s->s.getText()).collect(Collectors.toList());
    List<String> sortedList=orginalList.stream().sorted().collect(Collectors.toList());
    System.out.println(sortedList + " All are Decendinng Order");
   
    Assert.assertNotEquals(orginalList, sortedList);
}

@Test
public void employee_First_Name_Sorting()
{
    driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
    driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
    driver.findElement(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/th[4]")).click();
    List <WebElement> list=driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[4]"));
    List <String >collectList=list.stream().map(s->s.getText()).collect(Collectors.toList());
    System.out.println(collectList);
    List <String>newList=collectList.stream().sorted().collect(Collectors.toList());  

}

@Test
public  void employee_Last_Name_Sorting() throws InterruptedException
{
    //div[@id='activetab']//div[@class='common-listing-table']//tr/td[13]
   driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
		driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[13]"));

		for (WebElement webElement : list) {
        
        Thread.sleep(2000);
                try {
                    webElement.click();
                    
                } catch (Exception e) {
                   list= driver.findElements(By.id("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[13]"));
                }
                Thread.sleep(2000);
		    Select select = new Select(driver.findElement(By.xpath("//select[@id='swal2-select']")));
		    select.selectByVisibleText("Terminated");
            Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
            Thread.sleep(2000);
			WebElement mesge = driver.findElement(By.xpath("//div[@id='swal2-html-container']"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			
			
		
}
}
}

