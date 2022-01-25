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

			String characterName = inputFromBuffer[0];

			// constructs a Character instance
			System.out.println(characterName);

			i = 0;

		} catch (FileNotFoundException e) {

			System.out.println("FileNotFoundException");

		} catch (IOException e) {

			System.out.println("IOException");

		}
    }
   
}