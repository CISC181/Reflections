package pkgShape;

public class Rectangle {	
	private int iWidth;
	private int iLength;
	private Rectangle(int iWidth, int iLength) {
		super();
		this.iWidth = iWidth;
		this.iLength = iLength;
	}
	private double area()
	{
		return this.iLength * this.iWidth;
	}
}
