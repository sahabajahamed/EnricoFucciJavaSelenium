package DriverPanel;

import java.time.Duration;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Test;

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
	
		driver.get("https://dev.groundmetrx.com/company/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys(" jenifer");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);
   
}
@AfterMethod ()
public void closedBrowser()
{
    driver.findElement(By.xpath("//button[@id='end_your_day_btn']")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Clock out']")).click();
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
    Thread.sleep(2000);
    List <WebElement> list_OperationalChecks= driver.findElements(By.xpath("//div[@class='indivudial_card_item card_field_list_4']//button[@class='btn field_success_btn']"));
    for (WebElement webElement : list_OperationalChecks) 
    {

        webElement.click();
        
    }

    Thread.sleep(2000);
    js.executeScript("window.scrollTo(0, 0)");
    Thread.sleep(2000);

    
    String imagePath="/home/wadmin/EnricoFucciJavaSelenium/src/test/java/Image/Screenshot.png";
    Thread.sleep(2000);
    WebElement image=driver.findElement(By.xpath("//label[@data-card-id='37']"));
    Thread.sleep(2000);
    image.sendKeys(imagePath);
    
    // Actions act= new Actions(driver) ;
    // act.moveToElement(image).click().build().perform();
    // Robot rb = new Robot();
    // rb.delay(2000);
    //  StringSelection ss=new StringSelection("/home/wadmin/EnricoFucciJavaSelenium/src/test/java/Image/Screenshot.png");
    //  Toolkit.getDefaultToolkit().getSystemClipboard().getContents(ss);
    //  rb.keyPress(KeyEvent.VK_CONTROL);
    //  rb.keyPress(KeyEvent.VK_V);

    //  rb.keyRelease(KeyEvent.VK_CONTROL);
    //  rb.keyRelease(KeyEvent.VK_V);

    //  rb.keyPress(KeyEvent.VK_ENTER);
    //  rb.keyRelease(KeyEvent.VK_ENTER);

    


  

   

        
    
    
    
}

    
    
}
