package Java.apnaCollege.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTree {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class BinaryTree{

        static int idx=-1;

        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                System.out.println(".");
                return null;
            }
            
            System.out.println("rtoot");
            Node newNode=new Node(nodes[idx]);
            System.out.println("left");
            newNode.left=buildTree(nodes);
            System.out.println("right");
            newNode.right=buildTree(nodes);

            return newNode;
        }

        public static void printPreOrder(Node root){
            if(root==null){
                System.out.print("-1" + ", ");
                return;
            }

            System.out.print(root.data + ", ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

        public static void printInOrder(Node root){
            if(root==null){
                System.out.print("-1" + ", ");
                return;
            }

            printInOrder(root.left);
            System.out.print(root.data + ", ");
            printInOrder(root.right);
        }

        public static void printPostOrder(Node root){
            if(root==null){
                System.out.print("-1" + ", ");
                return;
            }

            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + ", ");
        }

        public static void printLevelOrder(Node root){
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int countOfNodes(Node root){
            if(root==null){
                return 0;
            }

            return countOfNodes(root.left) + countOfNodes(root.right) + 1;
        }

        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
        }

        public static int height(Node root){
            if(root==null){
                return 0;
            }

            return Math.max(height(root.left), height(root.right)) + 1;
        }

        public static int diameter(Node root){
            if(root==null){
                return 0;
            }

            int diam1=diameter(root.left);
            int diam2=diameter(root.right);
            int diam3=height(root.left) + height(root.right) + 1;

            return Math.max(diam3, Math.max(diam1, diam3));
        }

        static class TreeInfo{
            int ht;
            int diam;

            TreeInfo(int ht, int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }

        public static TreeInfo diameter2(Node root){
            if(root==null){
                return new TreeInfo(0, 0);
            }

            TreeInfo left=diameter2(root.left);
            TreeInfo right=diameter2(root.right);

            int myHeight=Math.max(left.ht, right.ht) + 1;

            int diam1=left.diam;
            int diam2=right.diam;
            int diam3=left.ht+right.ht+1;

            int myDiam=Math.max(Math.max(diam1, diam2), diam3);

            TreeInfo ans=new TreeInfo(myHeight, myDiam);

            return ans;
        }

        public static boolean isIdentical(Node root, Node subRoot){
            if(subRoot==null && root==null){
                return true;
            }

            if(root==null || subRoot==null){
                return false;
            }

            if(root.data==subRoot.data){
                return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
            }

            return false;
        }

        public static boolean isSubtree(Node root, Node subRoot){
            if(subRoot==null){
                return true;
            }

            if(root==null){
                return false;
            }

            if(root.data==subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }

            return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);
        }
    }

    public static void main(String[] args) {
        int nodes[]={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
                    //  1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        Node travel=root;
        System.out.println("PRE ORDER PRINT: ");
        tree.printPreOrder(travel);
        System.out.println();
        System.out.println("IN ORDER PRINT: ");
        tree.printInOrder(travel);
        System.out.println();
        System.out.println("POST ORDER PRINT: ");
        tree.printPostOrder(travel);
        System.out.println();
        System.out.println("LEVEL ORDER PRINT: ");
        tree.printLevelOrder(travel);
        System.out.println("NO. of nodes: " + tree.countOfNodes(travel));
        System.out.println("Sum of tree: " + tree.sumOfNodes(travel));
        System.out.println("Height of tree: " + tree.height(travel));
        System.out.println("Diameter of tree: " + tree.diameter(travel));
        System.out.println("Diameter2 of tree: " + tree.diameter2(travel).diam);

        System.out.println(tree.idx);
    }
}
