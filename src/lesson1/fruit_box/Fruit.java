package lesson1.fruit_box;

public abstract class Fruit {
    private float weight;

    Fruit(float weight) {
        this.weight = weight;
    }

    float getWeight() {
        return this.weight;
    }
}
