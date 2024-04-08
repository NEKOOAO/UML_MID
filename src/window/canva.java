package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import shape.Group_obj;
import shape.baseline;
import shape.block_object;
import shape.draw_obj;
import shape.line_factory;
import shape.lines;
import shape.move_object;
import shape.shape_factory;
import shape.shapes;

public class canva extends JPanel{
    ArrayList<draw_obj> draw_object_arr,select_obj_arr;
    ArrayList<baseline>  line_arr;
    shape_factory shape_factory;
    line_factory line_factory;
    Graphics g ;
    draw_obj now_mov_obj;
    Point offset = null,select_starPoint = null;
    shape.select_square select_square;
    baseline now_line;
    
    block_object draw_obj_start;
    public canva(mouse_controller _Controller){
        addMouseListener(_Controller);
        addMouseMotionListener(_Controller);
        draw_object_arr = new ArrayList<>();
        line_factory = new line_factory();
        shape_factory = new shape_factory();
        select_obj_arr = new ArrayList<>();
        line_arr = new ArrayList<>();
    }
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i =  draw_object_arr.size()-1; i >=0; i--) {
            if(draw_object_arr.get(i).controlable)draw_object_arr.get(i).draw(g);   
        }
        for (baseline line : line_arr) {
            line.draw(g);
        }
        if(select_square!=null)select_square.draw(g);
    }
    public void create_object(shapes _shapes,Point pt){
        draw_object_arr.add(shape_factory.create_obj(_shapes, pt));
        repaint();
    }
    public void de_select_obj(){
        for (draw_obj now_object : draw_object_arr) {
            now_object.select_obj(false);
        }
        select_obj_arr.clear();
        repaint();
    }
    public void select_object(Point pt){
        de_select_obj();
        draw_obj now_obj = find_object(pt);
        if(now_obj!=null){
            now_obj.select_obj(true);
            select_obj_arr.add(now_obj);
        } 
        repaint();
    }
    public void draw_line(lines type,Point end){
        if(draw_obj_start==null)draw_obj_start = find_blockObj(end);
        if(draw_obj_start!=null && now_line==null){
            now_line = line_factory.create_line(type,draw_obj_start, end);
            line_arr.add(now_line);
        }
        if(now_line!=null){
            now_line.set_line_end(end);
        }
        repaint();
    }
    public void draw_line_with_obj(Point end){
        if(now_line!=null){
            block_object obj_end;
            obj_end = find_blockObj(end);
            if(obj_end!=null && obj_end!=draw_obj_start){
                now_line.set_end_port(obj_end.connect_port(end));
            }
            else{
                line_arr.remove(now_line);
            }
        }
        repaint();reset_action();
    }
    public void reset_action(){
        now_mov_obj = null;
        offset = null;
        select_starPoint = null;
        select_square = null;
        now_line = null;
        draw_obj_start = null;
        repaint();
    }
    public void move_object(Point start,Point end){
        if(now_mov_obj==null){
            now_mov_obj = find_object(start);
            if(now_mov_obj!=null)offset = new Point(end.x-now_mov_obj.pt.x,end.y-now_mov_obj.pt.y );
        }
        if(now_mov_obj!=null){
            end.x-=offset.x;
            end.y-=offset.y;
            now_mov_obj.move_obj(end);
           // obj_start.move_obj_vec(move_vec);
        }
        else{
            select_group(start, end);
        }
        repaint();
    }
    public void group(){
        if(select_obj_arr.size()<2){
            return;
        }
        Point left = new Point(select_obj_arr.get(0).pt),right = new Point(select_obj_arr.get(0).pt);
        for (draw_obj obj : select_obj_arr) {
            left.x = Math.min(left.x, obj.pt.x);
            left.y = Math.min(left.y, obj.pt.y);
            right.x = Math.max(right.x, obj.right_pt.x);
            right.y = Math.max(right.y, obj.right_pt.y);
        }
        draw_object_arr.add(new Group_obj(left,right, select_obj_arr));
        for (draw_obj obj : select_obj_arr) {
            obj.controlable = false;
        }
    }
    public void ungroup(){
        System.out.println(select_obj_arr.size());
        if(select_obj_arr.size()>=2)return;
        if(select_obj_arr.get(0) instanceof Group_obj){
            Group_obj group =(Group_obj) select_obj_arr.get(0);
            draw_object_arr.remove(group);
            for (draw_obj obj : group.group_member) {
                obj.controlable = true;
            }
            group.group_member.clear();
        }
    }

    public void change_name(){
        if(select_obj_arr.size() ==1 && select_obj_arr.get(0) instanceof block_object){
            JOptionPane optionPane = new JOptionPane();
            String new_name =  optionPane.showInputDialog(this, "input name");
            if(new_name != null ){
                ((block_object) select_obj_arr.get(0)).change_name(new_name);
                repaint();
            }
        }
    }

    private block_object find_blockObj(Point pt){
        for (draw_obj now_object : draw_object_arr) {
            if(now_object.isinblock(pt) &&  now_object instanceof block_object ){
                return (block_object)now_object;
            }
        }
        return null;
    }

    private void select_group(Point start,Point end){
        de_select_obj();
        if(select_starPoint == null){
            select_starPoint = end;
            select_square = new shape.select_square(end);
        }
        Point left_up = new Point(Math.min(start.x,end.x), Math.min(start.y,end.y));
        Point right_down = new Point(Math.max(start.x,end.x), Math.max(start.y,end.y));
        for (draw_obj obj : draw_object_arr) {
            if(obj.is_in_block(left_up, right_down)){
                obj.select_obj(true);
                select_obj_arr.add(obj);
            }
        }
        select_square.update_end(end);
        
    }
    private draw_obj find_object(Point pt){
        for (draw_obj now_object : draw_object_arr) {
            if(now_object.isinblock(pt)){
                return now_object;
            }
        }
        return null;
    }
}
