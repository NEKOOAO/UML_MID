package window.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modes.mode_list;
import window.button_group;

public class button extends JButton {
    public button(mode_list mode,button_group button_group,String image_path){
        super();
        setIcon(new ImageIcon(image_path));
        //setText(mode.name());
        setPreferredSize(new Dimension(100, 100));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_group.push_button(mode);
            }
        });
    }
}
