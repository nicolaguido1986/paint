package com.example.model;

public interface Command {

  Operation getOperation();

  Canvas apply(Canvas canvas);
}
