package window.menu;

import java.awt.Dimension;

import javax.swing.JMenuBar;

import window.canva;

public class menu_bar  extends JMenuBar{
    edit_menu edit_menu ;
    public menu_bar(canva canva){
        edit_menu = new edit_menu(canva);
        add(edit_menu);
        //setPreferredSize(new Dimension(120, 28));
    }
}
