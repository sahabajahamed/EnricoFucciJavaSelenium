package DataFolder;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Data {

    WebDriver driver ;

    public static String TerminalName = "T";
    public static String RandTerminalStr = RandomStringUtils.randomAlphabetic(4);
    public static String SpotName = "S";
    public static String RandSpotStr = RandomStringUtils.randomAlphabetic(4);
    public static String TerminalEmail = "@yopmail.com";
    public static String RandTerminalEmail = RandomStringUtils.randomAlphabetic(4);

    public static String RandomUsername = RandomStringUtils.randomAlphabetic(6);
    
        

    public void StartBrowser()
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
    
    
    public static int getRandomTerminalNumber()
     {
        Random rand = new Random();
        int randomNumber1 = rand.nextInt(10000);
        int randomNumber2 = rand.nextInt(10000);

        return randomNumber1; // Adjust range as needed
    }
    
       
    public static long getRandomPhoneNumber()
    {
        Random rand1 = new Random();
        return rand1.nextLong(1000000000L, 9999999999L); // Adjust range as needed
    }



      // Asset module
///////////////////////////////////////////////////////////
    public static int getRandomTruckNumber()
    {
        Random rand3 = new Random();
        return rand3.nextInt(10000); // Adjust range as needed
    }

    public static String RandomTruckMake = RandomStringUtils.randomAlphanumeric(8);
    

    public static int getRandomTruckYear()
    {
        Random rand3 = new Random();
        return rand3.nextInt(2000,2053); // Adjust range as needed
    }




    //SuperAdmin Company Registeration
///////////////////////////////////////////////////////
 public static String RandomCompanyname = RandomStringUtils.randomAlphabetic(8);
//  public static String RandomCompanyEmail = RandomStringUtils.randomAlphabetic(4);
 public static String CompanyEmail = "@yopmail.com";
 public static String RandomCompanyUsernameEmail = RandomStringUtils.randomAlphabetic(8);






           // Read & show Specific column data from Web to console in VScode
/////////////////////////////////////////////////////////////////////////


 public void ShowSpecificTerminalColumnData()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
		driver.findElement(By.xpath("//a[text()='Terminals/Spots']")).click();

		WebElement table = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div[5]/div[1]/div[1]/div[2]/div/table/tbody"));

        // Specify the column index (0-based) from which you want to select random data
        int columnIndex = 1; // Example: selecting from the third column

        // Get all rows from the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Create a random number generator
        Random random = new Random();

        // Iterate through rows, start from index 1 to skip the header row
        // for (int i = 1; i < rows.size(); i++) {
        //     // Get the specific cell (data) in the column
        //     WebElement cell = rows.get(i).findElements(By.tagName("td")).get(columnIndex);

        //     // Print the data in the cell
        //     // System.out.println("Random data from column " + columnIndex + ": " + cell.getText());
        // }

        // Generate a random index within the range of the number of cells in the column
        int randomIndex = random.nextInt(rows.size() - 1) + 1; // Exclude the header row

        // Get the specific cell (data) in the column at the randomly generated index
       WebElement randomCell = rows.get(randomIndex).findElements(By.tagName("td")).get(columnIndex); 

        // Print the selected random data
        System.out.println("Randomly selected data from column " + columnIndex + ": " + randomCell.getText());       
		
	}





                    //Read specific column of Terminal from Excel sheet
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String ReadSpecificTerminalColumnExcel()
    {
        String filePath = "src/test/java/DataFolder/ExcelData/XlsxData.xlsx";
        
        // Column index from which you want to read random data (0-based index)
        int columnIndex = 1; // Example: reading from the first column

        try (FileInputStream fis = new FileInputStream(filePath)) {
            // Create a workbook object
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
            
            // Get the number of rows in the column
            int numRows = sheet.getLastRowNum() + 1;

            // Create a random number generator
            Random random = new Random();

            // Generate a random index within the range of the number of rows in the column
            int randomRowIndex = random.nextInt(numRows);

            // Get the cell at the random row index and specified column index
            Cell cell = sheet.getRow(randomRowIndex).getCell(columnIndex);

            // Get the cell value as a string
            String randomData = cell.getStringCellValue();

            // Print the random data
          //  System.out.println("Random data from column " + columnIndex + " and row " + (randomRowIndex + 1) + ": " + randomData);
            
        //   System.out.println(randomData);
        return randomData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;

    }




    //Random Origin Location for Routes
/////////////////////////////////////////////////////////////////////////////////////////////
public static String RandomOriginArray()
{
   String location [] = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","District Of Columbia","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming" };
   Random randlocation = new Random();
   int randomIndex = randlocation.nextInt(location.length);
   return location[randomIndex];
   //System.out.println("Random Value: " + location[randomIndex]);
}




    //Random Ownership dropdown data for Assets
////////////////////////////////////////////////////////////////////////////////////////
 public static String RandomOwnershipArray()
 {
    String Ownership [] = {"Finance","Lease","Paid Off"};
    Random randomownership = new Random();
    int rndomIndex = randomownership.nextInt(Ownership.length);
    return Ownership[rndomIndex];
 }





   //Random Department dropdown data for Assets
////////////////////////////////////////////////////////////////////////////////////////
public static String RandomDepartmentArray()
{
   String Department [] = {"Line Haul","P&D NY","P&D NJ"};
   Random randomdepartment = new Random();
   int rndomIndex = randomdepartment.nextInt(Department.length);
   return Department[rndomIndex];

}

  //Random Department dropdown data for Employee
////////////////////////////////////////////////////////////////////////////////////////
public static String RandomEmployeeDepartmentArray()
{
   String Department [] = {"Line Haul","P&D"};
   Random randomEmployeedepartment = new Random();
   int rndomIndex = randomEmployeedepartment.nextInt(Department.length);
   return Department[rndomIndex];

}


 //Random Type dropdown data for Employee
////////////////////////////////////////////////////////////////////////////////////////
public static String RandomEmployeeTypeArray()
{
   String Department [] = {"LH","Spot","P&D"};
   Random randomEmployeeType = new Random();
   int rndomIndex = randomEmployeeType.nextInt(Department.length);
   return Department[rndomIndex];

}




//////////// Random date for calender pick with (mm/dd/yyy) format
//////////////////////////////////////////////////////////////////////////////////
public static String RandomDate()
{
    String s = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    return s;
}


//////////// Random date FORMAT VERSION for calender pick with (mm-dd-yyy) format in AVR Dispatch
//////////////////////////////////////////////////////////////////////////////////
public static String RandomDateFormat()
{
    String s = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
    return s;
}



//////////// Random Time for calender pick with (mm/dd/yyy) format
//////////////////////////////////////////////////////////////////////////////////
public static String RandomTime()
{
    String s = new SimpleDateFormat("HH:mm").format(new Date());
    return s;
}




//////////// Random VIN for Truck
//////////////////////////////////////////////////////////////////////////////////
public static long RandomVIN()
{
    Random rndVIN = new Random();
   return rndVIN.nextLong(100000000000000000L);
}



////// Random FEDEX id for Employees
//////////////////////////////////////////////////////////////////////////////
public static Integer RandomFedexID()
{
    Random rndfedex = new Random();
    return rndfedex.nextInt(10000000);
}



///////////////////////////////////////////////////////////////////////////
 //Read specific column of Assets from Excel sheet
/////////////////////////////////////////////////////////////////////////////////////////////////////

public static String ReadSpecificAssetsColumnExcel()
{
    String filePath = "src\\test\\java\\DataFolder\\ExcelData\\AssetsXlsxData.xlsx";
    
    // Column index from which you want to read random data (0-based index)
    int columnIndex = 1; // Example: reading from the first column

    try (FileInputStream fis = new FileInputStream(filePath)) {
        // Create a workbook object
        Workbook workbook = new XSSFWorkbook(fis);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
        
        // Get the number of rows in the column
        int numRows = sheet.getLastRowNum() + 1;

        // Create a random number generator
        Random random = new Random();

        // Generate a random index within the range of the number of rows in the column
        int randomRowIndex = random.nextInt(numRows);

        // Get the cell at the random row index and specified column index
        Cell cell = sheet.getRow(randomRowIndex).getCell(columnIndex);

        // Get the cell value as a string
        String randomData = cell.getStringCellValue();

        // Print the random data
      //  System.out.println("Random data from column " + columnIndex + " and row " + (randomRowIndex + 1) + ": " + randomData);
        
    //   System.out.println(randomData);
    return randomData;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return filePath;

}


/////////////// Random Shift Array
////////////////////////////////////////////////////////////////////////////////////
public static String RandomShiftArray()
{
    String shift [] = {"AM","PM"};
    Random rndshift = new Random();
    int rndomIndex = rndshift.nextInt(shift.length);
   return shift[rndomIndex]; 
}



    
}
