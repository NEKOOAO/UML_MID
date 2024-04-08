package modes;

import java.awt.Point;
import java.util.ArrayList;

import window.canva;

public class mode_controller {
    ArrayList<Basemode> mode_array =new ArrayList<>() ;
    int now_mode_id;
    canva canva;
    public mode_controller(){
    }
    public void init(canva canva){
        this.canva = canva;
        create_mode();
        change_mode(mode_list.select_mode);
    }
    private void create_mode(){
        mode_array .add(new create_mode_class(canva));
        mode_array .add(new create_mode_usecase(canva));
        mode_array .add(new select_mode(canva));
        mode_array .add(new line_mode_assoc(canva));
        mode_array .add(new line_mode_comp(canva));
        mode_array .add(new line_mode_gen(canva));
    }
    public void change_mode(mode_list to_mode){
        mode_array.get(now_mode_id).deactivate();
        now_mode_id = to_mode.ordinal();
    }
    public void click(Point now){
        mode_array.get(now_mode_id).click(now);
    }
    public void drag(Point start, Point end){
        mode_array.get(now_mode_id).drag(start, end);
    }
    public void release(Point end) {
        mode_array.get(now_mode_id).release(end);
   }
}
