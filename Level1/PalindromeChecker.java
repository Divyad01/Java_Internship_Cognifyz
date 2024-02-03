import java.util.Scanner;

public class PalindromeChecker{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		
		System.out.print("Enter a word or a phrase:");
		String input=s.nextLine();
		
		if (isPalindrome(input)){
			System.out.println("Yes , it is a palindrome .");
		}
		else{
			System.out.println("No , it is not a palindrome .");
		}
		
		s.close();
	}
	
	//Method to check if a given string is a palindrome
	private static boolean isPalindrome(String str){
		
		//Removing spaces and punctuation,converting to lowercase
		String newStr =str.replaceAll("[^a-zA-Z]","").toLowerCase();
		
		
		//Checking if the newstring is a palindrome
		int left=0;
		int right=newStr.length() -1;
		
		while (left<right){
			if(newStr.charAt(left) != newStr.charAt(right)){
				return false; //Not a palindrome
			}
			
			left++;
			right--;
		
		}
		return true; // It is a palindrome
	}
	
}