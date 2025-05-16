package excercise1;
import java.util.Random;
import java.util.Vector;

public class MatrixMultMain {
	private static Vector<Vector<Integer>> matrix1 = new Vector<Vector<Integer>>();
	private static Vector<Vector<Integer>> matrix2 = new Vector<Vector<Integer>>();
	
	public static void main(String[] args) {
		initialize(3);
		System.out.println("--Matrix1--");
		displayMatrix(matrix1);
		System.out.println("--Matrix2--");
		displayMatrix(matrix2);
		System.out.println("--Result--");
		displayMatrix(matrixMult(matrix1, matrix2));
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
				thread1.start();
				try {
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				temp.add(thread1.getDot());
			}
			result.add(temp);
		}
		return result;
	}
	
	public static void initialize(int dimension) {
		Random random = new Random();
		for(int i=0; i<dimension; i++) {
			Vector<Integer> temp = new Vector<Integer>();
			for(int j=0; j<dimension; j++) {
				temp.add(random.nextInt(10));
			}
			matrix1.add(temp);
		}
		for(int i=0; i<dimension; i++) {
			Vector<Integer> temp = new Vector<Integer>();
			for(int j=0; j<dimension; j++) {
				temp.add(random.nextInt(10));
			}
			matrix2.add(temp);
		}
	}
	
	public static void displayMatrix(Vector<Vector<Integer>> matrix) {
		for(int i=0; i<matrix.size(); i++) {
			System.out.println(matrix.get(i).toString());
		}
	}
}
