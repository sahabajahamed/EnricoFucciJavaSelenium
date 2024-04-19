package CompanyAdmin.Assets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import DataFolder.Data;



public class VechicleSummary {
   

	WebDriver driver;
	String msg = "AVR has been successfully inserted";

    static int RanTruck = Data.getRandomTruckNumber();
    static int RanTruckYear = Data.getRandomTruckYear();
    static long RNVIN = Data.RandomVIN();

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

    


  ///////////// Add new Assets in web
/////////////////////////////////////////////////////////////////////////////////////////
  @Test 
  public void AddAssets() throws InterruptedException
  {
    driver.findElement(By.xpath("//a[normalize-space()='Assets']")).click();
    driver.findElement(By.xpath("//a[normalize-space()='Vehicle Summary']")).click();
    driver.findElement(By.xpath("//a[@data-bs-target='#add-asset-modal']")).click();

    driver.findElement(By.id("truck_number")).sendKeys(Integer.toString(RanTruck));
    Select Entity = new Select(driver.findElement(By.id("entity_id")));
    Entity.selectByVisibleText("DHL");
    driver.findElement(By.id("make")).sendKeys(Data.RandomTruckMake);
    driver.findElement(By.id("year")).sendKeys(Integer.toString(RanTruckYear));
    driver.findElement(By.id("asset_type")).sendKeys(Data.RandTerminalStr); 
    Select Department = new Select(driver.findElement(By.id("team")));
    Department.selectByVisibleText(Data.RandomDepartmentArray());
    Select Ownership = new Select(driver.findElement(By.id("ownership")));
    Ownership.selectByVisibleText(Data.RandomOwnershipArray());

    WebElement physicallocation = driver.findElement(By.id("location"));
    physicallocation.sendKeys(Data.ReadSpecificTerminalColumnExcel());
    Thread.sleep(4000);
	  physicallocation.sendKeys(Keys.ARROW_DOWN);
	  physicallocation.sendKeys(Keys.ENTER);

    driver.findElement(By.id("reg-date")).sendKeys(Data.RandomDate());
    driver.findElement(By.id("inspect-date")).sendKeys(Data.RandomDate());
    driver.findElement(By.id("license_plate")).sendKeys(Data.RandTerminalStr);
    driver.findElement(By.id("vin")).sendKeys(Long.toString(RNVIN));
    
    WebElement domicilelocation = driver.findElement(By.id("home_location"));
    domicilelocation.sendKeys(Data.ReadSpecificTerminalColumnExcel());
    Thread.sleep(4000);
	  domicilelocation.sendKeys(Keys.ARROW_DOWN);
	  domicilelocation.sendKeys(Keys.ENTER);

    driver.findElement(By.xpath("//input[@value='Submit']")).click(); 
  }


/////////////// Write Assets data from web to Excel
//////////////////////////////////////////////////////////////////////////////////////////

@Test
 public void WriteAssetsDataExcel()
 {
  driver.findElement(By.xpath("//a[normalize-space()='Assets']")).click();
  driver.findElement(By.xpath("//a[normalize-space()='Vehicle Summary']")).click();
   
	// Locate the table element
	WebElement table = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div[2]/div[5]/div/table/tbody"));

	// Get all rows from the table
	List<WebElement> rows = table.findElements(By.tagName("tr"));

	// Create a new Workbook
	Workbook workbook = new XSSFWorkbook();
	// Create a Sheet
	Sheet sheet = workbook.createSheet("AssetsData");

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
	try (FileOutputStream outputStream = new FileOutputStream("src/test/java/DataFolder/ExcelData/XlsxData.xlsx")) {
		workbook.write(outputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.println("Assets written on Excel sheet successfully");
 }



 







}
