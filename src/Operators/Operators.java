package Operators;

import java.util.LinkedHashMap;



public  class Operators {

	static LinkedHashMap<String,OperatorDetails > operators = new LinkedHashMap<String,OperatorDetails>();  
	
	
	public static boolean addOperator(String operator, OperatorDetails opd ) {
		
		operators.put(operator, opd);
		return true;
	}
	
	
	public static LinkedHashMap<String, OperatorDetails> getOperator() {
		createOperators();
		return operators ;
	}
	
	private static void createOperators() {
		Operator gt = new GreaterThan();
		gt.setOp(gt);
		Operator gte  = new GreaterThanEqualTo();
		gte.setOp(gte);
		Operator lt =  new LessThan();
		lt.setOp(lt);
		Operator lte = new LessThanEqualTo();
		lte.setOp(lte);
		Operator et = new EqualTo();
		et.setOp(et);
		Operator net =new NotEqualTo();
		net.setOp(net);
		Operator and = new And() ;
		and.setOp(and);
		Operator or = new OR() ;
		or.setOp(or);
		Operator bw = new BETWEEN();
		bw.setOp(bw);
	}
			
}