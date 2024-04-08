package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

import window.menu.menu_bar;

public class UML_frame extends JFrame{
    public button_group _button_group;
    public canva _canva;
    public menu_bar menu_bar;
    Container container;
    public UML_frame(){
        super("HelloWorldSwing");
        //JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        container = getContentPane();
    }
    void createAndShowGUI(){
        // 添加 "Hello World" 标签
        //JLabel label = new JLabel("Hello World");
       // getContentPane().add(label);

        container.add(_canva,BorderLayout.CENTER);
        container.add(_button_group.get_penel(),BorderLayout.WEST);
        setJMenuBar(menu_bar);
        setSize(1100,700);
        // 显示窗口
       // pack();
       setResizable(false);
        setVisible(true);
        //testing
        
    }
    public void show_window(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}