package task;

import duke.task.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void canSerialize() {
        Task td = new ToDos("Todo works", true);
        Task dl = new DeadLine("Deadline works", false,"2019-10-15", "18:00:00");
        Task et = new Events("Events works", "2019-10-15", "18:00:00", "20:00:00");
        assertEquals(dl.serialize(), "D|0|Deadline works|2019-10-15|18:00\n");
        assertEquals(td.serialize(), "T|1|Todo works\n");
        assertEquals(et.serialize(), "E|0|Events works|2019-10-15|18:00|20:00\n");
    }

    @Test
    public void canDeSerialize() {
        Task td = Task.deserialize("T|1|Todo works");
        Task dl = Task.deserialize("D|0|Deadline works|2019-10-15|18:00:00");
        Task et = Task.deserialize("E|0|Events works|2019-10-15|18:00|20:00:00");
        assertEquals(td.equals(new ToDos("Todo works", true)), true);
        assertEquals(dl.equals(new DeadLine("Deadline works", false,"2019-10-15", "18:00:00")), true);
        assertEquals(et.equals(new Events("Events works", "2019-10-15", "18:00:00", "20:00:00")), true);
    }
}