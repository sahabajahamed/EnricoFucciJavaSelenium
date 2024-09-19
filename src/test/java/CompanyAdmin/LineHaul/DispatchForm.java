package CompanyAdmin.LineHaul;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import DataFolder.Data;

public class DispatchForm {
	
	
	String msg = "AVR has been successfully inserted";
	
	WebDriver driver ;


// Initializing driver & Closing after task executed
@BeforeSuite	
	public void OpenBrowser() 
	{
		
	   Data dt = new Data();
	   dt.StartBrowser();
	}
	
@AfterSuite (enabled = false)
  public void Closebrowser()
  {
	driver.quit();
  }
	





@Test 
public void AddDispatchviaAdmin() throws InterruptedException 
{
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Dispatch Form']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Add New Record']")).click();
	driver.findElement(By.id("created_date")).sendKeys(Data.RandomDateFormat());
	driver.findElement(By.name("created_time")).sendKeys(Data.RandomTime()); 
	
	WebElement employee = driver.findElement(By.name("driver_name")); //
	employee.sendKeys("James Anderson");
	Thread.sleep(4000);
	employee.sendKeys(Keys.ARROW_DOWN);
	employee.sendKeys(Keys.ENTER);
	
	driver.findElement(By.id("tractor_number")).sendKeys(Data.ReadSpecificAssetsColumnExcel());///////////////////Dynamic data
	
	driver.findElement(By.id("dispatch_from")).sendKeys(Data.ReadSpecificTerminalColumnExcel());
		Select DFs = new Select(driver.findElement(By.id("dispatch_from_type")));
	DFs.selectByVisibleText("Terminal");                ///////////////////////////Dynamic data
	
	
	driver.findElement(By.id("dispatch_to")).sendKeys(Data.ReadSpecificTerminalColumnExcel());
	Select DTs = new Select(driver.findElement(By.id("dispatch_to_type")));
	DTs.selectByVisibleText("Terminal");                /////////////////////////////Dynamic data
	
	
	driver.findElement(By.name("trailer_1")).sendKeys("1245");
	driver.findElement(By.name("trailer_2")).sendKeys("5421");
	
	driver.findElement(By.name("start_mileage")).sendKeys("2");////////////////////Dynamic data
	driver.findElement(By.id("avr_submit_btn")).click();
	
	
	// Perform actions that trigger an error, then locate the error message element
    WebElement errorMessageElement = driver.findElement(By.id("swal2-html-container"));
    
    // Get the text of the error message
    String actualErrorMessage = errorMessageElement.getText();
    
    // Define the expected error message
    String expectedErrorMessage = "AVR has been successfully inserted";
    
    
    // Assert that the actual error message matches the expected error message
    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    
      
}





@Test (invocationCount = 4)
public void SearchByDateDispatch() 
{   
   driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
   driver.findElement(By.xpath("//a[normalize-space()='Dispatch Form']")).click(); 	
   driver.findElement(By.id("daterange")).click();
   WebElement apply =  driver.findElement(By.id("daterange"));   
   apply.sendKeys("03/01/2024 - 03/30/2024");///////////////////////////////Dynamic data   
}

//GH/




	
  @Test
  public void ShowDispatchTableData() 
  {
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Dispatch Form']")).click();

	//driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys("wasim");	  // Search by keyword
		
//		 Select SL = new Select(driver.findElement(By.name("drivers_list_table_length")));      //Select table length         
//		 SL.selectByIndex(0);
		
		WebElement table = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div[2]/div[6]/div/div[2]/table/tbody"));
		List<WebElement> rows = new ArrayList<WebElement>();
		rows = table.findElements(By.tagName("tr"));
		 for (WebElement row : rows) 
		 	{
	            // Get all columns for each row
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            // Iterate through columns
	            for (WebElement column : columns) {
	            	
	            	
	                // Print text content of each cell
	                System.out.print(column.getText() + "\t");
	            
	            }
	            // Move to the next line after printing all columns of a row
	            System.out.println();
	        }

  
  }
  
  
  
  

// Abhishek change

}
  