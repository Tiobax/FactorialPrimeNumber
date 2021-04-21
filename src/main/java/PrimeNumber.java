/*
    Класс создает поток для нахождения всех простых чисел в промежутке [2, number] и записывает их в очередь queue,
    после чего будит поток класса Factorial
 */
import java.util.ArrayList;

public class PrimeNumber implements Runnable {
    private final long number;
    private QueuePrimeNumber queue;
    private ArrayList<Long> arrayPrimeNumber;
    private Thread thread;

    public PrimeNumber(long number, QueuePrimeNumber queue) {
        this.number = number;
        this.queue = queue;
        arrayPrimeNumber = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }
    /* Поиск простых чисел в промежутке [2, number] и  запись их в очередь queue
       После нахождения всех простых чисел прмечает что очередь больше не будет заполняться */
    @Override
    public void run() {
        if (number > 1) {
            for (long i = 2; i <= number; i++) {
                boolean isPrimeNumber = true;
                if (i > 1) {
                    for (Long foundPrimeNumber:arrayPrimeNumber) {
                        if (foundPrimeNumber > 1 && i%foundPrimeNumber == 0) {
                            isPrimeNumber = false;
                            break;
                        }
                    }
                }
                if (isPrimeNumber) {
                    LogFile.write("Найдено простое число - " + i);
                    arrayPrimeNumber.add(i);
                    queue.addPrimeNumberToStack(i);
                    synchronized (queue) {
                        queue.notifyAll();
                    }
                    /* Имитация компа-тормоза */
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
        queue.setState();
        synchronized (queue) {
            queue.notifyAll();
        }
    }

    /* Получить текущий поток */
    public Thread getThread() {
        return thread;
    }

    /* Получить список простых чисел */
    public ArrayList<Long> getArrayPrimeNumber() {
        return arrayPrimeNumber;
    }

}
