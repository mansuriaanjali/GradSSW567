package ssw567.assignment1.test;

import org.junit.Assert;
import org.junit.Test;

import ssw567.assignment1.src.InvalidTriangleException;
import ssw567.assignment1.src.Triangle;

/**
 * Unit tests for the Triangle class.
 */
public class TriangleTest {

	@Test
	public void testIsEquilateral() {
		Triangle t = null;
		try {
			t = new Triangle(42, 42, 42);
		} catch (InvalidTriangleException e) {
			Assert.fail("Should not be invalid.");
		}
		Assert.assertTrue("Should be an Equilateral triangle.", t.IsEquilateral());
	}

	@Test
	public void testIsIsosceles() {
		Triangle t = null;
		try {
			t = new Triangle(42, 20, 42);
		} catch (InvalidTriangleException e) {
			Assert.fail("Should not be invalid.");
		}
		Assert.assertTrue("Should be an Isosceles triangle.", t.IsIsosceles());
	}

	@Test
	public void testIsScalene() {
		Triangle t = null;
		try {
			t = new Triangle(42, 24, 36);
		} catch (InvalidTriangleException e) {
			Assert.fail("Should not be invalid.");
		}
		Assert.assertTrue("Should be a Scalene triangle.", t.IsScalene());
	}

	@Test
	public void testIsRight() {
		Triangle t = null;
		try {
			t = new Triangle(3, 4, 5);
		} catch (InvalidTriangleException e) {
			Assert.fail("Should not be invalid.");
		}
		Assert.assertTrue("Should be a Right triangle.", t.IsRight());
	}

	@Test
	public void testIsValid() {
		boolean thrown = false;
		try {
			new Triangle(3, 4, 5);
		} catch (InvalidTriangleException e) {
			thrown = true;
		}
		Assert.assertFalse("Should be a valid triangle.", thrown);
	}

	@Test
	public void testIsInvalid() {
		boolean thrown = false;
		try {
			new Triangle(5, 5, 20);
		} catch (InvalidTriangleException e) {
			thrown = true;
		}
		Assert.assertTrue("Should NOT be a valid triangle.", thrown);
	}
}
