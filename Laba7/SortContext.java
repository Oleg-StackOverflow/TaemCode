package Laba7;

public class SortContext {
    private SortingStrategy strategy;

    public SortContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(short[] array) {
        System.out.println("Використовуєтся: " + strategy.getClass().getSimpleName());
        strategy.sort(array);
    }
}

