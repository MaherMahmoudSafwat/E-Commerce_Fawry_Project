public class Product
{
    String Name;
    double Price;
    int Quantity;

    public Product(String name, double price, int quantity) {
        Name = name;
        Price = price;
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void ReduceQuantity(int Quantity)
    {
        this.Quantity-=Quantity;
    }
}
