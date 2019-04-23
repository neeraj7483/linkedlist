package info.main;

import info.LinkedList;
import info.Node;

public class MainClass extends Node<String> {
public static void main(String[] args) {
	LinkedList<Integer> list1=new LinkedList<Integer>();
	list1.insertNode(1);
	list1.insertNode(1);
	list1.insertNode(1);
	list1.insertNode(3);
	list1.insertNode(4);
	list1.insertNode(1);
	list1.insertNode(6);
	list1.insertNode(7);
	list1.insertNode(8);
	list1.printLL();
	Node<String> ad=new Node() {
	};
	
	System.out.println(list1.firstPositionOf(3));
	list1.sort();
	LinkedList<Integer> list2=new LinkedList<Integer>();
	list2.insertNode(10);
	list2.insertNode(132);
	list2.insertNode(16);
	list2.insertNode(53);
	list2.insertNode(54);
	list2.insertNode(100);
	list2.insertNode(6);
	list2.insertNode(7);
	list2.insertNode(8);
	list2.printLL();
	list2.sort();
	list2.printLL();
	
	
}
}
