import java.util.Scanner;
public class Staff {


    String staffName;
    String regNum;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Staff(String staffName, String regNum) {
        this.staffName = staffName;
        this.regNum = regNum;
    }

    public Staff(){

        System.out.println("Enter Staff Name:");
        this.staffName = input.nextLine();

        System.out.println("Enter Reg Number:");
        this.regNum = input.nextLine();


    }
}