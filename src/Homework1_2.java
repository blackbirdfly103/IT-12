public class Homework1_2 {
    public static void main(String[] args) {
        Duck duck = new Duck(2, "Male", "yellow");
        Fish fish = new Fish(1, "Female", 3, true);
        Zebra zebra = new Zebra(4, "Male", true);

        System.out.println(duck);
        duck.swim();
        duck.quack();

        System.out.println(fish);

        System.out.println(zebra);
        zebra.run();
    }
}

class Animal {
    protected int age;
    protected String gender;

    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public boolean isMammal() {
        return !(this instanceof Fish);
    }

    public void mate() {
        System.out.println("This " + this.getClass().getSimpleName() + " is mating.");
    }

    @Override
    public String toString() {
        return "Age: " + age + ", Gender: " + gender;
    }
}


class Duck extends Animal {
    private String beakColor = "yellow";

    public Duck(int age, String gender, String beakColor) {
        super(age, gender);
        if (beakColor != null) {
            this.beakColor = beakColor;
        }
    }

    public void swim() {
        System.out.println("Duck is swimming.");
    }

    public void quack() {
        System.out.println("Duck is quacking.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Beak Color: " + beakColor;
    }
}

class Fish extends Animal {
    private int sizeInFt;
    private boolean canEat;

    public Fish(int age, String gender, int sizeInFt, boolean canEat) {
        super(age, gender);
        this.sizeInFt = sizeInFt;
        this.canEat = canEat;
    }

    private void swim() {
        System.out.println("Fish is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Size in Ft: " + sizeInFt + ", Can Eat: " + canEat;
    }
}


class Zebra extends Animal {
    private boolean isWild;

    public Zebra(int age, String gender, boolean isWild) {
        super(age, gender);
        this.isWild = isWild;
    }

    public void run() {
        System.out.println("Zebra is running.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Is Wild: " + isWild;
    }
}
