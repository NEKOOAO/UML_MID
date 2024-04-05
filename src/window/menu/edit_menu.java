package window.menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class edit_menu extends JMenu{
    ArrayList<JMenuItem> opt_list ; 
    window.canva canva;
    
    public edit_menu(window.canva canva){
        super("edit");
        //setFont(new Font("Courier New", Font.BOLD, 15));
        opt_list = new ArrayList<>();
        create_item();
        this.canva = canva;
        for (JMenuItem item : opt_list) {
            add(item);
        }
    }
    private void create_item(){
        JMenuItem group_item = new JMenuItem("group");
        group_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                canva.group();
            }
        });
        opt_list.add(group_item);
        JMenuItem ungroup_item = new JMenuItem("ungroup");
        ungroup_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                canva.ungroup();
            }
        });
        opt_list.add(ungroup_item);
        JMenuItem newname_item = new JMenuItem("change object name");
        newname_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                canva.change_name();
            }
        });
        opt_list.add(newname_item);
    }
}
