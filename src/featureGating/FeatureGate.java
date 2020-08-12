package featureGating;

import java.util.Map;

import Evaluator.IEvaluator;
import Evaluator.InfixEvaluator;
import Operators.Operators;

public class FeatureGate implements IfeatureGate {

	@Override
	public boolean isAllowed(String conditionalExpression, Map<String, String> user) {
		
		IEvaluator ev= new InfixEvaluator(Operators.getOperator()) ;
		return ev.evaluate(conditionalExpression, user);
	}

}
