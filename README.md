### This is a java project created for the G5066 Introduction to Programming Assignments Project T1 Week 7 and Project T1 Week 11 in Nov 2023. For more information please check the docx file. 

# Java Programming Projects Showcase

This repository showcases my Java programming skills through two projects: a **Library Management System (Project T1 Week 7)** and its extension **(Project T1 Week 11)**. These projects demonstrate proficiency in object-oriented programming, data structures, and software testing. Both received high marks, highlighting my attention to detail and problem-solving abilities.

## Project T1 Week 7: Core Library System

This project implements a basic library system with three core classes: **TextBook**, **Library**, and **LibraryCard**.

### Functionality

- **TextBook**: Manages textbook information (title, chapters, read status). Includes methods for reading chapters, checking completion, and resetting the book.
  
- **LibraryCard**: Represents a library card with a borrowing limit and tracking of borrowed books. Includes methods for swiping the card, checking expiration, and retrieving card information.
  
- **Library**: Simulates a library with a bookshelf (array) of textbooks. Includes methods for issuing library cards, borrowing books (removing them from the shelf), returning books (re-adding them to the shelf, maintaining the order), and describing the library's current state.

### This project successfully demonstrates:

- **Object-Oriented Design**: Effective use of classes and objects to model real-world entities.
  
- **Data Structures**: Implementation of a fixed-size array to represent the library's bookshelf.
  
- **Method Design**: Clear, concise methods that adhere to the specified requirements.
  
- **Error Handling**: Robust handling of edge cases, such as attempting to borrow a book with an invalid card or when the shelf is empty.

**Grade**: 100/100

## Project T1 Week 11: Enhanced Library System with Student and College Simulation

Building upon the core library system, this project introduces two new classes: **Student** and **College**, creating a simulation of student library usage.

### Enhancements

- **Student Class**: Models a student who can join the library, borrow and read textbooks, and return them. Includes methods to check if studies are complete, simulate studying, and describe the student's status.
  
- **College Class**: Simulates a college with a library and multiple students. Includes methods to describe the college's overall state, to advance the simulation one step (random student studies), and to run the simulation for a specified number of steps.
  
- **Stand-Alone Execution**: The project is designed to run independently of BlueJ, accepting command-line arguments to customize simulation parameters.
  
- **Javadoc Documentation**: Comprehensive Javadoc documentation for the Student and College classes, adhering to JavaDoc conventions.
  
- **Unit Testing**: Thorough unit tests using JUnit to validate the functionality of the Student and College classes.

### This extended project demonstrates:

- **Advanced Object-Oriented Programming**: Complex interactions between multiple classes.
  
- **Simulation Design**: Building a model to simulate real-world behavior.
  
- **Software Engineering Practices**: Producing stand-alone code, documenting with Javadoc, and using unit testing.

**Grade**: 71/100 (Feedback indicated minor issues with constructor implementation and method logic; mostly related to specific details of the requirements and edge case handling, not core functionality. Significant portions of functionality were implemented correctly and received full credit.)

The code for both projects is available within this repository. Feel free to explore the source code and unit tests. I am confident that these projects demonstrate my ability to design, implement, and test robust and well-documented Java applications.
