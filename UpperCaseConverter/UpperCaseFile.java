import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

		try {

			File fileInput = new File(fileRead);

			br = new BufferedReader(new FileReader(fileInput));
			
			FileWriter writer = new FileWriter(fileWrite, true);
			
			bw = new BufferedWriter(writer);

			String strInput;

			ArrayList<String> inputFromBuffer = new ArrayList<String>();

			int i = 0;

			while ((strInput = br.readLine()) != null) {

				inputFromBuffer.add(strInput);
				
				String userInput = inputFromBuffer.get(i);
				
//				System.out.println("Before conversion: " + i + " " + userInput);
				
				for (int j = 0; j < userInput.length(); j++) {
					
					
					
					if(userInput.charAt(j) != 'a' && userInput.charAt(j) != 'e' && userInput.charAt(j) != 'i' && userInput.charAt(j) != 'o' && userInput.charAt(j) != 'u') {
						userInput = userInput.replace(userInput.charAt(j), Character.toUpperCase(userInput.charAt(j)));
						
					}
				}

				bw.write(userInput + "\n");
				
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