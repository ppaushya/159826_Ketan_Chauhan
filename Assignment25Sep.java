package assignment;

import java.util.Scanner;

public class Assignment25Sep {

	public static void main(String[] args) {
		
		solveProblem1();
//		solveProblem2();
//		solveProblem3();
//		solveProblem4();
//		solveProblem5();
//		solveProblem6();
//		solveProblem7();
	}

	//---------------------------------------problem 1----------------------------------------
	public static void solveProblem1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number:");
		int max = scan.nextInt();
		scan.close();
		
		int odd_n=1,even_n=2,c=0;
		boolean isOdd = true;
		while(odd_n<max || even_n<max) {
			if(isOdd) {
				System.out.print(odd_n+" ");
				odd_n = odd_n +2;
			}else {
				System.out.print(even_n+" ");
				even_n = even_n +2;
			}
			c++;
			if(c==3) {
				c = 0;
				isOdd = !isOdd;
			}
		}
	}
	

	//---------------------------------------problem 2----------------------------------------
	public static void solveProblem2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number:");
		int num = scan.nextInt();
		System.out.println("Sum of digits:"+sumOfDigit(num));
		scan.close();
	}
	
	public static int sumOfDigit(int num) {
		int sum = 0;
		while(num>0) {
			sum += num%10;
			num /= 10;
		}
		return sum;
	}
	

	//---------------------------------------problem 3----------------------------------------
	public static void solveProblem3() {
		for(int i=1;i<=1000;i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num==1) {
			return false;
		}
		if(num==2) {
			return true;
		}
		if(num%2==0) {
			return false;
		}
		
		int sqrt = (int)Math.sqrt(num);
		for(int i=3;i<=sqrt;i=i+2) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	//---------------------------------------problem 4----------------------------------------
	public static void solveProblem4() {
		for(int i=1;i<=1000;i++) {
			if(isArmstrong(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isArmstrong(int num) {
		int n=num,sum = 0;
		while(n>0) {
			sum += Math.pow(n%10,3);
			n /= 10;
		}
		return sum==num;
	}
	
	//---------------------------------------problem 5----------------------------------------
	public static void solveProblem5() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter message:");
		String msg = scan.next();
		scan.close();
		
		int len = msg.length();
		for(int i=0;i<len;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(msg.charAt(j)+" ");
			}
			System.out.println();
		}
	}
	
	//---------------------------------------problem 6----------------------------------------
		public static void solveProblem6() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter number:");
			int num = scan.nextInt();
			scan.close();
			
			printParts("",num);
		}
		
		//---------------------------------------problem 7----------------------------------------
		public static void solveProblem7() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter number:");
			int num = scan.nextInt();
			scan.close();
			
			printParts("",num);
		}
		
		public static void printParts(String prev,int n) {
			if(n==1) {
				if(prev=="") {
					System.out.print(prev + "1");
				}else {
					System.out.print(prev + "+1");
				}
				System.out.println();
				return;
			}
			for(int i=1;i<n;i++) {
				if(prev=="") {
					System.out.print(prev+ i+"+"+(n-i));
					System.out.println();
					if(n-i>1) {
						printParts(prev+i,n-i);
					}
				}else {
					System.out.print(prev+"+" +i+"+"+(n-i));
					System.out.println();
					if(n-i>1) {
						printParts(prev+"+"+i,n-i);				
					}
				}
			}
		}
}
