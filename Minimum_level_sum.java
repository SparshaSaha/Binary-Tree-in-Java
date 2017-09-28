/*
THIS QUESTION WAS ASKED IN THE FIRST CODING ROUND OF MY MICROSOFT CODING INTERVIEW

WE ARE RQEUIRED TO PRINT THE MINIMUM LEVEL IN WHICH A SUM CAN BE FOUND STARTING FROM THE ROOT OF A BINARY
TREE.

Example:
                                    1
                                  /   \
                                2       9
                              /   \    /  \
                            3     4   10   11
                                /  \
                              5     6
                                  /  \
                                7     8

  If The given input is 20 then there are two paths:

  1->2->4->6->7 .....level=4    and
  1->9->10  ......level=2

  since 2 in lesser it should return 2

  If no tree found -1 is returned

  */


import java.io.*;
import java.util.*;

class Node{
  int data;
  Node left,right;

  Node(int n)
  {
    data=n;
    left=right=null;
  }
}

class Minimum_level_sum{
  public static void main(String args[])
  {

    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(9);
    root.left.left=new Node(3);
    root.left.right=new Node(4);
    root.left.right.left=new Node(5);
    root.left.right.right=new Node(6);
    root.left.right.right.left=new Node(7);
    root.left.right.right.right=new Node(8);
    root.right.left=new Node(10);
    root.right.right=new Node(11);

    System.out.println("Enter sum to be found");

    Scanner sc=new Scanner(System.in);

    int height=sc.nextInt();




    System.out.println(findlevelsum(root,0,height));


  }

  static int findlevelsum(Node root,int level,int sum)
  {
    if(root==null)
    return -1;
    else if(root.data==sum)
    return level;
    else if(sum-root.data<0)
    {
      return -1;
    }
    else
    {
      int x=findlevelsum(root.left,level+1,sum-root.data);
      int y=findlevelsum(root.right,level+1,sum-root.data);

      if(x==-1 && y!=-1)
      return y;
      else if(x!=-1 && y==-1)
      return x;
      else if(x==-1 && y==-1)
      return -1;
      else{
        return Math.min(x,y);
      }
    }
  }
}
