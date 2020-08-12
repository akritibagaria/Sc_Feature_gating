package Operators;

public class NotEqualTo extends Operator{
    private OperatorDetails opd ;
	public NotEqualTo() {
		opd = new OperatorDetails() ;
		opd.setNumberOfOperands(2);
		opd.setPriority(100);
		opd.setSymbol("!=");
		Operators.addOperator("!=",opd);
	}

	@Override
	public <T> boolean compute(T[] operands) {
		// TODO Auto-generated method stub
		if(operands.length == opd.getNumberOfOperands() && operands[0].getClass() == operands[1].getClass()) {
			if( Utility.isNumeric((String)operands[0]) && Utility.isNumeric((String)operands[1]) ) {
				if( Integer.parseInt((String) operands[0]) != Integer.parseInt((String) operands[1]))
					return true;
				else
					return false;
			}
			
			if(operands[0].getClass() == String.class) {
				if( (((String) operands[0]).compareTo( (String)operands[1])) != 0 )
					return true;
				else
					return false;
			}

		}
		
	
		throw new IllegalArgumentException();
	}
	
	public void setOp(Operator op) {
		opd.setOp(op);
	}

}
