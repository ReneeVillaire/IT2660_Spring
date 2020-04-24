

import java.util.List;
import java.util.Scanner;

public class Main {
    private static GenericSinglyLinkedList<String, Listing> studentList = new GenericSinglyLinkedList<String, Listing>();

    private static void getInitialData() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int studentCount = Integer.parseInt(inputScanner.nextLine());

        for(var count = 0; count < studentCount; count++) {
            Listing temp = new Listing();
            temp.input();
            studentList.insert(temp.getName(), temp);
        }
    }

    private static void printMenu() {
        System.out.println("Enter:  1. to insert a new student's information.");
        System.out.println("        2. to fetch and output a student's information.");
        System.out.println("        3. to delete a student's information.");
        System.out.println("        4. to update a student's information.");
        System.out.println("        5. to output all of the student's information.");
        System.out.println("        6. to exit the program.");
    }

    private static boolean handleChoice(int choice) {
        Scanner input = new Scanner(System.in);

        if(choice == 1) {
            Listing temp = new Listing();
            temp.input();
            studentList.insert(temp.getName(), temp);
        }
        else if(choice == 2) {
            System.out.println("Enter a student's name: ");
            String studentName = input.nextLine();
            var foundStudent = studentList.fetch(studentName);

            if(foundStudent != null) {
                System.out.println("Student Found!  Information as follows: ");
                System.out.println(foundStudent.toString());
            }
            else
                System.out.println("ERROR! THE STUDENT WAS NOT FOUND!");
        }
        else if(choice == 3) {
            System.out.println("Enter a student's name: ");
            var studentName = input.nextLine();
            var found = studentList.delete(studentName);

            if(found)
                System.out.println(studentName + " was successfully removed.");
            else
                System.out.println("ERROR! " + studentName + " was not found and was not removed!");
        }
        else if(choice == 4) {
            System.out.println("Enter updated information.");
            Listing temp = new Listing();
            temp.input();
            var updated = studentList.update(temp.getName(), temp);

            if(updated)
                System.out.println("Record was updated.");
            else
                System.out.println("ERROR!  The record was not found!");
        }
        else if(choice == 5) {
            System.out.println("Printing out database.");
            studentList.showAll();
        }
        else if(choice == 6) {
            System.out.println("Thank you.  Goodbye.");
            return true;
        }
        else {
            System.out.println("Unknown error");
        }

        return false;
    }

    public static void main(String[] args) {
        getInitialData();
        boolean exit = false;
        Scanner input = new Scanner(System.in);

        while(!exit) {
            printMenu();
            var choice = Integer.parseInt(input.nextLine());
            exit = handleChoice(choice);
        }

        /*GenericSinglyLinkedList<String, Integer> newList = new GenericSinglyLinkedList<String, Integer>();
        newList.insert("test1", 5);
        newList.insert("test2", 10);
        newList.insert("test3", 15);
        newList.showAll();

        newList.update("test3", 25);
        newList.showAll();

        var value = newList.fetch("test1");
        System.out.println("Fetched value for test1: " + value);

        if(newList.delete("test1") == true) {
            System.out.println("Deleted the node for test1.");
            newList.showAll();
        }
        else
            System.out.println("Error deleting the node for test1");*/
    }


/*    private static Stack test;

    private static void populateStack() {
        if(test.isEmpty()) {
            System.out.println("The stack is empty.  Adding values to it.");
            Listing temp1 = new Listing("Matthew", "NR", "1");
            Listing temp2 = new Listing("Renee", "Miami, OH", "23");
            Listing temp3 = new Listing("Sammy", "Bay Village, OH", "4");
            Listing temp4 = new Listing("Joseph", "Nowheresville, IN", "100");

            test.push(temp1);
            System.out.println("Added Matthew.");
            test.push(temp2);
            System.out.println("Added Renee.");
            test.push(temp3);
            System.out.println("Added Sammy.");
            test.push(temp4);
            System.out.println("Added Joe.");
        }
        else {
            System.out.println("The stack is not empty.  Current contents are: ");
            test.showAll();
        }
    }

    public static void testPeek() {
        System.out.println("Testing the peek function.");
        var top = test.peek();

        if(top == null)
            System.out.println("There is no data on the stack.");
        else
            System.out.println("The top of the stack is: " + top.toString());
    }

    public static void testPop() {
        System.out.println("Testing the pop function");

        while(!test.isEmpty()) {
            var top = test.pop();

            if(top != null)
                System.out.println(top.toString());
            else
                System.out.println("Null was encountered.");
        }
    }

    public static void testClear() {
        System.out.println("Testing the clear function");
        test.clear();
    }

    public static void isStackFull() {
        System.out.println("Testing the isFull() function.");

        if(test.isFull())
            System.out.println("The stack is full.");
        else
            System.out.println("The stack is not full.");
    }

    public static void main(String[] args) {
        test = new Stack();
        isStackFull();
        populateStack();
        isStackFull();
        testPeek();
        isStackFull();
        testPop();
        isStackFull();
        testClear();
        isStackFull();
        populateStack();
        isStackFull();
    }*/
}
