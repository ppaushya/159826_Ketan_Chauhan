package assignment;

public class AssignmentSep27 {

	public static void main(String[] args) {
		
		//Question 1
		//printPrimeFraction(24);

		//Question 2
		/*String s2 = "hello";
		s2 = AlphabetSoup(s2);
		System.out.println(s2);*/
		

		//Question 3
/*		String s3 = "hello world, this sentence is capitalized";
		System.out.println(s3);
		s3 = LetterCapitalize(s3);
		System.out.println(s3);
*/

		//Question 4
		/*String s4 = "hello world, this sentence is capitalized";
		System.out.println(s4);
		s4 = LetterChanges(s4);
		System.out.println(s4);*/

		//Question 5
		/*String s5 = "hello world, this sentence is capitalized";
		System.out.println(s5);
		s5 = reverseOrder(s5);
		System.out.println(s5);*/

		//Question 6
//		System.out.println(findFactorial(15));

		//Question 7
		/*String s5 = "hello world, find maximum lenght word from this sentence";
		System.out.println(s5);
		System.out.println(LongestWord(s5));*/

		//Question 8
		String s1 = "School master";
		String s2 = "The classroom";
		System.out.println(isAnagram(s1, s2));
	}
	
	//--------------------------------Question 1-----------------------------
	public static void printPrimeFraction(int n) {
		boolean isFirst = true;
		for(int c=2;c<=n;c++) {
			while(n%c==0) {
				n /= c;
				if(!isFirst) {
					System.out.print(",");
				}else {
					isFirst = !isFirst;
				}
				System.out.print(c);
			}
			if(n==1) {
				break;
			}
		}
	}
	
	
	//--------------------------------Question 2-----------------------------
	public static String AlphabetSoup(String str) {
		char[] arr = str.toCharArray();
		sortArrayByBubbleSort(arr);
		return new String(arr);
	}
	
	public static void sortArrayByBubbleSort(char[] array) {
		int len = array.length;
		char temp;
		
		for(int i=0;i<len-1;i++) {
			for(int j=len-2;j>=i;j--) {
				if(array[j]>array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//--------------------------------Question 3-----------------------------
	public static String LetterCapitalize(String str) {		
		char[] arr = str.toCharArray();
		int len = arr.length;
		
		if(arr[0]>=97 && arr[0]<=122) {
			arr[0] -= 32;
		}
		
		for(int i=1;i<len;i++) {
			if(arr[i-1]==' ' && arr[i]>=97 && arr[i]<=122) {
				arr[i] -= 32;
			}
		}
		
		return new String(arr);
	}
	
	//--------------------------------Question 4-----------------------------
	public static String LetterChanges(String str) {
		char[] arr = str.toCharArray();
		int len = arr.length;
		
		for(int i=0;i<len;i++) {
			if(arr[i]>=97 && arr[i]<=122) {
				arr[i]++;
				if(arr[i]>122) {
					arr[i]=97;
				}
				if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') {
					arr[i] -= 32;
				}
			}
		}
		
		return new String(arr);
	}
	
	//--------------------------------Question 5-----------------------------
	public static String reverseOrder(String str) {
		char[] arr = str.toCharArray();
		reverseArray(arr);
		return new String(arr);
	}
	
	public static void reverseArray(char[] array) {
		char temp;
		int len = array.length;
		for(int i=0;i<len/2;i++) {
			temp = array[i];
			array[i] = array[len-i-1];
			array[len-i-1] = temp;
		}
	}
	
	//--------------------------------Question 6-----------------------------
	public static String findFactorial(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i=num;i>0;i--) {
			sb.append(i);
			if(i!=1) {
				sb.append("*");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	//--------------------------------Question 7-----------------------------
	/*public static String LongestWord(String str) {
		String[] arr = str.split(" ");
		int max = arr[0].length();
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].length()>max) {
				max = arr[i].length();
				index = i;
			}
		}
		return arr[index];
	}*/
	
	public static String LongestWord(String str) {
		int max = 0;
		int len = str.length();
		
		int counter = 0;
		int start = 0;
		int max_start = 0;
		
		for(int i=0;i<len;i++) {
			if((str.charAt(i)>=97 && str.charAt(i)<=122) || (str.charAt(i)>=65 && str.charAt(i)<=90) ) {
				if(counter==0) {
					start = i;
				}
				counter++;
			}else {
				if(counter>max) {
					max = counter;
					max_start = start;
				}
				counter = 0;
			}
		}
		
		if(counter>max) {
			max = counter;
			max_start = start;
		}
		
		return str.substring(max_start, max_start+max);
	}
	
	//--------------------------------Question 8-----------------------------
	public static boolean isAnagram(String str1,String str2) {
		char[] a1 = str1.toCharArray();
		char[] a2 = str2.toCharArray();
		a1 = makeCapitalToSmall(a1);
		a2 = makeCapitalToSmall(a2);
		sortArrayByBubbleSort(a1);
		sortArrayByBubbleSort(a2);
		str1 = new String(a1);
		str2 = new String(a2);
		return str1.equals(str2);
	}
	
	private static char[] makeCapitalToSmall(char[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=65 && arr[i]<=90) {
				arr[i] += 32;
			}
		}
		return arr;
	}
}
