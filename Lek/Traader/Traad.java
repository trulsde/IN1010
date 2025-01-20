public class Traad implements Runnable {
    
    public void run(){
        for (int i = 1; i < 5000; i++){
            if (i % 1000 == 0){
                System.out.printf("Dette er den " + i + ". gangen");
                System.out.println();
            }
        }
        
    }
}
