class Rekursjon {
    public static void main(String[] args) {
        tellNed(5);
    }
    
    public static String tellNed(int n) {
        if (n == 0) {
            return "Ferdig";
        }
        System.out.println(n);
        String tekst = tellNed(n-1);
        System.out.println(tekst);
        System.out.println(n);
        
        return tekst;
    }
}