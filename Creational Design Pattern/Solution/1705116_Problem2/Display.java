public interface Display {
    public String DisplayType();
}

class TouchScreen implements Display
{
    @Override
    public String DisplayType() {
        return "Display : Touch Screen";
    }
}

class LED implements Display
{
    @Override
    public String DisplayType() {
        return "Display : LED";
    }
}

class LCD implements Display
{
    @Override
    public String DisplayType() {
        return "Display : LCD";
    }
}
