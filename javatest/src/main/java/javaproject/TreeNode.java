package javaproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	public int data;
	public TreeNode leftChild;
	public TreeNode rightChild;
	
	public TreeNode(int data) {
		this.data = data;
	}

	//前序遍历
	public static void preOrder(TreeNode biTree){
	    System.out.println(biTree.data+"");
	    TreeNode leftTree=biTree.leftChild;
	    if(leftTree!=null){
	        preOrder(leftTree);
	    }
	    TreeNode rightTree=biTree.rightChild;
	    if(rightTree!=null){
	        preOrder(rightTree);
	    }
	}
	//中序遍历
	public static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		} else {
			//System.out.println("node.data=" + node.data + ", node.leftChild = " + (node.leftChild == null? "" : node.leftChild.data));
			inOrderTraversal(node.leftChild);
			System.out.println(node.data);
			//System.out.println("node.data=" + node.data + ", node.rightChild = " + (node.rightChild == null? "" : node.rightChild.data));
			inOrderTraversal(node.rightChild);
		}
	}
	//后序遍历
	public static void postOrder(TreeNode biTree){
	    TreeNode leftTree = biTree.leftChild;
	    if (leftTree != null) {
	        postOrder(leftTree);
	    }
	    TreeNode rightTree = biTree.rightChild;
	    if(rightTree != null){
	        postOrder(rightTree);
	    }
	    System.out.println(biTree.data+"");
	}
	
	//分层遍历
	public static void leverOrder(TreeNode node){
		
		if(node ==null) {
			return;
		}
		
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		
		linkedList.add(node);
		
		while (!linkedList.isEmpty()) {
			TreeNode cur = linkedList.removeFirst();
			System.out.println(cur.data+"");
			if (cur.leftChild != null) {
				linkedList.add(cur.leftChild);
			}
			if (cur.rightChild != null) {
				linkedList.add(cur.rightChild);
			}
		}
	}
	
	public static int maxDepth(TreeNode root){
		if (root == null) {
			return 0;
			
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			   depth ++;
			   int size = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				
				TreeNode node = queue.poll();
				System.out.println(node.data);
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
					
				}
			}
			
			
		}
		System.out.println(depth);
		return depth;
		
	}
	//分层遍历打印树
	public static void printFromTopToBottom(TreeNode node){
		if(node == null){
			return;
		}
		
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		
		TreeNode lastNode = node;
		TreeNode nextLaNode = node;
		
		linkedList.add(node);
		
		while (!linkedList.isEmpty()) {
			TreeNode cur = linkedList.removeFirst();
			System.out.println(cur.data);
			if(cur.leftChild != null){
				nextLaNode = cur.leftChild;
				linkedList.add(cur.leftChild);
			}
			
			if (cur.rightChild != null) {
				nextLaNode = cur.rightChild;
				linkedList.add(cur.rightChild);
			}
			
			if (lastNode == cur) {
				lastNode = nextLaNode;
				System.out.println("change");
			}
		}
	}
	//前序遍历，用栈实现
	public static void preOrderUseStack(TreeNode node){
		if (node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		
		while (!stack.empty()) {
			TreeNode cur = stack.pop();
			System.out.println(cur.data);
			if (cur.rightChild != null) {
				stack.push(cur.rightChild);
			}
			
			if (cur.leftChild != null) {
				stack.push(cur.leftChild);
			}
		}
	}
	
	public static void postOrderUseStack(TreeNode node){
		if (node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode cur = node;
		while (!stack.empty() || cur !=null){
			if(cur != null){
				stack.push(cur);
				cur = cur.leftChild;
			}else{
				cur = stack.pop();
				System.out.println(cur.data);
				cur = cur.rightChild;
			}
		}
	}
	
	
	public static void MidOrderUseStack(TreeNode node){
		if (node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode cur = node;
		while (!stack.empty() || cur !=null){
			if(cur != null){
				stack.push(cur);
				cur = cur.leftChild;
			}else{
				cur = stack.pop();
				System.out.println(cur.data);
				cur = cur.rightChild;
			}
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		
		node1.leftChild = node2;
		node1.rightChild = node3;
		
		node2.leftChild = node4;
		node2.rightChild = node5;
		
		node3.leftChild = node6;
		
		node3.rightChild = node7;
		
		node4.leftChild = node8;
		node5.rightChild = node9;
		node6.rightChild = node10;
		node7.leftChild = node11;
		System.out.println("qianxubianli");
		preOrder(node1);
		
		System.out.println("zhongxuxubianli");
		inOrderTraversal(node1);
		
		
		
		System.out.println("houxubianli");
		postOrder(node1);
		
		
		System.out.println("fencengbianli");
		leverOrder(node1);
		
		System.out.println("hahhha");
		printFromTopToBottom(node1);
		
		
		System.out.println("preOrderUseStack");
		preOrderUseStack(node1);
		
		System.out.println("MidOrderUseStack");
		MidOrderUseStack(node1);
		
		
		System.out.println("maxDepth");
		maxDepth(node1);
		
		
		System.out.println("preorderTraversal2");
		List<Integer> list = preorderTraversal2(node1);
		System.out.println(list.toString());
		
		
		System.out.println("打印所有路径");
		binaryTreePaths(node1);
		
		
		System.out.println("最短路径");
		System.out.println(minDepth(node1));
		
		
		flatten(node1);
//		System.out.println("qianxubianli");
//		MidOrderUseStack(node1);
		
		
	}
	//先序遍历用栈实现，返回list
	 public static List<Integer> preorderTraversal2(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<>();
	        if(root != null){
	            stack.push(root);
	        }
	        
	        while (!stack.empty()) {
	        	
	        	TreeNode node = stack.pop();
	        	list.add(node.data);
	        	if (node.rightChild!= null) {
					stack.push(node.rightChild);
				}
	        	
	        	if (node.leftChild!= null) {
					stack.push(node.leftChild);
				}
				
			}
	        
	        return list;
	    }
	 
	 //二叉树打印所有路径
	    public static List<String> binaryTreePaths(TreeNode root) {
	    	List<String>  result = new ArrayList<String>();
	    	getString(result,root , "");
	    	System.out.println(result.toString());
	    	return result;
	        
	    }
	    
	    public static void getString(List<String> list ,TreeNode node,String current){
    	if (node == null) {
				return;
		}
    	if (node.leftChild == null && node.rightChild == null ) {
    		list.add(current + node.data );
		}
    	
    	if (node.leftChild != null) {
    		getString(list ,node.leftChild,current + node.data + "->");

		}
    	
    	if (node.rightChild != null) {
    		getString(list , node.rightChild,current + node.data + "->");
		}
    	    	
	    }
	    
	    //树的最小深度，雷同最大深度函数
	    public static int minDepth(TreeNode root) {
	    	int minDepth = 0;
	    	if (root == null) {
				return 0;
			}
	    	
	       LinkedList<TreeNode> queue = new LinkedList<>();
	       queue.add(root);
	       
	       while (!queue.isEmpty()) {
	    	   
	    	   minDepth ++;
	    	   System.out.println("minDepth = " +  minDepth);
	    	   int size  = queue.size();
             for (int i= 0;i< size;i ++) {
            	 System.out.println("i = " +  i);
            	 TreeNode node = queue.removeFirst();
            	 
            	 if (node.rightChild == null && node.leftChild == null) {
					return minDepth;
				}
            	 if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
            	 
            	 if (node.rightChild != null) {
            		 queue.add(node.rightChild);
 				}
				}
				
			}
	       
	       return minDepth;
	        
	    }
	    
	    //树转换为链表 ，没有左孩子，还是分层遍历的思想
	    public static void flatten(TreeNode root) {
	        if (root == null) {
				return;
			}
	        
	        LinkedList<TreeNode> linkedList = new LinkedList<>();
	        linkedList.add(root);
	        
	        TreeNode preNode = null;
	        
	        while (!linkedList.isEmpty()) {
				int size = linkedList.size();
				for (int i = 0; i < size; i++) {
					TreeNode treeNode = linkedList.removeFirst();
					if (treeNode.leftChild != null) {
						linkedList.add(treeNode.leftChild);
					}
					if (treeNode.rightChild != null) {
						linkedList.add(treeNode.rightChild);
					}
					if (preNode != null) {
						preNode.rightChild = treeNode;
						preNode.leftChild = null;
					}
					
					preNode = treeNode;
				}
			}
	    }
	    
}