import java.io.IOException;
import java.util.Scanner;

public class Library {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("********************Welcome to the Grouplease Library!****************");
        System.out.println("              Please Select From The Following Options:               ");
        System.out.println("**********************************************************************");
        Books ob = new Books();
        Staffs obStaff = new Staffs();

        int choice;
        int searchChoice;

        do{

            ob.dispMenu();
            choice = input.nextInt();

            switch(choice){

                case 1:
                    Book b = new Book(null,null,null,null,null,null,null,null);
                    ob.addBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Enter 1 to Search with Serial No.");
                    System.out.println("Enter 2 to Search with Author Name.(Full Name)");
                    System.out.println("Enter 3 to Search with Group Book.(Full Name)");
                    System.out.println("Enter 4 to Search with Name Book.");
                    searchChoice = input.nextInt();

                    switch(searchChoice){

                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                            break;
                        case 3:
                            ob.searchByGroupBook();
                            break;
                        case 4:
                            ob.searchByNameBook();
                            break;
                    }
                    break;

                case 4:

                    ob.showAllBooks();
                    break;
                case 5:
                    Staff s = new Staff();
                    obStaff.addStaff(s);
                    break;
                case 6:
                    obStaff.showAllStaff();
                    break;
                case 7:
                    obStaff.BorrowBook(ob);
                    break;
                case 8:
                    obStaff.ReturnBook(ob);
                    break;
                case 9:
                    var rf = new ReadTxtFile();

                    String filename = "/Users/gl/Desktop/DB.txt";

                    try
                    {
                     rf.readLines(filename);

                    }
                    catch(IOException e)
                    {

                        System.out.println("Unable to create "+filename+": "+e.getMessage());
                    }
                   ob.showBook();
                    break;
                case 10:
                    ob.saveFile();
                    break;
                default:
                    System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

            }

        }
        while (choice!=0);
































    }

}