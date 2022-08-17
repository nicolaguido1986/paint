package com.example.model;

import com.example.exception.UnprocessableCommandException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

import static com.example.model.Canvas.DRAWING_CHAR;

@Value
@Slf4j
public class LineCommand implements ToolCommand {
  public static final Pattern pattern =
      Pattern.compile("(L) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*) ([1-9]\\d*)");

  private static Operation operation = Operation.LINE;

  int x0;
  int y0;

  int x1;
  int y1;

  public LineCommand(String commandLine) {
    var matcher = pattern.matcher(commandLine);
    if (!matcher.find()) {
      throw new UnprocessableCommandException("Command not valid");
    }
    x0 = Integer.parseInt(matcher.group(2));
    y0 = Integer.parseInt(matcher.group(3));
    x1 = Integer.parseInt(matcher.group(4));
    y1 = Integer.parseInt(matcher.group(5));
    if (x0 != x1 && y0 != y1) {
      throw new UnprocessableCommandException("Command not valid. Line is oblique");
    }
  }

  @Override
  public Operation getOperation() {
    return operation;
  }

  @Override
  public void draw(char[][] grid, int width, int height) {
    if (grid == null) {
      throw new UnprocessableCommandException("Canvas is null");
    }
    log.debug("Diagonal command invoked, ({}, {}) ({}, {})", x0, y0, x1, y1);

    if (x0 > width || x1 > width || y0 > height || y1 > height) {
      throw new UnprocessableCommandException("Points cannot be drawn");
    }
    if (x0 == x1) {
      for (int i = y0; i <= y1; i++) {
        grid[i][x0] = DRAWING_CHAR;
      }
    } else {
      for (int i = x0; i <= x1; i++) {
        grid[y0][i] = DRAWING_CHAR;
      }
    }
    log.debug("Line command applied");
  }
}
