import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

object SudokuSolver {
  def main(args: Array[String]): Unit = {
    // Ask the user to enter a puzzle
    println("Enter a Sudoku Puzzle:")
    val input = StdIn.readLine()
    
    // Remove spaces and commas
    val cleanInput = input.replaceAll("[,\\s]", "")
    
    // Create our two-dimensional array using the data
    val puzzle = Array.ofDim[Int](9, 9)
    for (i <- 0 until 9; j <- 0 until 9) {
      puzzle(i)(j) = cleanInput((i * 9) + j).asDigit
    }
    
    // Print out the initial puzzle
    printPuzzle(puzzle)
    
    // Solve the puzzle
    solvePuzzle(puzzle)
  }
  
  def printPuzzle(puzzle: Array[Array[Int]]): Unit = {
    for (row <- puzzle) {
      println(row.mkString("  "))
    }
    println()
  }
  
  def solvePuzzle(puzzle: Array[Array[Int]]): Unit = {
    for (_ <- 1 to 100) { // Loop a maximum of 100 times
      var changed = false
      for (i <- 0 until 9; j <- 0 until 9) {
        if (puzzle(i)(j) == 0) {
          val possibleValues = getPossibleValues(puzzle, i, j)
          if (possibleValues.length == 1) {
            puzzle(i)(j) = possibleValues.head
            changed = true
            println("Updated puzzle:")
            printPuzzle(puzzle)
          }
        }
      }
      if (!changed) return // If no changes were made, we're done
    }
  }
  
  def getPossibleValues(puzzle: Array[Array[Int]], row: Int, col: Int): Seq[Int] = {
    val allValues = 1 to 9
    val usedValues = ArrayBuffer[Int]()
    
    // Check row and column
    for (i <- 0 until 9) {
      usedValues += puzzle(row)(i)
      usedValues += puzzle(i)(col)
    }
    
    // Check 3x3 square
    val squareRow = (row / 3) * 3
    val squareCol = (col / 3) * 3
    for (i <- squareRow until squareRow + 3; j <- squareCol until squareCol + 3) {
      usedValues += puzzle(i)(j)
    }
    
    allValues.diff(usedValues.distinct)
  }
}
