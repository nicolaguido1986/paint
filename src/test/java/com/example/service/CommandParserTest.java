package com.example.service;

import com.example.exception.UnprocessableCommandException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandParserTest {

  @ParameterizedTest
  @ValueSource(strings = {" ", "", "d ", "c"})
  void shouldFailTheParsing(String input) {
    assertThrows(UnprocessableCommandException.class, () -> CommandParser.parse(input));

  }

  @ParameterizedTest
  @EmptySource
  void shouldFailWithNullCommand(String input) {
    assertThrows(UnprocessableCommandException.class, () -> CommandParser.parse(input));
  }
}
