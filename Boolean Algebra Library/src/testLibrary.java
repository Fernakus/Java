import java.util.*;

public class testLibrary {
	private static BooleanFunctions obj = new BooleanFunctions();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter in the [row x col] size for the square matrix: ");
		int size = in.nextInt();
		int[][] i = new int[size][size];
		int[][] b = new int[size][size];
		
		System.out.println();
		System.out.println("Identity Matrix[I]:");
		obj.populateIdentity(i);
		obj.print2D(i);
		
		System.out.println();
		System.out.println("Random Matrix[R]:");
		obj.populateRandom(b);
		obj.print2D(b);
		
		System.out.println();
		System.out.println("NOT [I]:");
		int[][] not = obj.NOT(i);
		obj.print2D(not);
		
		System.out.println();
		System.out.println("NOT [R]:");
		not = obj.NOT(b);
		obj.print2D(not);
		
		System.out.println();
		System.out.println("[I] AND [R]:");
		int[][] and = obj.AND(i, b);
		obj.print2D(and);
		
		System.out.println();
		System.out.println("[I] OR [R]: ");
		int[][] or = obj.OR(i, b);
		obj.print2D(or);
		
		System.out.println();
		System.out.println("[I] XOR [R]: ");
		int[][] xor = obj.XOR(i, b);
		obj.print2D(xor);
		
		System.out.println();
		System.out.println("[I] NAND [R]: ");
		int[][] nand = obj.NAND(i, b);
		obj.print2D(nand);
		
		System.out.println();
		System.out.println("[I] NOR [R]: ");
		int[][] nor = obj.NOR(i, b);
		obj.print2D(nor);
		
		System.out.println();
		int[][] c = obj.generateMatrix();
		System.out.println();
		System.out.println("Generated Matrix: ");
		obj.print2D(c);
		
		System.out.println();
		System.out.println("(([R] OR [R]) AND ([I] OR [I])): ");
		or = obj.OR(b, b);
		int[][] or1 = obj.OR(i, i);
		and = obj.AND(or, or1);
		obj.print2D(and);
		
		System.out.println();
		System.out.println("Random Matrix[Mr]:");
		obj.populateRandom(b);
		obj.print2D(b);
		
		System.out.println();
		System.out.println("[Mr] EQUAL [Mr]");
		boolean result = obj.EQUAL(b, b);
		System.out.println("EQUAL: " + result);
		
		System.out.println();
		System.out.println("[Mr] NOTEQUAL [I]:");
		result = obj.NOTEQUAL(b, i);
		System.out.println("NOTEQUAL: " + result);
		
		System.out.println();
		System.out.println("[Mr] NOTEQUAL [Mr]:");
		result = obj.NOTEQUAL(b, b);
		System.out.println("NOTEQUAL: " + result);
		
	
		System.out.println();
		System.out.println("[I] X [I]: ");
		obj.populateIdentity(i);
		int[][] ixi = obj.matrixMul(i, i);
		obj.print2D(ixi);
		in.close();
		
		
		int[][] durer = obj.durersMatrix;
		System.out.println("Row Sum --> " + obj.sumRow(durer));
		System.out.println("Col Sum --> " + obj.sumCol(durer));
		System.out.println("Matrix Sum --> " + obj.sumMatrix(durer));
	}
}

