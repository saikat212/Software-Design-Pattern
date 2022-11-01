public abstract class Device implements TeaGAS_System{

    @Override
    public abstract Identification UsedID();

    @Override
    public abstract Storage UsedStorage();


    @Override
    public abstract Display UsedDisplay();


    @Override
    public abstract ControllerSystem UsedController();


    @Override
    public abstract Internet UsedInternetService();

    @Override
    public abstract String WeightMeasurementOption();

    @Override
    public abstract String UsedFrameWork();

    @Override
    public abstract String MicroController();
}


