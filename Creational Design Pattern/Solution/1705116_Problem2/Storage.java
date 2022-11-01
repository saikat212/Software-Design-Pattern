public interface Storage {

    public String StorageType();
}

class SDCard implements Storage
{
    @Override
    public String StorageType() {
        return "Storage: SD Card";
    }
}

class RaspberryBuiltInStorage implements Storage
{
    @Override
    public String StorageType()
    {
        return "Storage: Raspberry Pi BuiltIn Storage";
    }
}
