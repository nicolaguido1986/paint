package com.example.model;

import lombok.Value;

@Value
public class Canvas {
  public static final char DRAWING_CHAR = 'x';
  char[][] canvas;
  int width;
  int height;

  public Canvas(int width, int height) {
    this.width = width;
    this.height = height;

    canvas = new char[height + 2][width + 2];
    for (int i = 0; i <canvas.length ; i++) {
      for (int j = 0; j < canvas[0].length; j++) {
        if (i == 0 || i == (height + 1)) {
          canvas[i][j] = '=';
        } else if (j == 0 || j == (width + 1)) {
          canvas[i][j] = '|';
        } else {
          canvas[i][j] = ' ';
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (char[] chars : canvas) {
      stringBuilder.append(String.valueOf(chars));
      stringBuilder.append(System.getProperty("line.separator"));
    }
    return stringBuilder.toString();
  }

  public void print() {
    System.out.println(this);
  }
}
