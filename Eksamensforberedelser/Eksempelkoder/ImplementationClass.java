interface Interface extends ParentInterface {
    int childMethod();
}

public class ImplementationClass implements Interface {
    @Override
    public String parentMethod() {
        return "Something";
    }

    @Override
    public int childMethod() {
        return 0;
    }
}