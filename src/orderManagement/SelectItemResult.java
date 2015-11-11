package orderManagement;

public class SelectItemResult {
  private int itemCode, itemPrice;
  private String itemName;

  public SelectItemResult() {
    this.itemCode = 0;
    this.itemName = "noname";
    this.itemPrice = 0;
  }

  public SelectItemResult(int itemCode, String itemName, int itemPrice) {
    this();
    this.itemCode = itemCode;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
  }

  public int getItemCode() {
    return itemCode;
  }

  public String getItemName() {
    return itemName;
  }

  public int getItemPrice() {
    return itemPrice;
  }
}