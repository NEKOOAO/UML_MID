package shape;

import java.awt.Point;

public class shape_factory {

    public block_object create_obj(shapes type,Point pt){
        switch (type) {
            case class_object:
                return new class_object(pt);
            case use_case_object:
                return new use_case_object(pt);
            default:
                break;
        }
        return null;
    }
    
}
