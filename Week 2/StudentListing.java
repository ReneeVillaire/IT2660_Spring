import javax.swing.JOptionPane;

public class StudentListing
{
    private String name;
    private String number;
    private String gpa;

    public StudentListing () {
        name = "";
        number = "";
        gpa = "";
    }

    public StudentListing (String n, String a, String num)
    {
        name = n;
        number = a;
        gpa = num;
    }

        
    public String toString()
    {
        return ("Name is " + name +
        "\nID is " + number +
        "\nGPA is " + gpa + "\n");
    }
        public StudentListing deepCopy()
            {
                StudentListing clone = new StudentListing (name, number, gpa);
                return clone;
            }
        public int compareTo (String targetKey)
            {
                return(name.compareTo(targetKey));
            }
        public void input ()
            {
                name = JOptionPane.showInputDialog("Enter a name");
                number = JOptionPane.showInputDialog("Enter ID");
                gpa = JOptionPane.showInputDialog("Enter GPA");
            }
    }