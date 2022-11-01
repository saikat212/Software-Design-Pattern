public abstract class ArduinoMega extends Device{

    @Override
    public String MicroController() {
        return "MicroController: Arduino Mega";
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
        return new LED();
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
abstract class Gold extends ArduinoMega
{
    @Override
    public String WeightMeasurementOption() {
        return "WeightMeasurement : Weight Module";
    }

    @Override
    public abstract String UsedFrameWork();
}
class GoldDjango extends Gold
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Django";
    }
}

class GoldSpring extends Gold
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Spring";
    }
}


class GoldLaravel extends Gold
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Laravel";
    }
}