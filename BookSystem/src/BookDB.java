

public class BookDB {
    private int sNo;
    private String GroupBook;
    private String bookName;
    private String authorName;
    private int bookQty;
    private int bookQtyCopy;
    private String BorrowDate;
    private String ReturnDate;


    public BookDB(String sNo, String gBook, String nBook, String aBook, String qBook){


        this.sNo = Integer.parseInt(sNo);
        this.GroupBook = gBook;
        this.bookName = nBook;
        this.authorName = aBook;
        this.bookQty = Integer.parseInt(qBook);
        bookQtyCopy = this.bookQty;

    }
}
