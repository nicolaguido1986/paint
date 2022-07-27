package com.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class QuiteCommandTest {

  @Test
  void shouldCreateQuiteCommand() {
    assertNotNull(new QuiteCommand());
  }

  @Test
  void shouldQuiteFromTheProgram() {
    assertNull(new QuiteCommand().apply(new Canvas(5, 5)));
  }
}
