import java.io.*;

class Bird {
	private String name;
	private int frequency;
	public static int maxFrequency = 1;

	// constructor
	public Bird(String a, int b) {

		name = a;
		frequency = b;

	}

	public String getName() {

		return name;
	}

	public int getFrequency() {

		return frequency;
	}

	public void setFrequency(int n) {

		frequency += n;

	}

}

public class TestSinglyList {

	// Time complexity is O(n^2) for the main method
	public static void main(String args[]) throws Exception {
		// Constructs a singly linked list instance
		SinglyLinkedList<Bird> birdsList = new SinglyLinkedList<>();
		// read the birds file
		File fileBirdsInput = new File("birds.txt");

		BufferedReader br = new BufferedReader(new FileReader(fileBirdsInput));

		String strInput;

		int count = 0;
		// check every single line in the file (O(n))
		while ((strInput = br.readLine()) != null) {

			// constructs a Bird instance
			Bird aBird = new Bird(strInput.trim(), 1);

			// add first bird to the linked list
			if (count == 0) {

				birdsList.addFirst(aBird);

				// add the remainder birds one by one to the linked list
			} else {

				birdsList.addElement(aBird);
			}

			count++;

		}

		birdsList.sortElements(Bird.maxFrequency);

		birdsList.printElements();

		// read the second file for the excluded birds

		File fileBirdsExclude = new File("birds2.txt");

		var brExclude = new BufferedReader(new FileReader(fileBirdsExclude));

		String strExclude;

		while ((strExclude = brExclude.readLine()) != null) {

			birdsList.removeElement(strExclude.trim());
		}

		System.out.println("\n*************After Exclusion*************\n");

		birdsList.printElements();

		br.close();
		brExclude.close();
	}

}
