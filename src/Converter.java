import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		
		// TITLE
		System.out.println("-------------------------------------------------");
		System.out.println("\tCONVERT °C OR °F DEGREES.");
		System.out.println("-------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		char convert = ' ';
		
		// CHOSE THE CONVERTER
		do {
			do {	
				System.out.println("Choose a conversion method :");
				System.out.println("1 - Convert Celsius to Fahrenheit");
				System.out.println("2 - Convert Fahrenheit to Celsiuss");
				String myChoise = sc.nextLine();
				convert = myChoise.charAt(0);

			} while (convert != '1' && convert != '2');
			
			switch (convert)
			{
				case '1':
					System.out.println("Celsius temperature to convert :");
					double celsiusToConvert = arrondi(sc.nextDouble(), 1);
					double celsicusConverted = celsiusConverter(celsiusToConvert);
					
					System.out.println("-------------------------------------------------");
					System.out.print(celsiusToConvert + "°C is equal to : ");
					System.out.println(celsicusConverted + "°F");
					
					convert = restart();
					sc.nextLine();
					break;
					
				case '2':
					System.out.print("Fahrenheit temperature to convert:\n");
					double fahrenheitToConvert = arrondi(sc.nextDouble(), 1);
					double fahrenheitConverted = fahrenheitConverter(fahrenheitToConvert);
					
					System.out.println("-------------------------------------------------");
					System.out.print(fahrenheitToConvert + "°F is equal to : ");
					System.out.println(fahrenheitConverted + "°C");

					convert = restart();
					sc.nextLine();
					break;			}
			
		} while (convert == '0');
			
		System.out.println("Thank you, Good bye !");
		sc.close();
		
	}

	public static double celsiusConverter(double celsiusToConvert) {
		double result = (9f / 5f * celsiusToConvert + 32);
		return arrondi(result, 2);
	}
	
	public static double fahrenheitConverter(double fahrenheitToConvert) {
		double result = (fahrenheitToConvert - 32) * 5 / 9;
		return arrondi(result, 2);
	}
	
	public static char restart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Did you want do other convert? (Y/N)");
		System.out.println("-------------------------------------------------");

		String restart = sc.nextLine();
		char reponse = restart.charAt(0);
		if (reponse == 'Y' || reponse == 'y')
			return '0';
		else
			return ' ';
	}

	public static double arrondi(double A, int B) {
		  return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}
	
}
