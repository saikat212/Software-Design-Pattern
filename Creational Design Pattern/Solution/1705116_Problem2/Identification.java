
public interface Identification
{
    public String IDName();
}

 class RFIDCard implements Identification
{
    @Override
    public String IDName()
    {
        return "Identification : RFIDCard";
    }
}

 class NFCCard implements Identification
{
    @Override
    public String IDName()
    {
        return "Identification : NFCCard";
    }
}
