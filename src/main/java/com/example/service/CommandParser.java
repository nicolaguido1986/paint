package com.example.service;

import com.example.exception.UnprocessableCommandException;
import com.example.model.Command;
import com.example.model.CreateCommand;
import com.example.model.DiagonalCommand;
import com.example.model.LineCommand;
import com.example.model.QuiteCommand;
import com.example.model.RectangleCommand;
import com.example.model.UndoCommand;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang.StringUtils;

@UtilityClass
public class CommandParser {

    public Command parse(String commandLine) throws UnprocessableCommandException {
        if (StringUtils.isBlank(commandLine)) {
            throw new UnprocessableCommandException("Command line is blank");
        }
        var line = commandLine.trim();

        return switch (line.charAt(0)) {
            case 'C'-> new CreateCommand(line);
            case 'L' -> new LineCommand(line);
            case 'R' -> new RectangleCommand(line);
            case 'Q' -> new QuiteCommand();
            case 'D' -> new DiagonalCommand(line);
            case 'U' -> new UndoCommand();
            default -> throw new UnprocessableCommandException("Command not implemented");
        };
    }
}
