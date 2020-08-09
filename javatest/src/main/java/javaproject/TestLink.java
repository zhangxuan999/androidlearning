package javaproject;

import java.util.zip.Inflater;

public class TestLink {
	public static void main(String[] args) {
		
		int i =1;
		int j = 1;
		if(j == i++){
			
			System.out.println("haha");
		}
		
		System.out.println(i);
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.nextNode = node2;
		node2.nextNode = node3;
		node3.nextNode = node4;
		node4.nextNode = node5;
		node5.nextNode = null;
		
		System.out.println("hhhh"+ deleteNode(node1, 3).data);;
		
//		isHasCricle(node1);
		
//		System.out.println("testReverse");
//		Node headNode  = reverse(node1);
//		while (headNode!=null) {
//			System.out.println(headNode.data);
//			headNode = headNode.nextNode;
//		}
		
		
//		Test(node1, node2);
		
		
		
		System.out.println("testReverse" + node1.data);
		System.out.println("testReverse" + node2.data);
		
		
	}
	private static void Test(Node node1,Node node2){
		node1.data = 5;
		node2 = node1;
		
		System.out.println("testReverseyy" + node1.data);
		System.out.println("testReverseyy" + node2.data);
	}
	
	//输出链表倒数第k个节点

	private static Node deleteNode(Node headNode ,int k) {
		if (k<=0) {
			return null;
			
		}
		Node pNode = headNode;
		Node qNode = headNode;
		for (int i = 0; i < k-1; i++) {
			if (pNode == null) {
				return null;
			}
			pNode = pNode.nextNode;
		}
		
		while(pNode.nextNode != null){
		      pNode = pNode.nextNode;
		      qNode = qNode.nextNode;
		    }
		
		return qNode;
		
	}
	//链表反转
	private static Node reverse(Node head){
		Node preNode = null;
		Node now = head;
		while(now != null){
			Node nextNode = now.nextNode;
			now.nextNode = preNode;			
			preNode = now;
			now = nextNode;
		}
		
		return preNode;
		
		
	}
	//链表是否带环
	private static boolean isHasCricle(Node head){
		boolean result = false;
		Node slow = head;
		Node fast= head;
		while (slow != null && fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			if(slow == fast){
				result = true;
				break;
			}
		}
		System.out.println(result);
		return result;
		
	}
	
		static class Node{
			int data;
			Node nextNode;
			public Node(int data){
				this.data = data;
			}
		}	
		
}


