/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_grade;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CrJ
 */
public class Student_Grade extends JFrame {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
   
        // TODO code application logic here
    private static final long serialVersionUID = 1L;
	Container c;
	JTable tb;
	JLabel no_of_grades,as,bs,cs,ds,es,fs;
	String data[] = { "Name", "Grade" ,"total"};
	DefaultTableModel tm = new DefaultTableModel(data, 0);
	Vector<String> name = new Vector<String>();
	Vector<String> grades = new Vector<String>();
        public Student_Grade(){
            
            super("Final Grade Calculator");
            
            c = getContentPane();
            c.setLayout(null);
            setBounds(400, 400, 400, 400);
            tb = new JTable(tm);
            no_of_grades  = new JLabel("total no of grades is:");
            as =  new JLabel("As = ");
            bs =  new JLabel("Bs = ");
            JScrollPane sp = new JScrollPane(tb);
            
            sp.setBounds(40, 45, 555, 430);
            no_of_grades.setBounds(170, 380, 35, 30);
            as.setBounds(180, 480, 30  , 30);
            bs.setBounds(180, 480, 25, 30);
            
            c.add(tb);
            c.add(no_of_grades);
            c.add(as);
            c.add(bs);
        
        }
    
    
    
    public void parsetext() throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Grades"));
        int HW1;
        int HW2;
        int HW3;
        int Midterm;
        int Project;
        int Final;
        int As = 0, Bs = 0, Cs = 0, Ds = 0, Es = 0;
        String[] students = new String[30];
        int i = 0;
        while (sc.hasNextLine()) {

            students[i] = sc.nextLine();
            System.out.println(students[i]);
            i++;
        }
        sc.close();
        i = 0;

        // for (int j = 0; j < students.length; j++) {
        while (i < students.length) {
            HW1 = 0;
            HW2 = 0;
            HW3 = 0;
            Midterm = 0;
            Project = 0;
            Final = 0;
            System.out.println("");
            String student = students[i];
            String nam = "";

            String[] total = student.split(",");
            double NumericGrade = 0;
            String Grade = "";
            //    System.out.println(animalsArray[2]);
            nam = total[0];
            name.add(nam);
            HW1 = Integer.parseInt(total[1]);
            HW2 = Integer.parseInt(total[2]);
            HW3 = Integer.parseInt(total[3]);
            Midterm = Integer.parseInt(total[4]);
            Project = Integer.parseInt(total[5]);
            Final = Integer.parseInt(total[6]);

            NumericGrade = (0.45 * ((HW1 + HW2 + HW3) / 3)) + (.25 * Project) + ((.30 * (Midterm + Final) / 2));

            //System.out.println(NumericGrade);
            if (NumericGrade <= 100 && NumericGrade >= 90) {
                Grade = "A";
                    grades.add(Grade);
                    
            } else if (NumericGrade <= 89 && NumericGrade >= 80) {

                Grade = "B";
                    grades.add(Grade);

            } else if (NumericGrade <= 79 && NumericGrade >= 70) {

                Grade = "C";
                    grades.add(Grade);
            } else if (NumericGrade <= 69 && NumericGrade >= 60) {

                Grade = "D";
                    grades.add(Grade);

            } else if (NumericGrade >= 0 && NumericGrade <= 59) {

                Grade = "E";
                    grades.add(Grade);
            }   
            //System.out.format("%32s%16s", name, Grade);
            // System.out.println("Name = "+name +"       "+ Grade);

            switch (Grade) {

                case "A":
                    As++;
                    break;
                case "B":
                    Bs++;
                    break;
                case "C":
                    Cs++;
                    break;
                case "D":
                    Ds++;
                    break;
                case "E":
                    Es++;
                    break;
            }

            i++;

        }   
            for (int j = 0; j < name.size(); j++) {
            String[] ss = {name.elementAt(j),grades.elementAt(j)};
            
            tm.addRow(ss);
                System.out.println(grades);
            
            
        }
        
        
        
        
        System.out.println("");
        System.out.println("");
        System.out.print("A's=" + As);
        System.out.print(" B's= " + Bs);
        System.out.print(" C's= " + Cs);
        System.out.print(" D's= " + Ds);
        System.out.print(" E's= " + Es);
        System.out.println("");
    }

 public static void main(String[] args) throws FileNotFoundException {

     
            Student_Grade ss = new Student_Grade();
            ss.setVisible(true);
            ss.parsetext();
            ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 
 
 }



}
