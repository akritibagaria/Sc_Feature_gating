package main;

import User.User;
import featureGating.FeatureGate;
import featureGating.IfeatureGate;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		user.addAttribute("age", "26");
		user.addAttribute("gender", "Male");
		user.addAttribute("past_order_amount", "20000");
		IfeatureGate fg = new FeatureGate();
		String exp =  "( age > 25 AND gender == Male ) OR ( past_order_amount > 10000 )";
		boolean b = fg.isAllowed(exp, user.getUserAttributes());
		
		System.out.println(b);
	}

}
