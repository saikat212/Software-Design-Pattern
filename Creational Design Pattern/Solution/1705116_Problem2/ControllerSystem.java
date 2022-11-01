public interface ControllerSystem {

    public String ControllerType();
}

class TouchController implements ControllerSystem
{

    @Override
    public String ControllerType() {
        return "Controller: Touch Controller";
    }
}


class ButtonController implements ControllerSystem
{

    @Override
    public String ControllerType() {
        return "Controller: Button Controller";
    }
}