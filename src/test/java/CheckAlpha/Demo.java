package CheckAlpha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Demo
{
    String ad;

    public  static String ReadExcelData() throws IOException
    {   
        //Create an object of File class to open xlsx file
        File fl = new File("src\\test\\java\\DataFolder\\ExcelData\\XlsData.xls"); 
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(fl);

        //Creating workbook instance that refers to .xls file
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        HSSFSheet sheet= wb.getSheet("Sheet1");

        //Create a row object to retrieve row at index 3
        HSSFRow row =sheet.getRow(3);
        
        //Create a cell object to retreive cell at index 4
        HSSFCell cell=row.getCell(4);
        
        //Get the address in a variable
        String address = cell.getStringCellValue();
        
        return address;
        //Printing the address
        // System.out.println("Address is :"+ address);        
       
        // this.ad = address;
        // System.out.println("Address is :"+ ad);
    }
    


    public void chk()
    {
        System.out.println("Address is :" + ad);
    }



    @SuppressWarnings("deprecation")
    public void RandomName() throws IOException
    {
    URL url = new URL("https://api.api-ninjas.com/v1/randomuser");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("accept", "application/json");
    InputStream responseStream = connection.getInputStream();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(responseStream);
    System.out.println(root.path("fact").asText());

    }
   
     


    
    public static void main(String[] args) throws IOException
     {
        Demo d = new Demo();
        d.RandomName();
        

     }
   
    
 

}
