package Evaluator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;


import Operators.*;


/* Assumptions: 
 * 1. The operators dont appear in the expression as a string.
 * 2. There is a space between all the operators, operands, variables etc.
 * 
 */

public class InfixEvaluator implements IEvaluator {
	private Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	LinkedHashMap<String,OperatorDetails > operators;
	
	

	public InfixEvaluator(LinkedHashMap<String, OperatorDetails> operators) {
		super();
		this.operators = operators;
	}



	@Override
	public boolean evaluate(String exp, Map<String, String> user) {
		String[] tokens = parseExpression(exp);

       Stack<String> values = new Stack<String>(); 
       Stack<String> ops = new Stack<String>();
       
       for (int i = 0; i < tokens.length; i++) 
       { 
 
           if (tokens[i] == " ") 
               continue; 
 
 
           if (isNumeric(tokens[i])) 
           { 
               values.push(tokens[i]); 
           } 
 
 
           else if (tokens[i].equals("(")) 
               ops.push(tokens[i]); 
 
           // Closing brace encountered, solve entire brace 
           else if (tokens[i].equals(")") ) 
           { 
               while (!ops.peek().contentEquals("(") ) 
                 values.push(applyOp(values, ops, operators)); 
               ops.pop(); 
           } 
 
           // Current token is an operator. 
           else if (isOperator(tokens[i], operators )) 
           { 
               // While top of 'ops' has same or greater precedence to current 
               // token, which is an operator. Apply operator on top of 'ops' 
               // to top two elements in values stack 
               while (!ops.empty() && hasPrecedence(tokens[i], ops.peek(), operators )) 
                 values.push(applyOp(values, ops, operators)); 
 
               // Push current token to 'ops'. 
               ops.push(tokens[i]); 
           } 
           else if(isVariable(tokens[i], user)) {
        	   values.push(user.get(tokens[i]));
           }
           else {
        	   values.push(tokens[i]);
           }
       } 
 
       // Entire expression has been parsed at this point, apply remaining 
       // ops to remaining values 
       while (!ops.empty()) 
           values.push(applyOp(values, ops, operators)); 
 
       // Top of 'values' contains result, return it 
       return Boolean.parseBoolean((String)values.pop()); 
   } 
       
       

	private boolean isVariable(String string, Map<String, String> user) {
		if(user.containsKey(string))
			return true;
		else 
			return false;

	}



	private boolean hasPrecedence(String token, String top, LinkedHashMap<String, OperatorDetails> operators) {
		if(top.equals("(") || top.equals(")"))
			return false;
		else if(operators.get(top).getPriority() >= operators.get(token).getPriority())
			return true;
		else 
			return false;
 

	}



	private boolean isOperator(String token, LinkedHashMap<String, OperatorDetails> operators) {
		Set<String> keyset = operators.keySet();
		
		for(String s: keyset) {
			if(s.equals(token))
				return true;
		}
		return false;

	}

	
	private String[] parseExpression(String exp){
		String[] arrOfStr = exp.split(" ");
		return arrOfStr;
	}
	
	private String applyOp(Stack<String> values, Stack<String> ops, LinkedHashMap<String, OperatorDetails> operators) {
		OperatorDetails opd = operators.get(ops.pop());
		int numOperands = opd.getNumberOfOperands();
		String[] arr = new String[numOperands];
		for(int i = numOperands-1 ; i>=0; i-- )
			arr[i] = values.pop();
		boolean b = opd.getOp().compute(arr);
		return String.valueOf(b);	
	}
	
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return numericPattern.matcher(strNum).matches();
	}

	
	
}
