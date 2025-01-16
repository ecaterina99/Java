public class EmptyCritiqueException extends Exception {

    @Override
    public String getMessage() {
        return "Critique cannot be empty!";
    }
}