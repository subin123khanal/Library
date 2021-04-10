

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;


public class Course {
    JFrame coursePanel = new JFrame();
    public Course(){



        coursePanel.setMinimumSize(new Dimension(600, 600));
        coursePanel.setTitle("Course Information");
        coursePanel.setLocationRelativeTo(null);
        coursePanel.setLayout(new GridLayout(2, 2));

        JTable course_table = new JTable();
        JPanel course_frame = new JPanel();
        DefaultTableModel tableModel = new DefaultTableModel();
        course_frame.setLayout(new GridLayout(0, 2));
        JPanel course = new JPanel();
        course.setLayout(new GridLayout(8, 2));
        course.add(new JLabel("Course ID"));
        JTextField CourseIdText = new JTextField();
        course.add(CourseIdText);
        course.add(new JLabel("Course Name"));
        JTextField CourseNameText = new JTextField();
        course.add(CourseNameText);
        course.add(new JLabel("Fee"));
        String [] Level= {"5,00,000(BBA)", "6,00,000(BIT)", "7,00,000(BIM)" };
        JComboBox level_sel = new JComboBox(Level);
        course.add(level_sel);
        course_frame.add(course);

        JPanel Course_button = new JPanel();
        Course_button.setLayout(new GridLayout(2, 2));

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CourseIdText.getText().isEmpty() && CourseNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(coursePanel, "No data to clear.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    CourseIdText.setText(null);
                    CourseNameText.setText(null);
                }
            }
        });

        JButton add_course = new JButton("Add Course");
        Course_button.add(add_course);
        add_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Course_name = CourseNameText.getText().trim();
                String Level = level_sel.getSelectedItem().toString();
                String id = CourseIdText.getText().trim();
                try {
                    int Course_id = Integer.parseInt(CourseIdText.getText());
                    if (CourseIdText.getText().isEmpty() || CourseNameText.getText().isEmpty() || Level.isEmpty()) {
                        JOptionPane.showMessageDialog(coursePanel, "Please fill the form completely...", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(coursePanel, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(CourseIdText.getText());
                        System.out.println(CourseNameText.getText());
                        System.out.println(Level);

                        Object[] rowData = {
                                CourseIdText.getText(),
                                CourseNameText.getText(),
                                Level
                        };
                        tableModel.addRow(rowData);
                        clear.doClick();
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(coursePanel, "ERROR... Please Fill correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (e.getSource() == add_course) {
                    try {
                        FileWriter fw = new FileWriter("Course.txt", true);
                        fw.write(id + " ");
                        fw.write(Course_name + " ");
                        fw.write(Level + " ");
                        fw.write("\n");
                        fw.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

            }
        });


        JButton Cancel_course = new JButton("Cancel course");
        Course_button.add(Cancel_course);
        Cancel_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelCourse cancelcourse = new CancelCourse();
                cancelcourse.setcancelCourse();

            }
        });


        JButton delete_Course = new JButton("Delete Course");
        Course_button.add(delete_Course);
        delete_Course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete Row
                if (course_table.getSelectedRowCount() == 1) {
                    tableModel.removeRow(course_table.getSelectedRow());
                    JOptionPane.showMessageDialog(coursePanel, "Data from selected row is deleted.");
                }
                else {
                    if (course_table.getSelectedRowCount() == 0) {
                        JOptionPane.showMessageDialog(coursePanel, "Table is Empty");
                    }
                    else {
                        JOptionPane.showMessageDialog(coursePanel, "Please select single row to delete", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                clear.doClick();


            }
        });


        JButton edit_course = new JButton("Edit Module");
        Course_button.add(edit_course);
        course_table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = course_table.getSelectedRow();
                try{
                    CourseIdText.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    CourseNameText.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    level_sel.setSelectedItem(tableModel.getValueAt(selectedRow, 2).toString());

                }catch(NullPointerException exception){
                    System.out.println("NullPointerException thrown!!!");
                }
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
        edit_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = course_table.getSelectedRow();
                String Module_name = CourseNameText.getText().trim();
                String Level = level_sel.getSelectedItem().toString();
                try {
                    int Module_id = Integer.parseInt(CourseIdText.getText());
                    if (CourseIdText.getText().trim().isEmpty() || CourseNameText.getText().trim().isEmpty() || Level.isEmpty()) {
                        JOptionPane.showMessageDialog(coursePanel, "Please fill up the form completely....", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.setValueAt(Module_id,selectedRow,0);
                        tableModel.setValueAt(Module_name,selectedRow,1);
                        tableModel.setValueAt(Level, selectedRow, 2);
                        JOptionPane.showMessageDialog(coursePanel, "Updated successfully!!!", "Information", JOptionPane.INFORMATION_MESSAGE);

                        clear.doClick();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(coursePanel, "ERROR... Please Fill correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        course_frame.add(Course_button);
        coursePanel.add(course_frame);


        JPanel Table = new JPanel();
        Table.setLayout(new BorderLayout());
        Table.setBorder(new TitledBorder("Course Information"));
        Table.setLayout(new GridLayout(0, 1));
        Object[] columnName = {"Course ID", "Course Name", "Fee"};
        tableModel.setColumnIdentifiers(columnName);
        course_table.setModel(tableModel);
        JScrollPane pane = new JScrollPane(course_table);
        Table.add(pane);
        course_table.setFillsViewportHeight(true);
        course_table.setDefaultEditor(Object.class, null);
        coursePanel.add(Table);
    }

    public static void main(String[] args){

        new Course();
    }

    public void setModuleAssign(boolean b) {

        coursePanel.setVisible(true);
    }
}

