package Main.Util;

public class Tuple<X, Y> {
    public X x;
    public Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    public void setX(X newX) {
        this.x = newX;
    }
    public void setY(Y newY) {
        this.y = newY;
    }
    public X getX() {
        return this.x;
    }
    public Y getY() {
        return this.y;
    }
}