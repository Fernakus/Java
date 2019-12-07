public interface BooleanInterface {
	// Matrix Methods
	public void populateIdentity(int[][] a); 
	public void print2D(int[][] a);
	public void populateRandom(int[][] a);
	public void populateRandomRange(int[][] a, int high, int low);
	public int[][] generateMatrix();
	public int[][] matrixMul(int[][] a, int[][] b);
	public int sumRow(int[][] a);
	public int sumCol(int[][] a);
	public int sumMatrix(int[][] a);
	
	// Boolean Operations
	public int[][] NOT(int[][] a);
	public int[][] AND(int[][] a, int[][] b);
	public int[][] OR(int[][] a, int[][] b);
	public int[][] XOR(int[][] a, int[][] b);
	public int[][] NAND(int[][] a, int[][] b);
	public int[][] NOR(int[][] a, int[][] b);
	public boolean EQUAL(int[][] a, int[][] b);
	public boolean NOTEQUAL(int[][] a, int[][] b);
}
