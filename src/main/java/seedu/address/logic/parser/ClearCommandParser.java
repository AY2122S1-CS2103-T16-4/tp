package seedu.address.logic.parser;

import seedu.address.logic.commands.ClearCommand;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.FLAG_PERSON;
import static seedu.address.logic.parser.CliSyntax.FLAG_EVENT;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

public class ClearCommandParser implements Parser<ClearCommand> {
    public ClearCommand parse(String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, FLAG_PERSON, FLAG_EVENT);

            boolean isClearingPerson = arePrefixesPresent(argMultimap, FLAG_PERSON);
            boolean isClearingEvent = arePrefixesPresent(argMultimap, FLAG_EVENT);

            if (!isClearingPerson || !isClearingEvent || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));
            }

            if (isClearingEvent) {

            }
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

