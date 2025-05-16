package excercise1;

import java.util.Vector;

/**
 * NOTE: changed type of v1 and v2 to Vector as using a thread for
 * just calculating the product of two ints would not make sense nor correspond to the name of the class
 * @author aabert
 */
public class DotProductThread extends Thread {
	private int dot;
	private Vector<Integer> v1, v2;

	public DotProductThread(Vector<Integer> v1, Vector<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		dot=0;
	}
	
	@Override
	public void run() {
		for(int i=0; i<v1.size(); i++) {
			dot += (v1.get(i)*v2.get(i));
		}
	}

	//GETTERS AND SETTERS
	public int getDot() {
		return dot;
	}

	public void setDot(int dot) {
		this.dot = dot;
	}

	public Vector<Integer> getV1() {
		return v1;
	}

	public void setV1(Vector<Integer> v1) {
		this.v1 = v1;
	}

	public Vector<Integer> getV2() {
		return v2;
	}

	public void setV2(Vector<Integer> v2) {
		this.v2 = v2;
	}
}
