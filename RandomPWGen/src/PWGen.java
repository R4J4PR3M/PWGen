import java.util.Random;
import java.util.Scanner;
public class PWGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean runProgram = true;
		
		while (runProgram == true){
		boolean special = true;
		boolean numbers= true;
		
		Scanner userKeyboard = new Scanner(System.in);
		System.out.print("Please enter the amount of characters you want\t \t");
		int limit = userKeyboard.nextInt();
		int limitMod = 0;
		
		System.out.print("Do you want numbers?\t \t \t \t \t");
		String userResponse= userKeyboard.nextLine();
		userResponse= userKeyboard.nextLine();
		
		
		if (userResponse.substring(0 , 1).equalsIgnoreCase("y")){
			numbers = true;
		} else {
			numbers = false;
		}
		
		
		System.out.print("Do you want special characters?\t \t \t \t" );
		userResponse= userKeyboard.nextLine();
		
		
		if (userResponse.substring(0 , 1).equalsIgnoreCase("y")){
			special = true;
		} else {
			special = false;
		}
		
		if (numbers == true && special == false){
			
			limitMod= limit%3;
			limit/=3;
		} else if (numbers==false && special==false) {
			
			limitMod= limit%4;
			limit/=4;
		} else if (numbers==true && special == true){
			
			limitMod=limit%4;
			limit/=4;
		} else if (numbers==false && special == true){
			
			limitMod=limit%3;
			limit/=3;
		}
		 
		
		String password="";
		String specialCharacters= "!@#$%&*?/";
		Random rand = new Random();
		
		String abcU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String abcL = "abcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < limit; i++){
			int alphabetVariable = rand.nextInt(26);
			int spclChar = rand.nextInt(specialCharacters.length());
			
			if (numbers == true && special == false){
				
				password+=rand.nextInt(9);
				password+=abcU.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcL.charAt(alphabetVariable);
				
			} else if (numbers==false && special==false) {
				
				password+=abcU.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcL.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcL.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcU.charAt(alphabetVariable);
				
			} else if (numbers==true && special == true){
				
				password+=rand.nextInt(9);
				password+=abcU.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcL.charAt(alphabetVariable);
				spclChar= rand.nextInt(specialCharacters.length());
				password+=specialCharacters.charAt(spclChar);
			} else if (numbers==false && special == true){
				
				password+=abcU.charAt(alphabetVariable);
				alphabetVariable = rand.nextInt(26);
				password+=abcL.charAt(alphabetVariable);
				spclChar= rand.nextInt(specialCharacters.length());
				password+=specialCharacters.charAt(spclChar);
			}
			
		}
		
		for (int i = 0; i<limitMod;i++){
			int alphabetVariable = rand.nextInt(26);
			password+=abcU.charAt(alphabetVariable);
		}
		
		System.out.println("Generated Password: \t \t \t \t \t" + password);
		System.out.println("We recommend changing passwords every 3-6 months.");

		System.out.print("Would you like to generate another password? \t \t");
		userResponse = userKeyboard.nextLine();
		
		if (userResponse.substring(0 , 1).equalsIgnoreCase("y")){
			runProgram = true;
		} else {
			System.exit(0);
		}
		
	}
	}

}
