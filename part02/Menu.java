package part02;
import java.util.Scanner;
/**
 * 
 * @author Eunan Diamond @StudentNumber 40293751 @Date:31/10/2020
 *
 */
public class Menu {
	
	private String items[];//this array is used to store the options on the menu
	private String title;//this string is used to output the title of the menu
	private Scanner input;//this Scanner is used to read in the value the user sent from main method to the getUserChoice method
	//constructor so that the class can be initialized
	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}
	/**this method is used to output the menu display
	It does this by reading in the title which is set in the main method and it displays the "+" below the title
	as the length of the string using the .length() function. Again a for loop is used to output the options of menu
	along with it's option number, these options are declared in the main class and read into the Menu class via the constructor.
	This class returns nothing therefore void
	*/
	private void display() {
		System.out.println(title);
		for (int count = 0; count < title.length(); count++) {
			System.out.print("+");
		}
		System.out.println();
		for (int option = 1; option <= items.length; option++) {
			System.out.println(option + ". " + items[option - 1]);
		}
		System.out.println();
	}
	/**this class is uses no parameters and returns an int. This class is used to get The user choice for which option they choosed from the menu
	by asking which option they want. returns this number to main class and passes in no parameters
	*/
	public int getUserChoice() {
		if ( items == null || items.length == 0 ) {
			return 0;
		}
		int value = 0;
		display();
		boolean ok = false;
		do {
			System.out.print("Enter Selection: ");
			try {
				value = input.nextInt();
				if ( (value > 0 && value <= items.length) ) {
					ok = true;
				}
				else {
					System.out.println("Enter a value between 1 and " + items.length);
				}
			}
			catch(Exception ex) {
				System.out.println("Error input.");
				input.nextLine();
			}
		} while (!ok);

		return value;
	}
}


