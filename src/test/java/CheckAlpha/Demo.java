package SuperAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Demo
{
    String f;

    public String show() throws IOException
    {
        File fl = new File("src\\test\\java\\DataFolder\\ExcelData\\XlsData.xls");

        FileInputStream inputStream = new FileInputStream(fl);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet("Sheet1");
        HSSFRow row2=sheet.getRow(1);
        
        //Create a cell object to retreive cell at index 5
        HSSFCell cell=row2.getCell(4);
        
        //Get the address in a variable
        String address= cell.getStringCellValue();
        
        
        return address;
        //Printing the address
        // System.out.println("Address is :"+ address);        
       
        
    }


     
    public static void main(String[] args) throws IOException
     {
        Demo d = new Demo();
        d.show();

     }
   
    
 

}
