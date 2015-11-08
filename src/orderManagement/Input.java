package orderManagement;

import java.util.Scanner;

public class Input {
  static int convertToInteger() {
    Scanner stdIn = new Scanner(System.in);
    String input = stdIn.next();
    int number = -1;
    if (isNumber(input)) {
      number = Integer.parseInt(input);
    }
    return number;
  }
  
  private static boolean isNumber(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException nfex) {
      return false;
    }
  }
}