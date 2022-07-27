package com.example.model;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Value
@Slf4j
public class QuiteCommand implements Command {
  private static Operation operation = Operation.QUITE;

  @Override
  public Operation getOperation() {
    return operation;
  }

  @Override
  public Canvas apply(Canvas canvas) {
    log.debug("Quite command invoked.");
    return null;
  }
}
