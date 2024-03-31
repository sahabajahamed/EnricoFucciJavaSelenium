package SuperAdmin;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    
   public static String rndst = RandomStringUtils.randomAlphabetic(7);



    public void RandomAlpha()
    {
     System.out.println(rndst);

    }

    public static void main(String[] args) {
        Random rd = new Random();
        rd.RandomAlpha();
    }

}
