public class StudentList
{
    private int next;
    private int size;
    private StudentListing[] data;

    public StudentList()
        {
            next = 0;
            size = 100;
            data = new StudentListing[size];
        }
    public StudentList(int s)
        {
            next = 0; 
            data = new StudentListing[s];
            size = s;
        }
    public boolean insert (StudentListing newStudentListing)
        {
            if(next>= size)
                return false;
            data[next] = newStudentListing.deepCopy();

            if(data[next] == null)
                return false;
            next = next + 1;
            return true;
        }
    public StudentListing fetch (String targetKey)
        {
            StudentListing studentlisting;
            StudentListing temp;

            int i = 0;
            while(i < next && !(data[i].compareTo(targetKey) == 0))
            {   i++;
            }
            if(i == next)
                return null;

            studentlisting = data[i].deepCopy();
            if(i !=0)
            {
                temp = data[i - 1];
                data[i - 1] = data[i];
                data[i] = temp;
            }
            return studentlisting;
        }
    public boolean delete(String targetKey)
        {
            int i = 0;
            while(i < next && !(data[i].compareTo(targetKey) == 0))
            {   i++;                
            }
            if(i == next)
                return false;
            data[i] = data[next - 1];
            data[next - 1] = null;
            next = next - 1;
            return true;
        }

    public boolean update (String targetKey, StudentListing newStudentListing)
        {
            if(delete(targetKey) == false)
                return false;
            else if (insert(newStudentListing) == false)
                return false;
            else
                return true;
        }
    public void showAll()
        {
            for(int i = 0; i < next; i++)
            System.out.println(data[i].toString());
        }
}