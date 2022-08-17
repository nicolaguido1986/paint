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
//class LineCommandTest {
//
//  private static final int WIDTH = 5;
//  private static final int HEIGHT = 5;
//  private static final Canvas CANVAS = new Canvas(WIDTH, HEIGHT);
//
//  @ParameterizedTest
//  @ValueSource(strings = {"", " ", "L 1 2", "L -1 -2", "L 0 0 0 0"})
//  void shouldThrownExceptionWhenNotValid(String input) {
//    var exception = assertThrows(UnprocessableCommandException.class, () -> new LineCommand(input));
//    assertEquals("Command not valid", exception.getMessage());
//  }
//
//  @Test
//  void shouldThrownExceptionWhenLineIsOblique() {
//    var exception =
//        assertThrows(UnprocessableCommandException.class, () -> new LineCommand("L 1 2 3 4"));
//    assertEquals("Command not valid. Line is oblique", exception.getMessage());
//  }
//
//  @ParameterizedTest
//  @ValueSource(strings = {"L 1 2 1 3", "L 1 2 5 2"})
//  void shouldCreateCommand(String input) {
//    assertNotNull(new LineCommand(input));
//  }
//
//  @Test
//  void shouldNotApplyCanvasNull() {
//    var exception =
//        assertThrows(
//            UnprocessableCommandException.class, () -> new LineCommand("L 1 2 1 3").apply(null));
//    assertEquals("Canvas is null", exception.getMessage());
//  }
//
//  @ParameterizedTest
//  @ValueSource(strings = {"L 6 2 6 3", "L 1 6 5 6"})
//  void shouldNotApplyCoordinateOutsideCanvas(String input) {
//    var exception =
//        assertThrows(
//            UnprocessableCommandException.class, () -> new LineCommand(input).apply(CANVAS));
//    assertEquals("Points cannot be drawn", exception.getMessage());
//  }
//
//  @Test
//  void shouldDrawAVerticleLine() {
//    var command = new LineCommand("L 1 2 1 4");
//    var canvas = command.apply(CANVAS);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[2][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[3][1]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[4][1]);
//  }
//
//  @Test
//  void shouldDrawAHorizontalLine() {
//    var command = new LineCommand("L 2 1 4 1");
//    var canvas = command.apply(CANVAS);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][2]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][3]);
//    assertEquals(DRAWING_CHAR, canvas.getCanvas()[1][4]);
//  }
//}
