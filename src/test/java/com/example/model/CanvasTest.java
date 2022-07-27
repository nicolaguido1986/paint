package com.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CanvasTest {

  @Test
  @DisplayName("Should print correctly")
  void printCorrectly() {
    Canvas canvas = new Canvas(5, 5);
    System.out.println(canvas.toString());
  }
}
