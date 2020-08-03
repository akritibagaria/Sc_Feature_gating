package featureGating;

import java.util.Map;

public interface IfeatureGate {
	boolean isAllowed(String conditionalExpression, Map<String, String> user);
}
