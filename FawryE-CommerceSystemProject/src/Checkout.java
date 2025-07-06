import java.util.Map;

public class Checkout
{

    public static void checkout(Customer Customer,Cart Cart)
    {
        if(Cart.getFlag()==0)
        {
            return;
        }
        double TotalPrices = 0;
        double TotalInKilos = 0;
        Map<Product,Integer> UserPurchases = Cart.getUserPurchasesInsideTheCart();
        for(Map.Entry<Product,Integer> Entries : UserPurchases.entrySet())
        {
            TotalPrices+=(Entries.getKey().getPrice()*Entries.getValue());
            if(Entries.getKey() instanceof ShippingService)
            {
                TotalInKilos+=(((ShippingService) Entries.getKey()).getWeight() * Entries.getValue());
            }
        }
        ShowReceipt(Cart,TotalPrices,TotalInKilos,Customer);
    }
    public static void ShowReceipt(Cart Cart,double TotalPrices,double TotalInKilos,Customer Customer)
    {
        System.out.println("**Shipment notice **");
        for(Map.Entry<Product,Integer>Entries:Cart.getUserPurchasesInsideTheCart().entrySet())
        {
            if(Entries.getKey() instanceof ShippingService)
            {
                double ResultInKilos = Entries.getValue()*((ShippingService) Entries.getKey()).getWeight();
                ResultInKilos = (ResultInKilos > 1000)? ResultInKilos/1000 : ResultInKilos;
                System.out.println(Entries.getValue() + "x" + Entries.getKey().getName() + "\t\t\t" + ResultInKilos + "g");
            }
        }
        System.out.println("Total package weight " + ((TotalInKilos > 1000) ? TotalInKilos/1000 : TotalInKilos));
        System.out.println("** Checkout receipt **");
        for(Map.Entry<Product,Integer>Entries:Cart.getUserPurchasesInsideTheCart().entrySet())
        {
            System.out.println(Entries.getValue() + "x" + Entries.getKey().getName() + " \t " + Entries.getKey().getPrice()*Entries.getValue());
        }
        if(TotalPrices > Customer.getBalance())
        {
            System.out.println("Error,Insufficient balance : TotalPrices is " + TotalPrices + " Your Current Balance is " + Customer.getBalance());
            return;
        }
        System.out.println("---------------------------");
        System.out.println("Subtotal            " + TotalPrices);
        System.out.println("Shipping            " + ((TotalInKilos==0)?0:30));
        if(TotalInKilos == 0)
        {
            System.out.println("Shipping            " + 0);
            System.out.println("Amount              " + TotalPrices);
        }
        else
        {
            System.out.println("Shipping            " + 30);
            System.out.println("Amount              " + (TotalPrices+30));
        }
    }
}
