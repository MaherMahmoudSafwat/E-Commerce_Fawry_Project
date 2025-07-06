public class Customer
{
    String Name;
    double Balance;

    public Customer(String name, double balance)
    {
        Name = name;
        Balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
