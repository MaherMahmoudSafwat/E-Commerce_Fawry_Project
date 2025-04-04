public final class Utility
{
    private static String GetSubString(String UserOrders)
    {
        return UserOrders.substring(UserOrders.indexOf("("));
    }
    private static String GetProduct(String UserOrders)
    {
        return UserOrders.substring(1,UserOrders.indexOf(",")).trim();
    }
    private static int GetQuantity(String UserOrders)
    {
        return Integer.parseInt(UserOrders.substring(UserOrders.lastIndexOf(",")+1,UserOrders.length()-1).trim());
    }
   static String IsStringCorrect(String UserOrders)
    {
        String SubString="";
        String ProductName="";
        int Quantity=0;
        try
        {
            SubString = GetSubString(UserOrders);
            ProductName = GetProduct(SubString);
            Quantity = GetQuantity(SubString);
        }
        catch(Exception  E)
        {
            System.out.println("Invalid Input");
            return "";
        }
        return ProductName + "," +Quantity;
    }
}
