/* Matrix.java */

/**
 *  The Matrix class represents a 3x3 matrix as an array of integers. It
 *  also provides matrices that can then be used in calculating the blur value 
 *  and gradients of a particular Pixel in PixImage. It also provides methods
 *  for converting/preparing each Pixel in PixImage for blurring and sobel
 *  edging.
 *  It provides a method for scalar multiplication of two matrices which is
 *  required for finding the blurred image and sobel edges.
 */

public class Matrix {

	/** 
	 * matrix array stores the elements of the Matrix.
	 */
	private int[][] matrix;

	public Matrix() {
		matrix =  new int[][] { { 0, 0, 0 },
														{ 0, 0, 0 },
														{ 0, 0, 0 } };
	}

	/**
	 * @param e## element (short) in the ## position of Matrix.
	 */
	public Matrix(short e00, short e01, short e02,
					short e10, short e11, short e12,
					short e20, short e21, short e22) {
		matrix =  new int[][] { { (int)e00, (int)e01, (int)e02 },
														{ (int)e10, (int)e11, (int)e12 },
														{ (int)e20, (int)e21, (int)e22 } };
	}

	/**
	 * @param e## element (int) in the ## position of Matrix.
	 */
	public Matrix(int e00, int e01, int e02,
					int e10, int e11, int e12,
					int e20, int e21, int e22) {
		matrix =  new int[][] { { e00, e01, e02 },
														{ e10, e11, e12 },
														{ e20, e21, e22 } };
	}

	/**
	 * @param array an (int) array of matrix elements.
	 */
	public Matrix(int[][] array) {
		matrix =  new int[][] { { array[0][0], array[0][1], array[0][2] },
														{ array[1][0], array[1][1], array[1][2] },
														{ array[2][0], array[2][1], array[2][2] } };
	}

	/**
	 * @param array an (short) array of matrix elements.
	 */
	public Matrix(short[][] array) {
		matrix =  new int[][] { { (int)array[0][0], (int)array[0][1], (int)array[0][2] },
														{ (int)array[1][0], (int)array[1][1], (int)array[1][2] },
														{ (int)array[2][0], (int)array[2][1], (int)array[2][2] } };
	}

	public void setxy(int x, int y, int value) {
		matrix[x][y] = value;
	}

	public static Matrix gradientxMatrix() {
		Matrix gradx = new Matrix(1, 0, -1, 2, 0, -2, 1, 0, -1);
		return gradx;
	}

	public static Matrix gradientyMatrix() {
		Matrix grady = new Matrix(1, 2, 1, 0, 0, 0, -1, -2, -1);
		return grady;
	}

	public static Matrix blurMatrix() {
		Matrix blur = new Matrix(1, 1, 1, 1, 1, 1, 1, 1, 1);
		return blur;
	}

	public static Matrix[] Pixel2Matrix0(PixImage object, int x, int y) {
		Matrix[] matrixArray = new Matrix[3];
		int posx, posy, width = object.getWidth(), height = object.getHeight();
		matrixArray[0] = new Matrix();
		matrixArray[1] = new Matrix();
		matrixArray[2] = new Matrix();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posx = x + i - 1;
				posy = y + j - 1;
				if ((posx >= 0 && posx < width) && (posy >= 0 && posy < height)) {
					matrixArray[0].matrix[i][j] = object.getRed(posx, posy);
					matrixArray[1].matrix[i][j] = object.getGreen(posx, posy);
					matrixArray[2].matrix[i][j] = object.getBlue(posx, posy);
				} else {
					matrixArray[0].matrix[i][j] = 0;
					matrixArray[1].matrix[i][j] = 0;
					matrixArray[2].matrix[i][j] = 0;
				}
			}
		}
		return matrixArray;
	}

	public static Matrix[] Pixel2MatrixReflect(PixImage object, int x, int y) {
		Matrix[] matrixArray = new Matrix[3];
		int posx, posy, width = object.getWidth(), height = object.getHeight();
		matrixArray[0] = new Matrix();
		matrixArray[1] = new Matrix();
		matrixArray[2] = new Matrix();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posx = abs(x + i - 1, width);
				posy = abs(y + j - 1, height);
				matrixArray[0].matrix[i][j] = object.getRed(posx, posy);
				matrixArray[1].matrix[i][j] = object.getGreen(posx, posy);
				matrixArray[2].matrix[i][j] = object.getBlue(posx, posy);
			}
		}
		return matrixArray;
	}

	public static int scalarMultiply(Matrix m1, Matrix m2) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += (m1.matrix[i][j] * m2.matrix[i][j]);
			}
		}
		return sum;
	}

	public static int abs(int x, int limit) {
		if (x < 0) {
			return (-x - 1);
		} else if (x >= limit) {
			return (limit - 1 - (x - limit));
		} else {
			return x;
		}
	}

}