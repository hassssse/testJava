package orderManagement;

public class SelectItemResult {
  private int itemCode;
  private String itemName;
  
  public SelectItemResult() {
    this.itemCode = 0;
    this.itemName = "noname";
  }
  
  public SelectItemResult(int itemCode, String itemName) {
    this();
    this.itemCode = itemCode;
    this.itemName = itemName;
  }

  public int getItemCode() {
    return itemCode;
  }

  public String getItemName() {
    return itemName;
  }
  
  
}
