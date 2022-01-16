package duke.command;

import duke.task.*;
import duke.ui.*;
import duke.storage.*;

import java.io.IOException;

/**
 * Represents command to delete a task from the task list.
 *
 */
public class DeleteCommand extends Command{
    protected Integer index;

    public DeleteCommand(Integer index) {
        this.index = index-1;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {
        ui.deleteList(task, this.index);
        task.delete(this.index);
        storage.overWriteFile(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
