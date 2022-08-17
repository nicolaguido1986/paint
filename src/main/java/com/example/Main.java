package com.example;

import com.example.exception.UnprocessableCommandException;
import com.example.model.Canvas;
import com.example.model.Command;
import com.example.model.Operation;
import com.example.model.QuiteCommand;
import com.example.model.SystemCommand;
import com.example.model.ToolCommand;
import com.example.service.CommandParser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {

  public static final String ENTER_COMMAND = "enter command:: ";
  public static final String COMMAND_NOT_VALID = "Command not valid";

  @SneakyThrows
  public static void main(String[] args) {
    Canvas canvas = null;
    Command command = null;
    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.print(ENTER_COMMAND);
        try {
          command = CommandParser.parse(scanner.nextLine());
          if (command instanceof QuiteCommand) {
            System.exit(1);
          }
          if (command instanceof SystemCommand systemCommand) {
            canvas = systemCommand.apply(canvas);
          }
          if (command instanceof ToolCommand toolCommand){
            canvas.apply(toolCommand);
          }
          canvas.print();
        } catch (UnprocessableCommandException ex) {
          log.error(COMMAND_NOT_VALID, ex);
        }
      } while (true);
    }
  }
}
