import java.util.List;

public class Main {
    public static void fetchValues(String[] keys, BinaryTree tree) {
        Listing[] listings = new Listing[keys.length];

        for(var idx = 0; idx < listings.length; idx++)
            listings[idx] = tree.fetch(keys[idx]);

        for(var idx = 0; idx < listings.length; idx++)
            printListing(listings[idx]);
    }

    public static void printListing(Listing value) {
        if(value != null)
            System.out.println("Found student. Info as follows:\r\n" + value.toString());
        else
            System.out.println("Student does not exist.");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        String[] names = new String[5];
        names[0] = "Root";
        names[1] = "Joe";
        names[2] = "Renee";
        names[3] = "Matthew";
        names[4] = "Samantha";
        Listing root = new Listing(names[0], "23", "500");
        Listing l1 = new Listing(names[1], "23", "450");
        Listing l2 = new Listing(names[2], "23", "3000");
        Listing l3 = new Listing (names[3], "23", "9000");
        Listing l4 = new Listing(names[4], "23", "9001");
        tree.insert(root);
        tree.insert(l1);
        tree.insert(l2);
        tree.insert(l3);
        tree.insert(l4);

        fetchValues(names, tree);

        //update Renee with address 35
        System.out.println("Updated Renee's address to 35");
        Listing updateRenee = new Listing(names[2], "35", "3000");
        tree.update(names[2], updateRenee);
        fetchValues(names, tree);

        //delete Joe
        tree.delete(names[1]);
        fetchValues(names, tree);
    }
}