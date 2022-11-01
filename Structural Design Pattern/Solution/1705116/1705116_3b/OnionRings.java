
public class OnionRings extends PizzaDecorator{
    public OnionRings(Pizza samplePizza)
    {
        super(samplePizza);
    }


    public String prepareFood() {
        return super.prepareFood()+" , Onion Rings";
    }


    public double price() {
        return super.price()+100.0;
    }
}
