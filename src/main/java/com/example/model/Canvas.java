package com.example.model;

import lombok.Value;

import java.util.Stack;

@Value
public class Canvas {
  public static final char DRAWING_CHAR = 'x';
  char[][] grid;
  int width;
  int height;
  Stack<ToolCommand> commandStack = new Stack<>();

  public Canvas(int width, int height) {
    this.width = width;
    this.height = height;
    grid = new char[height + 2][width + 2];
    initCanvas();
  }

  private void initCanvas() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i == 0 || i == (height + 1)) {
          grid[i][j] = '=';
        } else if (j == 0 || j == (width + 1)) {
          grid[i][j] = '|';
        } else {
          grid[i][j] = ' ';
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (char[] chars : grid) {
      stringBuilder.append(String.valueOf(chars));
      stringBuilder.append(System.getProperty("line.separator"));
    }
    return stringBuilder.toString();
  }

  public void apply(ToolCommand command) {
    commandStack.push(command);
  }

  public void undo() {
    if (!commandStack.empty()) {
      commandStack.pop();
    }
  }

  public void print() {
    initCanvas();
    commandStack.stream().forEach(toolCommand -> toolCommand.draw(grid, width, height));
    System.out.println(this);
  }
}
