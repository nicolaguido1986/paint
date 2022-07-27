# Drawing Program

This application implements a simple text (ASCII) based drawing program. This basic program allows users to:

 - Create a new canvas 
 - Draw on the canvas using text based commands 
 - Quit the program

# Requirements

Java 14 required

# Run the application

The following section explains how to run and execute the java application from command line. 

## Create the executable jar

```mvn clean install``` 
This command create an executable jar with all the runtime dependencies. 

## Run the executable jar
```java -jar target/Paint-1.0-SNAPSHOT.jar```

The command allows to start the java application.

## Test

```mvn clean verify```

The command allows to run all the junit Test.

# Assumptions

## Single-thread execution

The application does not support multi-threading executions. The Canvas object is not an immutable object. 

## Assumption execution

The program does not handle extensively the exception. The command are sensitive case.
If the command will be entered wrongly an error will be logged, and the application terminates.
The command exception has been caught, but the exception management has not been implemented.

## Line Command assumption

It is not possible to generate curve lines. The two points identifing a line:
must be on the same line, vertically or horizontally. 

Given ```L x0 y0 x1 y1```, then ```x0 == x1 || y0 == y1```

## Rectangle Command assumption

The first point identifies the upper left corner, and it MUST BE on the top and on the left of the second point. 

Given ```R x0 y0 x1 y1```, then ```x0 <= x1 && y0 <= y1```

## Implementation assumption
This solution could have been implemented in a single class. 

I have used a more Object Oriented approach to solve the assignment. 
This approach is more readable and easy to test. And it will allow to extend the program with other feature more easily.

I have created an Interface representing a Command. Each Command must be firstly generated.
During the Command generation, the commandLine passed as parameter will be validated against a REGEX.

Once a Command has been generated, it will be applied. 

```Canvas apply(Canvas);```

This method takes in input a Canvas, and it will return a new/updated Canvas

The Canvas is mainly a framed matrix. The Canvas object provides a print method. This method will be invoked every time 
a canvas has been updated. 