package CompanyAdmin.Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.*;

public class ReportsChecked {

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


@Test
public void Userverifiedto_IVMRreport()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement tittle=driver.findElement(By.xpath("//h4[normalize-space()='IVMR Report']"));
    tittle.click();
    String text=tittle.getText();
    String actualText="IVMR Report";
    Assert.assertEquals(text,actualText);

}

@Test
public void userVerifiedLine_Haul_Profitability_Report()
{
    
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
   WebElement tittle =driver.findElement(By.xpath("//a[@href='/linehaul-profitability-report']//div[@class='inn-content']"));
   tittle.click();
   String textt=tittle.getText();
   String actual = "Line Haul Profitability Report";
   Assert.assertEquals(textt,actual);


}
@Test
public void userVerified_Linehaul_Payroll()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement lineHaulClick=driver.findElement(By.xpath("//a[@href='/reports/linehaul-payroll']//div[@class='inn-content']"));
    lineHaulClick.click();
    String linehaulTittle=lineHaulClick.getText();
    String actualLinehaulPayroll="Linehaul Payroll";
    Assert.assertEquals(linehaulTittle,actualLinehaulPayroll);

}
@Test
public void userVerified_AVR_Daily_Pickup()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement avrDailypickup=driver.findElement(By.xpath("//a[@href='/reports/avr-daily-pickup-daily-totals']//div[@class='inn-content']"));
    avrDailypickup.click();
    String avrdailypickupTittle=avrDailypickup.getText();
    String actualaveDailypickUp="AVR Daily Pickup (Daily Totals)";
    Assert.assertEquals(avrdailypickupTittle,actualaveDailypickUp);
}

@Test
public void userVerified_IVMR_Bulk_Report()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement IvmrBulkReport=driver.findElement(By.xpath("//a[@href='/reports/ivmr/bulk']//div[@class='inn-content']"));
    IvmrBulkReport.click();
    String expecredTittle= IvmrBulkReport.getText();
    String actualTittle="IVMR Bulk Report";
    Assert.assertEquals(expecredTittle,actualTittle);
}
@Test
public  void userVerified_Linehaul_Activity_Summary()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement lineHaulSummary=driver.findElement(By.xpath("//h4[normalize-space()='Line Haul Activity Summary']"));
    lineHaulSummary.click();
    String expectedResult=lineHaulSummary.getText();
    String actualResult="Linehaul Activity Summary";
    Assert.assertEquals(expectedResult,actualResult);

}

@Test
public void userVerified_Linehaul_Leg_Estimator()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement legEstimator= driver.findElement(By.xpath("//a[@href='/leg-estimation']//div[@class='inn-content']"));
    legEstimator.click();
    String expectedResult= legEstimator.getText();
    String actualMessage="Linehaul Leg Estimator";
    Assert.assertEquals(expectedResult,actualMessage);
    
    
}

@Test
public void userVerified_Line_Haul_Settlement_Estimator()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement settElementEsElement= driver.findElement(By.xpath("//a[@href='/line-haul-settlement-estimator']//div[@class='inn-content']"));
    settElementEsElement.click();
    String expectedResult= settElementEsElement.getText();
    String actualResult="Line Haul Settlement Estimator";
    Assert.assertEquals(expectedResult,actualResult);

}

@Test
public void userVerified_Line_Haul_Payroll_automation()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement payrollAutomation= driver.findElement(By.xpath("//a[@href='/linehaul-payroll-automation']//div[@class='inn-content']"));
    payrollAutomation.click();
    String expectedResult= payrollAutomation.getText();
    String actualResult= "Line Haul Payroll Automation";
    Assert.assertEquals(expectedResult,actualResult);
    


}
@Test
public void userVerified_Settalment_No_Revenue()
{
    driver.findElement(By.xpath("//a[normalize-space()='Reports']")).click();
    WebElement settElementRevenue= driver.findElement(By.xpath("//a[@href='/settlement-no-revenue']//div[@class='inn-content']"));
    settElementRevenue.click();
    String expectedResult= settElementRevenue.getText();
    String actualResult="Settlement No Revenue";
    Assert.assertEquals(expectedResult,actualResult);
    

}



}




