
public class Librarian extends User {
    public Librarian(String name, int Id) {
        super(name, Id);
    }

    @Override
    public boolean borrowBook(Book book) {
        if (book.borrow()) {
            borrowedBooks.add(book);
            return true;
        }
        System.out.println("This book is already borrowed");
    return false;
    }

    @Override
    public String getInfo() {
        return "The list of librarian's borrowed books is: " + super.getInfo();

    }
}
