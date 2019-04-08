
package application;

import java.util.Stack;

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
	     return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")");
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
                 double b = values.pop();
                 switch(token)
                	  {
                      case "+":
                          answer = a + b;
                          break;
                      case "-":
                          answer = b - a;
                          break;
                      case "*":
                          answer = a * b;
                          break;
                      case "/":{
                    	  if(a!=0)
                    		  answer = b / a;
                    	  else
                    		  return "ERR";
                          break;   
                      }
                }
                values.add(answer); 
            }
        }
        x = Double.toString(answer);
        return x;
}
	public  String rpnChange(String result) {
		result = result.trim();
	//	if (result.charAt(result.length() -1)== ')')
	//		result += " ";
		String[] tokens = result.split(" ");
		Stack<String> stack= new Stack<String>();
		String exit="";
		String w;
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
                 case "*":{
                	 String x = " ";
                	 while (stack.search("/")!=-1) {
                		 x=stack.pop();
                		 if(x!="(")
                			 exit+=x + " ";
                	 }
                	stack.add("*");		
                	break;
                 }
                 case "/":{
                	 String x = " ";
                	 while (stack.search("*")!=-1) {
                		 x=stack.pop();	
                		 if(x!="(")
                			 exit+=x + " ";
                	 }
                	 stack.add("/");
                	break;		 
                 }
                 case "+":{
                	 String x = " ";
                	 while (stack.search("*")!=-1 || stack.search("-")!=-1 || stack.search("/")!=-1) {
                		 x=stack.pop();
                		 if(x!="(")
                			 exit+=x + " ";
                	 }
                	 stack.add("+");
                	break;		 
                 }
                 case "-":{
                	 String x = " ";
                	 while (stack.search("*")!=-1 || stack.search("+")!=-1 || stack.search("/")!=-1) {
                		 x=stack.pop();
                		 if(x!="(")
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
			
		

