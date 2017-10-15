/* THIS  PROGRAM REORDERS A GIVEN LINKED LIST SUCH THAT 0 POINTS TO NTH Node ,1 TO N-1TH NODE
2ND NODE TO N-2TH NODE AND SO ON...
EXAMPLE:---

1->2->3->4->5

OUTPUT:

1->5->2->4->3

*/


import java.io.*;

class Node{
  int data;
  Node next;

  Node(int d)
  {
    data=d;
  }
}

class Reorderlist
{
  public static void main(String args[])
  {
    Node head=new Node(1);
    head.next=new Node(2);
    head.next.next=new Node(3);
    head.next.next.next=new Node(4);
   head.next.next.next.next=new Node(5);
   head.next.next.next.next.next=new Node(6);
   head.next.next.next.next.next.next=new Node(7);




    gfg g=new gfg();


      Node y=g.reorderlist(head);

      while(y!=null)
      {
        System.out.print(y.data+" ");
        y=y.next;
      }
  }
    Node reorderlist(Node head)
    {
      Node ff=new Node(99);

       int x=calssize(head);

       Node prevnode=head;
       System.out.println(x/2);
       for(int i=1;i<=x/2;)
       {


            int zi=x-2*i+1;
            Node z=getnodeatdist(prevnode.next,zi);
            Node temp=prevnode.next;
            prevnode.next=z;
            z.next=temp;

            if(i==1)
            head=prevnode;

            prevnode=temp;

            i+=1;
       }
       prevnode.next=null;


        return head;

    }

    Node getnodeatdist(Node x,int dist)
    {
        if(dist==1)
        return x;
        else
        {
          Node z=  getnodeatdist(x.next,dist-1);
            return z;
        }
    }

    int calssize(Node x)
    {
        int count=0;
        while(x!=null)
        {
            count++;
            x=x.next;
        }

        return count;
    }
}
