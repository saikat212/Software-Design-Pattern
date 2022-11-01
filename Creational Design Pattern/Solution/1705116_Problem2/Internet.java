public interface Internet {
    public String InternetServiceName();
}

class WifiORGSM implements Internet
{
    @Override
    public String InternetServiceName() {
        return "Internet: Wifi or GSM";
    }
}


class Ethernet implements Internet
{
    @Override
    public String InternetServiceName() {
        return "Internet: Ethernet ";
    }
}
