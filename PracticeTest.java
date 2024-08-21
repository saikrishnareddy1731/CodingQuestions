package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PracticeTest {

	public static void main(String arg[]) {

		// 1. Anagaram
		String s1 = "listen";
		String s2 = "silent";
		boolean b = isAnagram(s1, s2);
		System.out.println("Is Anagram : " + b);

		// 2 sort And Concatenate
		String input = "banana,apple,grape,orange,kiwi";
		String result = sortAndConcatenate(input);
		System.out.println("Sorted and Concatenated String: " + result);

		// 3. count Character Frequency
		String input1 = "This is a test. This test is only a test.";
		countCharacterFrequency(input1);

		// 4. count Character Frequency
		countWords(input1);

		// 5.Duplicate Characters
		String str = "SaiKrishnaReddy";
		duplicateChar(str);

		// 6. factorial Regular
		int num = 4;
		int d = factorialReg(num);
		System.out.println("factorial using Regualar function of  " + num + " is : " + d);
		// 6. factorial Recursion
		int c = factorialRecursion(num);
		System.out.println("factorial using Recursion function of " + num + " is : " + c);

		// 7. Fibonacci
		int fib = fibonacci(4);
		System.out.println("7. Fibonacci of 4 is : " + fib);

		//8. Palindrom 
		String strd = "madam";
		Boolean f = palindromefun(strd);
		System.out.println("8. palindrom : " + f);
		
		
		//9. Prime Number
		int n = 23;
		boolean p = primeNum(n);
		System.out.println("9. Prime Number: " + p);
		
		//10. Remove White Space
		String str3 = "  Java   Programming Language  ";
		String strW = removeWhiteSpace(str3);
		System.out.println("10. Remove White Space: "+strW);
		
		//11. Reverse Characters 
		String str4 = "Hello, world.";
		String g = reverseCharacters(str4);
		System.out.println("11. Reverse Characters : " + g);
		
		//12. Reverse  String 
		String st = "  Java   Programming Language  ";
		String h = reverseStringWordsOnly(st);
		System.out.println("12. Reverse String : " + h);
		
		//13. second Highest Number
		int[] numbers = { 4, 7, 2, 18, 10, 3 };
		int sh = secHighest(numbers);
		System.out.print("13. Second Highest Number :" + sh);
		
		//14.Two Sum
		int[] nums = { 2, 1, 11, 7, 15 };
		int target = 9;
		int[] result1 = twoSum(nums, target);
		System.out.println("14. Two Sum Indices: [" + result1[0] + ", " + result1[1] + "]");
		
		swapTwoNumbers(2, 3);
		 

	}



	// 1. Anagaram
	private static boolean isAnagram(String s1, String s2) {
		Map<Character, Integer> an = new HashMap<>();
		if (s1.length() != s2.length())
			return false;

		for (char c : s1.toCharArray()) {
			an.put(c, an.getOrDefault(c, 0) + 1);
		}

		for (char c : s2.toCharArray()) {
			if (!an.containsKey(c)) {
				return false;
			}
			an.put(c, an.get(c) - 1);
		}

		return true;
	}

	// 2 sort And Concatenate
	private static String sortAndConcatenate(String input) {

		String str[] = input.split(",");

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].compareTo(str[j]) > 0) {
					String tmp = str[i];
					str[i] = str[j];
					str[j] = tmp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}

		return sb.toString();
	}

	// 3. count Character Frequency
	private static void countCharacterFrequency(String input1) {

		String str[] = input1.split("\\s+");
		Map<String, Integer> cf = new HashMap<>();

		for (String s : str) {
			cf.put(s, cf.getOrDefault(s, 0) + 1);
		}

		System.out.println("3. count Character Frequency ");
		for (Map.Entry<String, Integer> st : cf.entrySet()) {
			System.out.println(st.getKey() + " " + st.getValue());
		}

	}

	// 4. count No of Words
	private static void countWords(String input1) {

		Map<Character, Integer> cw = new HashMap<>();

		for (char c : input1.toCharArray()) {
			if (c != ' ') {
				cw.put(c, cw.getOrDefault(c, 0) + 1);
			}

		}

		System.out.println(" 4. count No of Words ");
		for (Map.Entry<Character, Integer> d : cw.entrySet()) {
			System.out.println(d.getKey() + " " + d.getValue());

		}

	}

	// 5.duplicate Characters
	private static void duplicateChar(String str) {
		Map<Character, Integer> dc = new HashMap<>();
		for (char c : str.toCharArray()) {
			dc.put(c, dc.getOrDefault(c, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		System.out.println(" 5. duplicateChar ");
		for (Map.Entry<Character, Integer> ek : dc.entrySet()) {
			if (ek.getValue() > 1) {
				System.out.println(ek.getKey() + " " + ek.getValue());
			}
		}
	}

	// 6.a.factorialReg
	private static int factorialReg(int num) {
		if (num <= 1)
			return num;

		int res = 1;
		for (int i = 2; i <= num; i++) {
			res *= i;
		}
		return res;
	}

	// 6.b. factorialRecursion

	private static int factorialRecursion(int num) {
		if (num <= 1)
			return num;

		return num * factorialRecursion(num - 1);
	}

	// 7.Fibonacci
	private static int fibonacci(int num) {
		if (num <= 1)
			return num;

		int a = 0, b = 1;
		for (int i = 2; i <= num; i++) {
			int temp = a + b;
			a = b;
			b = temp;
		}

		return b;
	}

   // 8. palindrome function
	private static Boolean palindromefun(String strd) {
		int i=0,j=strd.length()-1;
	  char str[]=strd.toCharArray();
		while(i<j)
		{
          if(str[i]!=str[j])
          {
        	  return false;
          }
          i++;j--;
		}
		return true;
	}
	
	
	//9. Prime Number 
	private static boolean primeNum(int n) {
		
		if(n<=1)
			return false;
		
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}

	//10. Remove White Space

	private static String removeWhiteSpace(String str3) {
		 StringBuilder sb=new StringBuilder();
		 for(char c: str3.toCharArray())
		 {
			 if(c!=' ')
			 {
				 sb.append(c);
			 }
		 }
		return sb.toString();
	}

	
	//11. Reverse  a String 
	private static String reverseCharacters(String str4) {

	    char str[]=str4.toCharArray();
	    int i=0,j=str.length-1;
	    while(i<j)
	    {
	    	char temp=str[i];
	    	str[i]=str[j];
	    	str[j]=temp;
	    	i++;
	    	j--;
	    }
	    
		return new String(str);
	}


	
   //12. Reverse String Words
	private static String reverseStringWordsOnly(String st) {
		String str[]=st.split("\\s+");
	StringBuilder sb=new StringBuilder();
	for(int i=str.length-1;i>=0;i--)
	{
		sb.append(str[i]);
        if (i > 0) {
            sb.append(" "); 
        }
	}
		return sb.toString();
	}


  // 13. Second Highest Number
	private static int secHighest(int[] numbers) {
		int firstHighNum=Integer.MIN_VALUE,secHighNum=Integer.MIN_VALUE;
		
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]>firstHighNum)
			{
				secHighNum=firstHighNum;
				firstHighNum=numbers[i];
			}
			else if(numbers[i]>secHighNum&&numbers[i]<firstHighNum)
			{
				secHighNum=numbers[i];
			}
		}
		return secHighNum;
	}




//14.  Two Sum 
	private static int[] twoSum(int[] nums, int target) {
		
		Map<Integer,Integer>n=new HashMap<>();
		for(int i=0; i<nums.length;i++)
		{
			int complement= target-nums[i];
			if(n.containsKey(complement))
			{
				return new int[] {n.get(complement),i };
			}
			n.put(nums[i], i);
		}
        
		throw new IllegalArgumentException("Target Element is not found");
	}


   //15. Swapping of 2 numbers
	private static void swapTwoNumbers(int a, int b) {
		int temp=a+b;
		a=temp-a;
		b=temp-a;
		System.out.println("a :"+a+" b : "+b);
		
	}





}
