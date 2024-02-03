import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator{
	public static void main(String[] args){
		Scanner s =new Scanner(System.in);
		
		System.out.print("Enter the length of the password:");
		int length =s.nextInt();
		
		System.out.print("Include numbers? (true/false):");
		boolean includeNumbers=s.nextBoolean();
		
		System.out.print("Include lowercase letters ? (true/false) :");
		boolean includeLowerCase=s.nextBoolean();
		
		System.out.print("Include uppercase letters ? (true/false) :");
		boolean includeUpperCase =s.nextBoolean();
		
		System.out.print("Include special characters ? (true/false) :");
		boolean includeSpecialChars =s.nextBoolean();
		
		String password =generatePassword(length,includeNumbers,includeLowerCase,includeUpperCase,includeSpecialChars);
		System.out.println("Generated password :"+ password);
	}
	
	private static String generatePassword(int length,boolean includeNumbers,boolean includeLowerCase,boolean includeUpperCase,boolean includeSpecialChars){
		StringBuilder password =new StringBuilder();
		String lowercaseChars="abcdefghijklmnopqrstuvwxyz";
		String uppercaseChars="ABCDEFGHIJKLMNOPWRSTUVWXYZ";
		String numberChars="0123456789";
		String specialChars="!@#$%^&*()-_=+[]{}|;'\"<>,.?/";
		
		String validChars="";
		if(includeLowerCase) validChars +=lowercaseChars;
		if(includeUpperCase) validChars +=uppercaseChars;
		if(includeNumbers) validChars +=numberChars;
		if(includeSpecialChars)validChars +=specialChars;
		
		
		Random random =new Random();
		for(int i =0;i <length ;i++){
			int randomIndex =random.nextInt(validChars.length());
			password.append(validChars.charAt(randomIndex));
		}
		return password.toString();
	}
}