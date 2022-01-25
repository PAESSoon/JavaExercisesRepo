import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpperCaseFile {
	private static String fileRead;
	private static String fileWrite;

    public static void main(String[] args) {
    	
    	UpperCaseFile result = new UpperCaseFile("upperCase.txt", "lowerCase.txt");
    	convertToUpperCase();
    	
    }
    
    
    public UpperCaseFile(String fileR, String fileW) {
    	
    	this.fileRead = fileR;
    	this.fileWrite = fileW;
    }
    
    public static void convertToUpperCase() {
    	
    	BufferedReader br = null;

		try {

			File fileInput = new File(fileRead);

			br = new BufferedReader(new FileReader(fileInput));

			String strInput;

			String[] inputFromBuffer = new String[4];

			int i = 0;

			while ((strInput = br.readLine()) != null) {

				inputFromBuffer[i] = strInput;

				i++;
			}

			String userInput = inputFromBuffer[0];

			// constructs a Character instance
			System.out.println("Before conversion: " + userInput);

			i = 0;
			
			for (int j = 0; j < userInput.length(); j++) {
				
				
				
				if(userInput.charAt(j) != 'a' && userInput.charAt(j) != 'e' && userInput.charAt(j) != 'i' && userInput.charAt(j) != 'o' && userInput.charAt(j) != 'u') {
					userInput = userInput.replace(userInput.charAt(j), Character.toUpperCase(userInput.charAt(j)));
					System.out.println("userInput.charAt(j): " + userInput.charAt(j));
				}
			}
			
			System.out.println("After conversion: " + userInput);

		} catch (FileNotFoundException e) {

			System.out.println("FileNotFoundException");

		} catch (IOException e) {

			System.out.println("IOException");

		}
    }
   
}