//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
            ShippingService Cheese = new ShippingService("Cheese",
                100,10,200);
            ShippingService Biscuits = new ShippingService("Biscuits",
                150,30,700);
            Product TV = new Product("TV",
                3000,20); // Non-Shippable Service
            Product ScratchCard = new Product("ScratchCard",
                100,5); //Non-Shippable Service

            Product FreshCheese = new ProductsWithExpirationDates("Fresh Cheese",100,10,false); //Product with expired date.
            Product FreshBiscuits = new ProductsWithExpirationDates("Fresh Biscuits",150,10,true); //Product with expired data.

            Customer Customer1 = new Customer("Mohammed",5000);
            Customer Customer2 = new Customer("Ahmed",4000);
            Customer Customer3 = new Customer("Maher",3000);

            Cart C1 = new Cart();
            C1.Add(FreshBiscuits,5);
            Checkout.checkout(Customer3,C1);
            System.out.println("---------------------------");
            Cart C2 = new Cart();
            C2.Add(Cheese,2);
            C2.Add(Biscuits,1);
            Checkout.checkout(Customer1,C2);
            System.out.println("---------------------------");
            Cart C3 = new Cart();
            C3.Add(Cheese,2);
            C3.Add(ScratchCard,1);
            C3.Add(Biscuits,3);
            Checkout.checkout(Customer2,C3);
            System.out.println("---------------------------");
    }
}