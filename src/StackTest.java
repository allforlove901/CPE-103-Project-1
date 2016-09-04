/*
 * Brett Nelson bnelso26@calpoly.edu
 * 1/21/15
 * Project 1
 */

import java.util.Scanner;
import java.io.*;

//class to test MyStack implementation
public class StackTest {

	private static boolean quit = false; //determines when program should quit
	
	//main method, tests MyStack object
	public static void main (String args[]){
		
		MyStack<String> stack = new MyStack<String>();
		Scanner sc = new Scanner(System.in);
		
		printMenu();//menu printed in helper method to make main method smaller
		
		while(!quit){
			System.out.println("Choose an operation:");
			String input = sc.nextLine();
			switch(input){
			
			case "a":
				//push
				System.out.println("Please give an input value");
				String store = sc.nextLine();
				stack.push(store);
				System.out.println(store + " pushed in");
				break;
				
			case "d":
				//pop
				try{
				System.out.println(stack.pop() + " popped out");
				}
				catch(Exception e){
					System.out.println("Invalid operation on an empty stack");
				}
				break;
				
			case "p":
				//peek
				try{
				System.out.println(stack.peek() + " on top");
				}
				catch(Exception e){
					System.out.println("Invalid operation on an empty stack");
				}
				break;
				
			case "e":
				//check if empty
				if(stack.isEmpty())
					System.out.println("empty");
				else
					System.out.println("not empty");
				break;
				
			case "q":
				//quit
				quit = true;
				System.out.println("quitting program");
				break;
				
			default:
				System.out.println("Invalid choice");
			}
		}
	}
	
	//method made to reduce size of main method
	private static void printMenu(){
		//System.out.println("Choose one of the following operations:");
		System.out.println("   • push/add (enter the letter a)");
		System.out.println("   • pop/delete (enter the letter d)");
		System.out.println("   • peek (enter the letter p)");
		System.out.println("   • check if the stack is empty (enter the letter e)");
		System.out.println("   • quit (enter the letter q)");
	}
}
