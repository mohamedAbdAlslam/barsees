
package barsees;

public class Stone {
    public int x;
    public boolean on_Board;
    public Stone(int x , boolean on_Board )
    {
    this.x=x;
    this.on_Board=on_Board;
  
    }

    public int getX() {
        return x;
    }

    public boolean isOn_Board() {
        return on_Board;
    }
      @Override
    public String toString() {
        return "Position{x=" + x + ", y=" + on_Board + "}";
    }
    
}
