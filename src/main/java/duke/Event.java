package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Event is a variation of Tasks that carries a task description and its start and end time
 * @author CShuwen
 * @version 1.0
 * @since 0.0
 */
public class Event extends Task{
    private int isDone;
    private final LocalDate from;
    private final LocalDate to;

    public Event(String description, LocalDate from, LocalDate to, Integer isDone){
        super(description, isDone = isDone);
        this.isDone = isDone;
        this.from = from;
        this.to = to;
    }

    @Override
    public void unMark(){
        isDone = 0;
    }

    @Override
    public void markAsDone(){
        isDone = 1;
    }

    @Override
    public String dataFormat(){
        if (isDone == 1) {
            return "E/1/" + description + "/" + this.from + "/" + this.to;
        }else {
            return "E/0/" + description + "/" + this.from + "/" + this.to;
        }
    }

    public String getStatusIcon(){
        return (isDone == 1 ? "[X]": "[ ]");
    }


    @Override
    public String toString(){
        return "[E]["+ isDone + "]" + description + " (from "
                + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + " to " + this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
