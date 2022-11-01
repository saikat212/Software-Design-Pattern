public abstract class ATMega32 extends Device{

    @Override
    public String MicroController() {
        return "MicroController: ATMega32";
    }

    @Override
    public Identification UsedID() {
        return new RFIDCard();
    }

    @Override
    public Storage UsedStorage() {
        return new SDCard();
    }

    @Override
    public Display UsedDisplay() {
        return new LCD();
    }

    @Override
    public ControllerSystem UsedController() {
        return new ButtonController();
    }

    @Override
    public Internet UsedInternetService() {
        return new WifiORGSM();
    }

    @Override
    public abstract String WeightMeasurementOption();
    @Override
    public abstract String UsedFrameWork();

}
 abstract class Silver extends ATMega32
{
    @Override
    public String WeightMeasurementOption() {
        return "WeightMeasurement : Load Sensor";
    }

    @Override
    public abstract String UsedFrameWork();
}
class SilverDjango extends Silver
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Django";
    }
}

class SilverSpring extends Silver
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Spring";
    }
}


class SilverLaravel extends Silver
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Laravel";
    }
}