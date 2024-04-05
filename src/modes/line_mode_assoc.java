package modes;

import java.awt.Point;

import shape.lines;

public class line_mode_assoc extends line_mode{

    public line_mode_assoc(window.canva canva) {
        super(canva);
    }

    @Override
    public void drag(Point start, Point end) {
        canva.draw_line(lines.association_line,  end);
    }
}
