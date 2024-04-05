package window;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modes.mode_controller;

public class mouse_controller implements MouseListener,MouseMotionListener{
    boolean can_operate_canva = false,is_drag = false;
    Point start_point,end_point;
    double click_max_distance = 10;
    mode_controller _mode_controller;
    public mouse_controller(mode_controller mode_controller){
        start_point = new Point();
        end_point = new Point();
        _mode_controller = mode_controller;
    }


    private boolean is_click(){
        double move_distance = Math.abs(start_point.getX()-end_point.getX())+Math.abs(start_point.getY()-end_point.getY());
        return move_distance<click_max_distance;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start_point.setLocation(e.getX(), e.getY());
        if(is_drag)return;
        _mode_controller.click(new Point(start_point));
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        end_point.setLocation(e.getX(), e.getY());
        _mode_controller.release(end_point);
        is_drag = false;    
    }
    


    @Override
    public void mouseEntered(MouseEvent e) {
        can_operate_canva = true;
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        can_operate_canva = false;
  }


    @Override
    public void mouseDragged(MouseEvent e) {
        is_drag = true  ;
        end_point.setLocation(e.getX(), e.getY());
        _mode_controller.drag(new Point(start_point),new Point( end_point));
        can_operate_canva = true;
    }


    @Override
    public void mouseMoved(MouseEvent e) {
  }
    
}
