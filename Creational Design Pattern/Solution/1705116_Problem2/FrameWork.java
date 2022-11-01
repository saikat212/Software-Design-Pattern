public interface FrameWork {
    public String FrameName();
}

class Django implements  FrameWork
{
    @Override
    public String FrameName() {
        return "FrameWork: Django ";
    }
}
class Spring implements  FrameWork
{
    @Override
    public String FrameName() {
        return "FrameWork: Spring ";
    }
}

class Laravel implements  FrameWork
{
    @Override
    public String FrameName() {
        return "FrameWork: Laravel ";
    }
}