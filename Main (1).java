import java.util.*;
public class Main
{
    public static void maxArea(int arr[])
    {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        
        Stack<Integer> s = new Stack<>();
        //nsr
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
           s = new Stack<>();
        //nsl
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //current area :width = j-i-1 *height 
        for(int i=0;i<arr.length;i++)
        {
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currarea = height*width;
            maxArea = Math.max(currarea,maxArea);
        }
        System.out.print("MAx area in histogram is "+maxArea);
    }
    public static void main(String args[])
    {
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}