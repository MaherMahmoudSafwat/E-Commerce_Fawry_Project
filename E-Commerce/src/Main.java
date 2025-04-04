import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static boolean FlagIsHasShipping = false;
    static double FinalPriceFeesBills = 0;
    static Customer customer;
    public static void main(String[] args)
    {
        //Some test cases are down below the code.
        Scanner Input = new Scanner(System.in);
        System.out.println("Welcome to El-Fawry E-Commerce.");
        System.out.println("Please enter your balance.");
        customer = new Customer(Input.nextDouble());
        System.out.println("Enter cart.add(Product,Quantity) to purchase a product or enter Checkout(Customer,Cart) for payment");
        ShowMenuOptionsToTheUser();
        String UserOrders="";
        String ProductName = "",ProductQuantity="";
        ArrayList<Products>products = new ArrayList<Products>();
        boolean FlagIsShipping = false;
        Input.nextLine();
        boolean Flag = true;
        while(true)
        {
            UserOrders = Input.nextLine();
            Products P = new Products();
            ShippingService SS = new ShippingService();
            if (UserOrders.equals("Checkout(Customer,Cart)")) {
                break;
            }
            if (!UserOrders.contains("cart.add(") || UserOrders.charAt(UserOrders.length() - 1) != ')') {
                System.out.println("Invalid Input.");
                continue;
            }
            UserOrders = Utility.IsStringCorrect(UserOrders);
            if (UserOrders.isEmpty()) {
                continue;
            }
            ProductName = UserOrders.substring(0, UserOrders.indexOf(",")).trim().toLowerCase();
            if(ProductName.isEmpty())
            {
                System.out.println("The cart is empty");
                continue;
            }
            ProductQuantity = UserOrders.substring(UserOrders.indexOf(",") + 1);
            try
            {
                P = new Products(ProductName,Integer.parseInt(ProductQuantity));
                P.IsProductExpires(ProductName);
                P.SetProductPrice();
                P.IsProductAvaliable();
                FinalPriceFeesBills+=P.get_ProductPrice();
                if((P.get_ProductName().equals("cheese")||P.get_ProductName().equals("biscuit")||P.get_ProductName().equals("tv")||P.get_ProductName().equals("mobile"))
                && Flag)
                {
                    if (FinalPriceFeesBills+30 > customer.get_Balance())
                    {
                        throw new InSufficientBalanceException("InSufficient Balance as your current balance is " + (customer.get_Balance())
                                + " and the final price is " + FinalPriceFeesBills);
                    }
                    else
                    {
                        Flag = false;
                        FinalPriceFeesBills+=30;
                    }
                }
                else
                {
                    if (FinalPriceFeesBills > customer.get_Balance())
                    {
                        throw new InSufficientBalanceException("InSufficient Balance as your current balance is " + (customer.get_Balance())
                                + " and the final price is " + FinalPriceFeesBills);
                    }
                }
            }
            catch(ProductExpiredException PEE)
            {
                System.out.println(PEE.getMessage());
                continue;
            }
            catch (InSufficientBalanceException ISBE)
            {
                FinalPriceFeesBills-=P.get_ProductPrice();
                System.out.println(ISBE.getMessage());
                continue;
            }
            catch(ProductOutOfStockException POOS)
            {
                System.out.println(POOS.getMessage());
                continue;
            }
            P.set_ProductPrice(P.SetProductPrice());
            products.add(P);
        }
        ShippingNotice(products);
        CheckOutRecipts(products);
    }
    public static void ShippingNotice(ArrayList<Products>P)
    {
        double TotalWeight = 0.0;
        ShippingService SS = new ShippingService();
        for(Products PTS : P)
        {
            if(SS.IsProductHasShipping(PTS.get_ProductName()))
            {
                if(PTS.get_ProductName().equals("cheese"))
                {
                    SS.SetName = "cheese";
                    TotalWeight += PTS.get_ProductQuantity() * SS.GetWeight();
                    System.out.println(PTS.get_ProductQuantity() + "x" + "  Chesse\t" + PTS.get_ProductQuantity() * SS.GetWeight());
                }
                else if(PTS.get_ProductName().equals("biscuits"))
                {
                    SS.SetName = "biscuits";
                    TotalWeight += PTS.get_ProductQuantity() * SS.GetWeight();
                    System.out.println(PTS.get_ProductQuantity() + "x" + "  biscuits\t" + PTS.get_ProductQuantity() * SS.GetWeight());
                }
                else if(PTS.get_ProductName().equals("tv"))
                {
                    SS.SetName = "tv";
                    TotalWeight += PTS.get_ProductQuantity() * SS.GetWeight();
                    System.out.println(PTS.get_ProductQuantity() + "x" + "  tv\t" + PTS.get_ProductQuantity() * SS.GetWeight());
                }
                else if(PTS.get_ProductName().equals("mobile"))
                {
                    SS.SetName = "mobile";
                    TotalWeight += PTS.get_ProductQuantity() * SS.GetWeight();
                    System.out.println(PTS.get_ProductQuantity() + "x" + "  mobile\t" + PTS.get_ProductQuantity() * SS.GetWeight());
                }
                FlagIsHasShipping = true;
            }
        }
        if(TotalWeight < 1000)
        {
            System.out.println("Total Package Weight is " + TotalWeight + "g");
        }
        else
        {
            System.out.println("Total Package Weight is " + (double)TotalWeight/1000 + "Kg");
        }
    }
    public static void CheckOutRecipts(ArrayList<Products>P)
    {
        System.out.println("** Checkout receipt **");
        for(Products PTS : P)
        {
            if(PTS.get_ProductName().equals("cheese"))
            {
                System.out.println(PTS.get_ProductQuantity() + "x" + "  Chesse\t" + PTS.get_ProductPrice());
            }
            else if(PTS.get_ProductName().equals("biscuits"))
            {
                System.out.println(PTS.get_ProductQuantity() + "x" + "  biscuits\t" + PTS.get_ProductPrice());

            }
            else if(PTS.get_ProductName().equals("tv"))
            {
                System.out.println(PTS.get_ProductQuantity() + "x" + "  tv\t" + PTS.get_ProductPrice());
            }
            else if(PTS.get_ProductName().equals("mobile scratch"))
            {
                System.out.println(PTS.get_ProductQuantity() + "x" + " mobile scratch\t" + PTS.get_ProductPrice());
            }
            else if(PTS.get_ProductName().equals("mobile"))
            {
                System.out.println(PTS.get_ProductQuantity() + "x" + " mobile\t" + PTS.get_ProductPrice());
            }
        }
        System.out.println("---------------------------------------");
        if(FlagIsHasShipping)
        {
            System.out.println("SubTotal \t " + (FinalPriceFeesBills-30));
            System.out.println("Shipping \t " + 30);
            System.out.println("Amount \t " + (FinalPriceFeesBills));
        }
        else
        {
            System.out.println("SubTotal \t " + FinalPriceFeesBills);
        }
        System.out.println("The Remaining Balance is \t " + (customer.get_Balance()-(FinalPriceFeesBills)));
    }
    public static void ShowMenuOptionsToTheUser()
    {
        System.out.println("Please choose one of the following:");
        System.out.println("1-cheese \t 200g");
        System.out.println("2-biscuits \t 700g");
        System.out.println("3-mobile \t 500g");
        System.out.println("4-tv \t 1000g");
        System.out.println("5-mobile scratch");
    }
    //Following Examples
     /*
     Balance to enter = 5000;
     cart.add(mobile,3)
     cart.add(tv,3)
     cart.add(mobile scratch,6)
     Checkout(Customer,Cart)
     */
    /*
    Balance to enter = 1500;
    cart.add(cheese,15)
    InSufficient Balance as your current balance is 1500.0 and the final price is 1530.0
    cart.add(cheese,14)
    Checkout(Customer,Cart)
     */
    /*
    Welcome to El-Fawry E-Commerce.
    Please enter your balance.
    4100
    Enter cart.add(Product,Quantity) to purchase a product or enter Checkout(Customer,Cart) for payment
    Please choose one of the following:
    1-cheese 	 200g
    2-biscuits 	 700g
    3-mobile 	 500g
    4-tv 	 1000g
    5-mobile scratch
    cart.add(cheese,15)
    cart.add(cheese,1)
    The product is out of stock
    cart.add(biscuit,3)
    Product is Expired
    cart.add(tv,3)
    cart.
    Invalid Input.
    cart.add(,5)
    The cart is empty
    cart.add(mobile scratch,5)
    cart.add(mobile,10)
    The product quantity you asked for is not available
    cart.add(mobile,7)
    InSufficient Balance as your current balance is 4100.0 and the final price is 9580.0
    cart.add(mobile,1)
    Checkout(Customer,Cart)
    15x  Chesse	3000.0
    3x  tv	3000.0
    1x  mobile	500.0
    Total Package Weight is 6.5Kg
    ** Checkout receipt **
    15x  Chesse	1500.0
    3x  tv	900.0
    5x mobile scratch	150.0
    1x mobile	1000.0
    ---------------------------------------
    SubTotal 	 3550.0
    Shipping 	 30
    Amount 	 3580.0
    The Remaining Balance is 	 520.0
    */
}

