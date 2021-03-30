package gui.Punt;

public class Punt {

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

    public boolean equals(Punt andere){
        if(this == andere) return true;
        return false;
    }

    public String toString(){
        return "(" + this.getX() + ", " + this.getY() + ")";
    }


}
