package Operators;

public class BETWEEN extends Operator{
    private OperatorDetails opd ;
	public BETWEEN() {
		opd = new OperatorDetails() ;
		opd.setNumberOfOperands(3);
		opd.setPriority(100);
		opd.setSymbol("BETWEEN");
		Operators.addOperator("BETWEEN",opd);
	}

	@Override
	public <T> boolean compute(T[] operands) {
		// TODO Auto-generated method stub
		if(operands.length == opd.getNumberOfOperands() && operands[0].getClass() == operands[1].getClass()) {
			if( Utility.isNumeric((String)operands[0]) && Utility.isNumeric((String)operands[1]) && Utility.isNumeric((String)operands[2]) ) {
				if( Integer.parseInt((String) operands[0]) >= Integer.parseInt((String) operands[1]) && Integer.parseInt((String) operands[0]) <= Integer.parseInt((String) operands[2]))
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
