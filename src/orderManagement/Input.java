package orderManagement;

import java.util.Scanner;

public class Input {
  static int constrainInteger() {
    Scanner stdIn = new Scanner(System.in);
    String input = stdIn.next();
    int number = -1;
    if (isNumber(input)) {
      number = Integer.parseInt(input);
    }
    return number;
  }
  
  private static boolean isNumber(String val) {
    try {
      Integer.parseInt(val);
      return true;
    } catch (NumberFormatException nfex) {
      return false;
    }
  }
}
