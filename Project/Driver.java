package pkgfinal.project;
import java.util.*;
import java.io.*;

public class Driver extends Employee{
    public static void main(String args[]){
        System.out.print("\033[H\033[2J"); //clear the screen

        Scanner sc=new Scanner(System.in);
        Employee_Show preview =new Employee_Show();

        int i=0;

        Employee obj1 = new Employee(); // calling the class function
        obj1.menu();

        while(i<6) // starting the loop
        {

            System.out.print("\nEnter choice :");
            i=Integer.parseInt(sc.nextLine());

            switch(i){ // to switch statements
                case 1:
                {
                    Employee_Add ep =new Employee_Add(); // calling the create class function and run the function
                    ep.CreateFile();

                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 2:
                {
                    System.out.print("\nEnter Employee's ID :");
                    String s=sc.nextLine();
                    try
                    {
                        preview.viewFile(s);}
                        catch(Exception e){System.out.println(e);}

                        System.out.print("\nEnter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.menu();
                        break;
                    }

                case 3:
                {
                    System.out.print("\nEnter Employee's ID :");
                    String s=sc.nextLine();
                    Employee_Remove remove =new Employee_Remove();
                    remove.removeFile(s);
     
                    System.out.print("\nEnter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 4:
                {
                    System.out.print("\nEnter Employee's ID :");
                    String I=sc.nextLine();
                    try
                    {
                        preview.viewFile(I);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    Employee_Update update = new Employee_Update();
                    System.out.print("Enter the detail you want to Update :");
                    System.out.print("\nExample :\n");
                    System.out.println("If you want to change the name, input the current name then enter. After that, input the name then press enter.\n");
                    String s=sc.nextLine();
                    System.out.print("Enter the Updated Info :");
                    String n=sc.nextLine();
                    try
                    {
                        update.updateFile(I,s,n);

                        System.out.print("\nEnter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.menu();
                        break;
                    }
                    catch(IOException e)
                    {
                        System.out.println(e);
                    }
                }
                case 5:
                {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
            }
        }
    }
}
