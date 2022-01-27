
/* 
a) This problem has 1 input: the number of coupons the user has won.

b) Number of required output is 3
    1 - the Welcome message.
    2 - The question asking how many coupons the user has.
    3 - The result (Number of candies/free games and remaining coupons the user will get).
    
c)  - Find number of candies by dividing number of coupons input by 5
    - Find remaining number of coupons using Modulo
    - Find number of free games by dividing remaining number of coupons by 3
    - Find remaining number of coupons left by using Modulo
    
d) User has 16 coupons
	    - number of candies: 16 / 5 = 3
	    - Remaining coupons: 16 % 5 = 1
	    - number of free games: 1 / 3 = 0
	    - Coupons left: 1 % 3 = 1

	User has 2 coupons
	    - number of candies: 2 / 5 = 0
	    - Remaining coupons: 2 % 5 = 2
	    - number of free games: 2 / 3 = 0
	    - Coupons left: 2 % 3 = 2

*/

import java.util.Scanner;

public class CouponRedeemer {
	public static void main(String[] args) {
		
//		Print welcome message
        System.out.println("Welcome to Pamela's Coupon Redeemer!\n");

		Scanner input = new Scanner(System.in);
		
//		Ask user for number of coupons that they won		
		System.out.print("How many coupons do you have to redeem? ");
		
		int couponsTotal = input.nextInt();
		
//		Find number of candies that can be redeemed		
        int numberOfCandies = couponsTotal / 5;
        
//      Find number of coupons left
        int remainderCoupons = couponsTotal % 5;
        
//		Find number free games that can be redeemed
        int numberOfFreeGames = remainderCoupons / 3;
        
//      Find how many coupons left in the end
        int numberOfCouponsLeft = remainderCoupons % 3;
        
//      Print the result
        System.out.println("\nWith your winnings, you can have " + numberOfCandies + " Candy Bar(s) and " + numberOfFreeGames + " free game(s) and still have " + numberOfCouponsLeft + " coupon(s) left.\n\nHope you enjoy your treats!");
        
        input.close();
	}
}