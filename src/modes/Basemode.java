package modes;

import java.awt.Point;

public abstract class Basemode {
    public abstract void click(Point now);
    public abstract void drag(Point start,Point end);
    public abstract void activate();
    public abstract void deactivate();
    public void release(Point end){};
}
