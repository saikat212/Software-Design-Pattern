public abstract class RaspberryPI extends Device{

    @Override
    public String MicroController() {
        return "MicroController: Raspberry Pi";
    }

    @Override
    public Identification UsedID() {
        return new NFCCard();
    }

    @Override
    public Storage UsedStorage() {
        return new RaspberryBuiltInStorage();
    }

    @Override
    public Display UsedDisplay() {
        return new TouchScreen();
    }

    @Override
    public ControllerSystem UsedController() {
        return new TouchController();
    }

    @Override
    public Internet UsedInternetService() {
        return new Ethernet();
    }

    @Override
    public abstract String WeightMeasurementOption();
    @Override
    public abstract String UsedFrameWork();

}
abstract class Diamond extends RaspberryPI
{
    @Override
    public String WeightMeasurementOption() {
        return "WeightMeasurement : Load Sensor";
    }

    @Override
    public abstract String UsedFrameWork();
}
class DiamondDjango extends Diamond
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Django";
    }
}

class DiamondSpring extends Diamond
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Spring";
    }
}


class DiamondLaravel extends Diamond
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Laravel";
    }
}


abstract class Platinum extends RaspberryPI
{
    @Override
    public String WeightMeasurementOption() {
        return "WeightMeasurement : Weight Module";
    }

    @Override
    public abstract String UsedFrameWork();
}
class PlatinumDjango extends Platinum
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Django";
    }
}

class PlatinumSpring extends Platinum
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Spring";
    }
}


class PlatinumLaravel extends Platinum
{
    @Override
    public String UsedFrameWork() {
        return "FrameWork: Laravel";
    }
}