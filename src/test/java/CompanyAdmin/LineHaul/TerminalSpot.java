package CompanyAdmin.LineHaul;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

// Importing manual created class for Code-Reusability

import DataFolder.Data;
import CheckAlpha.*;


public class TerminalSpot extends Data
{
    
    WebDriver driver;
	String msg = "AVR has been successfully inserted";

	static int RanTermi = Data.getRandomTerminalNumber();
	static long RanPhone = Data.getRandomPhoneNumber();

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
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("qademo");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
		

   }

   @AfterSuite (enabled = false)
  public void Closebrowser()
  {
	driver.quit();
  }



  // Add New Terminal
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test 
    public void AddTerminal() throws InterruptedException, IOException
    {   
		driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
		driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
		driver.findElement(By.linkText("Add New Terminal")).click();

		WebElement location = driver.findElement(By.id("terminal_address")); //
		location.sendKeys(RandTerminalStr);
		Thread.sleep(4000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);
		

		driver.findElement(By.id("terminal_number")).sendKeys(Integer.toString(RanTermi));
		driver.findElement(By.id("terminal_name")).sendKeys(TerminalName + RandTerminalStr); 
        driver.findElement(By.id("abbreviation")).sendKeys(RandTerminalStr);
		driver.findElement(By.id("email")).sendKeys(RandTerminalEmail + TerminalEmail);
		driver.findElement(By.id("phone")).sendKeys(Long.toString(RanPhone));

		driver.findElement(By.xpath("//button[@class='w-100 btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		
    }
    
	
    
	///////////////  Show Terminal list in console here in VScode 
//////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void ShowTerminalData()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
		driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();

		
		// WebElement table = driver.findElement(By.id("terminals_list_table"));
		WebElement table = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div[5]/div[1]/div[1]/div[2]/div/table/tbody"));
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

	



	///////////////  Write existing Terminal data from Web to Excel to reuse it later
//////////////////////////////////////////////////////////////////////////////////////////////////////	

@Test
 public void WriteTerminalDataExcel()
 {
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
   
	// Locate the table element
	WebElement table = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div[5]/div[1]/div[1]/div[2]/div/table/tbody"));

	// Get all rows from the table
	List<WebElement> rows = table.findElements(By.tagName("tr"));

	// Create a new Workbook
	Workbook workbook = new XSSFWorkbook();
	// Create a Sheet
	Sheet sheet = workbook.createSheet("TerminalData");

	// Counter for Excel row
	int rowNum = 1;

	// Iterate through rows
	for (WebElement row : rows) 
	{
		// Create a new Excel row
		Row excelRow = sheet.createRow(rowNum++);
		// Get all columns for each row
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int colNum = 0;
		// Iterate through columns
		for (WebElement column : columns) {
			// Get the text content of the cell
			String cellText = column.getText();
			// Create a new cell in the Excel row and set its value
			excelRow.createCell(colNum++).setCellValue(cellText);
		}
	}

	// Write the workbook content to a file
	try (FileOutputStream outputStream = new FileOutputStream("src\\test\\java\\DataFolder\\ExcelData\\XlsxData.xlsx")) {
		workbook.write(outputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.println("Terminals written on Excel sheet successfully");
 }

	



 @Test
 public void AddSpot() throws InterruptedException
 {
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
    driver.findElement(By.id("spots-tab")).click(); 
	driver.findElement(By.linkText("Add New Spot")).click();

	WebElement location = driver.findElement(By.id("spot_address")); //
		location.sendKeys(RandTerminalStr);
		Thread.sleep(4000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);

	driver.findElement(By.id("spot_number")).sendKeys(Integer.toString(RanTermi));
	driver.findElement(By.id("spot_name")).sendKeys(SpotName + RandSpotStr);	
    driver.findElement(By.cssSelector(".col-lg-6:nth-child(3) #email")).sendKeys(RandTerminalEmail + TerminalEmail);
	driver.findElement(By.cssSelector(".col-lg-6:nth-child(4) #phone")).sendKeys(Long.toString(RanPhone));
	WebElement HomeTerminal = driver.findElement(By.id("home_terminal"));
	HomeTerminal.sendKeys(Data.ReadSpecificTerminalColumnExcel());
	Thread.sleep(4000);
	HomeTerminal.sendKeys(Keys.ARROW_DOWN);
	HomeTerminal.sendKeys(Keys.ENTER);
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("document.getElementById('schedule_priority').click()");
	driver.findElement(By.xpath("//button[normalize-space()='Add Spot']")).click();
	driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
 }





 @Test
 	public void AddRoute()
	{
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
    driver.findElement(By.id("routes-tab")).click(); 
	driver.findElement(By.linkText("Add New Route")).click();

	driver.findElement(By.id("origin")).sendKeys(Data.ReadSpecificTerminalColumnExcel()); 
	driver.findElement(By.id("destination")).sendKeys(Data.ReadSpecificTerminalColumnExcel()); // "RanTermi" can also be used, but it will again give same number. So that's why again called it to get new Random number
	driver.findElement(By.id("route_display")).sendKeys(RandTerminalStr);
	driver.findElement(By.id("of_miles")).sendKeys(Integer.toString(Data.getRandomTerminalNumber()));
	Select originlocation = new Select(driver.findElement(By.id("state")));
	originlocation.selectByVisibleText(Data.RandomOriginArray());
	driver.findElement(By.xpath("//button[normalize-space()='Add Route']")).click();
	driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
  	}
	



@Test
public void AddEnroute()throws InterruptedException
{
	driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
	driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();
    driver.findElement(By.id("enroutes-tab")).click(); 
	driver.findElement(By.linkText("Add New Enroute")).click();


	WebElement location = driver.findElement(By.id("enroute_address")); //
		location.sendKeys(RandTerminalStr);
		Thread.sleep(4000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);
	driver.findElement(By.id("enroute_number")).sendKeys(Integer.toString(RanTermi));
	driver.findElement(By.id("enroute_name")).sendKeys(RandTerminalStr);
	driver.findElement(By.cssSelector(".col-lg-6:nth-child(3) #email")).sendKeys(RandTerminalEmail + TerminalEmail);
	driver.findElement(By.id("phone_number")).sendKeys(Long.toString(RanPhone));
	driver.findElement(By.xpath("//button[normalize-space()='Add Enroute']")).click();
	driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
}	



	
	


}
