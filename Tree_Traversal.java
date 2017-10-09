import java.util.*;

class Node{
  int data;
  Node left,right;

  Node(int data)
  {
    this.data=data;
    left=right=null;
  }
}



class Tree_Traversal
{
  public static void main(String args[])
  {
    //Create customn Tree_Traversal
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

    System.out.println("Preorder , Postorder and Inorder traversals are :");
    preorder(root);
    System.out.println();
    postorder(root);
    System.out.println();
    inorder(root);

  }

  static void preorder(Node root)
  {
    if(root==null)
    return;
    else
    {
      System.out.print(root.data+", ");
      preorder(root.left);
      preorder(root.right);
    }
  }

  static void postorder(Node root)
  {
    if(root==null)
    return;
    else
    {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data+", ");
    }
  }


  static void inorder(Node root)
  {
    if(root==null)
    return;
    else{
      inorder(root.left);
      System.out.print(root.data+", ");
      inorder(root.right);
    }
  }
}
