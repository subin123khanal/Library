

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    JFrame frame = new JFrame();
    public Admin(){
        setLayout(new GridLayout(2, 2));
        setVisible(true);
        setMinimumSize(new Dimension(300, 200));
        setTitle("Course Registration System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();



        JFrame frame12 = new JFrame();
        frame12.setLayout(new GridLayout(0, 2));
        JButton btn21 = new JButton("AssignModule");
        btn21.setMinimumSize(new Dimension(100,100));
        panel.add(btn21);
        btn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AssignModule assignModule = new AssignModule();
                assignModule.setModuleAssign(true);
            }


        });
        JFrame frame13 = new JFrame();
        frame13.setLayout(new GridLayout(0, 2));
        JButton btn22 = new JButton("Course information");
        btn22.setMinimumSize(new Dimension(100,100));
        panel.add(btn22);
        btn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Course assignModule = new Course();
                assignModule.setModuleAssign(true);
            }


        });

        JFrame frame14 = new JFrame();
        frame14.setLayout(new GridLayout(0, 2));
        JButton btn23 = new JButton("Module");
        btn23.setMinimumSize(new Dimension(100,100));
        panel.add(btn23);
        btn23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Modules module = new Modules();
                module.setModuleAssign(true);
            }



        });
        add(panel);

    }


    public static void main(String [] args){

        new Admin();
    }

    public void setAdministrator(boolean b){


    }
}
