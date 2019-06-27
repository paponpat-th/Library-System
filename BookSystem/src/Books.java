import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

import static java.lang.System.*;

public class Books {

    private static Book theBooks[] = new Book[10];     // Array that stores 'Book' Objects.
    //BookaBooks[]=new Book[50];
    public static int count;

    Scanner input = new Scanner(in);




    public int compareBookObjects(Book b1, Book b2){

        if (b1.bookName.equalsIgnoreCase(b2.bookName)){

            out.println("Book of this Name Already Exists.");
            return 0;

        }
        if (b1.sNo==b2.sNo){

            out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b){

        for (int i=0; i<count; i++){

            if (this.compareBookObjects(b, this.theBooks[i]) == 0)
                return;

        }

        if (count<50){

            theBooks[count] = b;
          // saveFile(b);
            count++;

        }
        else{

            out.println("No Space to Add More Books.");

        }

    }

    public  void saveFile( ) {
        String path = "/Users/gl/Desktop/DB.txt";

        File file = new File(path);
       PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        try {
            FileWriter writerTo = new FileWriter(file, true);
            for (int i = 0; i < theBooks.length; i++) {
                if (theBooks[i] != null) {
                    writerTo.write(Integer.toString(theBooks[i].sNo));
                    writerTo.write(",");
                    writerTo.write(theBooks[i].GroupBook);
                    writerTo.write(",");
                    writerTo.write(theBooks[i].bookName);
                    writerTo.write(",");
                    writerTo.write(theBooks[i].authorName);
                    writerTo.write(",");
                    writerTo.write(Integer.toString(theBooks[i].bookQty));
                    writerTo.write(",");
                    writerTo.write(Integer.toString(theBooks[i].bookQtyCopy));
                    writerTo.write(",");
                    writerTo.write(theBooks[i].BorrowDate);
                    writerTo.write(",");
                    writerTo.write(theBooks[i].ReturnDate);
                    writerTo.append('\n');

                }
            }
            writerTo.close();
            out.println("Save Completed");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
           /* try {
                FileWriter writer = new FileWriter(file,true);
                for (int i = 0; i < theBooks.length; i++) {
                    //for (int j = 0; j < theBooks[i].; j++) {
                        writer.write(theBooks[i]+" ";
                   // }
                    writer.write("\n");   // write new line
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/



     /*   File file = new File(path);

        FileWriter writer;

        try {

            writer = new FileWriter(file, true);
            writer.write(w.sNo);
            writer.write(",");
            writer.write(w.GroupBook);
            writer.write(",");
            writer.write(w.bookName);
            writer.write(",");
            writer.write(w.authorName);
            writer.write(",");
            writer.write(w.bookQty+"\r\n");

            writer.close();

            System.out.println("Write success!");

        } catch (IOException e) {


            e.printStackTrace();

        }*/
    }

  public void adDataBook(Book b){

       for (int i=0; i<count; i++){

           if (this.compareBookObjects(b, this.theBooks[i]) == 0)
               return;

       }

           if (count<50){
               //System.out.println("Start");
               theBooks[count] = b;
               count++;
               //new book(lines[0],lines[1],lines[2],lines[3],lines[4]);

           }




          // lines.clone(theBooks[0]);
      //System.out.println("add DB is completed");

   }
   public void showBook(){
       for (int i=0; i<count; i++) {
           // System.out.println(count);
           //System.out.println(theBooks[0].bookName);
           //if (count==1){
           // System.out.println(theBooks[0].bookName);
           //}else {
           //   count--;
           out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                   theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);
           // }


       }
   }

    public void searchBySno(){

        out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        int sNo;
        out.println("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        out.println("S.No\t\tName\t\tGroup Book\t\tAuthor\t\tAvailable Qty\t\tTotal Qty\t\tBorrow Date\t\tReturn Date");
        for (int i=0; i<count; i++){

            if (sNo == theBooks[i].sNo){

                out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);
                flag++;
                return;

            }

        }
        if (flag == 0)
            out.println("No Book for Serial No " + sNo + " Found.");

    }

    public void searchByAuthorName(){

        out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        out.println("Enter Author Name:");
        String authorName = input.nextLine();
        int flag = 0;
        out.println("S.No\t\tName\t\tGroup Book\t\tAuthor\t\tAvailable Qty\t\tTotal Qty\t\tBorrow Date\t\tReturn Date");
        for (int i=0; i<count; i++){


            if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

                out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);
                flag++;
            }


        }
        if (flag == 0)
            out.println("No Books of " + authorName + " Found.");

    }


    public void searchByGroupBook(){

        out.println("\t\t\t\tSEARCH BY GROUP BOOK");
        //input.nextLine();
        out.println("Enter Group BookName:");
        String Groupname = input.nextLine();
        int flag = 0;
        out.println("S.No\t\tName\t\tGroup Book\t\tAuthor\t\tAvailable Qty\t\tTotal Qty\t\tBorrow Date\t\tReturn Date");
        for (int i=0; i<count; i++){

            if (Groupname.equalsIgnoreCase(theBooks[i].GroupBook)){

                out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);
                flag++;
            }

        }
        if (flag == 0)
            out.println("No Books of " + Groupname + " Found.");

    }
    public void searchByNameBook(){

        out.println("\t\t\t\tSEARCH BY Name BOOK");
        //input.nextLine();
        out.println("Enter Book Name:");
        String name = input.nextLine();
        int flag = 0;
        out.println("S.No\t\tName\t\tGroup Book\t\tAuthor\t\tAvailable Qty\t\tTotal Qty\t\tBorrow Date\t\tReturn Date");
        for (int i=0; i<count; i++){
            String s= theBooks[i].bookName;
           // System.out.println(s);
            if (s.indexOf(name)>=0){
                out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);
                flag++;
            }

        }
        if (flag == 0)
            out.println("No Books of " + name + " Found.");

    }
    public void showAllBooks(){

        out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        out.println("S.No\t\tName\t\tGroup Book\t\tAuthor\t\tAvailable Qty\t\tTotal Qty\t\tBorrow Date\t\tReturn Date");
        //System.out.println(count);
       // System.out.println(theBooks.length);
        for (int i=0; i<count; i++){

            out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t"+ theBooks[i].GroupBook + "\t\t" + theBooks[i].authorName + "\t\t" +
                    theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty + "\t\t" + theBooks[i].BorrowDate + "\t\t" + theBooks[i].ReturnDate);


        }


    }

    public void upgradeBookQty(){

        out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        out.println("Enter Serial No of Book");
        int sNo = input.nextInt();
        for (int i=0; i<count; i++){

            if (sNo == theBooks[i].sNo){

                out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;

            }

        }

    }


    public void dispMenu(){

        out.println("----------------------------------------------------------------------------------------------------------");
        out.println("Enter 0 to Exit Application.");
        out.println("Enter 1 to Add new Book.");
        out.println("Enter 2 to Upgrade Quantity of a Book.");
        out.println("Enter 3 to Search a Book.");
        out.println("Enter 4 to Show All Books.");
        out.println("Enter 5 to Register Staff.");
        out.println("Enter 6 to Show All Registered Staffs.");
        out.println("Enter 7 to Borrow Book. ");
        out.println("Enter 8 to Return Book");
        out.println("Enter 9 to Add text file to Array");
        out.println("Enter 10 to Save Array to text file");
        out.println("----------------------------------------------------------------------------------------------------------");

    }

    public int isAvailable(int sNo){

        //returns the index number if available



        for (int i=0; i<count; i++){

            if (sNo == theBooks[i].sNo){
                if(theBooks[i].bookQtyCopy > 0){

                    out.println("Book is Available.");
                    return i;

                }
                out.println("Book is Unavailable");
                return -1;

            }

        }

        out.println("No Book of Serial Number " + " Available in Library.");
        return -1;


    }

    public Book borrowBook(){

        out.println("Enter Serial No of Book to be Borrow.");
        int sNo = input.nextInt();

        int bookIndex =isAvailable(sNo);
        LocalDateTime DateObj = LocalDateTime.now();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = DateObj.format(FormatObj);
        if (bookIndex!=-1){

            //int bookIndex = isAvailable(sNo);
            theBooks[bookIndex].bookQtyCopy--;
            theBooks[bookIndex].BorrowDate=formattedDate;

            return theBooks[bookIndex];
        }

        return null;

    }

    public void returnBook(Book b){
        LocalDateTime DateObj = LocalDateTime.now();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = DateObj.format(FormatObj);
        for (int i=0; i<count; i++){

            if (b.equals(theBooks[i]) ){

                theBooks[i].bookQtyCopy++;
                theBooks[i].ReturnDate=formattedDate;
                return;

            }

        }

    }







}