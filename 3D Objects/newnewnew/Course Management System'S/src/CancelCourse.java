
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class CancelCourse extends Course {


    public void CancelCourse() {
        boolean x = false;
        boolean y = false;



        String[] courseDetails = new String[14];

        if (coursePanel.equals("")) {
            JOptionPane.showMessageDialog(null, "ID cannot be empty.");
        } else {

            File f = new File("courses.txt");
            if (f.exists()) {

                try {
                    File temp = new File("temp.txt");
                    File course = new File("courses.txt");

                    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
                    BufferedReader br = new BufferedReader(new FileReader(course));

                    String record;

                    while ((record = br.readLine()) != null) {
                        y = true;
                        int counter = 0;
                        StringTokenizer st = new StringTokenizer(record, ",");

                        for (counter = 0; counter < 14; counter++) {
                            courseDetails[counter] = st.nextToken();
                        }

                        if (courseDetails[0].equals(coursePanel)) {
                            x = true;
                            courseDetails[13] = "false";
                        }
                        String data = courseDetails[0] + "," + courseDetails[1] + "," + courseDetails[2] + "," + courseDetails[3] + "," + courseDetails[4] + "," +
                                courseDetails[5] + "," + courseDetails[6] + "," + courseDetails[7] + "," + courseDetails[8] + "," + courseDetails[9]
                                + "," + courseDetails[10] + "," + courseDetails[11] + "," + courseDetails[12] + "," + courseDetails[13];


                        bw.write(data);
                        bw.flush();
                        bw.newLine();
                    }
                    br.close();
                    bw.close();

                    if (x && y) {
                        course.delete();
                        temp.renameTo(course);
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "course has been cancelled.");
                        System.out.println("Success");
                    }
                    if (!x) {
                        temp.delete();
                        JOptionPane.showMessageDialog(null, " ID didnt match.");
                    }

                } catch (IOException e) {
                    System.out.println("Error Occured");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error.");
            }

        }
    }

    public void setcancelCourse() {
        coursePanel.setLocationRelativeTo(coursePanel.getMostRecentFocusOwner());


    }
}

