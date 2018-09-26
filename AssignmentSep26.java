package assignment;

import java.util.Scanner;

public class MatrixOperation {

	int[][] matrix;
	int len;
	
	public void getMatrix() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows(or columns) of square matrix: ");
		len = sc.nextInt();
		
		matrix = new int[len][len];
		System.out.println("Enter elements: ");
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	
	public void printMatrix() {
		System.out.println();
		System.out.println("Matrix:");
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//--------------------Question 1---------------------
	public void printUpperTriangleMatrix() {
		System.out.println();
		System.out.println("Upper triangle:");
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(j>=i) {
					System.out.print(matrix[i][j]+" ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printLowerTriangleMatrix() {
		System.out.println();
		System.out.println("Lower triangle:");
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(j<=i) {
					System.out.print(matrix[i][j]+" ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printTransposeMatrix() {
		System.out.println();
		System.out.println("Transpose matrix:");
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	//--------------------Question 2---------------------
	public static void getMinSumRow(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		
		int min_index = 0;
		int min_sum = 0;
		int sum = 0;
		
		for(int j=0;j<c;j++) {
			sum += mat[0][j];
		}
		min_sum = sum;
		
		for(int i=1;i<r;i++) {
			sum = 0;
			for(int j=0;j<c;j++) {
				sum += mat[i][j];
			}
			if(sum<min_sum) {
				min_sum = sum;
				min_index = i;
			}
		}

		System.out.println("Minimum sum row:");
		for(int j=0;j<c;j++) {
			System.out.print(mat[min_index][j]+" ");
		}
	}
	
	//--------------------Question 3---------------------
	public static void printMissingElementInRows(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		
		for(int i=0;i<r;i++) {
			System.out.print("\nMissing element in row { ");
			for(int j=0;j<c;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("} is :");
			System.out.print(findSmallestMissingElement(mat[i]));
		}
	}
	
	public static int findSmallestMissingElement(int[] arr) {
		if(!isArraySorted(arr)) {
			sortArrayByBubbleSort(arr);
		}
		for(int i=0;i<arr.length-1;i++) {
			if((arr[i+1]-arr[i])>1) {
				return arr[i]+1;
			}
		}
		return arr[arr.length-1] +1;
	}
	
	public static boolean isArraySorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void sortArrayByBubbleSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		
		for(int i=0;i<len-1;i++) {
			for(int j=len-2;j>=i;j--) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	//--------------------Question 4---------------------
	public static int[][] addMatrix(int[][] m1,int[][] m2) {
		int r1 = m1.length;
		int c1 = m1[0].length;
		int r2 = m2.length;
		int c2 = m2[0].length;
		
		if(r1!=r2 || c1!=c2) {
			System.out.print("Rows and Columns must be same");
			return null;
		}
		
		int[][] ans = new int[r1][c1];
		for(int i=0;i<r1;i++) {
			for(int j=0;j<c1;j++) {
				ans[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		return ans;
	}
	
	public static int[][] multiplyMatrix(int[][] m1,int[][] m2) {
		int r1 = m1.length;
		int c1 = m1[0].length;
		int r2 = m2.length;
		int c2 = m2[0].length;
		
		if(c1!=r2) {
			System.out.print("Column of 1st and Rows of 2nd matrix must be same");
			return null;
		}
		
		int[][] ans = new int[r1][c2];
		for(int i=0;i<r1;i++) {
			for(int j=0;j<c2;j++) {
				for(int k=0;k<c1;k++) {
					ans[i][j] += m1[i][k]*m2[k][j];
				}
			}
		}
		
		return ans;
	}
	
	public static void printMatrix(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		
		System.out.println("\nMatrix: ");
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	//-------------------Main---------------------
	public static void main(String[] args) {
		//Question 1
//		MatrixOperation mo = new MatrixOperation();
//		mo.getMatrix();
//		mo.printMatrix();
//		mo.printTransposeMatrix();
//		mo.printUpperTriangleMatrix();
//		mo.printLowerTriangleMatrix();
		
		//Question 2
//		int[][] mat0 = {{1,2},{2,3},{-1,1}};
//		getMinSumRow(mat0);
		
		//Question 3
//		int[][] mat1 = {{10,20,30},{1,7,8},{100,1,-1}};
//		printMissingElementInRows(mat1);
		
		
		//Question 4
		int[][] m1 = {{1,2},{2,5}};
		int[][] m2 = {{2,7},{3,4}};
		int[][] sum = addMatrix(m1,m2);
		int[][] mul = multiplyMatrix(m1,m2);
		
		printMatrix(m1);
		printMatrix(m2);
		printMatrix(sum);
		printMatrix(mul);
	}

}
