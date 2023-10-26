import java.util.*;
public class LinlList {
    public class  Node{
       int data;
       Node next;
       public Node (int data)
       {
         this.data  = data;
         this.next = null;
       }
    }
    
    public static Node head;
    public static Node tail;
    
    public void addnode(int data)
    {
        Node newnode = new Node(data);
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void addLast(int data)
    {
        Node newnode  = new Node(data);
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    } 
    public void middle(int index,int data)
    {
        if(index==0){
            addnode(data);
            return;
        }
        Node newnode = new Node(data);
        Node temp = head;
        int i=0;
        while(i<index-1)
        {
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
            temp.next=newnode;
        
    }
    public  void printlist()
    {
        if(head==null)
        {
            System.err.println("Empty");
            return;
        }
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }
   ////////////////////////////////////////////////////////
    public int remove_first()
    {
        Node tail = head;
        if(head==null)
        {
            System.out.print("Nothing found");
            return 0;
        }
        if(head.next==null)
        {
            head.data=0;
            head=tail=null;
            return 0;
        }

        int val = head.data;
        head = tail.next;
        tail.next = null;
        return val;
    }
    public void removelast()
    {
        System.out.println();
        Node prev = head;
        if(head==null)
        {
            System.out.print("Nothing Found");
        }
        if(head.next==null)
        {
            head=null;
        }
        while(prev.next!=null)
        {
            Node temp = prev.next;
            prev=prev.next;
             if(prev.next==null)
             {
                temp.next=null;
             }
        }

    }/*get element of nth term from last */
    public void  removefrmlast(int idx)
    {
        int sz=0;
        System.out.println(); 
        Node temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            sz++;
        }
        if(idx==sz)
        {
            head=head.next;
            return;
        }
        int i=1;
        int iTolast=sz-idx;
        Node prev = head;
        while(i<iTolast)
        {
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return ;
    }



    public int helper(Node head,int key)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data == key)
        {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1)
        {
            return -1;
        }
        return idx+1;
    } 
    
    
    ///////////////////////////////////////////////
    /*recursive search  */
    public void recsearch(int key)
    {
         System.out.println();
       System.out.print(helper(head, key));
    }




    /*revese  */
    public void reverse()
    {
        Node prev = null;
        Node curr=tail=head;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
////////////////////////////////////////////////////
  
    /*palindrom of linkedlist  */
    public void palindrom()
    {
        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        int sz=0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(1);
        System.out.println();
        System.out.println("linklist wale"+linkedList);
        for(Integer k :linkedList )
        {
            arr.add(k);
        }
        System.out.println("Arraylist vale "+arr);
        int left = 0;
        int right =4 - 1;

        // Check if the ArrayList is a palindrome
        boolean isPalindrome = true;
        while (left < right) {
            if (!arr.get(left).equals(arr.get(right))) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Output the result
        if (isPalindrome) {
            System.out.println("The LinkedList is a palindrome.");
        } else {
            System.out.println("The LinkedList is not a palindrome.");
        }
    }
//////////////////////////////////////////////////////////

    public static void main(String args[])
    {
        LinlList link = new LinlList();
        System.out.println("LinkedList........ formastion ");
        link.addLast(1);
        link.addLast(2);
        link.addnode(0);
        link.addLast(3);
        link.addLast(6);
        link.middle(4, 4);
        link.middle(5, 5);
        link.printlist();
        link.palindrom();
       
    }
}
