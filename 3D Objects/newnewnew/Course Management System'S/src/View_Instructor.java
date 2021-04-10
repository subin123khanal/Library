
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.security.PrivilegedAction;

class View_Instructor<T> extends JFrame
{
    JTabbedPane jtp1=new JTabbedPane();
    JPanel jp1=new JPanel();
    JTextArea t1=new JTextArea();
    private PrivilegedAction<T> tPrivilegedAction;


    View_Instructor() throws Exception
    {
        super("Instructor_Viewer");
        FileReader f=new FileReader("Instructor.txt");
        BufferedReader brk=new BufferedReader(f);
        String s;
        while((s=brk.readLine())!=null){
            t1.append(s);
        }
        jp1.add(t1);
        jtp1.addTab("Tab1",t1);
        add(jtp1);
        t1.setSize(400,400);
        jp1.setPreferredSize(new Dimension(410, 50));
    }
    public static void main(String args[]) throws Exception
    {
        View_Instructor sv1=new View_Instructor();
        sv1.pack();
        sv1.setVisible(true);
        sv1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    public void setView_Instructor() {
        setVisible(true);
    }
}