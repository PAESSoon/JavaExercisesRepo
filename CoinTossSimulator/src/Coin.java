import java.util.Random;

public class Coin {
	
	private String sideUp;
	
	public Coin() {
		toss();
	}

	public void toss() {
		
		Random random = new Random(); 
		int randomInt = random.nextInt(2);
		
//		System.out.println(randomInt);
		
		if(randomInt == 0) {
			
			sideUp = "Head";
			
		} else {
			
			sideUp = "Tail";
			
		}
		
	}
	
	public String getSideUp() {
		
		return sideUp;
	}

}
