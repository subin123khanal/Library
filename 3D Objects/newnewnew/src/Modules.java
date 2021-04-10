


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.sql.SQLException;

public class Modules{

    static moduleDatabase reg = new moduleDatabase();
    static JTable module_table = new JTable();
    static String[] col_name = {"Module_Name", "M_Level", "Module_ID"};
    static Object[][] row = {};
    static DefaultTableModel tableModel = new DefaultTableModel(row, col_name);
    JFrame modulePanel = new JFrame();


    public Modules(){




        modulePanel.setMinimumSize(new Dimension(600, 600));
        modulePanel.setTitle("Module Information");
        modulePanel.setLocationRelativeTo(null);
        modulePanel.setLayout(new GridLayout(2, 2));


        JPanel module_frame = new JPanel();
        module_frame.setLayout(new GridLayout(0, 2));
        JPanel module = new JPanel();
        module.setLayout(new GridLayout(8, 2));
        module.add(new JLabel("Module ID"));
        JTextField ModuleIdText = new JTextField();
        module.add(ModuleIdText);
        module.add(new JLabel("Module Name"));
        JTextField ModuleNameText = new JTextField();
        module.add(ModuleNameText);
        module.add(new JLabel("Level"));
        String [] Level= {"Level 4", "Level 5", "Level 6" };
        JComboBox level_sel = new JComboBox(Level);
        module.add(level_sel);
        module_frame.add(module);

        JPanel module_button = new JPanel();
        module_button.setLayout(new GridLayout(2, 2));

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ModuleIdText.getText().isEmpty() && ModuleNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(modulePanel, "No data to clear.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    ModuleIdText.setText(null);
                    ModuleNameText.setText(null);
                }
            }
        });

        JButton add_module = new JButton("Add Module");
        module_button.add(add_module);
        add_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Module_name = ModuleNameText.getText().trim();
                String Level = level_sel.getSelectedItem().toString();
                int Module_id = Integer.parseInt(ModuleIdText.getText());

                try {

                    if (ModuleIdText.getText().isEmpty() || ModuleNameText.getText().isEmpty() || Level.isEmpty()) {
                        JOptionPane.showMessageDialog(modulePanel, "Please fill the form completely...", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(modulePanel, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(ModuleIdText.getText());
                        System.out.println(ModuleNameText.getText());
                        System.out.println(Level);

                        Object[] rowData = {
                                ModuleIdText.getText(),
                                ModuleNameText.getText(),
                                Level
                        };
                        tableModel.addRow(rowData);
                        clear.doClick();
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(modulePanel, "ERROR... Please Fill correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (e.getSource() == add_module) {
                    try {
                        FileWriter fw = new FileWriter("Module.txt", true);
                        fw.write(Module_id+" ");
                        fw.write(Module_name + " ");
                        fw.write(Level + " ");
                        fw.write("\n");
                        fw.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }

            }
        });


        JButton generate_report = new JButton("Generate Report Card");
        module_button.add(generate_report);
        generate_report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentMarkstoFile studentMarkstoFile = new StudentMarkstoFile();
                studentMarkstoFile.setStudentMarkstoFile();

            }
        });


        JButton delete_module = new JButton("Delete Module");
        module_button.add(delete_module);
        delete_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete Row
                if (module_table.getSelectedRowCount() == 1) {
                    tableModel.removeRow(module_table.getSelectedRow());
                    JOptionPane.showMessageDialog(modulePanel, "Data from selected row is deleted.");
                }
                else {
                    if (module_table.getSelectedRowCount() == 0) {
                        JOptionPane.showMessageDialog(modulePanel, "Table is Empty");
                    }
                    else {
                        JOptionPane.showMessageDialog(modulePanel, "Please select single row to delete", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                clear.doClick();
                try {
                    int Module_ID = Integer.parseInt(ModuleIdText.getText());
                    reg.delete(Module_ID);
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }

            }


        });


        JButton edit_module = new JButton("Update");
        module_button.add(edit_module);
        module_table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = module_table.getSelectedRow();
                try{
                    ModuleIdText.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    ModuleNameText.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    level_sel.setSelectedItem(tableModel.getValueAt(selectedRow, 2).toString());

                }catch(NullPointerException exception){
                    System.out.println("NullPointerException thrown!!!");
                }

                tableModel.getValueAt(selectedRow, 0);
                reg.update( ModuleIdText,ModuleNameText,level_sel);
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
        edit_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = module_table.getSelectedRow();
                String Module_name = ModuleNameText.getText().trim();
                String Level = level_sel.getSelectedItem().toString();
                try {
                    int Module_id = Integer.parseInt(ModuleIdText.getText());
                    if (ModuleIdText.getText().trim().isEmpty() || ModuleNameText.getText().trim().isEmpty() || Level.isEmpty()) {
                        JOptionPane.showMessageDialog(modulePanel, "Please fill up the form completely....", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.setValueAt(Module_id,selectedRow,0);
                        tableModel.setValueAt(Module_name,selectedRow,1);
                        tableModel.setValueAt(Level, selectedRow, 2);
                        JOptionPane.showMessageDialog(modulePanel, "Updated successfully!!!", "Information", JOptionPane.INFORMATION_MESSAGE);

                        clear.doClick();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(modulePanel, "ERROR... Please Fill correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        module_frame.add(module_button);
        modulePanel.add(module_frame);


        JPanel Table = new JPanel();
        Table.setLayout(new BorderLayout());
        Table.setBorder(new TitledBorder("Module Information"));
        Table.setLayout(new GridLayout(0, 1));
        Object[] columnName = {"Module ID", "Module Name", "Level"};
        tableModel.setColumnIdentifiers(columnName);
        module_table.setModel(tableModel);
        JScrollPane pane = new JScrollPane(module_table);
        Table.add(pane);
        module_table.setFillsViewportHeight(true);
        module_table.setDefaultEditor(Object.class, null);
        modulePanel.add(Table);
    }

    public static void main(String[] args){

        new Modules();
    }


    public void setModuleAssign(boolean b) {

        modulePanel.setVisible(true);
    }
}

