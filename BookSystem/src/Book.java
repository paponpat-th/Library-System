import java.util.Scanner;
public class Book {

    public int sNo;
    public String GroupBook;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;
    public String BorrowDate;
    public String ReturnDate;

    Scanner input = new Scanner(System.in);

    public Book(String sNo, String gBook, String nBook, String aBook, String qBook,String qTotal,String bDate,String rDate){
        //System.out.println(sNo);

    if (sNo !=null){
        this.sNo = Integer.parseInt(sNo);
        this.GroupBook = gBook;
        this.bookName = nBook;
        this.authorName = aBook;
        this.bookQty = Integer.parseInt(qBook);
        this.bookQtyCopy = Integer.parseInt(qTotal);
        this.BorrowDate = bDate;
        this.ReturnDate = rDate;
    }else {

        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();
        System.out.println("Enter Group of Book:");
        this.GroupBook = input.nextLine();
        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();
        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }

    }

}