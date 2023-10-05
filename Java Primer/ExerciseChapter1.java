import java.util.*;
public class ExerciseChaper1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//boolean value = isEven(arr);
		//System.out.println(value);
		
		//double[] a = {1,1,1};
		//double answer = norm(a);
		//System.out.println(answer);
		
		//int n = numDiv(17);
		//System.out.println(n);
		
		//shuffle(arr);
		//outputCatdog();
	}
	
	/**
	 * 
	 * @param string s
	 * @return string whose punctuation removed
	 */
	static String removePunctuation(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i=sb.length()-1;i>=0;i--) {
			if(sb.charAt(i)=='!' || sb.charAt(i)=='?' || sb.charAt(i)=='.' || sb.charAt(i)==',' || sb.charAt(i)=='\'' || sb.charAt(i)=='\"')
				sb.deleteCharAt(i);
		}
		return sb.toString();
	}
	/**
	 * 
	 * C-1.14
	 * @param int array arr
	 * @return integer array reversed which is the reversed version of arr
	 */
	static int[] reverseIntArr(int[] arr) {
		int[] reversed = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			reversed[i] = arr[arr.length-(i+1)];
		}
		return reversed;
	}
	/**
	 * 
	 * C-1.15
	 * @param int array arr
	 * @return size 2 integer array minmax whose first element is min and second element is max of the input array
	 */
	static int[] minmax(int[] arr) {
		int min = 0;
		int max = 0;
		int[] minmax = new int[2];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[min]) {
				min = i;
			}
			if(arr[i]>arr[max]) {
				max = i;
			}
		}
		
		minmax[0] = arr[min];
		minmax[1] = arr[max];
		
		return minmax;
	}
	/**
	 * 
	 * C-1.16. Write a short program that takes as input three integers, a, b, and c, from the Java console and determines 
	 * if they can be used in a correct arithmetic formula (in the given order), like “a+b = c,” “a = b−c,” or “a ∗ b = c.”
	 * @param a
	 * @param b
	 * @param c
	 * @return true if parameters could be used in a correct arithmetic formula, and false if not.
	 */
	static boolean isArithmetic(int a, int b, int c) {
		if(a==b+c || a+b==c || a==b-c || a-b==c || a==b*c || a*b==c || a==(int)((double)b/c) || (int)((double)a/b)==c) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * C-1.17. Write a short Java method that takes an array of int values and determines 
	 * if there is a pair of distinct elements of the array whose product is even.
	 * @param int array arr
	 * @return true if product of two different elements is even, and false if not.
	 */
	static boolean isEven(int[] arr) {
		int[] oddEven = new int[2];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==1)
				oddEven[0] += 1;
			else
				oddEven[1] += 1;
		}
		
		//multiplication of two even value is even
		if(oddEven[1]>=2)
			return true;
		//multiplication of odd and even is even
		else if(oddEven[0]>=1 && oddEven[1]>=1)
			return true;
		//rest of the case, which is multiplication between two odd value is odd, thus false
		else
			return false;
	}
	
	/**
	 * 
	 * C-1.18. Give an implementation of a method named norm such that norm(v, p) returns the p-norm value of v 
	 * and norm(v) returns the Euclidean norm of v, where v is represented as an array of coordinates.
	 * @param v
	 * @param arg
	 * @return
	 */
	static double norm(double[] v, int...arg) {
		double value = 0;
		//Euclidean norm
		if(arg.length==0) {
			for(int i=0;i<v.length;i++) {
				value += Math.pow(v[i], 2);
			}
			return Math.sqrt(value);
		}
		//p-norm
		else {
			int p = arg[0];
			for(int i=0;i<v.length;i++) {
				value += Math.pow(v[i], p);
			}
			return Math.pow(value, 1.0/p);
		}
	}
	/**
	 * 
	 * C-1.19. Write a Java program that can take a positive integer greater than 2 as input and write out the number of times 
	 * one must repeatedly divide this number by 2 before getting a value less than 2.
	 * @param integer a
	 * @return number of division(by 2) to make integer 'a' less than 2.
	 */
	static int numDiv(int a) {
		int count = 0;
		if(a>2) {
			do {
				a /= 2;
				count++;
			}while(a>=2);
			
			return count;
		}else
			return 0;
	}
	
	/**
	 * 
	 * C-1.20. Write a Java method that takes an array of float values and determines 
	 * if all the numbers are different from each other (that is, they are distinct).
	 * @param float array arr
	 * @return true if all values are distinct, false if there are more than one duplicates.
	 */
	static boolean distinct(float[] arr) {
		boolean isDistinct = true;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				isDistinct = false;
				break;
			}
		}
		return isDistinct;
	}
	/**
	 * <Use Collections.shuffle method>
	 * C-1.21. Write a Java method that takes an array containing the set of all integers in the range 1 to 52 
	 * and shuffles it into random order. Your method should output each possible order with equal probability.
	 * @param integer array arr ranging from 1 to 52
	 */
	static void shuffle(int[] arr) {
		Integer[] array = new Integer[arr.length];
		for(int i=0;i<arr.length;i++) {
			array[i] = arr[i];
		}
		List<Integer> list = Arrays.asList(array);
		Collections.shuffle(list);
		System.out.println(list.toString());
	}
	
	/**
	 * <print all string permutations>
	 * C-1.22. Write a short Java program that outputs all possible strings formed by using the characters 
	 * 'c', 'a', 't', 'd', 'o', and 'g' exactly once.
	 */
	static void outputCatdog() {
		String s = "catdog";
		printPermutation(s, "");
	}
	private static void printPermutation(String str, String answer) {
		if(str.length()==0) {
			System.out.print(answer+" ");
			return;
		}
		for(int i=0;i<str.length();i++) {
			char character = str.charAt(i); //pick i-th element of the given string
			
			String remain = str.substring(0,i) + str.substring(i+1); //get remainder of the string excluding i-th element
			
			printPermutation(remain, answer + character); //recursion
		}
	}
	
	/**
	 * c-1.23. Write a short Java program that takes two arrays a and b of length n storing int values, 
	 * and returns the dot product of a and b.
	 * @param a
	 * @param b
	 * @return a dot product b
	 */
	static int dotProduct(int[] a, int[] b) {
		int ans = 0;
		for(int i=0;i<a.length;i++) {
			ans += (a[i]*b[i]);
		}
		return ans;
	}
}
