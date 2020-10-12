package seedu.duke.ui;

import java.util.Scanner;

public class Ui {

    public static void greetUser() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine() + "!");
    }

    public static String getUserInput() {
        System.out.println("What would you like to do?");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput;
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    public boolean sayBye(String userInput) {
        if (userInput.contains("bye")) {
            return true;
        }
        return false;
    }
}
