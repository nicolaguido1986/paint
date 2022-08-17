package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Operation {
  CREATE('C'),
  LINE('L'),
  RECTANGLE('R'),
  QUITE('Q'),
  DIAGONAL('D'),
  UNDO('U');

  char value;
}
