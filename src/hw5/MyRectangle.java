package hw5;

public class MyRectangle {
	double width;
	double depth;

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	double getArea() {
		double result=width*depth;
		System.out.println(result);
		return result;
	}

	public MyRectangle() {
	};

	public MyRectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	};
}
