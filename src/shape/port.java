package shape;

import java.awt.Graphics;
import java.awt.Point;

public class port extends move_object{

    int port_len = 10;
    public port(Point pt,int port_len) {
        super(pt);
        this.port_len = port_len;
        port_adj();
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(pt.x, pt.y, port_len, port_len);
    }

    @Override
    public void move_obj(Point new_pt){
        super.move_obj(new_pt);
        port_adj();
    }

    public Point get_point(){
        return pt;
    }

    private void port_adj(){
        pt.x-=port_len/2;
        pt.y-=port_len/2;
    }
    
}
