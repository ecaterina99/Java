public class Magazine implements Borrowable{

    public String title;
    private boolean isAvailable;

    public Magazine(String title){
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public boolean borrow() {
        if (this.isAvailable) {
            isAvailable = false;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean returnBorrowed() {
        if(!this.isAvailable) {
            isAvailable = true;
            return true;
        }
        else {
            return true;
        }
    }
}
