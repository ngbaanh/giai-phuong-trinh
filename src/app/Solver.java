package app;

import java.util.Vector;

public class Solver {
	private Vector<Double> terms;
	private Vector<Double> root;
	private boolean isInfinite; // Vo so nghiem
	private boolean isConsistent; // Co nghiem
	private boolean isInconsistent; // Vo nghiem
	
	
	public Solver(Vector<Double> terms, EquationType forEquationType) {
		this.terms = terms;
		switch (forEquationType) {
		case LINEAR_EQUATION:
			this.solveAsLinearEquation();
			break;			
		case POLYNOMIAL_EQUATION:
			this.solveAsPolynomialEquation();
			break;
		}
	}
	
	
	private void setStates(boolean isInfinite, boolean isConsistent, boolean isInconsistent) {
		this.isInfinite = isInfinite;
		this.isConsistent = isConsistent;
		this.isInconsistent = isInconsistent;
	}

	private void solveAsLinearEquation() {
		double a = terms.get(0), b = terms.get(1);
		if (a == 0) {
			if (b != 0) {
				this.setStates(false, false, true); // Vo nghiem
			} else {
				this.setStates(true, true, false); // Vo so nghiem
			}
		} else {
			double x = -b / a;
			root = new Vector<Double>();
			root.add(x);
			this.setStates(false, true, false); // Co nghiem
		}
	}
	

	private void solveAsPolynomialEquation() {
		double a = terms.get(0);
		if (a == 0) {
			terms.remove(0);
			this.solveAsLinearEquation();
		} else {
			double b = terms.get(1), c = terms.get(2), delta = b * b - 4 * a * c;
			this.setStates(false, true, false); // Co nghiem
			if (delta > 0) {
				root = new Vector<Double>();
				double x1 = (- b - Math.sqrt(delta)) / 2 / a;
				double x2 = (- b + Math.sqrt(delta)) / 2 / a;
				root.add(x1);
				root.add(x2);
			} else if (delta == 0) {
				root = new Vector<Double>();
				double x = - b / 2 / a;
				root.add(x);
			} else {
				this.setStates(false, false, true); // Vo nghiem
			}
		}
	}
	
	public Vector<Double> getTerms() {
		return terms;
	}

	public void setTerms(Vector<Double> terms) {
		this.terms = terms;
	}

	public Vector<Double> getRoot() {
		return root;
	}

	public void setRoot(Vector<Double> root) {
		this.root = root;
	}
	

	public boolean isInfinite() {
		return isInfinite;
	}


	public void setInfinite(boolean isInfinite) {
		this.isInfinite = isInfinite;
	}


	public boolean isConsistent() {
		return isConsistent;
	}


	public void setConsistent(boolean isConsistent) {
		this.isConsistent = isConsistent;
	}


	public boolean isInconsistent() {
		return isInconsistent;
	}


	public void setInconsistent(boolean isInconsistent) {
		this.isInconsistent = isInconsistent;
	}


	/**
	 * Phương thức tĩnh kiểm tra các chuỗi nhập vào có phù hợp làm nghiệm hay không.
	 * @param terms
	 * @return
	 */
	public static boolean validateTerms(EquationType forEquationType, String... terms) {
		boolean isRightType = false;
		if (forEquationType == EquationType.LINEAR_EQUATION) {
			isRightType = terms.length == 2;
		} else if (forEquationType == EquationType.POLYNOMIAL_EQUATION) {
			isRightType = terms.length == 3;
		}		
		if (isRightType) {
			@SuppressWarnings("unused")
			Double doubleNumber;
			for (String t : terms) {
				try {
					doubleNumber = Double.parseDouble(t);
				} catch (NumberFormatException e) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
}
