package shape;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public abstract class move_object {
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    public Point pt;
    public boolean controlable;
    public move_object(Point pt){
        controlable = true;
        this.pt = pt;
    }
    public abstract void draw(Graphics g);
    public void move_obj(Point new_pt){
        pt = new_pt;
    }   
     public void move_obj_vec(Point vec){
        Point new_pt = new Point(pt.x+vec.x, vec.y+pt.y);
        move_obj(new_pt);
    }

}
