package edu.nmsu.cs.circles;

/***
 * Example JUnit testing class for Circle1 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle1Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;

public class Circle1Test
{
	// Data you need for each test case
	private Circle1 circle1;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		circle1 = new Circle1(1, 2, 3);
	}

	//
	// Stuff you want to do after each test case
	//
	@After
	public void teardown()
	{
		System.out.println("\nTest finished.");
	}

	//
	// Test a simple positive move to the first quadrent
	//
	@Test
	public void simpleMoveQuad1()
	{
		Point p;
		System.out.println("Running test simpleMoveQuad1.");
		p = circle1.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
	}

	//
	// Test a simple move to the second quadrant
	//
	@Test
	public void simpleMoveQuad2()
	{
		Point p;
		System.out.println("Running test simpleMoveQuad2.");
		p = circle1.moveBy(-5, 3);
		Assert.assertEquals("x-value", -4, p.x,  0.00001);
		Assert.assertEquals("y-value", 5, p.y,  0.00001);
	}

	//
	// Test a simple negative move to the third quadrant
	//
	@Test
	public void simpleMoveQuad3()
	{
		Point p;
		System.out.println("Running test simpleMoveQuad3.");
		p = circle1.moveBy(-2, -1);
		Assert.assertTrue(p.x == -1 && p.y == 1);
	}

	
	//
	// Test a simple move to the fourth quadrant
	//
	@Test
	public void simpleMoveQuad4()
	{
		Point p;
		System.out.println("Running test simpleQuad4.");
		p = circle1.moveBy(5, -17);
		Assert.assertEquals("x-value", 6, p.x,  0.00001);
		Assert.assertEquals("y-value", -15, p.y,  0.00001);
	}


	//
	// Test scaling the size of a circle by positive factor
	//
	@Test
	public void posScale()
	{
		double radius;
		System.out.println("Running test posScale.");
		radius = circle1.scale(2.5);
		Assert.assertEquals(7.5, radius,  0.00001);
		
	}

	//
	// Test scaling the size of a circle by 0
	//
	@Test
	public void zeroScale()
	{
		double radius;
		System.out.println("Running test zeroScale.");
		radius = circle1.scale(0);
		Assert.assertEquals(Double.NaN, radius,  0.00001);
		
	}

	//
	// Test scaling the size of a circle by 0
	//
	@Test
	public void negScale()
	{
		double radius;
		System.out.println("Running test negScale.");
		radius = circle1.scale(-1);
		Assert.assertEquals(Double.NaN, radius,  0.00001);
		
	}

	//
	// Test if the circles are the same
	//
	@Test
	public void sameCircleIntersect()
	{
		System.out.println("Running test sameCircleIntersect.");
		boolean doesIntersect = circle1.intersects(circle1);
		//Assert.assertTrue(radius == 7.5);
		Assert.assertTrue(doesIntersect == true);
		
	}

	//
	// Test if the circles intersect at two points
	//
	@Test
	public void twoPointIntersect()
	{
		System.out.println("Running test twoPointIntersect.");
		Circle1 circle2 = new Circle1(7, 3, 5);
		boolean doesIntersect = circle1.intersects(circle2);
		Assert.assertTrue(doesIntersect == true);
		
	}

	//
	// Test if circles intersect at one point
	//
	@Test
	public void onePointIntersect()
	{
		System.out.println("Running test onePointIntersect.");
		Circle1 circle2 = new Circle1(0, 2, 2);
		Circle1 circle3 = new Circle1(0, -3, 3);
		boolean doesIntersect = circle2.intersects(circle3);
		Assert.assertTrue(doesIntersect == true);
	}

	//
	// Test if circles do not intersect 
	//
	@Test
	public void noIntersect()
	{
		System.out.println("Running test noIntersect.");
		Circle1 circle2 = new Circle1(-6, 0, 1);
		boolean doesIntersect = circle1.intersects(circle2);
		Assert.assertTrue(doesIntersect == false);
		
	}

	//
	//Test if one circle is contained within the other
	//
	@Test
	public void nestedIntersect()
	{
		System.out.println("Running test nestedIntersect.");
		Circle1 circle2 = new Circle1(2, 3.5, 1);
		boolean doesIntersect = circle1.intersects(circle2);
		Assert.assertTrue(doesIntersect == true);
		
	}

	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle1Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}
