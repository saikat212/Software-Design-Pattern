
import java.util.ArrayList;
import java.util.List;

public class SelectedSystem {

    List<TeaGAS_System> choicelist=new ArrayList<TeaGAS_System>();

    public void addSystem(TeaGAS_System item)
    {
        choicelist.add(item);
    }
    public void showDetails()
    {
        for(TeaGAS_System item:choicelist)
        {
            System.out.println(item.MicroController());

            System.out.println(item.WeightMeasurementOption());


            System.out.println(item.UsedID().IDName());


            System.out.println(item.UsedStorage().StorageType());


            System.out.println(item.UsedDisplay().DisplayType());


            System.out.println(item.UsedInternetService().InternetServiceName());


            System.out.println(item.UsedController().ControllerType());


            System.out.println(item.UsedFrameWork());





        }
    }
}
