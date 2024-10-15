Sudoku Solver
A simple and efficient Sudoku puzzle solver implemented in Scala. This project provides a basic solution for solving Sudoku puzzles using logical deduction.
Features

Solves basic to intermediate Sudoku puzzles
Command-line interface for easy input and visualization
Iterative solving approach
Step-by-step solution display

Installation
To use this Sudoku solver, you need to have Scala installed on your system. If you don't have Scala installed, you can download it from the official Scala website.

Clone this repository:
Copygit clone https://github.com/yourusername/sudoku-solver.git
cd sudoku-solver

Compile the Scala file:
Copyscalac SudokuSolver.scala


Usage

Run the compiled program:
Copyscala SudokuSolver

When prompted, enter your Sudoku puzzle as a single line of 81 digits. Use '0' for empty cells. You can use commas or spaces between numbers if you prefer, but they're not required.
Example input:
Copy530070000600195000098000060800060003400803001700020006060000280000419005000080079

The program will display the initial puzzle and then show each step of the solving process.

Limitations

This solver uses a simple logical deduction method and may not be able to solve very difficult Sudoku puzzles that require advanced techniques or guessing.
The solver will attempt to solve the puzzle up to 100 iterations. If it can't complete the puzzle within these iterations, it will display the partially solved puzzle.

Contributing
Contributions to improve the solver or extend its capabilities are welcome! Please feel free to submit pull requests or open issues for any bugs or feature requests.
