import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercitiul2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String userName=scanner.nextLine();
        while(!userName.equals("exit")){
            commandPush(userName);
            userName=scanner.nextLine();
        }
    }
    static void commandPush(String name){
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("Comanda pentru " + name + " a fost preluata!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        completableFuture.thenRunAsync(()->{
            System.out.println("Pizza pentru "+name+" este gata. Poate fi trimisa spre livrare");
        });
    }
}