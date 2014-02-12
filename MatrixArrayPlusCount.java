public class MatrixArrayPlusCount {

	private Matrix[] matrixArray;
	private int count;

	public MatrixArrayPlusCount() {
		this.matrixArray = new Matrix[3];
		this.matrixArray[0] = new Matrix();
		this.matrixArray[1] = new Matrix();
		this.matrixArray[2] = new Matrix();
		this.count = 0;
	}

	public MatrixArrayPlusCount(Matrix[] matrixArray, int count) {
		this.matrixArray = matrixArray;
		this.count = count;
	}

	public MatrixArrayPlusCount(Matrix[] matrixArray) {
		this.matrixArray = matrixArray;
		this.count = 0;
	}

	public Matrix getMatrix(int index) {
		return this.matrixArray[index];
	}

	public int getCount() {
		return this.count;
	}

	public static MatrixArrayPlusCount Pixel2MatrixCount0(PixImage object, int x, int y) {
		MatrixArrayPlusCount matrixArrayPlusCount = new MatrixArrayPlusCount();
		int posx, posy, width = object.getWidth(), height = object.getHeight();
		// Red Component
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posx = x + i - 1;
				posy = y + j - 1;
				if ((posx >= 0 && posx < width) && (posy >= 0 && posy < height)) {
					matrixArrayPlusCount.matrixArray[0].setxy(i, j, object.getRed(posx, posy));
					matrixArrayPlusCount.matrixArray[1].setxy(i, j, object.getGreen(posx, posy));
					matrixArrayPlusCount.matrixArray[2].setxy(i, j, object.getBlue(posx, posy));
					matrixArrayPlusCount.count ++;
				} else {
					matrixArrayPlusCount.matrixArray[0].setxy(i, j, 0);
					matrixArrayPlusCount.matrixArray[1].setxy(i, j, 0);
					matrixArrayPlusCount.matrixArray[2].setxy(i, j, 0);
				}
			}
		} /*
		// Green Component
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posx = x + i - 1;
				posy = y + j - 1;
				if ((posx >= 0 && posx < width) && (posy >= 0 && posy < height)) {
					matrixArrayPlusCount.matrixArray[1].setxy(i, j, object.getGreen(posx, posy));
				} else {
					matrixArrayPlusCount.matrixArray[1].setxy(i, j, 0);
				}
			}
		}
		// Blue Component
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posx = x + i - 1;
				posy = y + j - 1;
				if ((posx >= 0 && posx < width) && (posy >= 0 && posy < height)) {
					matrixArrayPlusCount.matrixArray[2].setxy(i, j, object.getBlue(posx, posy));
				} else {
					matrixArrayPlusCount.matrixArray[1].setxy(i, j, 0);
				}
			}
		} */
		return matrixArrayPlusCount;
	}

}