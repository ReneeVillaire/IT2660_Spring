public class TestThisBitch 
{
  public static void main(String[] args) 
  {
   
    StudentList bitches = new StudentList(3);
        StudentListing bitch1 = new StudentListing("Renee" , "52" , "4.0");
        StudentListing bitch2 = new StudentListing("Joe" , "51" , "0.7");
        StudentListing bitch3 = new StudentListing("Matthew" , "50" , "4.0");

    bitches.insert(bitch1);
    bitches.insert(bitch2);
    bitches.insert(bitch3);

    bitches.showAll();

    bitches.delete("Joe");

    bitches.showAll();

    StudentListing temp1 = bitches.fetch("Renee");
    System.out.println(temp1.toString());

    bitches.update("Matthew", new StudentListing("Samantha" , "49" , "4.0"));
    bitches.showAll();




  }

}