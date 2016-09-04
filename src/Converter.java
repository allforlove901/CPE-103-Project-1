/*
 * Brett Nelson bnelso26@calpoly.edu
 * 1/21/15
 * Project 1
 */

//class to create a converter object, used in arithmetic
public class Converter {

	//method to translate infix expression to postfix form
	public static String infixToPostfix(String expression){
		String postfix = "";
		
		MyStack<String> stack = new MyStack<String>();
		
		String[] arr = expression.split(" ");
		for(int i = 0; i<arr.length; i++){
			switch(arr[i]){
			case "(":
				stack.push(arr[i]);
				break;
				
			case")":
				while(true){
					if(stack.isEmpty()){;break;}
					String store = stack.pop();
					if(!store.equals("(")){
						postfix += store;
						postfix += " ";
					}
					else
						break;
				}//close while
				break;
				
			case"*":
				while(true){
					if(stack.isEmpty()){; stack.push(arr[i]);break;}
					if(stack.peek().equals("/") || stack.peek().equals("*")){
						String store = stack.pop();
						postfix += store;
						postfix += " ";
					}
					else{
						stack.push(arr[i]);
						break;
					}
				}
				break;
				
			case"/":
				while(true){
					if(stack.isEmpty()){; stack.push(arr[i]);break;}
					if(stack.peek().equals("/") || stack.peek().equals("*")){
						String store = stack.pop();
						postfix += store;
						postfix += " ";
					}
					else{
						stack.push(arr[i]);
						break;
					}
				}
				break;
				
			case"+":
				while(true){
					if(stack.isEmpty()){; stack.push(arr[i]);break;}
					if(stack.peek().equals("/") || stack.peek().equals("*") ||
					stack.peek().equals("+") || stack.peek().equals("-")){
						String store = stack.pop();
						postfix += store;
						postfix += " ";
					}
					else{
						stack.push(arr[i]);
						break;
					}
				}
				break;
			
			case"-":
				while(true){
					if(stack.isEmpty()){; stack.push(arr[i]);break;}
					if(stack.peek().equals("/") || stack.peek().equals("*") ||
					stack.peek().equals("+") || stack.peek().equals("-")){
						String store = stack.pop();
						postfix += store;
						postfix += " ";
					}
					else{
						stack.push(arr[i]);
						break;
					}
				}
				break;
				
			default:
				postfix += arr[i];
				postfix += " ";
			}//close switch
		}
		
		while(!stack.isEmpty()){
			postfix += stack.pop() + " ";
		}
		return postfix;
	}
	
	//method to evaluate postfix expression
	public static double postfixValue(String expression){
		
		double output = 0;
		
		MyStack<String> stack = new MyStack<String>();
		
		String[] arr = expression.split(" ");
		for(int i = 0; i<arr.length; i++){
			
			switch(arr[i]){
			case"*":
				double store1 = Double.parseDouble(stack.pop());
				double store2 = Double.parseDouble(stack.pop());
				stack.push(Double.toString(Math.round((store1*store2)*100)/100.0));
				break;
			
			case"/":
				double store3 = Double.parseDouble(stack.pop());
				double store4 = Double.parseDouble(stack.pop());
				stack.push(Double.toString(Math.round((store4/store3)*100)/100.0));
				break;
				
			case"+":
					double store5 = Double.parseDouble(stack.pop());
					double store6 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.round((store5+store6)*100)/100.0));
				break;
				
			case"-":
					double store7 = Double.parseDouble(stack.pop());
					double store8 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.round((store8-store7)*100)/100.0));
				break;
				
			default:
				stack.push(arr[i]);
			}//close switch
		}//close for
		return Double.parseDouble(stack.pop());	
		
	}//close method
}
