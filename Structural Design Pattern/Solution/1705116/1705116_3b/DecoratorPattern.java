import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class DecoratorPattern {

    private static int choice;

    public static void main(String[] args) throws NumberFormatException,IOException{
        do {
            System.out.println("=========== FOOD MENU============");
            System.out.println("1. Beef Pizza with French fry");
            System.out.println("2. Veggi Pizza with onion rings");
            System.out.println("3. A combo meal with Veggi Pizza, French Fry and Coke");
            System.out.println("4.A combo meal with Veggi Pizza, Onion Rings and Coffee");
            System.out.println("5. A Beef Pizza only");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            choice=Integer.parseInt(br.readLine());
            switch (choice)
            {
                case 1:
                {
                    Pizza p=new FrenchFries((Pizza) new BeefPizza());
                    System.out.println(p.prepareFood());
                    System.out.println(p.price());
                }
                break;
                case 2:
                {
                    Pizza p=new OnionRings((Pizza) new VeggiPizza());
                    System.out.println(p.prepareFood());
                    System.out.println(p.price());
                }
                break;
                case 3:
                {
                    Pizza p=new Coke((Pizza) new FrenchFries((Pizza) new VeggiPizza()));
                    System.out.println(p.prepareFood());
                    System.out.println(p.price());
                }
                break;
                case 4:
                {
                    Pizza p=new Coffe((Pizza) new OnionRings((Pizza) new VeggiPizza()));
                    System.out.println(p.prepareFood());
                    System.out.println(p.price());
                }
                break;
                case 5:
                {
                    Pizza p= new BeefPizza();
                    System.out.println(p.prepareFood());
                    System.out.println(p.price());
                }
                break;
            }

        }while (choice!=6);
    }
}
