# What is Java
Java is a high-level, class-based, object-oriented programming language. James Gosling at Sun Microsystems (now part of Oracle Corporation) designed it, and it was released in 1995. The language was developed with the "Write Once, Run Anywhere" (WORA) philosophy. This principle underscores Java's key feature - platform independence, allowing the same Java program to run on multiple platforms without modifications.

Java is designed to be both simple and powerful. It borrows its syntax from C and C++, but eliminates certain low-level programming complexities, such as explicit memory management and multiple inheritance found in C++. Known for its robustness, security, and simplicity, Java has become a popular choice among developers worldwide.

A sample of Java
Let's create the classic "Hello, World!" program, a friendly greeting from your computer.

## Here's the program:

`public class HelloWorld {   
public static void main(String[] args) {   
System.out.println("Hello, World!");
}
}
`

Don't worry if it looks a bit cryptic now. You'll get the hang of it soon.

This program simply prints the phrase "Hello, World!" to the console. But there's a lot going on here:

###  public class HelloWorld - 
* This is like the birth certificate of our program. We're telling Java we're creating a new public class (a kind of blueprint) and we're naming it HelloWorld. Every Java application has to have at least one class.

### public static void main(String[] args) - 
* This is the heart of our program, where the execution begins.
### System.out.println("Hello, World!"); - 
* These are our program's first words! This command instructs Java to print "Hello, World!" to the console, providing instant feedback.

Regardless of its complexity, a program always performs operations on numbers, strings, and other values. These values are called literals. There are many different sorts of literals in Java, but in this topic we will focus only on a few of them: the ones that surround us all the time in everyday life.

## Basic literals in Java
Consider literals as groceries. To use them, usually you need to store them somewhere. Typically, they are stored in variables, which you can think of as containers designed to hold a specific type of data.

Variables can only store matching data. You wouldn't want to accidentally put honey in a cardboard cereal box or pour cereal into a salt shaker. To prevent such mistakes, learn to distinguish between the basic literals: integer numbers, strings, and characters.

### Integer numbers
You use these numbers to count things in the real world as natural numbers. Integer numbers also include zero and negative ones. Here are several examples of valid integer number literals separated by commas: 0, 1, 2, 10, 11, -100.

Here is how integers can be used in code:

`int numApples = 1000;`

Reading code is crucial for anyone in IT, so let's parse it together. Here you put the integer 1000 into a variable of an integer type, called numApples. This is similar to filling a container with its designated contents!

You can increase code readability by dividing the digit into blocks with underscores: 1_000_000 is more readable than 1000000. So let's pack our apples to make selling them easier:

`int numPackedApples = 1_000_000;`

Fear not if these code snippets aren't 100% clear to you yet! They aim to help you develop the skill of code reading. Just grasp the overall meaning and follow your study plan, and you'll be writing your own code in no time!

### Characters
A character is a single symbol, denoted with single quotes. You can use character literals to represent single letters like 'A', 'x', digits from '0' to '9', whitespaces (' '), and other characters or symbols like '$'.

Be mindful of quotes and avoid confusing characters representing digits with the digits themselves:

`char charOne = '1'`

`int numOne = 1`

Fun fact: characters sit between integers and strings: they resemble strings, yet you can do math with them.

### Strings
A string is a sequence of characters, encapsulated by double quotes. It represents text-based information, such as an advertising line, a webpage address, or a website login name. Here are some valid examples: "text", "I want to know Java", "123456", "e-mail@gmail.com". As you can see, a string can include letters, digits, whitespaces, and other charactes altogether.

A string consisting of a single character like "A" is also a valid string, but do not confuse it with the 'A' character. Note the difference in quotes!

`char singleQuoted = 'A'`

`String doubleQuoted = "A"`
### Conclusion
You have learned to distinguish between the following literals:

* 123 is an integer number, "123" is a string;
* 'A' is a character, "A" is a string;
* '1' is a character, 1 is an integer number.

### The basic terminology
Now that you have seen the result, let's learn some basic terminology and then try to understand this program.

* **Program** – a sequence of instructions (called statements), which are executed one after another in a predictable manner. Sequential flow is the most common and straightforward sequence of statements, in which statements are executed in the order that they are written – from top to bottom in a sequential manner;


* **Statement** – a single action (like print some text) terminated by a semicolon (;);


* **Block** – a group of zero, one or more statements enclosed in a pair of braces {...}; There are two such blocks in the program above;


* **Method** – a sequence of statements that represents a high-level operation (also known as a subprogram or procedure);


* **Syntax** – a set of rules that define how a program needs to be written in order to be valid; Java has its own specific syntax that we will learn.


* **Keyword** – a word that has a special meaning in the programming language (public, class, and many others). These words cannot be used as variable names in your own program;


* **Identifier or name** – a word that refers to something in a program (such as a variable or a function name);


* **Comment** – a textual explanation of what the code does. Java comments start with //;


* **Whitespace** – all characters that are not visible (space, tab, newline, etc.).

## The Hello World program under a microscope
The Hello World program illustrates the basic elements of Java programs. For now, we will discuss only the most important elements.

1. The public class. It is the basic unit of a program. Every Java program must have at least one class. The definition of a class consists of the class keyword followed by the class name. A class can have any name, such as App, Main, or Program, but it must not start with a digit. A set of braces {...} encloses the body of a class.

`public class Main {
// ...
}`

The text after // is just a comment, not a part of the program. We will learn about comments in detail in later topics.

2. The main method. To make the program runnable, we put a method named main inside a class. It is the entry point for a Java program. Again, the braces {...} enclose the body of the method, which contains programming statements.

`public static void main(String[] args) {
// statements go here
}`

The keywords **public, static,** and **void** will be discussed later, so just remember them for now. The name of this method (main) is predefined and should always be the same. Capitalization matters: if you name your first method Main, MAIN or something else, the program cannot start.

The element String[] args represents a sequence of arguments passed to the program from the outside world. Don't worry about them right now.

3. **Printing "Hello, World!".** The body of the method consists of programming statements that determine what the program should do after starting. Our program prints the string "Hello, World!" using the following statement:

`System.out.println("Hello, World!"); //  each statement has to end with ;`

This is one of the most important things to understand from the Hello World program. We invoke a special method println to display a string followed by a new line on the screen. We will often use this approach to print something of interest to the screen. The text is printed without double quotes.

It is important that "Hello, World!" is not a keyword or an identifier; it is just some text to be printed.

### Keywords
As you can see, even a simple Java program consists of many elements, including keywords that are parts of the language. In total, Java provides more than 50 keywords which you will gradually learn on this platform. The full list is here, though you don't need to remember all of them at this moment.

Note, main is outside the given list because it is not a keyword.

### Conclusion
We have discussed the simplest program you can write in Java. It has a single class with a single main method. Every Java program must have a main method as it is the first to be executed when the program runs. Don't worry about memorizing every single term used in the topic (syntax, statement, block). These terms will reappear in further materials. Do not forget to use the provided Hello World program as a template in your own programs.











































