package CompanyAdmin.Adminstration;

import java.time.Duration;
import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {
     WebDriver driver;
	

// Initializing driver & Closing after task executed
@BeforeMethod	
	public void OpenBrowser() 
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


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
//div[@id='activetab']//div[@class='common-listing-table']//tr/th[2]
@Test
public void employeeFedEX_Id_Sorting()
{
    driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
    driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
    driver.findElement(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/th[2]"));
    List <org.openqa.selenium.WebElement>listFedxID=driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[2]"));
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
    List <org.openqa.selenium.WebElement> list=driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[4]"));
    List <String >collectList=list.stream().map(s->s.getText()).collect(Collectors.toList());
    System.out.println(collectList);
    List <String>newList=collectList.stream().sorted().collect(Collectors.toList());  

}

@Test
public  void employee_Last_Name_Sorting()
{
//     //div[@id='activetab']//div[@class='common-listing-table']//tr/td[13]
//    driver.findElement(By.xpath("//a[normalize-space()='Administration']")).click();
// 		driver.findElement(By.xpath(" //a[normalize-space()='Employees']")).click();
// 		List<WebElement> list = driver.findElements(By.xpath("//div[@id='activetab']//div[@class='common-listing-table']//tr/td[13]"));
// 		for (WebElement webElement : list) {
// 			webElement.click();

// 			Select select = new Select(driver.findElement(By.xpath("//select[@id='swal2-select']")));
// 			select.deselectByVisibleText("Terminated");
// 			driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
// 			WebElement mesge = driver.findElement(By.xpath("//div[@id='swal2-html-container']"));
// 			String expectedMessage = mesge.getText();
// 			String actual_message="The Driver has been updated successfully";
// 			Assert.assertEquals(expectedMessage, actual_message);

}
}

