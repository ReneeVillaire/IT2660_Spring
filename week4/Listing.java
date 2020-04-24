
import javax.swing.*;

public class Listing {
    private String name;
    private String address;
    private String number;

    public Listing() {
        name = "";
        address = "";
        number = "";
    }

    public Listing (String n, String a, String num) {
        name = n;
        address = a;
        number = num;
    }

    public String getName() { return name;}

    public String toString() {
        return ("Name is " + name + "\n" +
                "Address is: " + address + "\n" +
                "Number is: " + number + "\n");
    }

    public Listing deepCopy() {
        Listing clone = new Listing(name, address, number);
        return clone;
    }

    public void input() {
        name = JOptionPane.showInputDialog("Enter a name.");
        address = JOptionPane.showInputDialog("Enter an address");
        number = JOptionPane.showInputDialog("Enter a number");
    }
}
