package abstract_class_interface.thuc_hanh.animal_fruit;

import abstract_class_interface.thuc_hanh.animal_fruit.Fruit.Apple;
import abstract_class_interface.thuc_hanh.animal_fruit.Fruit.Fruit;
import abstract_class_interface.thuc_hanh.animal_fruit.Fruit.Orange;
import abstract_class_interface.thuc_hanh.animal_fruit.animal.Animal;
import abstract_class_interface.thuc_hanh.animal_fruit.animal.Chicken;
import abstract_class_interface.thuc_hanh.animal_fruit.edible.InterfaceEdible;
import abstract_class_interface.thuc_hanh.animal_fruit.animal.Tiger;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();

        for (Fruit fruit : fruits){
            System.out.println(fruit.howToEat());
        }

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken){
                InterfaceEdible interfaceEdible = (Chicken) animal;
                System.out.println(interfaceEdible.howToEat());
            }
        }
    }
}



