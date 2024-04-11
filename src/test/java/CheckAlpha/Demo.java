package CheckAlpha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



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



    public void WriteDataExcel()
    {

    }

     


    
    public static void main(String[] args) throws IOException
     {
        Demo d = new Demo();
        d.ReadExcelData();
        d.chk();

     }
   
    
 

}
