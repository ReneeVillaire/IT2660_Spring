//Submitted by:      Renee Villaire
//Operating System:  Microsoft Windows
//IDE:               jGRASP

public class ListingArray {
   
    public static void main(String[] args) {
    
       System.out.println("Ciao, Bella Renee!"); //display the string
 

       Listing [] odin = new Listing [3];

       for (int idx=0; idx<odin.length; idx++) {
        //    Listing temp = new Listing();
        //    temp.input();

        //    System.out.println(temp.getName());
        //    System.out.println(temp.getAge());

        //    odin[idx] = temp;

        odin[idx] = new Listing();

        odin[idx].input();

        }

        for (int idx=odin.length-1; idx>-1; idx--) {
        
            System.out.println(odin[idx].getName());
            System.out.println(odin[idx].getAge());

        }
    }
   
 }
 //please help