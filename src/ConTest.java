/*
 * Brett Nelson bnelso26@calpoly.edu
 * 1/21/15
 * Project 1
 */

import java.util.Scanner;

//main class to test converter object
public class ConTest {

	//main method, tests the methods of converter object
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		Converter converter = new Converter();
		boolean quit = false;
		
		//printMenu used to reduce size of main method
		printMenu();
		
		while(!quit){
			System.out.println("Choose an operation:");
			String input = sc.nextLine();
			switch(input){
			case"i":
				System.out.println("Please give an input value");
				System.out.println("The postfix expression is: " + converter.infixToPostfix(sc.nextLine()));
				break;
				
			case"p":
				System.out.println("Please give an input value");
				System.out.println("The value of the postfix expression is: " + converter.postfixValue(sc.nextLine()));
				break;
				
			case"a":
				System.out.println("Please give an input value");
				String store = converter.infixToPostfix(sc.nextLine());
				System.out.println("The value of the arithmetic expression is: " + converter.postfixValue(store));
				break;
				
			case"q":
				System.out.println("Goodbye");
				quit = true;
				break;
				
			default:
				System.out.println("Invalid choice");
			}
		}
	}
	
	//method made to reduce size of main method
	private static void printMenu(){
		System.out.println("Choose one of the following operations:");
		System.out.println("   • Infix to postfix conversion (enter the letter i)");
		System.out.println("   • Postfix expression evaluation (enter the letter p)");
		System.out.println("   • Arithmetic expression evaluation (enter the letter a)");
		System.out.println("   • Quit the program (enter the letter q)");
	}
	
}
