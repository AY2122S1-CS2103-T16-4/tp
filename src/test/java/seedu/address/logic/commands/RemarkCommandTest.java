package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.index.Index;
import seedu.address.model.person.Remark;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

class RemarkCommandTest {

    @Test
    void execute_addRemarkUnfilteredList_success() {
        assertCommandSuccess(new RemarkCommand(new Index(1), new Remark("lol")),
                null, "", null);
    }
}