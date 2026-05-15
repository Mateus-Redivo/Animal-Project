# Animal Project - Java Inheritance Study

## Purpose

This project is a study exercise to practice core Object-Oriented Programming concepts in Java, mainly:

- Inheritance
- Method overriding
- Method overloading
- Abstraction with abstract classes
- Enums for controlled values

The idea is to model animals using a base class (`Animal`) and specialized classes like `Dog` and `Cat`.

## What This Project Is For

Use this repository to learn how to:

- Create a reusable parent class with common attributes and behavior.
- Extend that parent class in child classes with specific fields and methods.
- Override parent methods to change behavior in subclasses.
- Overload methods to support different parameter combinations.
- Organize Java code using packages (`app`, `model`, `enums`, `util`).

## Current Structure

```text
app/
  Main.java
enums/
  FurColor.java
  Habitat.java
  TrainingLevel.java
model/
  Animal.java
  Cat.java
  Dog.java
util/
  Validations.java
```

## Step-by-Step: How To Create This Project From Scratch

### 1. Create folders (packages)

Create the following directories:

- `app`
- `model`
- `enums`
- `util`

### 2. Create the abstract parent class

In `model/Animal.java`:

- Add common attributes such as `name`, `age`, `speed`, `weight`, `habitat`, and `isWild`.
- Create a constructor to initialize those fields.
- Add shared methods like `displayInfo()` and `move(int distance)`.
- Define methods that subclasses can override, such as `makeSound()` and `sleep()`.

### 3. Create enums

In `enums/Habitat.java`:

- Define fixed habitat values.
- Add `code` and `displayName` for each constant.
- Add a helper method like `fromCode(int code)`.

In `enums/TrainingLevel.java` and `enums/FurColor.java`:

- Define fixed values used by specific animal classes.

### 4. Create subclasses

In `model/Dog.java` and `model/Cat.java`:

- Use `extends Animal`.
- Add subclass-specific attributes.
- Use `super(...)` in constructors.
- Override methods (for example, `makeSound()`).
- Add overloaded methods (for example, different `move(...)` signatures).

### 5. (Optional) Add validation helpers

In `util/Validations.java`:

- Create utility methods to validate name, age, speed, weight, etc.
- Keep these methods static so they can be reused across classes.

### 6. Create the execution entry point

In `app/Main.java`:

- Instantiate objects like `Dog` and `Cat`.
- Call methods to demonstrate inheritance, overriding, and overloading.
- Print outputs to verify behavior.

### 7. Compile and run

From the project root:

```bash
javac app/Main.java model/*.java enums/*.java util/*.java
java app.Main
```

If you are on Windows PowerShell and wildcard expansion causes issues, compile each package separately or use your IDE build tools.

## Suggested Study Checklist

1. Start by finishing `Dog` and `Cat` constructors and methods.
2. Complete `TrainingLevel` and `FurColor` enums.
3. Add validation rules in `Validations`.
4. Use `Main` to create test objects and print behavior.
5. Refactor duplicated logic into shared methods.

## Notes

- This is an educational project, so incremental implementation is expected.
- You can extend the model with more animals (Bird, Fish, Horse) to reinforce inheritance practice.
