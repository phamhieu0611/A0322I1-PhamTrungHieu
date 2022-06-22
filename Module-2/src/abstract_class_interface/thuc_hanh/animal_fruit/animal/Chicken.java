package abstract_class_interface.thuc_hanh.animal_fruit.animal;

import abstract_class_interface.thuc_hanh.animal_fruit.edible.InterfaceEdible;

public class Chicken extends Animal implements InterfaceEdible {
    @Override
    public String makeSound() {
        return "Chicken: I was in alpha?";
    }

    @Override
    public String howToEat() {
        return "Could be fried.";
    }
}
