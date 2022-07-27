package com.example.model;

import com.example.exception.UnprocessableCommandException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

import static com.example.model.Canvas.DRAWING_CHAR;

@Value
@Slf4j
public class RectangleCommand implements Command {
  public static final Pattern pattern =
      Pattern.compile("(R) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*)");

  static Operation operation = Operation.RECTANGLE;

  int x0;
  int y0;

  int x1;
  int y1;

  public RectangleCommand(String commandLine) {
    var matcher = pattern.matcher(commandLine);
    if (!matcher.find()) {
      throw new UnprocessableCommandException("Command not valid");
    }
    x0 = Integer.parseInt(matcher.group(2));
    y0 = Integer.parseInt(matcher.group(3));
    x1 = Integer.parseInt(matcher.group(4));
    y1 = Integer.parseInt(matcher.group(5));
    if (x0 > x1 || y0 > y1) {
      throw new UnprocessableCommandException("Command not valid. Wrong coordinate");
    }
  }

  @Override
  public Operation getOperation() {
    return operation;
  }

  @Override
  public Canvas apply(Canvas canvas) {
    log.debug("Line command invoked, ({}, {}) ({}, {})", x0, y0, x1, y1);
    if (canvas == null) {
      throw new UnprocessableCommandException("Canvas is null");
    }
    if (x0 > canvas.getWidth()
            || x1 > canvas.getWidth()
            || y0 > canvas.getHeight()
            || y1 > canvas.getHeight()) {
      throw new UnprocessableCommandException("Points cannot be drawn");
    }
    var grid = canvas.getCanvas();
    for (int i = x0; i <= x1; i++) {
      grid[y0][i] = DRAWING_CHAR;
      grid[y1][i] = DRAWING_CHAR;
    }
    for (int i = y0; i < y1; i++) {
      grid[i][x0] = DRAWING_CHAR;
      grid[i][x1] = DRAWING_CHAR;
    }
    log.debug("Line command applied");
    return canvas;
  }
}
