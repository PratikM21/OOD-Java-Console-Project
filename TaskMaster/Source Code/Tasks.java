class Task {
    private String taskName;
    private String deadline;
    private boolean isDone;
    private int priority;

    public Task(String taskName, String deadline, int priority) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.priority = priority;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
    	return taskName + " | Priority: " + priority + " | Deadline: " + deadline + " | Done: " + isDone;
    }
}