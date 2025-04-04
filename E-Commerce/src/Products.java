import java.time.LocalDateTime;

public class Products
{
    private String _ProductName;
    private double _ProductPrice;
    private int _ProductQuantity;
    private int _IsProductExpires;
    private boolean _IsProductHasShipping;
    private static int[]ProductsQuantity = {15,5,3,6,8};

    Products()
    {

    }

    Products(String ProductName,int ProductQuantity)
    {
        this._ProductName = ProductName;
        this._ProductQuantity = ProductQuantity;
    }

    public void set_ProductName(String _ProductName) {
        this._ProductName = _ProductName;
    }

    public String get_ProductName() {
        return _ProductName;
    }

    public void set_ProductPrice(double _ProductPrice) {
        this._ProductPrice = _ProductPrice;
    }

    public int get_ProductQuantity() {
        return _ProductQuantity;
    }

    public void set_IsProductExpires(int _IsProductExpires) {
        this._IsProductExpires = _IsProductExpires;
    }

    public double get_ProductPrice() {
        return _ProductPrice;
    }

    public void set_ProductQuantity(int _ProductQuantity) {
        this._ProductQuantity = _ProductQuantity;
    }


    public int GetIsProductExpires()
    {
        return _IsProductExpires;
    }

    public void set_IsProductHAsShipping(boolean _IsProductHAsShipping) {
        this._IsProductHasShipping = _IsProductHAsShipping;
    }

    public boolean is_IsProductHAsShipping() {
        return _IsProductHasShipping;
    }
    private boolean ExpireDateOfCheese()
    {
        LocalDateTime Date = LocalDateTime.of(2025,4,30,0,0);
        LocalDateTime FinalDate = LocalDateTime.now();
        if(Date.getYear() > FinalDate.getYear())
        {
            return false;
        }
        if(Date.getYear() == FinalDate.getYear() && Date.getMonthValue() > FinalDate.getMonthValue())
        {
            return false;
        }
        if(Date.getYear() == FinalDate.getYear() && Date.getMonthValue() == FinalDate.getMonthValue() && Date.getDayOfMonth() <= FinalDate.getDayOfMonth())
        {
            return false;
        }
        return true;
    }
    private boolean ExpireDateOfBiscuit()
    {
        LocalDateTime Date = LocalDateTime.of(2025,4,4,0,0);
        LocalDateTime FinalDate = LocalDateTime.now();
        if(Date.getYear() > FinalDate.getYear())
        {
            return false;
        }
        if(Date.getYear() == FinalDate.getYear() && Date.getMonthValue() > FinalDate.getMonthValue())
        {
            return false;
        }
        if(Date.getYear() == FinalDate.getYear() && Date.getMonthValue() == FinalDate.getMonthValue() && Date.getDayOfMonth() <= FinalDate.getDayOfMonth())
        {
            return false;
        }
        return true;
    }
    public void IsProductExpires(String Product) throws ProductExpiredException {
        if (Product.equals("cheese"))
        {
            if (!ExpireDateOfCheese())
                throw new ProductExpiredException("Product is Expired");
        }
        else if (Product.equals("biscuit"))
        {
            if (!ExpireDateOfBiscuit())
                throw new ProductExpiredException("Product is Expired");
        }
    }
    public double SetProductPrice()
    {
        if(get_ProductName().equals("cheese"))
        {
            set_ProductPrice(100*get_ProductQuantity());
            return get_ProductPrice();
        }
        else if(get_ProductName().equals("biscuit"))
        {
            set_ProductPrice(150*get_ProductQuantity());
            return get_ProductPrice();
        }
        else if(get_ProductName().equals("tv"))
        {
            set_ProductPrice(300*get_ProductQuantity());
            return get_ProductPrice();
        }
        else if(get_ProductName().equals("mobile scratch"))
        {
            set_ProductPrice(30*get_ProductQuantity());
            return get_ProductPrice();
        }
        else if(get_ProductName().equals("mobile"))
        {
            set_ProductPrice(1000*get_ProductQuantity());
            return get_ProductPrice();
        }
        return 0.0;
    }
    public void IsProductAvaliable() throws ProductOutOfStockException
    {
        if(get_ProductName().equals("cheese"))
        {
            if(ProductsQuantity[0] == 0)
                throw new ProductOutOfStockException("The product is out of stock");
            else if(ProductsQuantity[0] < get_ProductQuantity())
                throw new ProductOutOfStockException("The product quantity you asked for is not available");
            else
                ProductsQuantity[0]-=get_ProductQuantity();
        }
        else if(get_ProductName().equals("biscuit"))
        {
            if(ProductsQuantity[1] == 0)
                throw new ProductOutOfStockException("The product is out of stock");
            else if(ProductsQuantity[1] < get_ProductQuantity())
                throw new ProductOutOfStockException("The product quantity you asked for is not available");
            else
                ProductsQuantity[1]-=get_ProductQuantity();
        }
        if(get_ProductName().equals("tv"))
        {
            if(ProductsQuantity[2] == 0)
                throw new ProductOutOfStockException("The product is out of stock");
            else if(ProductsQuantity[2] < get_ProductQuantity())
                throw new ProductOutOfStockException("The product quantity you asked for is not available");
            else
                ProductsQuantity[2]-=get_ProductQuantity();
        }
        if(get_ProductName().equals("mobile scratch"))
        {
            if(ProductsQuantity[3] == 0)
                throw new ProductOutOfStockException("The product is out of stock");
            else if(ProductsQuantity[3] < get_ProductQuantity())
                throw new ProductOutOfStockException("The product quantity you asked for is not available");
            else
                ProductsQuantity[3]-=get_ProductQuantity();
        }
        if(get_ProductName().equals("mobile"))
        {
            if(ProductsQuantity[4] == 0)
                throw new ProductOutOfStockException("The product is out of stock");
            else if(ProductsQuantity[4] < get_ProductQuantity())
                throw new ProductOutOfStockException("The product quantity you asked for is not available");
            else
                ProductsQuantity[4]-=get_ProductQuantity();
        }
    }
}
