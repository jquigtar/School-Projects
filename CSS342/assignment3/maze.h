//
// Created by Jordan Quigtar on 10/18/19.
//

#ifndef HWASSIGNMENT3_MAZE_H
#define HWASSIGNMENT3_MAZE_H
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

/*
 * Maze
 *
 * this is a class that holds a maze that is created when read in from a txt file
 * this class stores ints for the amount of rows and columns up to a max of 100.
 * the class also stores ints for which row and column the exit of the maze is.
 * the maze is stored in a 2 dimensional char array with ' ' for moveable
 * spaces and '+' where a creature has visited '*' where creatures path to exit is
 * and 'X' or '#'
 */
class Maze {
private:
    static int const MAX_ROWS = 100;
    static int const MAX_COLUMNS = 100;
    int rows;
    int columns;
    int rowExit;
    int columnExit;
    char maze [MAX_ROWS][MAX_COLUMNS];
public:
    /*
     * operator<<
     *
     * this is a function to overload the << operator to print out
     * the maze in 2d form from the 2d maze array to the console when
     * the << operator is called on a maze object
     */
    friend ostream& operator<<(ostream &out, const Maze &maze);

    /*
     * operator=
     *
     * this is a function to overload the = operator to assign the creature
     * this operator is called on, to be equal to the creature passed into the
     * parameter with all instance variables being the same.
     */
    Maze& operator=(const Maze &maze);

    /*
     * IsClear
     *
     * this is a function to check if the row and column passed in as
     * parameters, is a clear and moveable space in the maze that is
     * represented by a ' '
     */
    bool IsClear(int row, int column) const;

    /*
     * IsWall
     *
     * this is a function to check if the row and column passed in as
     * parameters, is a wall which is represented by a space that is
     * not clear, not a space where the creature traveled, a space where the
     * creature visited, and is not the maze exit.
     */
    bool IsWall(int row, int column) const;

    /*
     * IsPath
     *
     * this is a function to check if the row and column passed in
     * as parameters, is a space that is apart of a creatures path
     * that has traveled through the maze represented by a '*'
     */
    bool IsPath(int row, int column) const;

    /*
     * IsVisited
     *
     * this is a function to check if the row and column passed in
     * as parameters, is a space that has been visited by a  creatures
     * that has traveled through the maze represented by a '+'
     */
    bool IsVisited(int row, int column) const;

    /*
     * IsExit
     *
     * this is a function to check if the row and column passed in as
     * parameters, are equal to the exit of the maze. in other words it checks
     * that this row and column passed in are the rowExit and columnExit
     */
    bool IsExit(int row, int column) const;

    /*
     * MarkAsPath
     *
     * this is a function that marks the maze with '*' for a space
     * that is a part of the path of a creature that travels through
     * the maze to the exit.
     */
    void MarkAsPath(int row, int column);

    /*
     * MarkAsVisited
     *
     * this is a function that marks the maze with '+' for a space
     * that a creature has visited as the creature travels through the
     * maze.
     */
    void MarkAsVisited(int row, int column);

    /*
     * Maze
     *
     * this is a constructor for the Maze class requiring a valid file name
     * for the maze to be read in from and intialize the width, height, rowExit,
     * columnExit, and structure of the maze.
     */
    explicit Maze(string mazeFile);

    /*
     * Maze
     *
     * this is a copy constructor for the maze class that copies the
     * instance variables from the maze object passed into the parameter
     * and stores it for a new Maze object being created
     */
    Maze(Maze &maze);

    int getRow() const;
    int getColumn() const;
    int getRowExit() const;
    int getColumnExit() const;
};


#endif //HWASSIGNMENT3_MAZE_H
