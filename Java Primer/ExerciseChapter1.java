public class ExerciseChaper1 {

	public static void main(String[] args) {
		//int[] arr = {1,3,5};
		//boolean value = isEven(arr);
		//System.out.println(value);
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
	static double norm(int[] v, int...arg) {
		
	}
}
