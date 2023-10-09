public class doubly
{
    public class Node {
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addfirst(int data)
    {
          Node newnode = new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public void addlast(int data)
    {
        Node newnode = new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        newnode.prev = tail;
        tail = newnode;
    }
    public void printll()
    {
        if(head==null)
        {
            System.out.print("No data");
            return;
        }
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }}
    public static void main(String args[])
    {
        doubly ll = new doubly();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addfirst(9);
        ll.printll();
    }
}
