import java.util.HashMap;
import java.util.Map;

public class Cart
{
    private int Flag=1;

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

    private Map <Product,Integer> UserPurchasesInsideTheCart = new HashMap<Product,Integer>();
    public void Add(Product Product,int Quantity)
    {
        if (Product.getQuantity() < Quantity)
        {
            System.out.println("Error,The product Quantity in the stock less than the wanted product quantity");
            Flag = 0;
            return;
        }
        else if(Product.getQuantity()==0)
        {
            System.out.println("The product is out of the stock");
            Flag = 0;
            return;
        }
        if(Product instanceof ProductsWithExpirationDates)
        {
            if(((ProductsWithExpirationDates) Product).isExpired())
            {
                System.out.println("This product is expired");
                Flag = 0;
                return;
            }
        }
        if(Product == null)
        {
            System.out.println("Error,The cart can't be empty");
            Flag = 0;
            return;
        }
        UserPurchasesInsideTheCart.put(Product,Quantity);
        Product.ReduceQuantity(Quantity);
    }

    public Map<Product, Integer> getUserPurchasesInsideTheCart() {
        return UserPurchasesInsideTheCart;
    }

    public void setUserPurchasesInsideTheCart(Map<Product, Integer> userPurchasesInsideTheCart) {
        UserPurchasesInsideTheCart = userPurchasesInsideTheCart;
    }
}
