/* DList.java */

/**
 * DList is a representation of a Doubly Linked List. It is made up of
 * nodes of the DListNode class.
 * It has a sentinel node to add new nodes to the list.
*/

public class DList {

	private DListNode head;
  private int size;

	public DList() {
		head = new DListNode(0);
		head.next = head;
		head.prev = head;
		size = 0;
	}

	public DList(int length) {
		this();
		Pixel pixel = new Pixel();
		this.insertBack(pixel, length);
	}

	int getSize() {
		return size;
	}

	void insertBack(Pixel pixel, int length) {
		head.prev.next = new DListNode(pixel, length);
		head.prev.next.prev = head.prev;
		head.prev = head.prev.next;
		head.prev.next = head;
		size++;
	}

	void insertFront(Pixel pixel, int length) {
		head.next.prev = new DListNode(pixel, length);
		head.next.prev.next = head.next;
		head.next = head.next.prev;
		head.next.prev = head;
		size++;
	}

	DListNode getHead() {
		return head;
	}


}