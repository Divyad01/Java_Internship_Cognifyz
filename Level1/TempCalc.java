import java.util.Scanner;

public class TempCalc {

    public static void main(String[] args) {
        // Creating a Scanner object to get user input
        Scanner s = new Scanner(System.in);

        // Prompting the user to enter temperature value
        System.out.print("Enter temperature value: ");
        double temp = s.nextDouble();

        // Prompting the user to enter the unit of measurement
        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = s.next().charAt(0);

        // Performing the conversion
        double convertedTemperature;
        if (unit == 'C' || unit == 'c') {
            convertedTemperature = celsiusToFahrenheit(temp);
            System.out.println(temp + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = fahrenheitToCelsius(temp);
            System.out.println(temp + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
        }

        // Closing the Scanner
        s.close();
    }

    // Method to convert Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
