package modes;

import java.awt.Point;

import shape.lines;

public class line_mode_comp extends line_mode{

    public line_mode_comp(window.canva canva) {
        super(canva);
    }

    @Override
    public void drag(Point start, Point end) {
        canva.draw_line(lines.composition_line, end);
    }
}
