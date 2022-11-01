public abstract class PizzaDecorator implements  Pizza{
    private Pizza samplePizza;
    public PizzaDecorator(Pizza samplePizza)
    {
        this.samplePizza=samplePizza;
    }

    @Override
    public String prepareFood() {
        return samplePizza.prepareFood();
    }

    @Override
    public double price() {
        return samplePizza.price();
    }
}
