package com.example;

import com.example.model.Canvas;
import com.example.model.Command;
import com.example.model.Operation;
import com.example.service.CommandParser;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {

  public static final String ENTER_COMMAND = "enter command:: ";
  public static final String COMMAND_NOT_VALID = "Command not valid";

  public static void main(String[] args) {
    Command command = null;
    Canvas canvas = null;
    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.print(ENTER_COMMAND);
        try {
          command = CommandParser.parse(scanner.nextLine());
          canvas = command.apply(canvas);
          if (canvas != null) {
            canvas.print();
          }
        } catch (RuntimeException ex) {
          log.error(COMMAND_NOT_VALID, ex);
          System.exit(1);
        }
      } while (command.getOperation() != Operation.QUITE);
    }
  }
}
