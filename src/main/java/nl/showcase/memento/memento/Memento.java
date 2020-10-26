package nl.showcase.memento.memento;

import nl.showcase.memento.domain.Burger;

public class Memento {

    // The burger stored in the Memento object
    private Burger burger;

    // Save a new burger to the memento object
    public Memento(Burger burgerSave) {
        burger = burgerSave;
    }

    // Return the value stored in burger
    public Burger getSavedBurger() {
        return burger;
    }
}
