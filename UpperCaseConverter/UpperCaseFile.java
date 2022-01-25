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
    	BufferedWriter bw = null;
//    	FileWriter(String filename, boolean append);

		try {

			File fileInput = new File(fileRead);

			br = new BufferedReader(new FileReader(fileInput));
			
			FileWriter writer = new FileWriter(fileWrite, true);
			
			bw = new BufferedWriter(writer);

			String strInput;

			String[] inputFromBuffer = new String[5];

			int i = 0;

			while ((strInput = br.readLine()) != null) {

				inputFromBuffer[i] = strInput;

				
				String userInput = inputFromBuffer[i];
				
				for (int j = 0; j < userInput.length(); j++) {
					
					
					
					if(userInput.charAt(j) != 'a' && userInput.charAt(j) != 'e' && userInput.charAt(j) != 'i' && userInput.charAt(j) != 'o' && userInput.charAt(j) != 'u') {
						userInput = userInput.replace(userInput.charAt(j), Character.toUpperCase(userInput.charAt(j)));
//						System.out.println("userInput.charAt(j): " + userInput.charAt(j));
					}
				}

				bw.write(userInput + "\n");
				
				System.out.println("After conversion: " + i + " " + userInput);
				
				i++;
			}

			i = 0;
			
			bw.close();


		} catch (FileNotFoundException e) {

			System.out.println("FileNotFoundException");

		} catch (IOException e) {

			System.out.println("IOException");

		}
    }
   
}