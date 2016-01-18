package ds;

import java.util.LinkedList;
import java.util.Scanner;


public class Bst {
	
	private class Node{
		int key;
		Node left;
		Node right;
	}
	
	Node root;
	
	Bst(){
		root = null;
	}
	
	public void insert(int n){
		Node z = new Node();
		z.key = n;
		z.left = z.right = null;
		
		Node y = null;
		Node x = root;
		while(x!=null){
			y = x;
			if(z.key<x.key){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		if(y==null){
			root = z;
		}else if(z.key<y.key){
			y.left = z;
		}else{
			y.right = z;
		}
		
	}

	public void inorder(Node x){
		if(x==null) return;
		inorder(x.left);
		System.out.print(x.key+" ");
		inorder(x.right);
	}
	
	public int height(Node x){
		if(x==null) return 0;
		return 1 + Math.max(height(x.left), height(x.right));
	}
	
	public void levelorder(){
		LinkedList<Node> list = new LinkedList<Bst.Node>();
		Node temp = root;
		while(temp!=null){
			System.out.print(temp.key+" ");
			if(temp.left!=null) list.add(temp.left);
			if(temp.right!=null) list.add(temp.right);
			if(list.isEmpty()){
				temp = null;
			}else{
				temp = list.remove();
			}
			
		}
		
	}
	
	public Node commonancestor(Node root,int v1,int v2)
    {
        if(v1>v2){
            int t = v2;
            v2 = v1;
            v1 = t;
        }
        Node x = root;
        if(x.key<v1&&x.key<v2){
        	System.out.println("hey"+v1+":"+v2);
            if(x.right.key == v1 || x.right.key==v2) return x;
            else return commonancestor(x.right,v1,v2);
        }else if(x.key>v1&&x.key>v2){
            if(x.left.key == v1 || x.left.key==v2) return x;
            return commonancestor(x.left,v1,v2);
        }else{
            return x;
        }
       
    }
	
	public static void main(String[] args) {
		
		Bst b = new Bst();
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			b.insert(sc.nextInt());
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		//b.inorder(b.root);
		System.out.println(b.commonancestor(b.root, v1, v2).key+"");;
		
		
	}

}
