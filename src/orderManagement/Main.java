package orderManagement;

public class Main {
  public static void main(String[] args)  {
    //Scanner stdIn = new Scanner(System.in);
    int num = -1;
    while(num != 0) {
      System.out.println("処理を選択してください");
      System.out.println("1 受注検索");
      System.out.println("2 受注登録");
      System.out.println("3 受注削除");
      System.out.println("0 終了");
      System.out.print("番号:");
      num = Input.convertToInteger();

      switch(num) {
      case 1:
        System.out.println();
        new SelectIO();
        break;

      case 2:
        System.out.println();
        new InsertIO();
        break;

      case 3:
        System.out.println();
        new DeleteIO();
        break;

      case 0:
        break;

      default:
        Alert.incorrectNumber();
        System.out.println();
        break;
      }
    }
  }
}