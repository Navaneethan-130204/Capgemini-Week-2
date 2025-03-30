interface Worker {
    void performDuties();
}

class Persons {
    String name;
    int id;

    public Persons(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Persons implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        showInfo();
        System.out.println("Duties: Preparing meals and managing the kitchen.");
    }
}

class Waiter extends Persons implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        showInfo();
        System.out.println("Duties: Serving customers and taking orders.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101);
        Waiter waiter = new Waiter("Alice", 202);

        chef.performDuties();
        System.out.println();

        waiter.performDuties();
    }
}
