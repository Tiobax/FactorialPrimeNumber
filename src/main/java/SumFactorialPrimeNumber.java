/*
    Поиск суммы факториалов простых чисел
*/
import java.math.BigInteger;

public class SumFactorialPrimeNumber implements Observer {
    private Observer observer;
    private long number;
    private BigInteger sum;
    private QueuePrimeNumber queue;
    private PrimeNumber primeNumber;
    private Thread primeNumberThread;
    private Factorial factorial;
    private Thread factorialThread;

    public SumFactorialPrimeNumber(long number) {
        observer = this;
        this.number = number;
        sum = BigInteger.ZERO;
        queue = new QueuePrimeNumber();
    }

    /* Возврат суммы факториалов простых чисел */
    public BigInteger getSumFactorialPrimeNumber () {
        LogFile.openFile();
        primeNumber = new PrimeNumber(number, queue);
        primeNumberThread = primeNumber.getThread();
        factorial = new Factorial(number, queue, observer);
        factorialThread = factorial.getThread();

        try {
            primeNumberThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LogFile.closeFile();
        return sum;
    }

    /* Обновление суммы */
    @Override
    public void updateSum(BigInteger value) {
        sum = sum.add(value);
    }
}
