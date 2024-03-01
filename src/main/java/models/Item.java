package models;

public class Item {
   private String name;
   private String description;
   private int stock;
   private double price;

   public Item() {
   }

   public Item(String name, String description, int stock, double price) {
      this.name = name;
      this.description = description;
      this.stock = stock;
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public int getStock() {
      return stock;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
