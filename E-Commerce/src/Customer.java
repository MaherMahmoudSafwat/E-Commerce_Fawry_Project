public class Customer
{
    private double _Balance;
    Customer(double _Balance)
    {
        this._Balance = _Balance;
    }

    public void set_Balance(double _Balance) {
        this._Balance = _Balance;
    }
    public double get_Balance() {
        return _Balance;
    }

}
