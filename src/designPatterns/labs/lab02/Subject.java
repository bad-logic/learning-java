package designPatterns.labs.lab02;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
