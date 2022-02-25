//	function to check if the guessed complete word is correct
public class CheckCompleteWord {
	
	public static boolean getResult(char [] guess, char [] word) {
  	
	  	for (int i = 0; i < guess.length; i++) {
	  		
	  		if(guess[i] != word[i]) {
	  			
	  			return false;
	  			
	  		}
	  	}

	  	return true;
	   
	}
}

