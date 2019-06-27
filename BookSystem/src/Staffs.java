import java.util.Scanner;

public class Staffs{

    Scanner input = new Scanner(System.in);

    Staff theStaff[] = new Staff[50];

//books book;


    public static int count = 0;

    public void addStaff(Staff s){

        for (int i=0; i<count; i++){

            if(s.regNum.equalsIgnoreCase(theStaff[i].regNum)){

                System.out.println("Staff of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }

        }

        if (count<=50){

            theStaff[count] = s;
            count++;

        }

    }
    public void showAllStaff(){

        System.out.println("Staff Name\t\tReg Number");
        for (int i=0; i<count; i++){

            System.out.println(theStaff[i].staffName + "\t\t" + theStaff[i].regNum);

        }


    }

    public int isStaff(){
        //return index number of staff if available



        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();

        for (int i=0; i<count; i++){

            if (theStaff[i].regNum.equalsIgnoreCase(regNum)){

                return i;

            }

        }
        System.out.println("Staff is not Registered.");
        System.out.println("Get Registered First.");


        return -1;

    }
    public void borrowBook(Books book){
        int staffIndex =this.isStaff();

        if (staffIndex!=-1){
            System.out.println("Borrow out");

            book.showAllBooks();
            Book b = book.borrowBook();
            System.out.println("Borrow out");
            if (b!= null){

                if (theStaff[staffIndex].booksCount<=3){
                    System.out.println("adding book");
                    theStaff[staffIndex].borrowedBooks[theStaff[staffIndex].booksCount] = b;
                    theStaff[staffIndex].booksCount++;
                    return;

                }
                else {

                    System.out.println("Staff Can not Borrow more than 3 Books.");
                    return;

                }
            }
            System.out.println("Book is not Available.");

        }


    }

    public void returnBook(Books book){

        int staffIndex = this.isStaff();
        if (staffIndex != -1){
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name\t\t\tBorrow Date");
            Staff s = theStaff[staffIndex];
            for (int i=0; i<s.booksCount; i++){

                System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t"+
                        s.borrowedBooks[i].authorName + "\t\t\t" + s.borrowedBooks[i].BorrowDate);

            }
            System.out.println("Enter Serial Number of Book to be Return:");
            int sNo = input.nextInt();
            for (int i=0; i<s.booksCount; i++){

                if (sNo == s.borrowedBooks[i].sNo){

                    book.returnBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i]=null;
                    return;

                }


            }
            System.out.println("Book of Serial No "+sNo+"not Found");

        }



    }


}