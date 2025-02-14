package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.stream.Stream;

import seedu.address.logic.commands.RemovePersonFromEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventName;
import seedu.address.model.event.EventNameEqualKeywordPredicate;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameEqualKeywordPredicate;

/**
 * Parses input arguments and creates a new RemovePersonFromEventCommand object
 */
public class RemovePersonFromEventCommandParser implements Parser<RemovePersonFromEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the RemovePersonFromEventCommand
     * and returns an RemovePersonFromEventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RemovePersonFromEventCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_EVENT_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_EVENT_NAME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    RemovePersonFromEventCommand.MESSAGE_USAGE));
        }

        Name personName = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        EventName eventName = ParserUtil.parseEventName(argMultimap.getValue(PREFIX_EVENT_NAME).get());

        return new RemovePersonFromEventCommand(new NameEqualKeywordPredicate(personName),
                new EventNameEqualKeywordPredicate(eventName));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
