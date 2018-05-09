package ch07.poker;

public abstract class Card {
    private Point point;
    private Flower flower;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    abstract int getPoints();
}
