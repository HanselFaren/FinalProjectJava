package pkgfinal.project;
import java.util.*;
import java.io.*;

// menu class
public class Employee{
    public void menu(){
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\n\nPress 1 : Add Employee");
        System.out.println("Press 2 : Employee Details ");
        System.out.println("Press 3 : Remove an Employee");
        System.out.println("Press 4 : Update Employee");
        System.out.println("Press 5 : Quit");
    }
}

// add Employee class
class Employee_Add{
    public void CreateFile(){
        Scanner sc=new Scanner(System.in);
        
        EmployeeDetail emp=new EmployeeDetail();
        emp.getInfo();
        try{
            File fl=new File("file"+emp.employee_id+".txt");
            if(fl.createNewFile()){
                FileWriter Writing = new FileWriter("file"+emp.employee_id+".txt");
                Writing.write("Employee ID:"+emp.employee_id+"\n"+"Employee Name     :"+emp.name+"\n"+
                "Father's name     :"+emp.employee_father+"\n"+"Employee Contact  :"+emp.employee_contact+
                "\n"+"Email Information :"+emp.email+"\n"+"Employee position :"+emp.position+"\n"+
                "Employee Salary   :"+emp.employee_salary);
                Writing.close();
                System.out.println("\nEmployee has been Added :)\n");

                System.out.print("\n Enter to Continue");
                sc.nextLine();
            }
            else {
                System.out.println("\nEmployee already available :(");
                System.out.print("\nEnter to Continue");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}

// Employee detail class
class EmployeeDetail{
    String name;
    String email;
    String position;
    String employee_id;
    String employee_salary;
    String employee_contact;
    String employee_father;
    public void getInfo(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee's name       : ");
        name = sc.nextLine();
        System.out.print("Enter Father's name         : ");
        employee_father = sc.nextLine();
        System.out.print("Enter Employee's ID         : ");
        employee_id = sc.nextLine();
        System.out.print("Enter Employee's Email ID   : ");
        email = sc.nextLine();
        System.out.print("Enter Employee's Position   : ");
        position = sc.nextLine();
        System.out.print("Enter Employee contact Info : ");
        employee_contact = sc.nextLine();
        System.out.print("Enter Employee's Salary     : ");
        employee_salary = sc.nextLine();
    }
}

// preview Employee class
class Employee_Show{
    public void viewFile(String s) throws Exception{
        File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }
    }
}

// delete Employee class
class Employee_Remove{
    public void removeFile(String ID){

        File file = new File("file"+ID+".txt");
        if(file.exists())
        {
            if(file.delete());
            {
                System.out.println("\nEmployee has been removed Successfully");
            }
        }else{
            System.out.println("\nEmployee does not exists :( ");
        }
    }
}

// update Employee class
class Employee_Update{
    public void updateFile(String s,String o,String n) throws IOException
    {
        File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file);
        String FileContext="";
        while (sc.hasNextLine())
            {
                FileContext =FileContext+"\n"+sc.nextLine();
            }
        FileWriter Writing = new FileWriter("file"+s+".txt");
        FileContext = FileContext.replaceAll(o,n);
        Writing.write(FileContext);
        Writing.close();
    }
}

// Exit program class
class CodeExit{
    public void out(){
    System.out.println("\n*****************************************");
    System.out.println("Thanks for Using us");
    System.out.println("*****************************************");
    System.exit(0);
    }
}