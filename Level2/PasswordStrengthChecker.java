import java.util.Scanner;

public class PasswordStrengthChecker{
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter your password:");
		String password =scanner.nextLine();
		
		int length =password.length();
		boolean hasUpperCase= !password.equals(password.toLowerCase());
		boolean hasLowerCase =!password.equals(password.toUpperCase());
		boolean hasDigit =password.matches(".*\\d.*");
		boolean hasSpecialChar =!password.matches("[A-Za-z0-9]*");
		
		int strengthScore =0 ;
		
		if (length >=8){
			strengthScore++;
		}
		
		if (hasUpperCase){
			strengthScore++;
		}
		if (hasLowerCase){
			strengthScore++;
		}
		
		if(hasDigit){
			strengthScore++;
		}
		
		if(hasSpecialChar){
		strengthScore++;
		}
		
		String strengthDescription;
		
		switch (strengthScore){
			case 0:
			case 1:
				strengthDescription="Very Weak";
				break;
			case 2:
				strengthDescription ="Weak";
				break;
			case 3:
				strengthDescription ="Moderate";
				break;
			case 4:
				strengthDescription ="Strong";
				break;
			case 5 :
				strengthDescription ="Very Strong";
				break ;
			default:
				strengthDescription="unknown";				
		}
		
		System.out.println("Password strength :" +strengthDescription);
		
		scanner.close();
		
	}
}