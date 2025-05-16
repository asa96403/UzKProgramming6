package ex2;

/**
 * Fixed all mistakes in this class, passes JUnit tests.
 * comments do not apply anymore!
 * @author aabert
 */
public class FractionCorrected {
	private int zaehler;
	private int nenner;

	// incomplete
	public FractionCorrected(int zaehler, int nenner) {
		this.zaehler = zaehler;
		if(nenner==0) {
			throw new ArithmeticException("You cannot divide by 0!");
		} else {
			this.nenner = nenner;
		}
	}

	// wrong
	public void Kehrwert() {
		int nennerAlt= this.nenner;
		this.setNenner(this.zaehler);
		this.setZaehler(nennerAlt);
	}

	// wrong
	public void multiplikation(FractionCorrected a) {
		this.setNenner(this.nenner * a.getNenner());
		this.setZaehler(this.zaehler * a.getZaehler());
	}

	// wrong
	public void addition(FractionCorrected a) {
		if (a.getNenner() != this.getNenner()) {
			int neuerZaehler;
			this.setZaehler(this.getZaehler() * a.getNenner());
			neuerZaehler = a.getZaehler() * this.getNenner();
			this.setZaehler(this.getZaehler() + neuerZaehler);
			this.setNenner(this.getNenner() * a.getNenner());
		} else {
			this.setZaehler(this.getZaehler() + a.getZaehler());
		}
		kuerzen();
	}

	// wrong
	public void kuerzen() {
		int ggt = ggt(Math.abs(zaehler), Math.abs(nenner));
		this.zaehler /= ggt;
		this.nenner /= ggt;
	}

	// helper method Euklidian algorithm ,
	// here are no mistakes
	private int ggt(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	@Override
	public String toString() {
		return this.getZaehler() + "/" + this.getNenner();
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		if(nenner==0) {
			throw new ArithmeticException("You cannot divide by 0!");
		} else {
			this.nenner = nenner;
		}
	}
}
