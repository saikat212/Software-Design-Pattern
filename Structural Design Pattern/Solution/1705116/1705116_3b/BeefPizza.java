

public class BeefPizza implements Pizza

{
    @Override
    public String prepareFood() {
        return "Beef Pizza";
    }

    @Override
    public double price() {
        return 300.0;
    }
}