
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Assignment extends JFrame {
    static String dbUser = "root";
    static String dbPass = "";

    static final String url = "jdbc:mysql://localhost/";

    public Assignment() {
        setVisible(true);
        setMinimumSize(new Dimension(600, 600));
        setTitle("Course Registration System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();


        //      STUDENTS FUNCTIONS

        JFrame frame2 = new JFrame();
        frame2.setLayout(new GridLayout(0, 2));
        JButton btn2 = new JButton("Student");
        btn2.setPreferredSize(new Dimension(190, 90));
        panel.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Student student = new Student();
                student.setStudent(true);
            }
        });

//        ADMINISTRATOR FUNCTIONS
        JFrame frame1 = new JFrame();
        frame1.setLayout(new GridLayout(0, 3));
        JButton btn1 = new JButton("Course Administrator");
        btn1.setPreferredSize(new Dimension(190, 90));
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin administrator = new Admin();
                administrator.setAdministrator(true);
            }
        });


//        INSTRUCTOR FUNCTIONS
        JFrame frame3 = new JFrame();
        frame3.setLayout(new GridLayout(0, 2));
        JButton btn3 = new JButton("Instructor");
        btn3.setPreferredSize(new Dimension(190, 90));
        panel.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instructor instructor = new Instructor();
                instructor.setInstructor(true);
            }
        });
        add(panel);
    }

    public static void main(String[] args) {




            new Assignment();
        }
    }
