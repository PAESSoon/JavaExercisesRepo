
public class CoinTossTest {

	public static void main(String[] args) {
		
		Coin dollar = new Coin();
		
		System.out.println("Side facing up at Start: " + dollar.getSideUp());
		
		int headCount = 0, tailCount = 0;
		
		for (int i = 0; i < 20; i++) {
			
			dollar.toss();
			System.out.println("Side facing up: " + dollar.getSideUp());
			
			if(dollar.getSideUp().equals("Head")) {
				
				headCount++;
			} else {
				
				tailCount++;
			}
		}
		
		System.out.println("Head Count: " + headCount);
		System.out.println("Tail Count: " + tailCount);

	}

}
