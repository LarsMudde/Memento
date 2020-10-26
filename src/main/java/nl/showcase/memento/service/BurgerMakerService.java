package nl.showcase.memento.service;

import nl.showcase.memento.domain.Burger;
import nl.showcase.memento.memento.Caretaker;
import nl.showcase.memento.memento.Originator;
import org.springframework.stereotype.Service;

@Service
public class BurgerMakerService {

    private final Caretaker caretaker = new Caretaker();
    private final Originator originator = new Originator();

    private Burger burger = Burger.forName("newBurger");

    int savedBurgers = 0;
    int currentBurger = 0;

    public Burger setBurger(Burger updatedBurger) {
        // Set the value for the current memento
        originator.set(updatedBurger);

        // Add new burger to the careTaker
        caretaker.addMemento(originator.storeInMemento());

        savedBurgers++;
        currentBurger++;
        burger = updatedBurger;

        return burger;
    }

    public Burger undo() {
        // Verify there's something to Undo, otherwise just stop
        if(currentBurger >= 1) {
            // Decrement the current burger
            currentBurger--;

            // Get the previous burger
            burger = originator.restoreFromMemento(caretaker.getMemento(currentBurger));
        }
        return burger;
    }

    // Bonus
    public Burger redo() {
        if ((savedBurgers - 1) > currentBurger) {
            // Increment the current burger displayed
            currentBurger++;

            // Get the next burger
            burger = originator.restoreFromMemento(caretaker.getMemento(currentBurger));
            burger = originator.restoreFromMemento(caretaker.getMemento(currentBurger));
        }
        return burger;
    }

    // Also for fun
    public Burger getCurrentBurger() {
            return burger;
    }
}
