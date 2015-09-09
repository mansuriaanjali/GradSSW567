package ssw567.assignment1.src;

/**
 * Class that represents a Triangle.
 */
public class Triangle {

	private int sideA;
	private int sideB;
	private int sideC;

	public Triangle(int sideA, int sideB, int sideC)
			throws InvalidTriangleException {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		if (!hasValidSides()) {
			throw new InvalidTriangleException();
		}
	}

	/**
	 * Should have all different sides.
	 * @return True if Scalene triangle.
	 */
	public boolean IsScalene() {
		return sideA != sideB
				&& sideA != sideC
				&& sideB != sideC;
	}

	/**
	 * Should have at least 2 equal sides.
	 * @return True if Isosceles triangle.
	 */
	public boolean IsIsosceles() {
		return sideA == sideB
				|| sideA == sideC
				|| sideB == sideC;
	}

	/**
	 * Should have all equal sides.
	 * @return True if Equilateral triangle.
	 */
	public boolean IsEquilateral() {
		return sideA == sideB && sideB == sideC;
	}

	/**
	 * Should have one 90 degrees angle.
	 * @return True if Right triangle.
	 */
	public boolean IsRight() {
		// Using Pythagorean theorem, to all combinations.
		double powA = Math.pow(sideA, 2);
		double powB = Math.pow(sideB, 2);
		double powC = Math.pow(sideC, 2);
		return  powA + powB == powC
				|| powA + powC == powB
				|| powB + powC == powA;
	}

	/**
	 * The given values should form a valid triangle, which means no side can be
	 * greater then the sum of the other two sides.
	 * @return True if valid triangle.
	 */
	public boolean hasValidSides() {
		return sideA + sideB > sideC
				&& sideA + sideC > sideB
				&& sideB + sideC > sideA;
	}
}
