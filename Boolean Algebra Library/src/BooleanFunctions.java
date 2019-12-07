// Imports
import java.util.InputMismatchException;
import java.util.Scanner;

public class BooleanFunctions implements BooleanInterface{
	// Variables
	public int[][] durersMatrix = {{16, 3, 2, 13},
								   {5, 10, 11, 8},
								   {9, 6, 7, 12},
								   {4, 15, 14, 1}};
	/*
	 * Matrix Methods:
	 * 1. populateIdentity()
	 * 2. print2D
	 * 3. populateRandom()
	 * 4. populteRandomRange()
	 * 5. generateMatrix()
	 * 6. matrixMul()
	 * 7. sumRow()
	 * 8. sumCol()
	 * 9. sumMatrix()
	 */
	
	// populateIdentity()
	public void populateIdentity(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == j) a[i][j] = 1;
				else a[i][j] = 0;
			}
		}
	}
	
	// print2D()
	public void print2D(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// populateRandom()
	public void populateRandom(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int rand = 0 + (int)(Math.random() * (1 - 0 + 1));
				a[i][j] = rand;
			}
		}
	}
	
	// populateRandomRange()
	public void populateRandomRange(int[][] a, int high, int low) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int rand = low + (int)(Math.random() * (high - low + 1));
				a[i][j] = rand;
			}
		}
	}
	
	// generateMatrix()
	public int[][] generateMatrix() {
		Scanner in = new Scanner(System.in);
		System.out.println();	
		System.out.print("Enter m for [mxm] matrix: ");
		int m = in.nextInt();
		
		System.out.println();
		int[][] out = new int[m][m];
		for (int i = 0; i < m; i++) {
			System.out.println();
			System.out.println("Entering data for row[" + (i + 1) + "]");
			for (int j = 0; j < m; j++) {
				System.out.print("Col[" + (j+1) + "]: ");
				int num = in.nextInt();
				out[i][j] = num;
			}
		}
		in.close();
		return out;
	}
	
	// 	matrixMul()
	public int[][] matrixMul(int[][] a, int[][] b) {        
        int aCols = a[0].length; 
        int bCols = b[0].length; // m result columns length
        
        int[][] out = new int[a.length][bCols];
        
        for(int i = 0; i < a.length; i++) {        
            for(int j = 0; j < bCols; j++) {     
                for(int k = 0; k < aCols; k++) { 
                    out[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return out;
    }
	
	// sumRow
	public int sumRow(int[][] a) {
		// Create Scanner
		Scanner in = new Scanner(System.in);
		int rowToSum, rowSum = 0;
		
		// Take Input
		do {
			// Try catch
			try {
				System.out.print("Which row would you like to sum?: ");
				rowToSum = in.nextInt() - 1;

				if (rowToSum > a.length || rowToSum < 0) System.out.println("Invalid row to sum!");
				else break;
			}
			
			catch (InputMismatchException ex) {
				System.out.println("Not a valid integer!!");
				in.next();
			}
		} while(true);		
		
		// Sum row
		for (int i = 0; i < a.length; i++) {
			rowSum += a[rowToSum][i];
		}
		in.close();
		return rowSum;
	}
	
	// sumCol
	public int sumCol(int[][] a) {
		// Create Scanner
		Scanner in = new Scanner(System.in);
		int colToSum, colSum = 0;
		
		// Take Input
		do {
			// Try catch
			try {
				System.out.print("Which column would you like to sum?: ");
				colToSum = in.nextInt() - 1;

				if (colToSum > a.length || colToSum < 0) System.out.println("Invalid row to sum!");
				else break;
			}
			
			catch (InputMismatchException ex) {
				System.out.println("Not a valid integer!!");
				in.next();
			}
		} while(true);		
		
		// Sum row
		for (int i = 0; i < a.length; i++) {
			colSum += a[i][colToSum];
		}
		in.close();
		return colSum;
	}
	
	// sumMatrix()
	public int sumMatrix(int[][] a) {
		int total = 0;
		for (int i = 0; i < a.length; i++) for (int j = 0; j < a.length; j++) total += a[i][j];
		return total;
	}
	
	/*
	 * Boolean Algebra Methods:
	 * 1. NOT()
	 * 2. AND()
	 * 3. OR()
	 * 4. XOR()
	 * 5. NAND()
	 * 6. NOR()
	 * 7. EQUAL()
	 * 8. NOTEQUAL()
	 */
	
	// NOT()
	public int[][] NOT(int[][] a) {
		int out[][] = new int[a.length][a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 0) out[i][j] = 1;
				else out[i][j] = 0;
			}
		}
		
		return out;
	}
	
	// AND()
	public int[][] AND(int[][] a, int[][] b) {
		int out[][] = new int[a.length][b.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 1 && b[i][j] == 1) out[i][j] = 1;
				else a[i][j] = 0;
			}
		}
		
		return out;
	}
	
	// OR()
	public int[][] OR(int[][] a, int[][] b) {
		int out[][] = new int[a.length][b.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 0 || b[i][j] == 0) out[i][j] = 0;
				else out[i][j] = 1;
			}
		}
		
		return out;
	}

	// XOR()
	public int[][] XOR(int[][] a, int[][] b) {
		int out[][] = new int[a.length][b.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i][j] == 0 && b[i][j] == 0) || (a[i][j] == 1 || b[i][j] == 1)) out[i][j] = 0;
				else out[i][j] = 1;
			}
		}
		
		return out;
	}
	
	// NAND()
	public int[][] NAND(int[][] a, int[][] b) {
		int out[][] = new int[a.length][b.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i][j] == 1 && b[i][j] == 1)) out[i][j] = 0;
				else out[i][j] = 1;
			}
		}
		
		return out;
	}
	
	// NOR()
	public int[][] NOR(int[][] a, int[][] b) {
		int out[][] = new int[a.length][b.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i][j] == 0 || b[i][j] == 0)) out[i][j] = 1;
				else out[i][j] = 0;
			}
		}
		
		return out;
	}
	
	// Boolean Operations Returning Booleans
	// EQUAL()
	public boolean EQUAL(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i][j] == b[i][j])) continue;
				else return false;
			}
		}
		return true;
	}
	
	// NOTEQUAL()
	public boolean NOTEQUAL(int[][] a, int[][] b) {		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i][j] != b[i][j])) return true;
			}
		}
		
		return false;
	}
}

