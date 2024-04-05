import modes.mode_controller;
import window.*;
import window.menu.menu_bar;

public class UML_controller {
    public UML_frame window;
    public canva _Canva;
    public mouse_controller _Mouse_controller;
    public mode_controller _Mode_controller;
    public button_group button_group;
    public menu_bar menu_bar;
    public UML_controller(){
        window = new UML_frame();
        _Mode_controller = new mode_controller();
        _Mouse_controller = new mouse_controller(_Mode_controller);
        _Canva = new canva(_Mouse_controller);
        button_group = new button_group();
        _Mode_controller.init(_Canva);
        menu_bar = new menu_bar(_Canva);
        window._canva = _Canva;
        window._button_group =  button_group ;
        window.menu_bar = menu_bar;
        button_group.mode_controller =_Mode_controller;
        
    }
    public void show_window(){
        window.show_window();
    }
    public static void main(String[] args) {
        UML_controller myUML = new UML_controller(); 
        myUML.show_window();

    }
}