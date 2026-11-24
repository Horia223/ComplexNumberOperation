# ComplexNumberOperation

A Java console application for parsing and evaluating arithmetic expressions over complex numbers (`n1 op n2 ...`) from command-line arguments, structured around layered OOP packages (`domain`, `parser`, `service`, `ui`) for **Laborator 1 – MAP**[cite: 2].

## Concepts & Design Principles Used

- **Layered / Stratified Architecture:** Separates responsibilities across distinct packages—`Domain` (data models and arithmetic operations)[cite: 2], `parser` (token/expression parsing)[cite: 2], `service` (expression evaluation orchestration)[cite: 2], `ui` (CLI entry point via `Main.java`)[cite: 2], and `Teste` (testing)[cite: 2].
- **Object-Oriented Programming (OOP):** Models complex numbers, expressions, and operations as cohesive classes and interfaces/abstractions rather than procedural scripts[cite: 2].
- **Polymorphism & Abstraction (`Operation`):** Uses a common `Operation` abstraction with concrete implementations (`Addition`, `Subtraction`, `Multiplication`, `Division`) so `ExpressionEvaluator` can execute operations uniformly[cite: 2].
- **Single Responsibility Principle (SRP):** Keeps parsing (`ComplexNumberParser`, `DefaultOperationParser`, `ExpressionParser`)[cite: 2], evaluation (`ExpressionEvaluator`)[cite: 2], and CLI I/O (`Main`)[cite: 2] in separate components.
- **Open/Closed Principle (OCP):** Supports adding new operations or parser strategies behind existing `Operation` / `OperationParser` abstractions without rewriting `ExpressionEvaluator` or `Main`[cite: 2].
- **Design Patterns:** Structures operation creation/dispatch and expression parsing cleanly using OOP design patterns (such as Strategy/Polymorphic Dispatch for operations and Factory/Builder-style parsing)[cite: 2].
- **CLI Argument Processing & Parsing:** Reads expression tokens (`n1 op n2 ...`) from command-line arguments and converts raw strings into structured domain objects.
- **Array-Based Data Handling & Assignment Constraints:** Built around standard Java arrays and core language constructs in accordance with the **Laborator 1 – MAP** constraints (avoiding generic collections and Java 8 streams).

## Project Structure

- `src/Domain/` — Core domain model and operations:
  - `ComplexNumber.java` — Complex number representation
  - `Expression.java` — Expression representation
  - `Operation.java` — Operation abstraction/interface
  - `Addition.java`, `Subtraction.java`, `Multiplication.java`, `Division.java` — Concrete arithmetic operations
- `src/parser/` — Input parsing components:
  - `ComplexNumberParser.java` — Parses complex number tokens
  - `OperationParser.java` / `DefaultOperationParser.java` — Parses operator tokens
  - `ExpressionParser.java` — Parses full expression arguments
- `src/service/` — Evaluation logic:
  - `ExpressionEvaluator.java` — Evaluates parsed expressions
- `src/ui/` — Entry point:
  - `Main.java` — CLI entry point reading program arguments
- `src/Teste/` — Test directory
- `.gitignore` — Git ignore rules for IDE and build artifacts

## Building and Running

### Using IntelliJ IDEA
1. Open the project folder in IntelliJ IDEA.
2. Configure run/debug arguments for `ui.Main` with your complex number expression tokens.
3. Run `Main`.

### From the Command Line
Compile the Java sources into an output folder and run `ui.Main` with expression arguments:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out ui.Main <expression_tokens>
