package excercise1;
import java.util.Random;
import java.util.Vector;

public class MatrixMultMain {
	private static Vector<Vector<Integer>> matrix1 = new Vector<Vector<Integer>>();
	private static Vector<Vector<Integer>> matrix2 = new Vector<Vector<Integer>>();
	
	public static void main(String[] args) {
		initialize(3, 10);
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
			for(int j=0; j<matrix1.get(0).size(); j += 2 ) {
				DotProductThread thread1;
				DotProductThread thread2 = null;
				thread1 = new DotProductThread(matrix1.get(i), verticalMatrix2.get(j));
				if((j+1)<matrix1.get(0).size()) {
					thread2 = new DotProductThread(matrix1.get(i), verticalMatrix2.get(j));
				}
				thread1.start();
				if(thread2!=null) thread2.start();
				try {
					thread1.join();
					if(thread2!=null) thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				temp.add(thread1.getDot());
				if(thread2!=null) temp.add(thread2.getDot());
			}
			result.add(temp);
		}
		return result;
	}
	
	/**
	 * initializes matrix1 and matrix2 with random numbers within the specified bounds (exklusive) and the dimension dimension x dimension
	 * @param dimension specifies the dimension of the square matrixes
	 * @param bound the upper bound for the random numbers to be generated
	 * @author aabert
	 */
	public static void initialize(int dimension, int bound) {
		Random random = new Random();
		for(int i=0; i<dimension; i++) {
			Vector<Integer> temp = new Vector<Integer>();
			for(int j=0; j<dimension; j++) {
				temp.add(random.nextInt(bound));
			}
			matrix1.add(temp);
		}
		for(int i=0; i<dimension; i++) {
			Vector<Integer> temp = new Vector<Integer>();
			for(int j=0; j<dimension; j++) {
				temp.add(random.nextInt(bound));
			}
			matrix2.add(temp);
		}
	}
	
	/**
	 * displays the matrix in the console by displaying every row vector using the toString method below each other
	 * @param matrix the matrix to display in the console
	 * @author aabert
	 */
	public static void displayMatrix(Vector<Vector<Integer>> matrix) {
		for(int i=0; i<matrix.size(); i++) {
			System.out.println(matrix.get(i).toString());
		}
	}
}
