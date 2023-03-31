import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Client extends Thread{

    String name;
    CompletableFuture cf;

    public Client(String name,CompletableFuture cf) {
        this.name = name;
        this.cf=cf;

    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    cf.complete("Pizza pentru "+name+" este gata!");

    }
}
