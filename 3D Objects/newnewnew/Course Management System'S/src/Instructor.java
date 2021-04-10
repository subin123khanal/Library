



import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Instructor extends JFrame {
    JFrame frame3 = new JFrame();

    public Instructor() {
        frame3.setLayout(new GridLayout(0, 2));
        frame3.setVisible(true);
        frame3.setMinimumSize(new Dimension(400, 400));
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Instructor's Functions");
        frame3.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {

        new Instructor();
    }

    public void setInstructor(boolean b) {
        //Menu Bar
        JMenuBar menu_Bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menu_Bar.add(fileMenu);
        menu_Bar.add(editMenu);
        menu_Bar.add(helpMenu);




        JPanel Table = new JPanel();
        Table.setBorder(new TitledBorder("Instructor details"));
        Table.setLayout(new GridLayout(0, 1));
        JTable table = new JTable();
        Object[] columnName = {"Instructor name", "Module", "Module ID"};
        Object[] Data = {
                "Subin", "Java", 9999
        };
        Object[] Data1 = {
                "Subash", "python", 9801
        };
        Object[] Data2 = {
                "Sangam", "C++", 9851
        };
        DefaultTableModel tableModel = new DefaultTableModel(100, 3);
        tableModel.insertRow(0, Data);
        tableModel.insertRow(1, Data1);
        tableModel.insertRow(2, Data2);
        tableModel.setColumnIdentifiers(columnName);
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        Table.add(scrollPane);
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);

        frame3.add(Table);
        //Adding info, file-as form and buttons in JPanel

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        //Info form
        JPanel info = new JPanel();
        info.setBorder(new TitledBorder("form:"));
        info.setLayout(new GridLayout(4, 2));
        info.add(new JLabel("Instructor Name"));
        JTextField nameText = new JTextField();
        info.add(nameText);
        info.add(new JLabel("Module"));
        JTextField MnameText = new JTextField();
        info.add(MnameText);
        JTextField IDText = new JTextField();
        info.add(new JLabel("Module ID"));
        info.add(IDText);


        // Action of mouse listener in jtable
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Table cell selected!!");
                int rowNo = table.getSelectedRow();
                System.out.println("ROW NO:" + rowNo);
                System.out.println(table.getValueAt(rowNo, 0));
                System.out.println(table.getValueAt(rowNo, 1));
                System.out.println(table.getValueAt(rowNo, 2));

                nameText.setText(table.getValueAt(rowNo, 0).toString());
                MnameText.setText(table.getValueAt(rowNo, 1).toString());
                IDText.setText(table.getValueAt(rowNo, 2).toString());



            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });



        //Inserting menu item for File
        JMenuItem subExit = new JMenuItem("Exit");
        fileMenu.add(subExit);
        //subExit.addActionListener(new Main.subExit());

        //Inserting menu item for Edit
        //Adding subClear...
        JMenuItem subClear = new JMenuItem("Clear");
        editMenu.add(subClear);
        subClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameText.getText().isEmpty() && MnameText.getText().isEmpty() && IDText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame3, "There must be some data in table to clear.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                nameText.setText(null);
                MnameText.setText(null);
                IDText.setText(null);

            }
        });
        //Adding subSearch...
        JMenuItem subSearch = new JMenuItem("Search");
        editMenu.add(subSearch);
        subSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame3, "Search functionality will be supported in the professional version");
            }
        });

        editMenu.addSeparator();//Using separator between Search and Add
        //Adding subAdd...
        JMenuItem subAdd = new JMenuItem("Add");
        editMenu.add(subAdd);
        subAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = nameText.getText().trim();
                String sname = MnameText.getText().trim();
                int Phone = Integer.parseInt(IDText.getText());
                try {

                    if (nameText.getText().trim().isEmpty() || MnameText.getText().trim().isEmpty() || IDText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame3, "Please fill up the form completely....", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame3, "Inserted records are added in the table....", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(nameText.getText());
                        System.out.println(MnameText.getText());
                        System.out.println(IDText.getText());
                        String type = null;

                        System.out.println(type);
                        Object[] rowData = {
                                nameText.getText(),
                                MnameText.getText(),
                                IDText.getText(),
                                null
                        };
                        tableModel.insertRow(3, rowData);
                        subClear.doClick();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame3, "Please enter number in phone number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //Adding subRemove...
        JMenuItem subRemove = new JMenuItem("Remove");
        editMenu.add(subRemove);
        subRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getting tableModel from table
                DefaultTableModel tableModel1 = (DefaultTableModel) table.getModel();
                //delete Row
                if (table.getSelectedRowCount() == 1) {
                    //if single row is selected than delete
                    tableModel1.removeRow(table.getSelectedRow());
                } else {
                    //if no data is inserted in the table then to display message
                    if (table.getSelectedRowCount() == 0) {
                        JOptionPane.showMessageDialog(frame3, "Table is Empty");
                    }
                    //if multiples rows are selected
                    else {
                        JOptionPane.showMessageDialog(frame3, "Please select single row to delete", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        frame3.setJMenuBar(menu_Bar);
        //Inserting menu item for Help
        //Adding subAbout in Help menu
        JMenuItem subAbout = new JMenuItem("About");
        helpMenu.add(subAbout);
        subAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame3, "It is still in trial version!!");
            }
        });
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        subExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        subAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        subSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));
        subRemove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        subClear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        subAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
        //Button groups
        JPanel button = new JPanel();
        button.setLayout(new GridLayout(2, 2));

        //CLEAR BUTTON
        //Set inserted data to empty in info form
        JButton clearbutton = new JButton("Clear");
        button.add(clearbutton);
        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameText.getText().isEmpty() && MnameText.getText().isEmpty() && IDText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame3, "There must be some data in table to clear.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                nameText.setText(null);
                MnameText.setText(null);
                IDText.setText(null);

                JOptionPane.showMessageDialog(frame3, "Records are cleared...");
            }
        });
        //viewstudent BUTTON
        JButton view = new JButton("View Student");
        button.add(view);
        //To display message while search button is clicked.
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

                        File inputFile = new File("java.txt");
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
        //marks

        JButton Marks = new JButton("Student Marks");
        button.add(Marks);
        setTitle("student Marks");

        //To display message while search button is clicked.
        Marks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentMarks marks = null;
                try {
                    marks = new StudentMarks();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                marks.setStudentMarks();

                JOptionPane.showMessageDialog(Marks,"Please view_student and add Student_id and Marks.....");

            }

        });



        //ADD BUTTON
        //To add data into the table through info form
        JButton Add_details = new JButton("Add");
        button.add(Add_details);
        Add_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText().trim();
                String Mname = MnameText.getText().trim();
                String id = IDText.getText().trim();


                String type = null;
                try {

                    if (nameText.getText().trim().isEmpty() || MnameText.getText().trim().isEmpty() || IDText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame3, "Please fill up the form completely....", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame3, "records are added in the table and saved into file....", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(nameText.getText());
                        System.out.println(MnameText.getText());
                        System.out.println(IDText.getText());
                        type = null;

//
                        System.out.println(type);
                        Object[] rowData = {
                                nameText.getText(),
                                MnameText.getText(),
                                IDText.getText(),
                                type
                        };
                        tableModel.insertRow(3, rowData);
                        clearbutton.doClick();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame3, "Please enter number in phone number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (e.getSource() == Add_details) {
                    try {
                        FileWriter fw = new FileWriter("Instructor.txt", true);
                        fw.write(name + " ");
                        fw.write(Mname + " ");
                        fw.write(id + " ");
                        fw.write("\n");
                        fw.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        //REMOVE BUTTON
        //To remove selected records from the table
        JButton remove = new JButton("Remove");
        button.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getting tableModel from table
                DefaultTableModel tableModel1 = (DefaultTableModel) table.getModel();
                //delete Row
                if (table.getSelectedRowCount() == 1) {
                    //if single row is selected than delete
                    tableModel1.removeRow(table.getSelectedRow());
                } else {
                    //if no data is inserted in the table then to display message
                    if (table.getSelectedRowCount() == 0) {
                        JOptionPane.showMessageDialog(frame3, "Table is Empty");
                    }
                    //if multiples rows are selected
                    else {
                        JOptionPane.showMessageDialog(frame3, "Please select single row to delete", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        panel.add(info);
        panel.add(button);
        frame3.add(panel);
        frame3.pack();

        frame3.setVisible(true);
    }
}