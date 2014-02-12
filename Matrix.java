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

	public Matrix gradientxMatrix() {
		Matrix gradx = new Matrix(1, 0, -1, 2, 0, -2, 1, 0, -1);
		return gradx;
	}

	public Matrix gradientyMatrix() {
		Matrix grady = new Matrix(1, 2, 1, 0, 0, 0, -1, -2, -1);
		return grady;
	}

	public Matrix blurMatrix() {
		Matrix blur = new Matrix(1, 1, 1, 1, 1, 1, 1, 1, 1);
		return blur;
	}

	public Matrix Pixel2Matrix0(PixImage image, int x, int y) {
		Matrix matrix = new Matrix();
		
	}

}