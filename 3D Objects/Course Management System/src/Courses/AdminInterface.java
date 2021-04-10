package Courses;

import java.util.Scanner;

public class AdminInterface {
    private String firstName;
    private String lastName;
    private int gradeYear;


    public AdminInterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter the last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - level_4\n2 - level_5\n3 -level_6\nEnter the student level: ");
        this.gradeYear = in.nextInt();
        System.out.println(firstName+ " " + lastName+ " "+gradeYear);

    }

}
