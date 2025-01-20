public class FletteTrad implements Runnable{
    private Monitor monitor;

    public FletteTrad(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        monitor.flettSammen();
    }
}
