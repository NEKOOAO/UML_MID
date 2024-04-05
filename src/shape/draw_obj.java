package shape;

import java.awt.Point;

public abstract class draw_obj extends move_object {
    protected int heigth,length;
    boolean is_select = false;
    public Point right_pt;
    public draw_obj(Point pt,int hei,int len) {
        super(pt);
        heigth = hei;
        length = len;
        update_rightpt();
    }
    public void select_obj(boolean is_select){
        this.is_select = is_select;
    }
    public boolean isinblock(Point mouse_pt){
        double dx = mouse_pt.getX()-pt.getX();
        double dy = mouse_pt.getY()-pt.getY();
        if(dx>0 && dx < length&& dy >0 &&dy<heigth &&controlable){
            return true;
        }
        else{
            return false;
        }
    }
    public void move_obj(Point new_pt){
        super.move_obj(new_pt);
        update_rightpt();
    }
    protected boolean pt_in_block(Point now,Point left,Point right){
        if(
            left.x<now.x &&
            now.x<right.x &&
            left.y<now.y &&
            right.y>now.y&&
            controlable
        )
        {return true;}
        else 
        {return false;}
    }
    @Override
    public void move_obj_vec(Point vec) {
        super.move_obj_vec(vec);
        
    }
    private void update_rightpt(){
        right_pt = new Point(pt.x+length,pt.y+heigth);
    }
    public boolean is_in_block(Point left,Point right){
        if(
            pt_in_block(pt, left, right)&&
            pt_in_block(right_pt, left, right)&&
            controlable
        )
        {return true;}
        else {return false;}
    }
}
