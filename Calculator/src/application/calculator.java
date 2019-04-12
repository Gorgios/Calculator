
package application;

import java.util.Stack;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class calculator {
	private String result;
	public calculator(String result) {
		super();
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public static boolean isOperator(String s)
	{
	     return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")") ||s.equals("\u221a")||s.equals("\u00B2");
	}
	public void sqrtError() {
	Alert errorAlert = new Alert(AlertType.ERROR);
	errorAlert.setHeaderText("Sqrt ERORR ");
	errorAlert.setContentText("Your number must be greater or equal than 0");
	errorAlert.showAndWait();
	}
	public void divError() {
	Alert errorAlert = new Alert(AlertType.ERROR);
	errorAlert.setHeaderText("Divide ERROR");
	errorAlert.setContentText("You can't divide by zero. Remember that");
	errorAlert.showAndWait();
	}
	public String calculate(String result) {
        result = result.trim();
        Stack<Double> values = new Stack<>(); 
        String[] tokens = result.split(" ");
        String x;
        double answer = 0.0;

        for (String token: tokens)
        {
             if(!isOperator(token))
             {
                 values.add(Double.parseDouble(token));
            }
           else
           {
                 double a = values.pop();
           //      double b = values.pop();
                 double b ;
                 switch(token)
                	  {
                      case "+":
                    	  b=values.pop();
                          answer = a + b;
                         
                          break;
                      case "-":
                    	  b=values.pop();
                          answer = b - a;
                          break;
                      case "*":
                    	  b=values.pop();
                          answer = a * b;
                          break;
                      case "/":{
                    	  b=values.pop();
                    	  if(a!=0)
                    		  answer = b / a;
                    	  else
                    		  divError();
                          break;
                      }
                      case "\u221a":{
                    	  if (a>=0)
                    		  answer = Math.sqrt(a);
                    	  else 
                    		  sqrtError();
                    	  break;
                      }
                      case "\u00B2":
                    		  answer = a* a;
                    	  break;
                }
                values.add(answer); 
            }
        }
        x = Double.toString(answer);
        return x;
}
	public  String rpnChange(String result) {
		result = result.trim();
		String[] tokens = result.split(" ");
		Stack<String> stack= new Stack<String>();
		String exit="";
		for (String token: tokens) {
			if(!isOperator(token))
				exit+=token + " ";
			else {
				 switch(token)
           	  {
                 case "(":
                    stack.add("(");
                    break;
                 case ")":{
                	 String x =stack.pop();
                	 while (x!= "(" ) {
                		 exit+=x + " ";
                		 x=stack.pop();
                	 }
                	 break;
                 }
                 case "\u00B2":{
                	String x = " ";
                 	while (stack.search("\u221a")!=-1) {
                 		 x=stack.pop();
                 		 exit+=x + " ";
                 	}
                 	stack.add("\u00B2");	
                 	break;
                 }
                 case "\u221a": {
                	String x = " ";
                	while (stack.search("\u00B2")!=-1) {
                		 x=stack.pop();
                		 exit+=x + " ";
                	}
                	stack.add("\u221a");		
                	break;
                 }
                 case "*":{
                	 String x = " ";
                	 while (stack.search("/")!=-1 || stack.search("\u221a")!=-1 || stack.search("\u00B2")!=-1) {
                		 x=stack.pop();
                		 exit+=x + " ";
                	 }
                	stack.add("*");		
                	break;
                 }
                 case "/":{
                	 String x = " ";
                	 while (stack.search("*")!=-1  || stack.search("\u221a")!=-1 || stack.search("\u00B2")!=-1) {
                		 x=stack.pop();	
                		 exit+=x + " ";
                	 }
                	 stack.add("/");
                	break;		 
                 }
                 case "+":{
                	 String x = " ";
                	 while (stack.search("*")!=-1 || stack.search("-")!=-1 || stack.search("/")!=-1  || stack.search("\u221a")!=-1 || stack.search("\u00B2")!=-1) {
                		 x=stack.pop();
                		 exit+=x + " ";
                	 }
                	 stack.add("+");
                	break;		 
                 }
                 case "-":{
                	 String x = " ";
                	 while (stack.search("*")!=-1 || stack.search("+")!=-1 || stack.search("/")!=-1  || stack.search("\u221a")!=-1 || stack.search("\u00B2")!=-1) {
                		 x=stack.pop();
                		 exit+=x + " ";
                	 }
                	 stack.add("-");
                	 break;
                 }
			}
		}
		}
		while (!stack.empty()) {
			 String x ;
			 x=stack.pop();
			 if(x!="(")
				 exit+=x + " ";
		}
		exit = exit.replaceAll("  ", " ");	
		return exit;
	}
}
			
		

