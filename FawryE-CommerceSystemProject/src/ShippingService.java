public class ShippingService extends Product implements ShippableItems
{
    private double Weight;
    public ShippingService(String name, double price, int quantity,double Weight) {
        super(name, price, quantity);
        this.Weight = Weight;
    }

    @Override
    public double getWeight() {
        return Weight;
    }
}
