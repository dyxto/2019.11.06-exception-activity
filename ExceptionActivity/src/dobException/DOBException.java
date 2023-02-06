package dobException;
import java.util.Scanner;

public class DOBException {

	public static void main(String[] args) throws InvalidMonthException, InvalidDayException {
		
		Scanner kb = new Scanner(System.in);

		String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
		
		int year = -1, month = 0, day = 0;
		
		//year
	    System.out.print("Enter birth year: ");
		while (year < 0) { //while year is less than 0 (while year is negative, is -1 at start)
	    	try {
	    		year = kb.nextInt();
	    		if (year < 0) {
	    			System.out.println("Year may not be negative.");
	    			System.out.print("Enter birth year: ");
	    		}else if (!(year == (int)year)) {
	    			throw new InputMismatchException();
	    		}
	    	}catch(InputMismatchException y) {
		    	System.out.println(y.getMessage());
		    }
	    }
	    
	    //month
	    System.out.print("Enter birth month as a number: ");
	    while (month < 1 || month > 12) { //while month is less than 1 OR greater than 12 (while month is between 1 and 12, month starts at 0)
	    	try {
	    		month = kb.nextInt();
	    		if (month < 1 || month > 12) {
	    			throw new InvalidMonthException();
	    		}
	    	}catch(InvalidMonthException m) {
	    		System.out.println(m.getMessage());
	    		System.out.print("Enter birth month as a number: ");
	    	}
	    }
	    
	    //day
	    System.out.print("Enter birth day: ");
	    while (day < 1 || day >= 31) { //while day is less than 1 OR greater than 31 (day must be between 1 and 31, day starts at 0)
	    	try {
	    		day = kb.nextInt();
	    		if (day >= 1 || day <= 31) {
		    		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		    			if (!(day >= 1 && day <=31)) {
		    				throw new InvalidDayException(31);
		    			}
		    		}
		    		if (month == 4 || month == 6 || month == 9 || month == 11) {
		    			if (!(day >= 1 && day <=30)) {
		    				throw new InvalidDayException(30);
		    			}
		    		}
		    		if (month == 2) {
		    			if (day < 1 || day > 28) {
		    				throw new InvalidDayException(28);
		    			}
		    		}
	    		}
	    		System.out.println("Your birthdate is: " + months[month-1] + " " + day + ", " + year);
	    	}catch(InvalidDayException d) {
	    		System.out.println(d.getMessage());
	    		System.out.print("Enter birth day: ");
	    	}
	    }
	    
	}
}

class InputMismatchException extends Exception {
	public InputMismatchException() {
		super("Year must be a number. ");
	}
}
class InvalidMonthException extends Exception {
	public InvalidMonthException() {
		super("Month must be between 1 and 12. ");
	}
}
class InvalidDayException extends Exception {
	public InvalidDayException(int days) {
		super("Day must be between 1 and " + days + ". ");
	}
}
