package chapter01;

public record Apple(int weight, String color) {

    public Apple() {
        this(0, null);
    }
}
