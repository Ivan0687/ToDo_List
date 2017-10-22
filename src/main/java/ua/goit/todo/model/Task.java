package ua.goit.todo.model;

public class Task {

    private static int count = 1;

    private final int id;

    private String description;

    private boolean isDone;

    public Task(String description) {
        this.description = description;
        id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

}
