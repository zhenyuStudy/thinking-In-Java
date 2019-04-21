package structure;

import java.util.LinkedList;
public class BinaryTree {
	public TreeNode root = null;

	public BinaryTree() {
		root = new TreeNode(1, "A");
	}

	public TreeNode getRoot() {
		return root;
	}

	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(1, "B");
		TreeNode nodeC = new TreeNode(1, "C");
		TreeNode nodeD = new TreeNode(1, "D");
		TreeNode nodeE = new TreeNode(1, "E");
		TreeNode nodeF = new TreeNode(1, "F");
		TreeNode nodeG = new TreeNode(1, "G");
		root.setLeftChild(nodeB);
		root.setRightChild(nodeC);
		nodeB.setLeftChild(nodeD);
		nodeB.setRightChild(nodeE);
		nodeC.setLeftChild(nodeF);
		nodeC.setRightChild(nodeG);
	}

	public int getHeight() {
		return getHeight(root);
	}

	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.getLeftChild());
		int rightHeight = getHeight(node.getRightChild());
		return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
	}

	public int getSize() {
		return getSize(root);
	}

	public int getSize(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftSize = getSize(node.getLeftChild());
		int rightSize = getSize(node.getRightChild());
		return leftSize + rightSize + 1;
	}

	public void beforeOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		beforeOrder(node.getLeftChild());
		beforeOrder(node.getRightChild());
	}

	public void midOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		midOrder(node.getLeftChild());
		System.out.print(node.getData() + " ");
		midOrder(node.getRightChild());
	}

	public void afterOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		afterOrder(node.getLeftChild());
		afterOrder(node.getRightChild());
		System.out.print(node.getData() + " ");
	}
	
	public static void levelTraverse(TreeNode node) {
		if (node == null) return;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(node);
		System.out.println(node.getData()+ " ");
		while (list.size() !=0) {
			if(node.getLeftChild() != null) {
				list.add(node.getLeftChild());
			}
			if(node.getRightChild() != null) {
				list.add(node.getRightChild());
			}
		}
		System.out.println();
	}

	public TreeNode reverseBinaryTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		System.out.println(node.getData());
		TreeNode tempNode = node.getLeftChild();
		node.setLeftChild(node.getRightChild());
		node.setRightChild(tempNode);
		if (node.getLeftChild() != null) {
			reverseBinaryTree(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			reverseBinaryTree(node.getRightChild());			
		}
		return node;
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
//		int height = binaryTree.getHeight();
//		System.out.println("treeHeight: "+ height);
//		int size = binaryTree.getSize();
//		System.out.println("treeSize: "+size);
//		binaryTree.beforeOrder(binaryTree.root);
//		System.out.println();
//		binaryTree.midOrder(binaryTree.root);
//		System.out.println();
//		binaryTree.afterOrder(binaryTree.root);
//		System.out.println();
		binaryTree.reverseBinaryTree(binaryTree.root);
//		levelTraverse(binaryTree.reverseBinaryTree(binaryTree.root));
	}
}
