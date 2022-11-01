public class FrenchFries extends PizzaDecorator{
    public FrenchFries(Pizza samplePizza)
    {
        super(samplePizza);
    }


    public String prepareFood() {
        return super.prepareFood()+" , French Fry";
    }


    public double price() {
        return super.price()+100.0;
    }
}
