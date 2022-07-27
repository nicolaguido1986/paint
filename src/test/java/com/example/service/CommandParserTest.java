package com.example.service;

import com.example.exception.UnprocessableCommandException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandParserTest {

  @ParameterizedTest
  @ValueSource(strings = {" ", ""})
  void shouldFailWhenEmpty(String input) {
    var exception = assertThrows(UnprocessableCommandException.class, () -> CommandParser.parse(input));
    assertEquals("Command line is blank", exception.getMessage());
  }

  @ParameterizedTest
  @EmptySource
  void shouldFailWhenNull(String input) {
    var exception = assertThrows(UnprocessableCommandException.class, () -> CommandParser.parse(input));
    assertEquals("Command line is blank", exception.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"d ", "c"})
  void shouldFailWhenInvalidCommandLine(String input) {
    var exception = assertThrows(UnprocessableCommandException.class, () -> CommandParser.parse(input));
    assertEquals("Command not implemented", exception.getMessage());
  }
}
