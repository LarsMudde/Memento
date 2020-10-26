package nl.showcase.memento.memento;

import java.util.ArrayList;

public class Caretaker {

    // This is where all the mementos are saved
    ArrayList<Memento> savedBurgers = new ArrayList<>();

    // Adds a memento to the ArrayList
    public void addMemento(Memento memento) {
        savedBurgers.add(memento);
    }

    // Gets the memento requested from the arraylist
    public Memento getMemento(int index) {
        return savedBurgers.get(index);
    }
}
