import java.util.List;
import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String StringInput(String prompt, char letterCase) {
        if(letterCase == 'U') {
            Screen.AddToBottom(prompt);
            String userInput = scanner.nextLine().toUpperCase();
            return userInput;
        }
        else if (letterCase == 'L') {
            Screen.AddToBottom(prompt);
            String userInput = scanner.nextLine().toLowerCase();
            return userInput;
        }
        else {
            Screen.AddToBottom(prompt);
            String userInput = scanner.nextLine();
            return userInput;
        }
    }

    public static String SpecificStringInput (String prompt, char letterCase, List<String> validInputs, String errorMessage) {
        while(true){
            String userInput = StringInput(prompt, letterCase);
            for(String validInput : validInputs) {
                if(userInput.equals(validInput)) {
                    return userInput;
                }
            }
            Screen.AddToBottom(errorMessage);
        }
    }

    public static Integer IntegerInput(String prompt, String errorMessage) {
        while(true) {
            
            Screen.ResetBottom();
            Screen.AddToBottom(prompt);
            String userInput = scanner.nextLine();
            try {
                Integer number = Integer.valueOf(userInput);
                return number;
            } catch (NumberFormatException e) {
                Screen.ResetTop();
                Screen.AddToTop(errorMessage);
            }
        }
    }

    public static Integer SpecificIntegerInput (String prompt, String errorNotInt, Integer range, String errorNotInRange) {
        while(true){
            Integer userInput = IntegerInput(prompt, errorNotInt);
            for(int validInput = 0; validInput <= range; validInput++) {
                if(userInput == validInput) {
                    return userInput;
                }
            }
            Screen.ResetTop();
            Screen.AddToTop(errorNotInRange);
        }
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}