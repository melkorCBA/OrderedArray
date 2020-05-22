package ordarrayapp;
import java.util.Scanner;
import java.io.IOException;

public class OrdArrayApp {

  public static void clearSccreen(){
      try{
          new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
      catch(Exception E){
          System.out.println(E);
      }
  }

  public static void promptEnterKey(){
    System.out.println("\nPress \"ENTER\" to continue...");
    try {
        System.in.read(new byte[2]);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        
        OrdArray table21 = new OrdArray(100);
     
        /*NoDupArray table21=new NoDupArray(5);
        table21.insert(10);
        table21.insert(12);
        table21.insert(13);
        System.out.println(table21.find(12));
        System.out.println(table21.delete(13));
        table21.display();*/
        Scanner input = new Scanner(System.in);
        int menuIteam = 0;
       
        
        // System.out.println("\nMain menu");
        // System.out.println("1.Insert");
        // System.out.println("2.Delete");
        // System.out.println("3.Search");
        // System.out.println("4.Display");
        // System.out.println("5.Exit");
        clearSccreen();
        do{
            promptEnterKey();
            clearSccreen();
            System.out.println("\nMain menu");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Search");
            System.out.println("4.Display");
            System.out.println("5.Exit");
           
            System.out.println("\nPick a task");
            menuIteam=input.nextInt();
        switch (menuIteam) {

            case 1:
                System.out.println("Enter the new value");
                table21.insert(input.nextLong());
                break;
            case 2:
                System.out.println("Enter the Key to delete");
                System.out.println(table21.delete(input.nextLong()));
                break;
            case 3:
                System.out.println("Enter the Key to search");
                System.out.println(table21.findRecursive(input.nextLong(), 0, table21.size()-1,0));
                break;
            case 4:
                table21.display();
                break;
            case 5:
                menuIteam=0;
                break;

            default:
                System.err.println("Invalid menu iteam !!");
        }
       
        
        }while(menuIteam!=0);

       
        
        

        

    }

}
