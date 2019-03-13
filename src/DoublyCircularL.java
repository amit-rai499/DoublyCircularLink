class Employee
{
    private String name;
    private int sal;
    private String post;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", post='" + post + '\'' +
                '}';
    }
}
class Node
{
    private Employee emp;
    private Node next;
    private Node previous;
    public Employee  getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
class DoublyCircular {
    Node first;
    Node end;
    public int size;

    public boolean isEmpty() {
        return (first == null);
    }

    public void display() {
        if (isEmpty())
            System.out.println("No Node Available");
        else {
            Node temp = first;
            while (temp.getNext() != first) {
                System.out.println(temp.getEmp());
                temp = temp.getNext();
            }
            System.out.println(temp.getEmp());
        }
    }

    public void insertAtBeg(Employee e) {
        Node newnode = new Node();
        Node temp=first;
        newnode.setEmp(e);
        if (isEmpty()) {
            newnode.setPrevious(newnode);
            newnode.setNext(newnode);
            first=newnode;
            end=newnode;
        } else {
            newnode.setPrevious(end);
            end.setNext(newnode);
            first.setPrevious(newnode);
            newnode.setNext(first);
            first=newnode;
        }
    }
    public void insertAtEnd(Employee e)
    {
        if(isEmpty())
        {
            insertAtBeg(e);
            return;
        }
        Node newnode=new Node();
        newnode.setEmp(e);
        Node temp=end;
        temp.setNext(newnode);
        newnode.setPrevious(end);
        newnode.setNext(first);
    }
    public void deleteFirst()
    {
        Node temp=first;
        if(isEmpty())
            System.out.println("Empty.Nothing to delete");
        else
        {
            temp=temp.getNext();
            temp.setPrevious(end);
            first=temp;
        }
    }
}
public class DoublyCircularL
{
    public static void main(String[] args) {
        Employee e1=new Employee();
        e1.setName("Amit");
        e1.setPost("Manager");
        e1.setSal(250000);
        Employee e2=new Employee();
        e2.setName("Kumar");
        e2.setPost("CEO");
        e2.setSal(98762);
        Employee e3=new Employee();
        e3.setName("Rai");
        e3.setPost("MD");
        e3.setSal(86386);
        Employee e4=new Employee();
        e4.setName("Krishna");
        e4.setSal(54556);
        e4.setPost("BOSS");
        DoublyCircular obj=new DoublyCircular();
        obj.insertAtEnd(e4);
        obj.insertAtBeg(e1);
        obj.insertAtBeg(e2);
        obj.insertAtEnd(e3);
        obj.display();
    }
}