package modes;

import java.awt.Point;

import shape.shapes;
import window.canva;

public class create_mode_class extends create_mode {
    public create_mode_class (canva canva){
        super(canva);
    }
    @Override
    public void click(Point now) {
        canva.create_object(shapes.class_object, now);
    }

    @Override
    public void drag(Point start, Point end) {
    }

    @Override
    public void activate() {
    }

    @Override
    public void deactivate() {
    }
    
}
