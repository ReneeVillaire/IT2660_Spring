//Submitted by:      Renee Villaire
//Operating System:  Microsoft Windows
//IDE:               jGRASP

public class ListingMethods {
   
   public static void main(String[] args) {
   
      System.out.println("Ciao, Bella Renee!"); //display the string

      Listing thor = new Listing ();
      thor.setName("Chris Hemsworth");
      System.out.println("The name is " + thor.getName());//I am bad at commenting my code
      thor.setAge(37);
      System.out.println("The age is " + thor.getAge());//and I have no idea what I am doing
      
      Listing loki = new Listing();
      loki.input();
   }
  
}
//please help