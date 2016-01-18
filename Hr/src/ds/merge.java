package ds;

import java.util.Scanner;

class Node {
	int data;
	Node next;
	Node prev;
}

public class merge {

	


	public static Node MergeLists(Node headA, Node headB) {

		Node x = headA;
		Node y = headB;
		Node head = null;
		Node copy = null;
		Node n = null;
		while (x != null && y != null) {
			n = new Node();
			n.next = null;
			if (x.data < y.data) {
				n.data = x.data;
				x = x.next;
			} else {
				n.data = y.data;
				y = y.next;
			}
			if (head == null) {
				head = copy = n;
			} else {
				copy.next = n;
				copy = copy.next;
			}

		}
		while (y != null) {
			if(copy==null){
				copy = new Node();
				head = copy;
				copy.data = y.data;
				copy.next = null;
				y = y.next;
				continue;
			}
			copy.next = new Node();
			copy.next.next = null;
			copy.next.data = y.data;
			copy = copy.next;
			y = y.next;

		}
		while (x != null) {
			if(copy==null){
				copy = new Node();
				head = copy;
				copy.data = x.data;
				copy.next = null;
				x = x.next;
				continue;
			}
			copy.next = new Node();
			copy.next.next = null;
			copy.next.data = x.data;
			copy = copy.next;
			x = x.next;
		}

		return head;

	}
	

public static Node SortedInsert(Node head,int data) {
    Node n = new Node();
    n.data = data;
    if(head==null){
        n.prev = null;
        n.next = null;
        return n;
    }
    Node x = head;
    Node y = null;
    while(x!=null&&x.data<data){
    	y = x;
        x = x.next;
    }
    if(y==null){
    	n.prev = null;
    	n.next = x;
    	x.prev = n;
    	return n;
    }else{
    	y.next = n;
    	n.prev = y;
    	n.next= x;
    	if(x!=null) x.prev = n;
    	return head;
    }

   
    
  
}


public static Node Reverse(Node head) {
    
    if((head==null)||(head.next ==null))return head;
    
    Node left = head;
    Node mid = head.next;
    Node right = mid.next;
    left.next = null;
    while(right!=null){
        mid.next = left;
        left.prev = mid;
        
        left = mid;
        mid = right;
        right = right.next;
    }
    mid.next =  left;
    mid.prev = null;
    return mid;

}


	
	public static Node creat(int data, Node prev, Node next){
		Node k = new Node();
		k.data = data;
		k.next = next;
		k.prev = prev;
		return k;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node n = creat(2,null,null);
		Node l = creat(3,null,n);
		Node r = creat(4,n,null);
		n.prev = l;
		n.next = r;
		Node f = Reverse(l);
		while(f!=null){
			System.out.print(f.data+" ");
			f = f.next;
		}
	}

}
