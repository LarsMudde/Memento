package nl.showcase.memento.memento;

import nl.showcase.memento.domain.Burger;

public class Originator {
    private Burger burger;

    // Sets the value for the Burger
    public void set(Burger newBurger) {
        this.burger = newBurger;
    }

    // Creates a new memento with the new object in it
    public Memento storeInMemento(){
        return new Memento(burger);
    }

    public Burger restoreFromMemento(Memento memento) {
        burger = memento.getSavedBurger();
        return burger;
    }
}
