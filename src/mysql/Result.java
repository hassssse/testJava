package mysql;

public class Result {
  private String itemName;
  private double itemPrice;
  private String supplName;

  public Result() {
    super();
  }
  
  public String getItemName() {return itemName;}
  public double getItemPrice() {return itemPrice;}
  public String getSupplName() {return supplName;}
  public void setItemName(String itemName) {this.itemName = itemName;}
  public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}
  public void setSupplName(String supplName) {this.supplName = supplName;}
}