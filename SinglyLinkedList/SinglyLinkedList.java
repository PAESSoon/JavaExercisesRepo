
public class SinglyLinkedList<E> {
	// ---------------- nested Node class ----------------

	/**
	 * Node of a singly linked list, which stores a reference to its element and
	 * to the subsequent node in the list (or null if this is the last node).
	 */

	private static class Node<E> {

		private E element; // reference to the element stored at this node

		private Node<E> next; // reference to the subsequent node in the list

		// Creates a node with the given element and next node.

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// Accessor methods

		// Returns the element stored at the node (O(1))

		public E getElement() {
			return element;
		}

		// Returns the node that follows this one (or null if no such node) (O(1))

		public Node<E> getNext() {
			return next;
		}

		// Modifier methods

		// Sets the node's next reference to point to Node n (O(1))

		public void setNext(Node<E> n) {

			next = n;
		}
	}
	// ----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList

	private Node<E> head = null; // head node of the list (or null if empty)

	private Node<E> tail = null; // last node of the list (or null if empty)

	private int size = 0; // number of nodes in the list

	public SinglyLinkedList() {

	} // constructs an initially empty list

	// access methods

	// Returns the number of elements in the linked list (O(1))

	public int size() {
		return size;
	}

	// Tests whether the linked list is empty (O(1))

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() { // returns (but does not remove) the first element (O(1)
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E last() { // returns (but does not remove) the last element (or null if empty) (O(1))
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	// update methods

	// Adds an element to the front of the list O(1)

	public void addFirst(E e) {

		head = new Node<>(e, head); // create and link a new node

		if (size == 0) {
			tail = head; // special case: new node becomes tail also
		}
		size++;
	}

	// Adds an element to the end of the list (O(1))

	public void addLast(E e) {

		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty()) {
			head = newest; // special case: previously empty list
		} else {
			tail.setNext(newest); // new node after existing tail
		}
		tail = newest; // new node becomes the tail
		size++;
	}

	// Removes and returns the first element of the list (O(1))

	public E removeFirst() { // removes and returns the first element
		if (isEmpty()) {
			return null; // nothing to remove
		}
		E answer = head.getElement();
		head = head.getNext(); // will become null if list had only one node
		size--;
		if (size == 0) {
			tail = null; // special case as list is now empty
		}
		return answer;
	}

	// Adds new element to the list or update the frequency of existing element
	// (O(n))

	public void addElement(E e) {

		String birdHead = ((Bird) (head.getElement())).getName().trim();

		if (birdHead.equals(((Bird) e).getName().trim())) { // Check if head element exists already

			((Bird) (head.getElement())).setFrequency(1); // Update frequency of head element as already exists in the
															// list

			if (((Bird) (head.getElement())).getFrequency() > Bird.maxFrequency) { // update maximum frequency

				Bird.maxFrequency = ((Bird) (head.getElement())).getFrequency();

			}

		} else {

			Node<E> newest = new Node<>(e, null);

			// if only 1 element in list and name is new
			if (head == tail) {
				tail.setNext(newest);
				tail = newest;
				size++;

			} else {

				Node<E> temp = head;
				int sizeCount = size;

				// iterate from head and check if element name exists in the list

				while (sizeCount > 0 && temp != tail) {

					E answer = temp.getElement();

					String answerString = ((Bird) answer).getName();

					if (answerString.equals(((Bird) e).getName().trim())) {

						((Bird) answer).setFrequency(1);

						if (((Bird) answer).getFrequency() > Bird.maxFrequency) {

							Bird.maxFrequency = ((Bird) answer).getFrequency();

						}
						break;
					}

					temp = temp.getNext();

					sizeCount--;

				}

				if (sizeCount == 0 || temp == tail) {

					String birdTail = ((Bird) (tail.getElement())).getName().trim();

					if (birdTail.equals(((Bird) e).getName().trim())) { // check if tail is same as new name

						((Bird) (tail.getElement())).setFrequency(1);

						if (((Bird) (tail.getElement())).getFrequency() > Bird.maxFrequency) {

							Bird.maxFrequency = ((Bird) (tail.getElement())).getFrequency();

						}

						// if element to add is new, it becomes tail

					} else {

						tail.setNext(newest);
						tail = newest;
						size++;

					}

				}
			}

		}

	}

	// Sort elements in the list by descending order (O(n^2))

	public void sortElements(int count) {

		try {
			int frequencyCount = count;

			// start by the biggest frequency and make it the tail
			while (frequencyCount > 0) {

				Node<E> current = head;
				Node<E> afterCurrent = current.next;

				// iterate from the head and check each node
				while (current.next != tail) {

					if (((Bird) (head.getElement())).getFrequency() == frequencyCount) { // if head matches the
																							// frequencyCount, make it
																							// the new tail

						Node<E> answer = head;
						head = head.getNext();
						tail.setNext(answer);
						tail = answer;

					} else if (((Bird) (afterCurrent.getElement())).getFrequency() == frequencyCount) { // if any
																										// element
																										// matches the
																										// frequencyCount,
																										// make it the
																										// tail

						Node<E> answer = afterCurrent;
						current.next = afterCurrent.next;
						tail.setNext(answer);
						tail = answer;
					}
					current = current.next;
					afterCurrent = current.next;
				}

				frequencyCount--;
			}
		} catch (Exception e) {
			System.out.println("Exception in sort");
		}
	}

	// print all the elements in the list starting by the head (O(n))

	public void printElements() {

		try {

			Node<E> current = head;
			E answer = current.getElement();

			while (current != tail) {

				answer = current.getElement();

				System.out.println("Name: " + ((Bird) answer).getName() + " ");
				System.out.println("Frequency: " + ((Bird) answer).getFrequency() + "\n");

				current = current.getNext();
			}
			System.out.println("Name: " + ((Bird) tail.getElement()).getName() + " ");
			System.out.println("Frequency: " + ((Bird) tail.getElement()).getFrequency());
		} catch (Exception e) {
			System.out.println("Exception in print");
		}
	}

	// remove a node from the list (O(n))

	public E removeElement(String name) {
		try {

			E answer = head.getElement();

			String birdHead = ((Bird) (answer)).getName().trim();

			// check head then remove and update head if its element is in the exclude list
			if (birdHead.equals(name.trim())) {

				answer = head.getElement();

				head = head.getNext();

				size--;

			} else {

				Node<E> current = head;
				Node<E> afterCurrent = current.getNext();
				// iterate through the list
				while (afterCurrent != tail) {

					answer = afterCurrent.getElement();

					String answerString = ((Bird) answer).getName().trim();
					// remove corresponding excluded node based on its element
					if (answerString.equals(name.trim())) {

						current.next = afterCurrent.next;

						size--;

						break;
					}

					current = current.next;

					afterCurrent = afterCurrent.next;
				}

				String birdTail = ((Bird) (tail.getElement())).getName().trim();

				// check tail then remove if its element is in the exclude list
				if (birdTail.equals(name.trim())) {

					answer = tail.getElement();

					tail = afterCurrent;

					tail.next = null;

					size--;
				}

			}

			return answer;
		} catch (Exception ex) {
			System.out.println("Exception in exclude/remove");
			E e = null;
			return (E) e;
		}
	}

}
