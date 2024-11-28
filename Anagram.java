
public class Anagram {
		public static void main(String args[]) {
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

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
	} 
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
	static String preProcess(String str) {
		 String str1 =str.toLowerCase().replaceAll("[^a-z] ", "");
		return str1;
	} 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		int i = str.length()-1;
		StringBuilder str1 = new StringBuilder(str);
		while(i>-1)
		{
			int j =(int)(Math.random()*str.length());
			 str1.setCharAt(j,str.charAt(i));
			 i--; 
		}
		return str1.toString();
	}
}