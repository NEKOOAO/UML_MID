package shape;

import java.awt.Point;

public class line_factory {
    public baseline create_line(lines type,block_object start_obj,Point start){
        port start_port,end_port;
        start_port = start_obj.connect_port(start);
        switch (type) {
            case association_line:
                return new association_line(start_port);
            case generalization_line:
                return new generalization_line(start_port);
            case composition_line:
                return new composition_line(start_port);
            default:
                break;
        }
        return null;
    }
}
