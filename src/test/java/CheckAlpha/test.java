package SuperAdmin;


public class test
{
    public void Show()
    {
        int mark [] = {10,20,30};

        for (int i : mark) 
        {
           System.out.println(i); 
        }
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


   public static void main(String[] args) 
   {
    test an = new test();
    an.Show();
    test dg = new Dog();
    dg.Show(); 

    Dog dg1 = new Dog();
    dg1.Check("Hello");
    dg1.Check(500);

   }



}
    
    
