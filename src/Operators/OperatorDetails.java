package Operators;

public class OperatorDetails{
	
	Integer priority;
	Operator op;
	Integer numberOfOperands ;
	String symbol;
	
	public OperatorDetails(Integer priority, String symbol,Operator op, Integer numberOfOperands ) {
		this.priority = priority;
		this.op = op;
		this.numberOfOperands = numberOfOperands ;
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public OperatorDetails() {
		super();
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Operator getOp() {
		return op;
	}

	public void setOp(Operator op) {
		this.op = op;
	}

	public Integer getNumberOfOperands() {
		return numberOfOperands;
	}

	public void setNumberOfOperands(Integer numberOfOperands) {
		this.numberOfOperands = numberOfOperands;
	}
	
}