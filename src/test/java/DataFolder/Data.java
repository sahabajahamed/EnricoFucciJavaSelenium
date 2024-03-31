package DataFolder;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;




public class Data {

    public static String Term = "Terminal";
    public static String str = RandomStringUtils.randomAlphabetic(2);
  
    
    public static int getRandomNumber()
     {
        Random rand = new Random();
        return rand.nextInt(10000); // Adjust range as needed
    }
    
    
    
    
    

   
    
}
