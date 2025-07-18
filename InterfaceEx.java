interface Animal {
    void eat();

    void sleep();

    int val1 = 120;
    int val2 = 120;
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating");
        int val1 = 100; // local variable has higher preference
        // val2 = 200; this will cause a compile-time error
        System.out.println(val1);
        System.out.println(val2);
    }

    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

class InterfaceEx {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}
