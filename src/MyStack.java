/*
 * Brett Nelson bnelso26@calpoly.edu
 * 1/21/15
 * Project 1
 */

import java.util.LinkedList;
import java.util.EmptyStackException;
import java.util.*;
import java.io.*;

//class to create a LL stack using Nodes
public class MyStack<T> {

	private Node head; //node at top of stack
	
	//class to create a Node
	public class Node{
		
		public T element;//element stored in node
		public Node next;//link to next node
		
		//constructor takes in element and node
		public Node(T e, Node n){
			element = e;
			next = n;
		}
	}
	
	//empty constructor
	public MyStack(){
	}
	
	//pushes an element on top of stack
	public void push(T value){
		Node store = new Node(value, head);
		head = store;
	}
	
	//pops out and returns element on top of stack
	public T pop(){
		T store;
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			store = head.element;
			head = head.next;
		}
		return store;
	}
	
	//returns top element of stack
	public T peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return head.element;
	}
	
	//returns empty or not
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
}//close class
