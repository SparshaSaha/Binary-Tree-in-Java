//This program finds all the nodes at a given distance k from any node in a binary tree\
// User just needs to supply the binary tree and call the functions in order
/*
An Example:--
                            1
                          /   \
                        2       9
                      /   \    /  \
                    3     4   10   11
                        /  \
                      5     6
                          /  \
                        7     8

    In this tree if the target node is 4 and distance is 2 then it prints 3 1 7 8

*/



import java.io.*;
import java.util.*;
class Node
{
  Node left,right;
  int data;

  Node(int n)
  {
    data=n;
    left=right=null;
  }
}
class allnodes{
  static Map<Integer,Node> m=new HashMap<Integer,Node>();
  static int level_of_target=0;
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

    Node tofind=root.left.right;

    find_ancestors(root,tofind.data,0);


    Node ances=m.get(tofind.data);
    int data_o=tofind.data;

    int distance=2;

    for(int i=1;i<=level_of_target;i++)
    {
      find(ances,distance-i,data_o);
      data_o=ances.data;

      ances=m.get(ances.data);
    }

    nodes_below(tofind,distance,0);


  }

  static void nodes_below(Node root,int k,int level)
  {
    if(root==null)
    return;
    else if(level==k)
    {
      System.out.print(root.data+"  ");
    }
    else
    {
      nodes_below(root.left,k,level+1);
      nodes_below(root.right,k,level+1);
    }
  }

  static void find(Node root,int level,int data_o)
  {
    if(root==null)
    return;
    else if(level==0 && root.data!=data_o)
    System.out.print(root.data+"  ");
    else if(root.data!=data_o){
      find(root.left,level-1,data_o);
      find(root.right,level-1,data_o);
    }
  }

  static void find_ancestors(Node root,int tofind,int lev)
  {
    if(root==null)
    return;
    else if(root.data==tofind)
    {
      level_of_target=lev;
      return;
    }
    else if(root.left==null && root.right!=null){
      m.put(root.right.data,root);
      find_ancestors(root.right,tofind,lev+1);
    }
    else if(root.left!=null && root.right==null){
    m.put(root.left.data,root);
    find_ancestors(root.left,tofind,lev+1);
    }
    else if(root.left!=null && root.right!=null)
    {
      m.put(root.left.data,root);
      m.put(root.right.data,root);
      find_ancestors(root.right,tofind,lev+1);
      find_ancestors(root.left,tofind,lev+1);
    }

  }

}
