

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

public class Student extends JFrame {


    public static void main(String[] args) {
        new Student();
    }

    JLabel l2, l3, l6, l7, l9, l10,l11,l12,l13,l14;

    JTextField tf2, tf3, tf5, tf6;

    JTextArea area2, area1;




    public Student() {


        setTitle("Student's Functions");
        setLocationRelativeTo(null);
        setVisible(true);
        setMinimumSize(new Dimension(800,600));
        l2 = new JLabel("Name of the Student:");
        l2.setBounds(50, 50, 250, 20);

        tf2 = new JTextField();
        tf2.setBounds(220, 50, 250, 20);

        l3 = new JLabel(
                "Student id:");
        l3.setBounds(50, 100, 250, 20);

        tf3 = new JTextField();
        tf3.setBounds(220, 100, 250, 20);

        l6 = new JLabel("Contact Number:");
        l6.setBounds(50, 150, 250, 20);

        tf5 = new JTextField();
        tf5.setBounds(220, 150, 250, 20);

        l7 = new JLabel("Address:");
        l7.setBounds(50, 200, 250, 10);

        area1 = new JTextArea();
        area1.setBounds(220, 200, 250, 45);

        l9 = new JLabel("Gender:");
        l9.setBounds(50, 250, 250, 20);

        JRadioButton r5
                = new JRadioButton(" Male");
        JRadioButton r6
                = new JRadioButton(" Female");

        r5.setBounds(220, 250, 100, 30);
        r6.setBounds(320, 250, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r5);
        bg.add(r6);

        l10 = new JLabel("Nationality:");
        l10.setBounds(50, 300, 100, 20);

        tf6 = new JTextField();
        tf6.setBounds(220, 300, 100, 20);


        l11 = new JLabel("<<<<<Choose Modules>>>>>");
        l11.setBounds(100,340,200,20);

        l12 = new JLabel("level 4/5 modules choose||");
        l12.setBounds(50,380,200,20);

        JRadioButton rb5 = new JRadioButton();
        rb5.setText("Level 4");
        rb5.setBounds(50,430,70,25);

        JRadioButton rb6 = new JRadioButton();
        rb6.setText("Level 5");
        rb6.setBounds(50,460,70,25);







        l13 = new JLabel("level_6 modules choose");
        l13.setBounds(210,380,190,20);

        JRadioButton sem1 = new JRadioButton();
        sem1.setText("Sem_5");
        sem1.setBounds(180,420,65,20);

        final DefaultListModel<String> li2 = new DefaultListModel<>();
        li2.addElement("JAVA");
        li2.addElement("Python");

        final JList<String> list2
                = new JList<>(li2);
        list2.setBounds(180, 440,70 , 40);

        final DefaultListModel<String> li3 = new DefaultListModel<>();
        li3.addElement("JAVA");
        li3.addElement("Python");

        final JList<String> list3
                = new JList<>(li3);

        list3.setBounds(180, 490,70 , 40);

        JRadioButton sem2 = new JRadioButton();
        sem2.setBounds(260,420,65,20);
        sem2.setText("Sem_6");

        final DefaultListModel<String> li4 = new DefaultListModel<>();
        li4.addElement("C++");
        li4.addElement("Database");

        final JList<String> list4
                = new JList<>(li4);
        list4.setBounds(260, 440,80 , 40);

        final DefaultListModel<String> li5 = new DefaultListModel<>();
        li5.addElement("Programming");
        li5.addElement("MATHmatices");

        final JList<String> list5
                = new JList<>(li5);

        list5.setBounds(260, 490,80 , 40);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rb5);
        bg2.add(rb6);
        bg2.add(sem1);
        bg2.add(sem2);




        final JLabel label = new JLabel();
        label.setBounds(600, 330, 500, 30);

        final JLabel label1 = new JLabel();

        JButton view = new JButton("ViewTeacher");
        view.setBounds(680,50,120,20);

        l14 = new JLabel("<<<choose course>>>");
        l14.setBounds(550,50,150,25);

        JButton B = new JButton("Show");
        B.setBounds(690, 100, 80, 30);

        JButton c = new JButton("show");
        c.setBounds(50,500,80,30);




        final DefaultListModel<String> li1 = new DefaultListModel<>();


        li1.addElement("BBA");
        li1.addElement("BIT");
        li1.addElement("BIM");

        final JList<String> list1
                = new JList<>(li1);

        list1.setBounds(550, 75, 125, 125);

        JButton Receipt = new JButton("Generate Receipt");
        Receipt.setBounds(490, 250, 150, 30);


        JButton b2 = new JButton("Reset");
        b2.setBounds(640, 250, 80, 30);

        JButton b4 = new JButton("Delete");
        b4.setBounds(715,250,80,30);



        area2 = new JTextArea();
        area2.setBounds(350, 290, 450, 320);


        add(l2);
        add(l3);
        add(l6);
        add(l7);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(tf3);
        add(tf2);
        add(tf5);
        add(tf6);
        add(area1);
        add(area2);
        add(rb5);
        add(rb6);
        add(r5);
        add(r6);
        add(list1);
        add(list2);
        add(list3);
        add(list4);
        add(list5);
        add(B);
        add(c);
        add(view);
        add(label);
        add(label1);
        add(Receipt);
        add(b2);
        add(b4);
        add(sem1);
        add(sem2);

        c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String datas = "";
                if(rb5.isSelected()){
                    datas = tf2.getText()+" "+"you choose module "+"are"+" "+ "c++,c,python,java"+"(level 4)\n";
                }
                if(rb6.isSelected()){
                    datas =tf2.getText()+" "+"you choose module "+"are"+" "+ "java1,python2,c__3,php"+"(level 5)\n";
                }
                if(sem1.isSelected()){
                    datas =tf2.getText()+" "+"you choose module "+"are"+" "+ list2.getSelectedValue()+","+list3.getSelectedValue()+"(sem_5)\n";
                }
                if(sem2.isSelected()){
                    datas =tf2.getText()+" "+"you choose module "+"are"+" "+ list4.getSelectedValue()+","+list5.getSelectedValue()+"(sem_6)\n";
                }



                label1.setText((datas));
                label1.setBounds(0,470,300,150);


                if(e.getSource() ==c){
                    try{
                        FileWriter FW = new FileWriter("Student's.txt", true);
                        FW.write(label1.getText());
                        FW.close();


                    } catch (Exception ae) {
                        System.out.println(ae);;
                    }

                }
                JOptionPane.showMessageDialog(
                        label1, "DATA SAVED SUCCESSFULLY");


            }


        });

        B.addActionListener(new ActionListener() {

            // Method to display the data
            // entered in the text fields
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (list1.getSelectedIndex() != -1) {
                    data = "You had selected Course is:" + list1.getSelectedValue();
                    label.setText(data);
                }
                label.setText(data);
                label.setBounds(550, 210, 250, 20);
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    InputStream istream;
                    OutputStream ostream;
                    int c;
                    final int EOF = -1;
                    ostream = System.out;
                    try {

                        File inputFile = new File("Instructor.txt");
                        istream = new FileInputStream(inputFile);
                        try {
                            while ((c = istream.read()) != EOF)
                                ostream.write(c);
                        } catch (IOException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        } finally {
                            try {
                                istream.close();
                                ostream.close();
                            } catch (IOException ioException) {
                                System.out.println("File did not close");
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                        System.exit(1);
                    }


                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(view,"Please see Console.............");

            }
        });

        // Reset the text fields

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(
                    ActionEvent e) {
                area1.setText(" ");
                tf3.setText("");
                tf2.setText("");
                tf5.setText("");
                tf6.setText(" ");


            }
        });

        //delete button
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    FileReader reader = new FileReader("java.txt");
                    reader.skip(8);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });




        // Generating the receipt


        Receipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                area2.setText(
                        "--------------------------------"
                                + "-----------Student Information----"
                                + "--------------------------"
                                + "--------------------------"
                                + "-------------------\n");

                area2.setText(area2.getText()
                        + "Student Name"

                        + tf2.getText()+" \n "
                );
                area2.setText(area2.getText()
                        + "Student_ID: "
                        + tf3.getText()+"\n"
                );
                area2.setText(area2.getText()
                        + "Contact Number: "
                        + tf5.getText()
                        + "\n");
                area2.setText(area2.getText()
                        + "Address: "
                        + area1.getText()
                        + "\n");
                area2.setText(area2.getText()
                        +"gender:"
                        + l9.getText()
                        + "\n");
                area2.setText(area2.getText()
                        + "Nationality: "
                        + tf6.getText()
                        + "\n");

                bg2.toString();
                area2.setText(area2.getText()+
                        label1.getText()+ "\n"
                );



                area2.setText(area2.getText()
                        + "Had chosen course: "
                        + list1.getSelectedValue()
                        + "\n");

                int index1 = list1.getSelectedIndex();
                if (index1 == 0) {
                    area2.setText(area2.getText()
                            + "                    "
                            + "Total amount of this course to be "
                            + "paid is 4 Lakhs   \n");
                }

                if (index1 == 1) {
                    area2.setText(area2.getText()
                            + "                    "
                            + "Total amount to be paid "
                            + "is 3.9 Lakhs   \n");
                }

                if (index1 == 2) {
                    area2.setText(area2.getText()
                            + "                    "
                            + "Total amount to be paid "
                            + "is 3.8 Lakhs   \n");
                }

                if (e.getSource() == Receipt) {
                    try {


                        FileWriter fw = new FileWriter("java.txt", true);
                        fw.write(area2.getText());
                        fw.close();



                    } catch (Exception ae) {
                        System.out.println(ae);
                    }


                }
                if (e.getSource() == Receipt) {
                    if (e.getSource() == Receipt) {
                        try {


                            FileWriter fw = new FileWriter("studentMarks.txt", true);
                            fw.write(tf2.getText());
                            fw.close();



                        } catch (Exception ae) {
                            System.out.println(ae);
                        }


                    }


                }

                JOptionPane.showMessageDialog(
                        area2, "DATA SAVED SUCCESSFULLY");





            }



        });


        setSize(800, 600);
        setLayout(null);
        setVisible(true);
        setBackground(Color.cyan);


    }



    public void setStudent(boolean b) {



    }


}