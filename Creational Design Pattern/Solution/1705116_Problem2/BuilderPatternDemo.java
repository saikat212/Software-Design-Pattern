import java.io.IOException;


public class BuilderPatternDemo {

public static void main(String[] args) throws IOException
{
    while (true)
    {
        SystemBuilder builder=new SystemBuilder();
        SelectedSystem expectedSystem=builder.Choice_Package_And_WebServer();
        expectedSystem.showDetails();
        expectedSystem.choicelist.clear();

    }

}

}
