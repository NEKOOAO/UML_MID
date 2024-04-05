package modes;

import java.awt.Point;

import shape.lines;
import window.canva;

public abstract class line_mode extends Basemode  {
    canva canva;

    public line_mode (canva canva){
        this.canva = canva;
    }

    @Override
    public void click(Point now) {
    }

    @Override
    public void release(Point end) {
        canva.draw_line_with_obj( end);
   }
    @Override
    public void activate() {
   }

    @Override
    public void deactivate() {
   }

}
