public class ShippingService implements IShippingService
{

    public String SetName="";
    public double SetDouble = 0;
    @Override
    public String GetName()
    {
        return SetName;
    }

    @Override
    public double GetWeight()
    {
        double ProductWeight = 0;
        if(GetName().equals("cheese"))
        {
            ProductWeight=200;
        }
        else if(GetName().equals("biscuits"))
        {
            ProductWeight=700;
        }
        else if(GetName().equals("mobile"))
        {
            ProductWeight=500;
        }
        else if(GetName().equals("tv"))
        {
            ProductWeight=1000;
        }
        return ProductWeight;
    }
    public boolean IsProductHasShipping(String Product)
    {
        if(!Product.equals("cheese")&&!Product.equals("biscuits")&&!Product.equals("tv")&&!Product.equals("mobile"))
        {
            return false;
        }
        return true;
    }
}

