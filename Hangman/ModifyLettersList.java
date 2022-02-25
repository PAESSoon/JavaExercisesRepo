//	function to hide the guessed letters in the alphabetical pool
public class ModifyLettersList {
	public static char[] getLettersList(char [] listOfLetters, char letter) {
	  	
	  	for (int i = 0; i < listOfLetters.length; i++) {
	  		
	  		if(listOfLetters[i] == letter) {
	  			
	  			listOfLetters[i] = '*';
	  			
	  		}
	  	}
	  	
	  	return listOfLetters;
	   
	}
}
