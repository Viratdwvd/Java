import java.util.LinkedList;
public class linkedlist_loops {
    public class Node{
        int  data;
        Node next;
        public Node(int data) 
        {
            this.data = data;
            this.next = null;
        }


        public static Node head;


        public void addnode1(int data)
       {
        Node newnode = new Node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        }
    }
    
    public Node getmid(Node head)
    {
        Node slow = head;
        Node fast =  head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node Merge(Node head1,Node head2)
    {
         Node mergell = new Node(-1);
        Node temp = mergell.next;
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head1!=null)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head2!=null)
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        return mergell.next;
        
    }
    public Node mergesort(Node head)
    {
       if(head==null || head.next==null)
       {
        return head;
       }
       Node mid = getmid(head);
       Node righthead = mid.next;
       mid.next=null;
       Node leftnode = mergesort(head);
       Node rightnode  = mergesort(righthead);
       return Merge(leftnode, rightnode);
    }
    public static void main(String args[])
    {
        
        linkedlist_loops link = new linkedlist_loops();
        System.out.println("LinkedList........ formastion ");
        link.addnode1(2);
        link.addnode1(0);
        link.addnode1(3);
        link.addnode1(6);
        link.middle(4, 4);
       link.mergesort(link.head);
    }
    
}
