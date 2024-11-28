




/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		System.out.println(randomAnagram("RAN"));
		/*// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("hello", "world!"));

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		
	} */} 
	// Returns true if the two given strings are anagrams, false otherwise.
		public static boolean isAnagram(String str1, String str2) 
		{
		String all = "abcdefghigklmnopqrstuvwxyz";
		String str1Big = preProcess(str1);
		String str2Big = preProcess(str2);
		if(str1Big.length() != str2Big.length())
		{
			return false;
		}
			for(int i = 0; i<all.length(); i++)
			{
			
				if(str1Big.indexOf(all.charAt(i)) != -1)
				{
					if(str2Big.indexOf(all.charAt(i)) == -1)
					{
						return false;
					}
				}
				if(str2Big.indexOf(all.charAt(i)) != -1)
				{
					if(str1Big.indexOf(all.charAt(i)) == -1)
					{
						return false;
					}
				}
			}
		return true;
	
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	static String preProcess(String str) {
		 String str1 =str.toLowerCase().replaceAll("[^a-z]", "");
		return str1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		System.out.println(str);
		str = preProcess(str);
		int i = str.length()-1;
		StringBuilder str1 = new StringBuilder(str);
		while(i>-1)
		{
			int j =(int)(Math.random()*str.length());
			 str1.setCharAt(j,str.charAt(i));
			 i--; 
		}
		// Replace the following statement with your code
		return str1.toString();
	}
}