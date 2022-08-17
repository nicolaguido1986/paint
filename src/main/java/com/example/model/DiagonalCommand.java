package com.example.model;

import com.example.exception.UnprocessableCommandException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

import static com.example.model.Canvas.DRAWING_CHAR;

@Value
@Slf4j
public class DiagonalCommand implements ToolCommand {
  public static final Pattern pattern =
      Pattern.compile("(D) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*)");

  private static Operation operation = Operation.LINE;

  int x0;
  int y0;

  int x1;
  int y1;

  int diff;
  int xDirection;
  int yDirection;

  public DiagonalCommand(String commandLine) {
    var matcher = pattern.matcher(commandLine);
    if (!matcher.find()) {
      throw new UnprocessableCommandException("Command not valid");
    }
    x0 = Integer.parseInt(matcher.group(2));
    y0 = Integer.parseInt(matcher.group(3));
    x1 = Integer.parseInt(matcher.group(4));
    y1 = Integer.parseInt(matcher.group(5));
    diff = Math.abs(x0 - x1);
    if (Math.abs(y0 - y1) != diff) {
      throw new UnprocessableCommandException("Command not valid. Line is not a diagonal");
    }
    xDirection = x0 <= x1 ? 1 : -1;
    yDirection = y0 <= y1 ? 1 : -1;
  }

  @Override
  public Operation getOperation() {
    return operation;
  }

  @Override
  public void draw(char[][] grid, int width, int height) {
    log.debug("Line command invoked, ({}, {}) ({}, {})", x0, y0, x1, y1);
    if (grid == null) {
      throw new UnprocessableCommandException("Canvas is null");
    }
    if (x0 > width || x1 > width || y0 > height || y1 > height) {
      throw new UnprocessableCommandException("Points cannot be drawn");
    }
    for (int i = 0; i <= diff; i++) {
      grid[y0 + (i * yDirection)][x0 + (i * xDirection)] = DRAWING_CHAR;
    }
    log.debug("Line command applied");
  }
}
