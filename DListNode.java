/* DListNode.java */

/**
 *  The DListNode class represents a single node in a doubly linked
 *  list to be used in a RunLengthEncoding of an image.
 */

public class DListNode {

  /**
   *  pixel stores the RGB intensitiese of the current run.
   *  length represents the length of the current run.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   */
  private Pixel pixel;
  private int length;
  public DListNode prev;
  public DListNode next;

  /**
   *  @param pixel the RGB intensities of the current run.
   *  @param length the length of the current run.
   */
  public DListNode(Pixel pixel, int length) {
  	this.pixel = new Pixel(pixel);
  	this.length = length;
    prev = null;
    next = null;
  }

  /**
   *  @param length the length of the current run.
   */
  public DListNode(int length) {
  	this.pixel = new Pixel();
  	this.length = length;
    prev = null;
    next = null;
  }

  public short getRed() {
    return pixel.getRed();
  }

  public short getGreen() {
    return pixel.getGreen();
  }

  public short getBlue() {
    return pixel.getBlue();
  }

  public int getLength() {
    return length;
  }

  public void edit(Pixel pixel, int length) {
    this.pixel = pixel;
    this.length = length;
  }

  public void edit(int length) {
    this.length = length;
  }

  public void setPrev(DListNode prev) {
    this.prev = prev;
  }

  public void setNext(DListNode next) {
    this.next = next;
  }

  public String toString() {
    String runString = new String();
    runString += "(" + pixel.getRed();
    runString += "," + pixel.getGreen();
    runString += "," + pixel.getBlue() + ")";
    runString += "x" + length;
    return runString;
  }

  public boolean equals(DListNode that) {
    if (this.getRed() == that.getRed()) {
      if (this.getGreen() == that.getGreen()) {
        if (this.getBlue() == that.getBlue()) {
          return true;
        }
      }
    }
    return false;
  }

}