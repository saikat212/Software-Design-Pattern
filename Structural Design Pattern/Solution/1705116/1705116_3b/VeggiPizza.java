public class VeggiPizza implements Pizza

{
    @Override
    public String prepareFood() {
        return "Veggi Pizza";
    }

    @Override
    public double price() {
        return 200.0;
    }
}