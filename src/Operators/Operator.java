package Operators;

public abstract class Operator {
 
	public abstract  <T> boolean compute(T[] differentClasses) ;

	public abstract  void setOp(Operator op);
}
