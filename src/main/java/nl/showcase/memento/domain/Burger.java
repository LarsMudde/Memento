package nl.showcase.memento.domain;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Burger {

    private List<String> ingredients = new ArrayList<>();
    private String name;

    private Burger() {
    }

    private Burger(Burger origin) {
        this.name = origin.name;
        this.ingredients.addAll(origin.ingredients);
    }

    public static Burger forName(String name) {
        Assert.hasText(name, "name is obligated!");
        Burger burger = new Burger();
        burger.name = name;
        return burger;
    }

    public Burger changeName(String newName) {
        Burger burger = new Burger(this);
        burger.name = newName;
        return burger;
    }

    public Burger addIngredient(String ingredient) {
        Burger burger = new Burger(this);
        burger.ingredients.add(ingredient);
        return burger;
    }


    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
