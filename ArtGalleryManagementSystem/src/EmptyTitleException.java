public class EmptyTitleException extends Exception {

    @Override
    public String getMessage() {
        return "Title cannot be empty!";
    }
}
