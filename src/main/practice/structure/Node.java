package structure;

import static net.mindview.util.Print.*;

public class Node {
	// 数据域
	public int data;

	// 指针域，指向下一个节点
	public Node next;

	public static Node head = new Node();

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * 向链表添加数据
	 *
	 * @param value 要添加的数据
	 */
	public static void addData(int value) {
		Node newNode = new Node(value);

		Node currentNode = head;

		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}

		currentNode.next = newNode;
	}

	/**
	 * 遍历链表
	 *
	 * @param head 头节点
	 */
	public static void traverse(Node head) {

		// 临时节点，从首节点开始
		Node currentNode = head;

		while (currentNode != null) {

			System.out.print(currentNode.data + " ");

			// 继续下一个
			currentNode = currentNode.next;
		}
	}

	/**
	 * 插入节点
	 *
	 * @param head  头指针
	 * @param index 要插入的位置
	 * @param value 要插入的值
	 */
	public static void insertNode(Node head, int index, int value) {

		if (index < 1 || index > linkListLength(head)-1) {
			print("插入位置不合法");
			return;
		}

		int currentPos = 0;
		Node currentNode = head;
		Node insertNode = new Node(value);
		while (currentNode != null) {
			if ((index - 1) == currentPos) {
				insertNode.next=currentNode.next;
				currentNode.next = insertNode;
				return;
			}
			currentPos++;
			currentNode = currentNode.next;
		}
	}

	/**
	 * 获取链表的长度
	 * 
	 * @param head 头指针
	 */
	public static int linkListLength(Node head) {

		int length = 0;

		// 临时节点，从首节点开始
		Node currentNode = head;

		// 找到尾节点
		while (currentNode != null) {
			length++;
			currentNode = currentNode.next;
		}

		return length;
	}
	
	public static Node reverseLinkedList(Node head) {
		if (head == null) {
			return head;
		}
		Node current = head;
		Node preNode = null;
		Node nextNode = null;
		Node newHead = null;
		while (current != null) {
			nextNode = current.next;
			current.next = preNode;
			if (nextNode==null) {
				newHead = current;
			}
			preNode = current;
			current = nextNode;
		}
		return newHead;
	}
	
	public static Node mergeTwoLinkedList(Node node1,Node node2) {
		Node newHead = new Node(0);
		Node currentNode = null;
		while(node1 != null && node2 != null) {
			if (node1.data < node2.data) {
				Node newNode = new Node(node1.data);
				newHead.next = newNode;
				currentNode = newHead.next;
				node1 = node1.next;
			}
			if(node2.data < node1.data) {
				Node newNode = new Node(node2.data);
				newHead.next = newNode;
				currentNode = newHead.next;
				node2 = node2.next;
			}
		}
		while(node1 != null) {
			Node newNode = new Node(node1.data);
			newHead.next = newNode;
			currentNode = newHead.next;
			node1 = node1.next;
			
		}
		while(node2 != null) {
			Node newNode = new Node(node2.data);
			newHead.next = newNode;
			currentNode = newHead.next;
			node2 = node2.next;
		}
		return newHead;
	}

	public static void createLinkedList() {
		addData(10);
		addData(20);
		addData(30);
//		insertNode(head, 3, 40);
	}
	
	public static void createSeparatedLinkedList() {
		Node head = new Node();
		addData(40);
		addData(50);
		addData(60);
	}

	public static void main(String[] args) {
		createLinkedList();
//		traverse(head);
		traverse(reverseLinkedList(head));	
//		System.out.println(linkListLength(head));
	}
}
