
public class Coffe extends PizzaDecorator{
    public Coffe(Pizza samplePizza)
    {
        super(samplePizza);
    }


    public String prepareFood() {
        return super.prepareFood()+" ,Coffe";
    }


    public double price() {
        return super.price()+50.0;
    }
}
