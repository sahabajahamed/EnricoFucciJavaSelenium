package CheckAlpha;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import CheckAlpha.Demo;

public class test
{
    public void arrayShow()
    {
        int mark [] = {10,20,30};

        for (int i : mark) 
        {
           System.out.println(i); 
        }
    }



   


    public void ReadExcelFromOtherMethod() throws IOException
    {
      System.out.println(Demo.ReadExcelData());
    }

   

}


 class Dog extends test
{
    public void Show()  // Method Overriding
    {
        int a = 50;
      System.out.println(a);
    }

    public void Check(String a)
    {
      System.out.println(a);
    }

    public void Check(int b)
    {
        System.out.println(b);
    }


    
   public static void main(String[] args) throws IOException 
   {
    test an = new test();
    an.ReadExcelFromOtherMethod();
    // test dg = new Dog();
    // dg.Show(); 

    // Dog dg1 = new Dog();
    // dg1.Check("Hello");
    // dg1.Check(500);

   }



}
    
    
