package DataFolder;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;





public class Data {

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
        return rand1.nextLong(1000000000l, 10000000000l); // Adjust range as needed
    }



      // Truck module
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
    
}
