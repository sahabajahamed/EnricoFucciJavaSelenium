package DataFolder;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class Data {

   static WebDriver driver;

    public static String TerminalName = "T";
    public static String RandTerminalStr = RandomStringUtils.randomAlphabetic(4);
    public static String TerminalEmail = "@yopmail.com";
    public static String RandTerminalEmail = RandomStringUtils.randomAlphabetic(4);
    
    
    public static int getRandomTerminalNumber()
     {
        Random rand = new Random();
        return rand.nextInt(10000); // Adjust range as needed
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
        return rand3.nextInt(2000,3000); // Adjust range as needed
    }




    //SuperAdmin Company Registeration
///////////////////////////////////////////////////////
 public static String RandomCompanyname = RandomStringUtils.randomAlphabetic(8);
//  public static String RandomCompanyEmail = RandomStringUtils.randomAlphabetic(4);
 public static String CompanyEmail = "@yopmail.com";
 public static String RandomCompanyUsernameEmail = RandomStringUtils.randomAlphabetic(8);






           //Specific data from terminal
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







    
}
