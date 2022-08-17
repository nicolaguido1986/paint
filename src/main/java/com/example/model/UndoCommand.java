package com.example.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UndoCommand implements SystemCommand {
  @Override
  public Operation getOperation() {
    return null;
  }

  @Override
  public Canvas apply(Canvas canvas) {
    canvas.undo();
    return canvas;
  }
}
