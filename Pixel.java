/* Pixel.java */

/**
 *  This Pixel class represents a single pixel in an image. It is an
 *  array of three ints where the first, second and third integer 
 *  store the Red, Green and Blue value respectively.
 */

public class Pixel {

  private short red;
  private short green;
  private short blue;
  // private short[] color = new short[3];


  public Pixel(short red, short green, short blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public Pixel(Pixel original) {
    this.red = original.red;
    this.green = original.green;
    this.blue = original.blue;
  }

  public Pixel() {
    this.red = 0;
    this.green = 0;
    this.blue = 0;        
  }

  public short getRed() {
      return red;
  }

  public short getGreen() {
    return green;
  }

  public short getBlue() {
    return blue;
  }

  public String toString() {
    String str = new String();
    str += "[R:" + String.valueOf(red) + ",";
    str += " G:" + String.valueOf(green) + ",";
    str += " B:" + String.valueOf(blue) + "]\n";
    return str;
  }

  public void setRed(short red) {
    this.red = red;
  }

  public void setGreen(short green) {
    this.green = green;
  }

  public void setBlue(short blue) {
    this.blue = blue;
  }

  public boolean equals(Pixel other) {
    if (red == other.red) {
      if (green == other.green) {
        if (blue == other.blue) {
          return true;
        }
      }
    }
    return false;
  }

  public void averagePixel(Pixel[] pixelArray, int length) {
      int average = 0, counter;
      Pixel pixel = new Pixel();
      // Get red color
      for (counter = 0, average = 0; counter < length; counter++) {
          average += pixelArray[counter].getRed();
      }
      average /= length;
      this.setRed((short) average);
      // Get green color
      for (counter = 0, average = 0; counter < length; counter++) {
          average += pixelArray[counter].getGreen();
      }
      average /= length;
      this.setGreen((short) average);
      // Get blue color
      for (counter = 0, average = 0; counter < length; counter++) {
          average += pixelArray[counter].getBlue();
      }
      average /= length;
      this.setBlue((short) average);
  }


}
