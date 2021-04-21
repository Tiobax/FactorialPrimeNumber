/*
    QueuePrimeNumber - класс-монитор содержащий очередь простых чисел queuePrimeNumber
    Заполнение элементов происходит из потока класса PrimeNumber
    Поток класса Factorial забирает элементы из очереди
    Флаг queueFinalized (false - в очередь еще возможно будут добавлены новые элементы,
                         true - в очередь больше не будут добавляться новые элементы)
 */
import java.util.Deque;
import java.util.LinkedList;

public class QueuePrimeNumber {
    private Deque<Long> queuePrimeNumber;
    private boolean queueFinalized;

    public QueuePrimeNumber() {
        queuePrimeNumber = new LinkedList<>();
        queueFinalized = false;
    }

    /* Проверка на пустую очередь */
    public synchronized boolean isEmpty() {
        if (queuePrimeNumber.isEmpty()) return true;
        else return false;
    }

    /* Получение первого элемента очереди */
    public synchronized Long getPrimeNumberOfStack() {
        return queuePrimeNumber.pollFirst();
    }

    /* Добавление элемента в конец очереди */
    public synchronized  void addPrimeNumberToStack(Long number) {
        queuePrimeNumber.addLast(number);
        LogFile.write("В очередь добавленно новое простое число - " + number);
    }

    /* Получение статуса очереди (закончена или еще в процессе заполнения) */
    public boolean getState() {
        return queueFinalized;
    }

    /* Установка статуса очереди (очередь закончена, больше элементы добавляться не будут) */
    public void setState() {
        queueFinalized = true;
    }
}
