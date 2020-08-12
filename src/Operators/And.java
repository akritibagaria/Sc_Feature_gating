package Operators;

public class And extends Operator{
    private OperatorDetails opd ;
	public And() {
		opd = new OperatorDetails() ;
		opd.setNumberOfOperands(2);
		opd.setPriority(95);
		opd.setSymbol("AND");
		Operators.addOperator("AND",opd);
	}

	@Override
	public <T> boolean compute(T[] operands) {
		// TODO Auto-generated method stub
		if(operands.length == opd.getNumberOfOperands() && operands[0].getClass() == operands[1].getClass()) {

			
			if(operands[0].getClass() == String.class) {
				return ( Boolean.parseBoolean((String) operands[0])  && Boolean.parseBoolean((String) operands[1]) );

			}

		}
		
	
		throw new IllegalArgumentException();
	}
	
	public void setOp(Operator op) {
		opd.setOp(op);
	}

}
