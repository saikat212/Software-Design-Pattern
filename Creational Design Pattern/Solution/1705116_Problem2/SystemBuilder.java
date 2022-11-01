import javax.swing.plaf.synth.SynthLabelUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SystemBuilder {

    public SelectedSystem Choice_Package_And_WebServer() throws IOException
    {
        SelectedSystem PreferableSystem =new SelectedSystem();

        BufferedReader br =new BufferedReader((new InputStreamReader(System.in)));

        System.out.println("Enter the choice of Package of TeaGAS system: ");

        System.out.println("==============================================================");
        System.out.println("        1. Silver       ");
        System.out.println("        2. Gold       ");
        System.out.println("        3. Diamond       ");
        System.out.println("        4. Platinum      ");

        System.out.println("");

        int package_choice=Integer.parseInt(br.readLine());
        switch (package_choice)
        {
            case 1:
                System.out.println("You Selected Silver Package");
                System.out.println("\n\n");
                System.out.println("Enter the types of Web Server FrameWork:");
                System.out.println("#################################################");

                System.out.println("        1.Django        ");
                System.out.println("        2.Spring        ");
                System.out.println("        3.Laravel        ");

                System.out.println("");
                int framework_choice=Integer.parseInt(br.readLine());
                switch (framework_choice)
                {
                    case 1:

                        PreferableSystem.addSystem(new SilverDjango());
                        break;

                    case 2:
                        PreferableSystem.addSystem(new SilverSpring());
                        break;
                    case 3:
                        PreferableSystem.addSystem(new SilverLaravel());
                        break;


                }
                break;



            case 2:
                System.out.println("You Selected Gold Package");
                System.out.println("\n\n");
                System.out.println("Enter the types of Web Server FrameWork:");
                System.out.println("#################################################");

                System.out.println("        1.Django        ");
                System.out.println("        2.Spring        ");
                System.out.println("        3.Laravel        ");

                System.out.println("");
                int framework_choice1=Integer.parseInt(br.readLine());
                switch (framework_choice1)
                {
                    case 1:

                        PreferableSystem.addSystem(new GoldDjango());
                        break;

                    case 2:
                        PreferableSystem.addSystem(new GoldSpring());
                        break;
                    case 3:
                        PreferableSystem.addSystem(new GoldLaravel());
                        break;


                }
                break;


            case 3:
                System.out.println("You Selected Diamond Package");
                System.out.println("\n\n");
                System.out.println("Enter the types of Web Server FrameWork:");
                System.out.println("#################################################");

                System.out.println("        1.Django        ");
                System.out.println("        2.Spring        ");
                System.out.println("        3.Laravel        ");

                System.out.println("");
                int framework_choice2=Integer.parseInt(br.readLine());
                switch (framework_choice2)
                {
                    case 1:

                        PreferableSystem.addSystem(new DiamondDjango());
                        break;

                    case 2:
                        PreferableSystem.addSystem(new DiamondSpring());
                        break;
                    case 3:
                        PreferableSystem.addSystem(new DiamondLaravel());
                        break;


                }
                break;



            case 4:
                System.out.println("You Selected Platinum Package");
                System.out.println("\n\n");
                System.out.println("Enter the types of Web Server FrameWork:");
                System.out.println("#################################################");

                System.out.println("        1.Django        ");
                System.out.println("        2.Spring        ");
                System.out.println("        3.Laravel        ");

                System.out.println("");
                int framework_choice3=Integer.parseInt(br.readLine());
                switch (framework_choice3)
                {
                    case 1:

                        PreferableSystem.addSystem(new PlatinumDjango());
                        break;

                    case 2:
                        PreferableSystem.addSystem(new PlatinumSpring());
                        break;
                    case 3:
                        PreferableSystem.addSystem(new PlatinumLaravel());
                        break;


                }
                break;





        }


    return PreferableSystem;
    }

}
