package nl.showcase.memento.infrastructure.interfaces;

import nl.showcase.memento.domain.Burger;
import nl.showcase.memento.service.BurgerMakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("burgermaker")
public class BurgerMakerController {

    private final BurgerMakerService burgerMakerService;

    public BurgerMakerController(BurgerMakerService burgerMakerService) {
        this.burgerMakerService = burgerMakerService;
    }

    @PutMapping("/ingredients/add/{ingredient}")
    public ResponseEntity<Burger> addIngredient(@PathVariable String ingredient) {
        Burger burger = burgerMakerService.getCurrentBurger();
        burger = burger.addIngredient(ingredient);
        return ResponseEntity.ok(burgerMakerService.setBurger(burger));
    }

    @PutMapping("/burger/{name}")
    public ResponseEntity<Burger> updateName(@PathVariable String name) {
        Burger burger = burgerMakerService.getCurrentBurger();
        burger = burger.changeName(name);
        return ResponseEntity.ok(burgerMakerService.setBurger(burger));
    }

    @PostMapping("/undo")
    public ResponseEntity<Burger> undo() {
        return ResponseEntity.ok(burgerMakerService.undo());
    }

    @PostMapping("/redo")
    public ResponseEntity<Burger> redo() {
        return ResponseEntity.ok(burgerMakerService.redo());
    }

    @GetMapping("/burger")
    public ResponseEntity<Burger> getCurrentBurger() {
        return ResponseEntity.ok(burgerMakerService.getCurrentBurger());
    }
}
