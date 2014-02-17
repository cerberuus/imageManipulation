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

  /**
   *  @param pixel the RGB intensities of the current run.
   *  @param length the length of the current run.
   */
  public DListNode(Pixel pixel, int length) {
  	this.pixel = new Pixel(pixel);
  	this.length = length;
  }

  /**
   *  @param length the length of the current run.
   */
  public DListNode(int length) {
  	this.pixel = new Pixel();
  	this.length = length;
  }

}