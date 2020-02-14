import java.util.Scanner;

public class Listing {
   private String name;
   private int age;

   public Listing () {  
      name = " ";
      age = 0;   
   }

   public Listing( String n, int a) {
      name = n;
      age = a;
   }
   
   public void setName (String n)  {  name = n; }
   public void setAge (int a) { age = a; }

   public String getName () { return name; }
   public int getAge() { return age; }

   public void input(){
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter Name Odinson:");
      
      String userName = myObj.nextLine();
      name = userName;
      
      System.out.println("Enter Age Odinson:");
      
      int userAge = myObj.nextInt();
      age = userAge;
   }
}

