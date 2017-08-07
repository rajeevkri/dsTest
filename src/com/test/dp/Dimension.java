package com.test.dp;

//class representing dimensions of box
class Dimension implements Comparable<Dimension> {
	int height;
	int length;
	int width;

	Dimension(int height, int length, int width) {
		this.height = height;
		this.length = length;
		this.width = width;
	}

	Dimension() {
	}

	static Dimension createDimension(int height, int side1, int side2) {
		Dimension d = new Dimension();
		d.height = height;
		if (side1 >= side2) {
			d.length = side1;
			d.width = side2;
		} else {
			d.length = side2;
			d.width = side1;
		}
		return d;
	}

	/**
	 * Sorts by base area(length X width)
	 */
	@Override
	public int compareTo(Dimension d) {
		if (this.length * this.width >= d.length * d.width) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Dimension [height=" + height + ", length=" + length + ", width=" + width + "]";
	}
}
