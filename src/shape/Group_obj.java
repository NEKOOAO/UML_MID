package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Group_obj extends draw_obj{
    public ArrayList <draw_obj> group_member;
    Point move_vec;
    int length,heigth;
    public Group_obj(Point left,Point right,ArrayList<draw_obj> obj_list) {
        super(left, right.y - left.y,right.x - left.x);
        group_member = new ArrayList<>();
        for (draw_obj move_object : obj_list) {
            group_member.add(move_object);
        }
    }

    @Override
    public void move_obj(Point new_pt) {
        move_vec = new Point(new_pt.x-pt.x, new_pt.y-pt.y);
        super.move_obj(new_pt);
        for (move_object obj : group_member) {
            obj.move_obj_vec(move_vec);
        }
    }
    @Override
    public void draw(Graphics g) {
        for (move_object obj : group_member) {
            obj.draw(g);
        }
    }    
    @Override
    public void select_obj(boolean is_select) {
        super.select_obj(is_select);
        for (draw_obj obj : group_member) {
            obj.select_obj(is_select);
        }
    }

    
}
