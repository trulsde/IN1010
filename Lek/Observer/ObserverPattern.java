import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        newsFeed n = new newsFeed();

        Reader r = new Reader();
        n.addObserver(r);

        n.addArticle("Vinteren er tilbake");

        Reader r2 = new Reader();
        n.addObserver(r2);
    

        n.addArticle("Våren kommer nok snart");
    }
}

interface Observer {
    void update(Subject s, String title);
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String title);
}

class newsFeed implements Subject {

    ArrayList<Observer> observers = new ArrayList<Observer>();

    ArrayList<String> articles = new ArrayList<String>();

    public void addArticle(String header) {
        articles.add(header);
        notifyObservers(header);
    }
    public String getLastHeader() {
        return articles.getLast();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers(String title) {
        for(Observer o: observers) {
            o.update(this, title);
        }
    }
}

class Reader implements Observer {
    @Override
    public void update(Subject s, String header) {
        newsFeed n = (newsFeed)s;

        System.out.println("Ny artikkel: " + header);
    }
}