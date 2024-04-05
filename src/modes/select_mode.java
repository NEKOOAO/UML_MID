package modes;

import java.awt.Point;
import window.canva;

public class select_mode extends Basemode {
    canva canva;

    public select_mode (canva canva){
        this.canva = canva;
    }

    @Override
    public void click(Point now) {
        canva.select_object(now);
    }

    @Override
    public void drag(Point start, Point end) {
        canva.move_object(start, end);
   }
   @Override
   public void release(Point pt){
        canva.reset_action();
   }

    @Override
    public void activate() {
   }

    @Override
    public void deactivate() {
   }

}
