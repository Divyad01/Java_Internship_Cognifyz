import java.util.Scanner;

public class StudGrad{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		
		
		//Prompting the user to enter the number of grades
		System.out.print("Enter the number of grades:");
		int numberOfGrades =s.nextInt();
		
		//Validating if the entered number of grades is positive
		if(numberOfGrades <=0){
			System.out.println("Invalid input . Please enter a positive number");
			return;
		}
		 
		//Array to store the grades
		double[] grades =new double[numberOfGrades];
		
		//Input each grade from the user
		for(int i=0 ; i< numberOfGrades ;i++){
			System.out.print("Enter grade "+(i+1) +":");
			grades[i]=s.nextDouble();
		}
		
		//Calculating the average grade
		double sum=0;
		for(double grade :grades){
			sum+=grade;
		}
		double average =sum/numberOfGrades;
		
		//Displaying the average grade
		System.out.println("Average grade:"+average);
		
		s.close();
	}
	
}