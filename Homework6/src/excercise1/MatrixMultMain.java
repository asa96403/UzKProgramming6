package excercise1;
import java.util.Vector;

public class MatrixMultMain {
	public static void main(String[] args) {
		Vector<Vector<Integer>> matrix1;
		Vector<Vector<Integer>> matrix2;
		
	}
	
	/**
	 * Computes a matrix using Matrix Multiplication with the DotProduct Thread.
	 * The matrixes must be nxn matrixes (square) !
	 * Runtime probably O(n^3) (not the most efficient one)
	 * @param matrix1 the first Matrix to multiply nxn
	 * @param matrix2 the second Matrix to multiply nxn
	 * @return a Matrix (the Result of the matrix multiplication of matrix1 and matrix2
	 * @author aabert
	 */
	public static Vector<Vector<Integer>> matrixMult(Vector<Vector<Integer>> matrix1, Vector<Vector<Integer>> matrix2) {
		Vector<Vector<Integer>> result = new Vector<Vector<Integer>>();
		//Computing vertical Vectors and saving in a new Vector for that
		Vector<Vector<Integer>> verticalMatrix2 = new Vector<Vector<Integer>>();
		for(int i=0; i<matrix1.size(); i++) {
			Vector<Integer> vert = new Vector<Integer>();
			for(int j=0; j<matrix1.size(); j++) {
				vert.add(matrix2.get(j).get(i));
			}
			verticalMatrix2.add(vert);
		}
		//Multiplying the Matrixes using the DotProductThread
		for(int i=0; i<matrix1.size(); i++) {
			Vector<Integer> temp = new Vector<Integer>();
			for(int j=0; j<matrix1.get(0).size(); j++ ) {
				DotProductThread thread1 = new DotProductThread(matrix1.get(i), verticalMatrix2.get(j));
				
			}
		}
		return result;
	}
}
