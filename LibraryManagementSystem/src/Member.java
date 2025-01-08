import java.util.List;

public class Member extends User {
    public Member(String name, int Id) {
        super(name, Id);
    }
    public Member(String name, int Id, List<Book> borrowedBooks) {
        super(name, Id, borrowedBooks);
    }


    @Override
    public boolean borrowBook(Book book) {

        if (borrowedBooks.size() < 3)
        {
            if(book.borrow()){
                borrowedBooks.add(book);
                return true;
            }

            System.out.println("This book is already borrowed");
        }

        else {
            System.out.println("You are not allowed to borrow more books");
        }

        return false;
    }


}


