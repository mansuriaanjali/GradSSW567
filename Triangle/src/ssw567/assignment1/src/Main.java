package ssw567.assignment1.src;

import java.util.*;

public class Main {
	/**
	 * Simple main program that tests a Triangle.
	 * Accepts CLI input or standard input if no CLI arguments are found.
	 * @param args Should be 3 integers (triangle sides) to work properly.
	 */
	public static void main(String args[]) {
		int sideA = 3;
		int sideB = 4;
		int sideC = 5;
		if(args.length == 3) {
			try {
				sideA = Integer.parseInt(args[0]);
				sideB = Integer.parseInt(args[1]);
				sideC = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Should be 3 integers.");
				System.exit(1);
			}
		}
		else {
			System.out.println("Enter 3 integers.");
			try (Scanner scanner = new Scanner(System.in)) {
				sideA = scanner.nextInt();
				sideB = scanner.nextInt();
				sideC = scanner.nextInt();
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input. Should be 3 integers.");
				System.exit(1);
			}
		}

		Triangle triangle = null;
		try {
			triangle = new Triangle(sideA, sideB, sideC);
		} catch (InvalidTriangleException e) {
			System.out.println("The 3 integers can't compose a triangle.");
			System.exit(1);
		}

		System.out.println(triangle.IsEquilateral()
				? "Triangle is Equilateral." : "Triangle is not Equilateral.");
		System.out.println(triangle.IsIsosceles()
				? "Triangle is Isosceles." : "Triangle is not Isosceles.");
		System.out.println(triangle.IsScalene()
				? "Triangle is Scalene." : "Triangle is not Scalene.");
		System.out.println(triangle.IsRight()
				? "Triangle is Right." : "Triangle is not Right.");
	}
}
