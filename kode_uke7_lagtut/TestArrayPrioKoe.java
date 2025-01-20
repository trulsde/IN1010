public class TestArrayPrioKoe {
    public static void main(String[] args) {
        Liste<Integer> ap = new ArrayPrioKoe<>();
        ap.add(4);
        ap.add(0);
        ap.add(16);
        ap.add(5);
        ap.add(2);

        ap.remove(0);

        System.out.println("Tester iterable");
        for (Integer x: ap) {
            System.out.println(x);
        }
    }
}