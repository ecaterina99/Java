public class Task {
    private int id;
    private String description;
    boolean isCompleted;

    public Task() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted ;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] " + getDescription() + "\n" + "Completed: " + this.isCompleted;
    }

    public void markAsCompleted() {
        this.setIsCompleted(true);
    }


}


