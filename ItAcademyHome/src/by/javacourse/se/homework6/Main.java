package by.javacourse.se.homework6;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final Random RANDOM = new Random();
    private static AtomicBoolean stopFlag = new AtomicBoolean(true);
    private static int numberRobot = 5;

    public static void main(String[] args) {
        GeneralPartsList generalList = new GeneralPartsList();

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Producer(generalList));
        service.execute(new Consumer(generalList));
        service.execute(new Consumer(generalList));
        service.execute(new Consumer(generalList));
        service.shutdown();

    }

    static class Producer implements Runnable {
        GeneralPartsList generalList;

        public Producer(GeneralPartsList partsList) {
            this.generalList = partsList;
        }

        @Override
        public void run() {
            while (stopFlag.get()) {
                generalList.addPart(randomParts(RANDOM.nextInt(6)));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        GeneralPartsList generalList;
        LinkedList<PartOfRobot> localList;
        int counter = 0;

        public Consumer(GeneralPartsList partsList) {
            this.generalList = partsList;
            localList = new LinkedList<>();
        }

        @Override
        public void run() {
            while (stopFlag.get()) {

                if (counter == numberRobot) {
                    System.out.println(Thread.currentThread().getName() + " Победитель!!");
                    stopFlag.lazySet(false);
                }

                for (PartOfRobot part : PartOfRobot.values()) {
                    if (generalList.getPart(part) != null && !localList.contains(part)) {
                        localList.add(part);
                        System.out.println(Thread.currentThread().getName() + " забрал " + part);
                        System.out.println("Части робота " + ++counter + ": " + localList);
                    }
                }
                if (localList.size() == 6) {
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " создал робота " + counter);
                    localList.clear();
                }
            }
        }
    }

    public static PartOfRobot randomParts(int number) {
        for (PartOfRobot i : PartOfRobot.values()) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        return null;
    }
}
