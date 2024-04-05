package modes;

import java.awt.Point;

import shape.lines;

public class line_mode_gen extends line_mode{

    public line_mode_gen(window.canva canva) {
        super(canva);
    }

    @Override
    public void drag(Point start, Point end) {
        canva.draw_line(lines.generalization_line, end);
    }


}
