package com.example.model;

import com.example.exception.UnprocessableCommandException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Value
@Slf4j
public class CreateCommand implements SystemCommand {
  public static final Pattern pattern = Pattern.compile("(C) ([1-9]\\d*) ([1-9]\\d*)");

  private static Operation operation = Operation.CREATE;

  int width;
  int height;

  public CreateCommand(String commandLine) {
    var matcher = pattern.matcher(commandLine);
    if (!matcher.find()) {
      throw new UnprocessableCommandException("Command not valid");
    }
    width = Integer.parseInt(matcher.group(2));
    height = Integer.parseInt(matcher.group(3));
  }

  @Override
  public Operation getOperation() {
    return operation;
  }

  @Override
  public Canvas apply(Canvas canvas) {
    log.debug("Create command invoked, with w={} and h={}", width, height);
    canvas = new Canvas(width, height);
    log.debug("Canvas created with w={} and h={}", canvas.getWidth(), canvas.getHeight());
    return canvas;
  }
}
