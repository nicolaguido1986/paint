package com.example.model;

import com.example.exception.UnprocessableCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CreateCommandTest {

  private static final int WIDTH = 20;
  private static final int HEIGHT = 5;

  @ParameterizedTest
  @ValueSource(strings = {"C a b", "", " ", "c 1 2", "C -1 -2", "C 0 0"})
  void shouldThrownException(String input) {
    assertThrows(UnprocessableCommandException.class, () -> new CreateCommand(input));

  }

  @Test
  void shouldCreateCommand() {
    assertNotNull(new CreateCommand("C 1 1"));
  }

  @Test
  void shouldCreateACanvas() {
    var command = new CreateCommand("C " + WIDTH + " " + HEIGHT);
    var canvas = command.apply(null);
    assertEquals(WIDTH, canvas.getWidth());
    assertEquals(HEIGHT, canvas.getHeight());
  }

}
