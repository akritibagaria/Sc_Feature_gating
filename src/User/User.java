package User;

import java.util.HashMap;

public class User {
  HashMap<String, String> userAttributes = new HashMap<String, String>();
  
  public void addAttribute(String key, String value) {
	  userAttributes.put(key, value);
  }
  
  public HashMap<String, String> getUserAttributes(){
	  return userAttributes ;
  } 
}
