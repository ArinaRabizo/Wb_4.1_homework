

//Значения после завершения работы потоков будут меняться, потому что потоки работают асинхронно, и процессор выделяет
// ресурсы процессора на каждый из потоков каждый раз по-разному.

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread mythread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();


            }

        });

        Thread mythread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }

        });
            mythread.start();
            mythread1.start();

        try{
            mythread1.join();

       } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getValue());

    }
}
