//package com.example.model;
//
//import com.example.exception.UnprocessableCommandException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static com.example.model.Canvas.DRAWING_CHAR;
//import static org.junit.jupiter.api.Assertions.*;
//
//class RectangleCommandTest {
//  private static final Canvas CANVAS = new Canvas(5, 5);
//
//  @ParameterizedTest
//  @ValueSource(strings = {"", " ", "R 1 2", "R -1 -2", "R 0 0 0 0"})
//  void shouldThrownException(String input) {
//    var exception =
//        assertThrows(UnprocessableCommandException.class, () -> new RectangleCommand(input));
//    assertEquals("Command not valid", exception.getMessage());
//  }
//
//  @Test
//  void shouldThrownExceptionWhenCoordinatesAreNotValid() {
//    var exception =
//        assertThrows(UnprocessableCommandException.class, () -> new RectangleCommand("R 2 1 1 1"));
//    assertEquals("Command not valid. Wrong coordinate", exception.getMessage());
//  }
//
//  @Test
//  void shouldCreateCommand() {
//    assertNotNull(new RectangleCommand("R 1 2 3 4"));
//  }
//
//  @Test
//  void shouldNotApplyCanvasNull() {
//    var exception =
//        assertThrows(
//            UnprocessableCommandException.class,
//            () -> new RectangleCommand("R 1 2 1 3").apply(null));
//    assertEquals("Canvas is null", exception.getMessage());
//  }
//
//  @ParameterizedTest
//  @ValueSource(strings = {"R 6 2 6 3", "R 1 6 5 6"})
//  void shouldNotApplyCoordinateOutsideCanvas(String input) {
//    var exception =
//        assertThrows(
//            UnprocessableCommandException.class, () -> new RectangleCommand(input).apply(CANVAS));
//    assertEquals("Points cannot be drawn", exception.getMessage());
//  }
//
//  @Test
//  void shouldDrawARectangle() {
//    var command = new RectangleCommand("R 1 1 4 4");
//    var canvas = command.apply(CANVAS);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][2]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][3]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][4]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[2][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[2][4]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[3][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[3][4]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[4][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[4][2]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[4][3]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[4][4]);
//  }
//}
