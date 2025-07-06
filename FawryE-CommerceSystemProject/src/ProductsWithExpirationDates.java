public class ProductsWithExpirationDates extends Product
{
    boolean IsExpired;
    ProductsWithExpirationDates(String Name,double Price,int Quantity,boolean IsExpired)
    {
        super(Name,Price,Quantity);
        this.IsExpired = IsExpired;
    }

    public boolean isExpired() {
        return IsExpired;
    }

    public void setExpired(boolean expired) {
        IsExpired = expired;
    }
}
