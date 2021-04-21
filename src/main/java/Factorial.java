/*
    Поиск факториала
 */
import java.math.BigInteger;

public class Factorial implements Runnable, Subject{
    private long number;
    private QueuePrimeNumber queue;
    private Observer observer;
    private BigInteger factorial;
    private Thread thread;
    private long stackNumber;

    public Factorial(long number, QueuePrimeNumber queue, Observer observer) {
        this.number = number;
        this.queue = queue;
        this.observer = observer;
        factorial = BigInteger.ONE;
        thread = new Thread(this);
        thread.start();
    }

    /* Поиск факториала */
    @Override
    public void run() {
        sleep();
        if (!queue.isEmpty()) {
            stackNumber = queue.getPrimeNumberOfStack();
            LogFile.write("Из очереди взяли число - " + stackNumber);
            for (int i = 2; i <= number; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
                if (i == stackNumber) {
                    notifyObserver();
                    sleep();
                    if (!queue.isEmpty()) {
                        stackNumber = queue.getPrimeNumberOfStack();
                        LogFile.write("Из очереди взяли число - " + stackNumber);
                    }
                }
            }
        }
    }

    /* Получить текущий поток */
    public Thread getThread() {
        return thread;
    }
    /* Ждать пока в очередь будет добавленно новое простое число */
    private void sleep() {
        while (queue.isEmpty() && !queue.getState()) {
            try {
                LogFile.write("Поток ожидает появления следующего простого числа в очереди");
                synchronized (queue) {
                    queue.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* Найденный факториал добавляется в сумму */
    @Override
    public void notifyObserver() {
        LogFile.write("Отправили найденный факториал числа " + stackNumber + " - " + factorial);
        observer.updateSum(factorial);
    }
}
