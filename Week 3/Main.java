public class Main {
    private static StackItUp test;

    private static void populateStack() {
        if(test.isEmpty()) {
            System.out.println("The stack is empty. Adding values to it.");
            StudentListing temp1 = new StudentListing("Renee", "123", "4.0");
            StudentListing temp2 = new StudentListing("The Machine", "456", "0.7");
            StudentListing temp3 = new StudentListing("Matthew", "789", "4.0");
            StudentListing temp4 = new StudentListing("Samantha", "012", "4.0");

            test.push(temp1);
            System.out.println("Added Renee.");
            test.push(temp2);
            System.out.println("Added The Machine.");
            test.push(temp3);
            System.out.println("Added Matthew.");
            test.push(temp4);
            System.out.println("Added Samantha.");
            }
        else {
            System.out.println("The stack is not empty. Current Contents are: ");
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
                System.out.println ("Null was encountered.");
        }
    }

    public static void testClear() {
        System.out.println("testing the clear function");
        test.clear();
    }

    public static void isStackFull() {
        System.out.println("testing the isFull() function");

        if(test.isFull())
            System.out.println("The stack is full.");
        else
            System.out.println("The stack is not full and the dishes are done, man.");
    }

    public static void main(String[] args) {
        test = new StackItUp();
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
    }

}