package duke.task;

public class ToDos extends Task{
    public ToDos(String objective) {
        super(objective);
    }

    public ToDos(String objective, boolean done) {
        super(objective, done);
    }

    @Override
    public String serialize() {
        return "T|" + (this.done ? "1|" : "0|") + this.objective +"\n";
    };

    @Override
    public boolean equals(Object o) {
        if (o instanceof ToDos) {
            ToDos t = (ToDos) o;
            return this.objective.equals(t.objective) && (this.done==t.done);
        } else {
            return false;
        }
    }

    @Override
    public boolean sameTime(String date) {
        return false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
