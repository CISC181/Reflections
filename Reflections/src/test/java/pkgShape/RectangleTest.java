package pkgShape;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class RectangleTest {

	@Test
	public void RectangleTest() {
		Rectangle rec = null;
		int iWidth = 20;
		int iLength = 10;
		double dActualArea = 0;
		double dExpectedArea = 200;
		
		try {
			Class<?> c = Class.forName("pkgShape.Rectangle");
			
			//	Get the private constructor
			Constructor con = c.getDeclaredConstructor(new Class[] { int.class, int.class });		
			// Make the Constructor so it can run
			con.setAccessible(true);
			//	Invoke the Constructor
			rec = (Rectangle) con.newInstance(iWidth, iLength);
			//	Get the 'area' method
			Method mArea = c.getDeclaredMethod("area", null);
			//	Make the method accessible for execution
			mArea.setAccessible(true);
			//	Invoke the method, return the result to variable
			dActualArea = (double)mArea.invoke(rec, null);
			//	Run assert
			assertEquals(dExpectedArea, dActualArea, 0.01);

		} catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			fail("NoSuchMethodException");
		} catch (SecurityException e) {

			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		}

	}

}
