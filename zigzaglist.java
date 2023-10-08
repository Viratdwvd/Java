import java.util.*;
public class zigzaglist
 {
    public class Node
    {
        int data;
        Node next;
            public Node(int data)
            {
                this.data=data;
                this.next=null;
            }
     }
    public static Node head;
    public static Node tail;
    public void addlast(int data)
    {
        Node newnode = new Node(data);
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        tail.next = newnode;
        tail=newnode;
    }
    public void printlist()
    {
        Node temp = head;
        if(head==null)
        {
            System.out.print("No newnode");
            return ;
        }
        temp = temp.next;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("");
    }
    
    public void zigzag()
    {
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
       
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        Node prev  = null;
        Node next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;
        while(left!=null && right!=null)
        {
            nextL=left.next;
            left.next=right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[])
    {
        zigzaglist ll = new zigzaglist();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.printlist();
        ll.zigzag();
        ll.printlist();
    }
}

