

import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class StudentMarkstoFile extends JFrame {
    JFrame frame6 = new JFrame();

    public void Student(String l2,String[] l3,String[] teacherMod){
        String[] marks = new String[8];
        String data="";

        for(int i=0;i<8;i++){

            if(teacherMod[0].equals(l3[i])){
                try{
                    String m1 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[0]);
                    if(!m1.equals("")){
                        marks[i]=m1;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex1){

                }

            }
            else  if(teacherMod[1].equals(l3[i])){
                try{
                    String m2 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[1]);
                    if(!m2.equals("")){
                        marks[i]=m2;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex2){

                }
            }
            else  if(teacherMod[2].equals(l3[i])){
                try{
                    String m3 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[2]);
                    if(!m3.equals("")){
                        marks[i]=m3;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex3){

                }
            }
            else  if(teacherMod[3].equals(l3[i])){
                try{
                    String m4 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[3]);
                    if(!m4.equals("")){
                        marks[i]=m4;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex4){

                }
            }
            else{
                marks[i]="0";
            }

        }

        try{
            File file = new File("marks_of_students.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter("marks_of_students.txt",true);
            BufferedWriter br = new BufferedWriter(fw);
            data =l2+","+marks[0]+","+marks[1]+","+marks[2]+","+marks[3]+","+marks[4]+","+marks[5]+","+marks[6]+","+marks[7];
            br.write(data);
            br.flush();
            br.newLine();
            br.close();
            System.out.println("Success");
        }

        catch (IOException exp){
            System.out.println("Error Occured");
        }

    }



    public void marksForNextModules(String stuName,String[] stuSubs,String[] teacherMod){

        String[] marks = new String[8];
        String[] marksFromFile = new String[9];


        try{
            FileReader fr=new FileReader("marks_of_students.txt");
            BufferedReader br1=new BufferedReader(fr);

            String record;

            while ( (record=br1.readLine())!=null ){
                StringTokenizer st = new StringTokenizer(record,",");
                for(int i=0;i<9;i++){
                    marksFromFile[i]=st.nextToken();
                }
                if(marksFromFile[0].equals(stuName)){
                    break;
                }
            }
            br1.close();
        }

        catch (IOException e){
            System.out.println("Error in reading file");
        }


        String data="";


        for(int i=0;i<8;i++){

            if(teacherMod[0].equals(stuSubs[i]) && marksFromFile[i+1].equals("0")){
                try{
                    String m1 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[0]);
                    if(!m1.equals("")){
                        marks[i]=m1;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex1){

                }

            }
            else  if(teacherMod[1].equals(stuSubs[i]) && marksFromFile[i+1].equals("0")){
                try{
                    String m2 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[1]);
                    if(!m2.equals("")){
                        marks[i]=m2;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex2){

                }
            }
            else  if(teacherMod[2].equals(stuSubs[i]) && marksFromFile[i+1].equals("0")){
                try{
                    String m3 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[2]);
                    if(!m3.equals("")){
                        marks[i]=m3;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex3){

                }
            }
            else  if(teacherMod[3].equals(stuSubs[i]) && marksFromFile[i+1].equals("0")){
                try{
                    String m4 = JOptionPane.showInputDialog(null,"Enter mark for "+teacherMod[3]);
                    if(!m4.equals("")){
                        marks[i]=m4;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Marks cannot be empty.");
                    }
                }
                catch (NullPointerException ex4){

                }
            }
            else{
                marks[i]=marksFromFile[i+1];
            }

        }

        StudentMarkstoFile smtf = new StudentMarkstoFile();
        smtf.deleteRename(stuName,marks);

    }

    public  void deleteRename(String stuName,String[] marks){

        String[] courseDetails = new String[9];

        try {
            File tempMark = new File("java.txt");
            File mark = new File("studentMarks.txt");

            BufferedWriter bw = new BufferedWriter(new FileWriter(tempMark));
            BufferedReader br = new BufferedReader(new FileReader(mark));

            String record;

            while ((record = br.readLine()) != null) {
                int counter = 0;
                StringTokenizer st = new StringTokenizer(record, ",");

                for (counter = 0; counter < 9; counter++) {
                    courseDetails[counter] = st.nextToken();
                }

                String data;
                if (courseDetails[0].equals(stuName)) {

                    data = stuName+","+marks[0] + "," + marks[1] + "," + marks[2] + "," + marks[3] + "," + marks[4] + "," +
                            marks[5] + "," + marks[6] + "," + marks[7] ;
                }
                else{
                    data = courseDetails[0] + "," + courseDetails[1] + "," + courseDetails[2] + "," + courseDetails[3] + "," + courseDetails[4] + "," +
                            courseDetails[5] + "," + courseDetails[6] + "," + courseDetails[7] + "," + courseDetails[8];

                }

                bw.write(data);
                bw.flush();
                bw.newLine();

            }

            bw.close();
            br.close();

            mark.delete();
            tempMark.renameTo(mark);

        }

        catch (IOException ee) {
            System.out.println("Error Occured");
        }

    }

    public void setStudentMarkstoFile() {
        setVisible(true);

    }



}