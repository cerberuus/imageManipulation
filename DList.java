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
		head = new DListNode(-1);
		head.next = head;
		head.prev = head;
		size = 0;
	}

	public DList(int length) {
		this();
		Pixel pixel = new Pixel();
		this.insertBack(pixel, length);
	}

	public int getSize() {
		return size;
	}

	public void insertBack(Pixel pixel, int length) {
		head.prev.next = new DListNode(pixel, length);
		head.prev.next.prev = head.prev;
		head.prev = head.prev.next;
		head.prev.next = head;
		size++;
	}

	public void insertFront(Pixel pixel, int length) {
		head.next.prev = new DListNode(pixel, length);
		head.next.prev.next = head.next;
		head.next = head.next.prev;
		head.next.prev = head;
		size++;
	}

	public void insertBefore(RunIterator iterator, Pixel pixel, int length) {
		DListNode node = iterator.currNode();
		node.prev.next = new DListNode(pixel, length);
		node.prev.next.prev = node.prev;
		node.prev = node.prev.next;
		node.prev.next = node;
		size++;
	}

	public void insertAfter(RunIterator iterator, Pixel pixel, int length) {
		DListNode node = iterator.currNode();
		node.next.prev = new DListNode(pixel, length);
		node.next.prev.next = node.next;
		node.next = node.next.prev;
		node.next.prev = node;
		size++;
	}

	private void remove(DListNode node) {
		DListNode next = node.next;
		next.prev = node.prev;
		node.prev.next = next;
		size --;
	}

	public void editCurrentNode(RunIterator iterator, int length) {
		DListNode currNode = iterator.currNode();
		currNode.edit(length);
	}

	public DListNode getHead() {
		return head;
	}

	public void clean() {
		for (DListNode node = head.next; node.getLength() != -1; node = node.next) {
			if (node.getLength() == 0) {
				remove(node);
			}
		}
		DListNode current = head.next;		
		for (DListNode next = current.next; next.getLength() != -1; next = next.next) {
			if (current.equals(next)) {
				current.edit(current.getLength() + next.getLength());
				remove(next);
			} else {
				current = next;
			}
		}
	}

}