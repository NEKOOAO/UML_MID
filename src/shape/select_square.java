package shape;

import java.awt.Graphics;
import java.awt.Point;

public class select_square extends move_object{
    Point endpoint;
    public select_square(Point pt) {
        super(pt);
    }

    public void update_end(Point pt){
        endpoint = pt;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(
        Math.min(pt.x,endpoint.x), 
        Math.min(pt.y,endpoint.y),
        Math.abs(endpoint.x-pt.x),
        Math.abs(endpoint.y-pt.y));
    }
    
}
