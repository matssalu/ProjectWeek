package gui.Punt;

import java.util.Objects;

public class Punt implements Comparable<Punt> {

    private int X;
    private int Y;

    public Punt(int x, int y){
        setX(x);
        setY(y);
    }

    private void setX(int x) {
        this.X = x;
    }

    private void setY(int y) {
        this.Y = y;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return X == punt.X && Y == punt.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    public String toString(){
        return "(" + this.getX() + ", " + this.getY() + ")";
    }


    @Override
    public int compareTo(Punt o) {
        if(this.getY() > o.getY() && this.getX() > o.getX()) return 1;
        if(this.getY() < o.getY() && this.getX() < o.getX()) return -1;
        return 0;
    }

}
