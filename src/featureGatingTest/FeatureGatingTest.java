package featureGatingTest;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import User.* ;
import featureGating.*;


public class FeatureGatingTest {
	
	private static IfeatureGate fg ;
	private static User user ;
	
	@BeforeClass
	public static void setUp() {
		user = new User();
		user.addAttribute("age", "26");
		user.addAttribute("gender", "Male");
		user.addAttribute("past_order_amount", "20000");
		fg = new FeatureGate();
		
	}

	@AfterClass
	public static void tearDown() {
		
	}
	
	@Test
	public void testTrueCondition() {
		String exp =  "( age > 25 AND gender == Male ) OR ( past_order_amount > 10000 )";
		boolean b = fg.isAllowed(exp, user.getUserAttributes());
		System.out.println(b);
		assertEquals(true,b);

	}
	
	@Test
	public void testFalseCondition() {
		String exp =  "( age < 25 AND gender == Male ) OR ( past_order_amount > 25000 )";
		boolean b = fg.isAllowed(exp, user.getUserAttributes());
		System.out.println(b);
		assertEquals(false,b);

	}
	
	@Test
	public void testBetweenTrueCondition() {
		String exp =  "( age < 25 AND gender == Male ) OR ( past_order_amount BETWEEN 10000 25000 )";
		boolean b = fg.isAllowed(exp, user.getUserAttributes());
		System.out.println(b);
		assertEquals(true,b);

	}
}
