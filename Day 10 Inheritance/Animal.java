class Animals {
    String name;
    int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Animals give sound.");
    }
}

class Dog extends Animals {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog Barks");
    }
}

class Cat extends Animals {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat meow");
    }
}

class Bird extends Animals {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Bird chirp");
    }
}

public class Animal {

    public static void main(String[] args) {

        Animals dog = new Dog("Jimmy", 5);
        Animals cat = new Cat("Tom", 4);
        Animals bird = new Bird("Tuttu", 2);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}