class BilBruk {
    public static void main(String[] args) {
        Bil1 eneBilen = new Bil1();
        eneBilen.Print();
        Bil2 andrebilen = new Bil2("VW");
        System.out.println(andrebilen.getDetails());
        Bil3 tredjebilen = new Bil3("Lamborghini");
        Person lamborghini_eier = new Person("Anders", 21, tredjebilen);
        System.out.println(lamborghini_eier.allInfo());
    }
}
