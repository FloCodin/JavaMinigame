## Introduction to Java
Welcome to the world of Java programming!

Programming languages enable humans to write instructions that a computer can perform. With precise instructions, computers coordinate applications and systems that run the modern world.

Sun Microsystems released the Java programming language in 1995. Java is known for being simple, portable, secure, and robust. Though it was released over twenty years ago, Java remains one of the most popular programming languages today.

One reason people love Java is the Java Virtual Machine, which ensures the same Java code can be run on different operating systems and platforms. Sun Microsystems’ slogan for Java was “write once, run everywhere”.

![img.png](img.png)
Java Virtual Machine running Java on three different platforms

Programming languages are composed of syntax, the specific instructions which Java understands. We write syntax in files to create programs, which are executed by the computer to perform the desired task.

Let’s start with the universal greeting for a programming language. We’ll explore the syntax in the next exercise.


### public, static, and void are syntax we’ll learn about in future lessons.
String[] args is a placeholder for information we want to pass into our program. This syntax is necessary for the program to run but more advanced than we need to explore at the moment.

Our program also displayed the text "Hello World" on the screen. This was accomplished using a print statement:

System.out.println("Hello World");

We’ll learn more about print statements in the next exercise!

## Print Statements
Let’s take a closer look at this instruction from our previous program:

`System.out.println("Hello World");`

Print statements output information to the screen (also referred to as the output terminal). Let’s break this line of code down a little more. Don’t worry if some of the terms here are new to you. We’ll dive into what all of these are in much more detail later on!

* System is a built-in Java class that contains useful tools for our programs.
* out is short for “output”.
* println is short for “print line”.
  We can use System.out.println() whenever we want the program to create a new line on the screen after outputting a value:

`public class HideAndSeek {
public static void main(String[] args) {
System.out.println("Let's play hide and seek.");
System.out.print("Three...");
System.out.print("Two...");
System.out.println("One...");
System.out.println("Ready or not, here I come!");
}
}`


#### The following class shows what a comment would look like in a program.

`public class CommentExample {
// I'm a comment inside the class
public static void main(String[] args) {
// I'm a comment inside a method
System.out.println("This program has comments!");
}
}`

Comments are different from printing to the screen, when we use System.out.println(). These comments won’t show up in our terminal, they’re only for people who read our code in the text editor.


### Compilation: Catching Errors
Java is a compiled programming language, meaning the code we write in a .java file is transformed into byte code by a compiler before it is executed by the Java Virtual Machine on your computer.
![img_1.png](img_1.png)
A compiler is a program that translates human-friendly programming languages into other programming languages that computers can execute.

Steps of Java Compilation
Previous exercises have automatically compiled and run the files for you. Off-platform development environments can also compile and run files for you, but it’s important to understand this aspect of Java development so we’ll do it ourselves.

The compiling process catches mistakes before the computer runs our code.

The Java compiler runs a series of checks while it transforms the code. Code that does not pass these checks will not be compiled.

This exercise will use an interactive terminal. Codecademy has a lesson on the command line if you’d like to learn more.

For example, with a file called Plankton.java, we could compile it with the terminal command:

javac Plankton.java

A successful compilation produces a .class file: Plankton.class, that we execute with the terminal command:

java Plankton

An unsuccessful compilation produces a list of errors. No .class file is made until the errors are corrected and the compile command is run again.

`javac Compiling.java`


## Review
In this lesson, we’ve started writing our first programs in Java.

We’ve also learned rules and guidelines for how to write Java programs:

* Java programs have at least one class and one main() method.
* Each class represents one real-world idea.
* The main() method runs the tasks of the program.
* Java comments add helpful context to human readers.
* Java has whitespace, curly braces, and semicolons.
* Whitespace is for humans to read code easily.
* Curly braces mark the scope of a class and method.
* Semicolons mark the end of a statement.
* Java is a compiled language.
* Compiling catches mistakes in our code.
* Compilers transform code into an executable class.



























