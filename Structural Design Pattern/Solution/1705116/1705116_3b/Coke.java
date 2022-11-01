
public class Coke extends PizzaDecorator{
    public Coke(Pizza samplePizza)
    {
        super(samplePizza);
    }


    public String prepareFood() {
        return super.prepareFood()+" ,Coke";
    }


    public double price() {
        return super.price()+30.0;
    }
}
