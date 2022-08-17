package com.example.model;

public interface ToolCommand extends Command {

  void draw(char[][] canvas, int width, int height);
}
