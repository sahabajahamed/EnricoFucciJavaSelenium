package DriverPanel;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Pre_inspection_form {
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
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("jenifer");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
   
}
@AfterMethod ()
public void closedBrowser()
{
    // driver.findElement(By.xpath("//button[@id='end_your_day_btn']")).click();
    // driver.findElement(By.xpath("//button[normalize-space()='Clock out']")).click();
    driver.quit();

}

@org.testng.annotations.Test
public void Pre_inspection_form_fillUp()throws Exception
{
    driver.findElement(By.xpath("//a[normalize-space()='Line Haul']")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Driver AVR')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[normalize-space()='Clock In']")).click();
    Select selectAsset= new Select(driver.findElement(By.xpath("//select[@id='asset_id']")));
    selectAsset.selectByVisibleText("1616");

    //list_ExternalChecks click
    driver.findElement(By.xpath("//div[@class='card-footer parent_footer_1']//input[@value='Check']")).click();
    List <WebElement> list_ExternalChecks=driver.findElements(By.xpath("//div[@class='indivudial_card_item card_field_list_1']//button[@class='btn field_success_btn']"));
    for (WebElement webElement : list_ExternalChecks) {
        webElement.click();
    }
   
    Thread.sleep(2000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(1000, document.body.scrollHeight)");

    js.executeScript("window.scrollTo(600, 300)");
   

    //list_EngineCompartment click
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='card-footer parent_footer_2']//input[@value='Check']")).click();
    List <WebElement> list_EngineCompartment= driver.findElements(By.xpath("//div[@class='indivudial_card_item card_field_list_2']//button[@class='btn field_success_btn']"));
    for (WebElement webElement : list_EngineCompartment) {
        webElement.click();
        
    }
  
    //te_CabInterior click
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='card-footer parent_footer_3']//input[@value='Check']")).click();
    List <WebElement> liste_CabInterior=driver.findElements(By.xpath("//div[@class='indivudial_card_item card_field_list_3']//button[@class='btn field_success_btn']"));
    for (WebElement webElement : liste_CabInterior) {
        webElement.click();
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='card-footer parent_footer_4']//input[@value='Check']")).click();
    List <WebElement> list_OperationalChecks= driver.findElements(By.xpath("//div[@class='indivudial_card_item card_field_list_4']//button[@class='btn field_success_btn']"));
    for (WebElement webElement : list_OperationalChecks) 
    {

        webElement.click();
        
    }
    //scroll up
    Thread.sleep(2000);
    js.executeScript("window.scrollTo(0, 0)");
    Thread.sleep(2000);

    String imagPath="/home/wadmin/EnricoFucciJavaSelenium/src/test/java/DataFolder/Image/Screenshot.png";
    //Odometer - Enter Mileage (Image Required)

    driver.findElement(By.xpath("//span[normalize-space()='Add File Dash']/following-sibling::input")).sendKeys(imagPath); 
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Enter Mileage']")).sendKeys("100");
    driver.findElement(By.xpath("//input[@class='photo_form_submit add_mileage_card']")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Pass']")).click();
    
    //Engine Compartment Issues or Damage Images to Upload
    Thread.sleep(2000);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    driver.findElement(By.xpath("//div[@class='card mt-4 parent_card_39']//span[@class='title'][normalize-space()='Add File Dash']/following-sibling::input")).sendKeys(imagPath);
    Thread.sleep(3000);
    driver.findElement(By.name("card_comments[39]")).sendKeys("Issues or Damage Images to Upload");
    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    driver.findElement(By.xpath("(//input[@value='Ok'])[30]")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Pass']")).click();
    Thread.sleep(3000);

    //Is the Fire Extinguisher Fully Charged radio button 

    driver.findElement(By.xpath("(//input[@id='multichoise_42'])[1]")).click();
    js.executeScript("window.scrollTo(0, 0)");

    //Message on the Dash Display
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@class='card mt-4 parent_card_38']//span[@class='title'][normalize-space()='Add File Dash']/following-sibling::input[@name='image']")).sendKeys(imagPath);
    Thread.sleep(3000);
    driver.findElement(By.name("card_comments[38]")).sendKeys("Message on the Dash Display");
    driver.findElement(By.cssSelector("div[class='card mt-4 parent_card_38'] input[value='Ok']")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Fail']")).click();
    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    //Does truck have any other issues not mentioned? If yes take picture of damage and write comment. Skip if no
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@class='photo_form_submit add_photo_comment_optional_card']")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Pass']")).click();
    Thread.sleep(3000);

    //Please Sign perform
    WebElement signature=driver.findElement(By.xpath("//canvas[@id='signature_canvas']"));
    Actions act= new Actions(driver);
    Thread.sleep(3000);
    act.clickAndHold(signature).moveByOffset(50, 50).perform();
    act.moveByOffset(100, 0).moveByOffset(0, 100).moveByOffset(-100, 0).moveByOffset(0, -100).release().perform();

    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='submit_signature']")).click();
    
    //scroll up & click on Save button 
    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0, 0)");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class='btn save_btn desktop_submit_btn']")).click();

    //Verified pre-form submit or not 
    WebElement message =driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    String expectedMessage=message.getText();
    String actualMessage="Pre form Submitted Successfully";
    Assert.assertEquals(expectedMessage, actualMessage); 
    
    
}

    
    
}
