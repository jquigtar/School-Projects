//
// Created by Jordan Quigtar on 10/18/19.
//

#ifndef HWASSIGNMENT3_CREATURE_H
#define HWASSIGNMENT3_CREATURE_H
#include "maze.h"

#include <iostream>
#include <fstream>
#include <string>


using namespace std;

/*
 * Creature
 *
 * this is a class that holds a row and column position for a creatures
 * (X,Y) position for any maze it is passed into from the maze class.
 * it also holds a string path that will show the directions for the
 * creature to exit from its initial position if possible.
 */
class Creature {
private:
    int rowPosition;
    int columnPosition;
    string path;
public:

    /*
     * operator<<
     *
     * this is a function to overload the << operator to print out the
     * creatures x and y position in the form C(X, Y)
     */
    friend ostream &operator<<(ostream &out, const Creature &creature);

    /*
     * operator=
     *
     * this is a function to overload the = operator to assign the maze
     * this operator is called on to be equal to the maze passed into the
     * parameter with all
     */
    Creature& operator= (const Creature &Creature);

    /*
     * Creature
     *
     * this is a constructor for the creature class that takes two int parameters
     * row and column to store for the creatures rowPosition and columnPositon
     */
    Creature(int row, int column);

    /*
     * Creature
     *
     * this is a copy constructor for the creature class that copies all of the
     * instance variables from the creature object passed into the parameter and
     * creates a new creature object with these same values
     */
    Creature(const Creature &creature);

    /*
     * Solve
     *
     * this is the solve function that returns a string in the form of NNEEN
     * (where N means North, E means East, etc)
     * that will let the creature get to the exit
     * if creature cannot get to the exit, returns "X" string
     */
    string Solve(Maze &maze);

    /*
     * goNorth
     *
     * this is a recursive function that will first check if you can move
     * to the space north of the creatures position. if so, then check if
     * have moved to the exit if so, it will return true and change
     * the path instance variable for the move the creature just made.
     * if not it will try the goWest function , then try goEast function.
     * if none of these work then it will return false. move back to its
     * original position and change the path variable to remove the last move
     * the creature did that did not work.
     */
    bool goNorth(Maze &maze);

    /*
     * goEast
     *
     * this is a recursive function that will first check if you can move
     * to the space east of the creatures position. if so, then check if
     * have moved to the exit if so, it will return true and change
     * the path instance variable for the move the creature just made.
     * if not it will try the goNorth function , then try goSouth function.
     * if none of these work then it will return false. move back to its
     * original position and change the path variable to remove the last move
     * the creature did that did not work.
     */
    bool goEast(Maze &maze);

    /*
     * goSouth
     *
     * this is a recursive function that will first check if you can move
     * to the space South of the creatures position. if so, then check if
     * have moved to the exit if so, it will return true and change
     * the path instance variable for the move the creature just made.
     * if not it will try the goWest function , then try goEast function.
     * if none of these work then it will return false. move back to its
     * original position and change the path variable to remove the last move
     * the creature did that did not work.
     */
    bool goSouth(Maze &maze);

    /*
     * goWest
     *
     * * this is a recursive function that will first check if you can move
     * to the space west of the creatures position. if so, then check if
     * have moved to the exit if so, it will return true and change
     * the path instance variable for the move the creature just made.
     * if not it will try the goNortht function , then try goSouth function.
     * if none of these work then it will return false. move back to its
     * original position and change the path variable to remove the last move
     * the creature did that did not work.
     */
    bool goWest(Maze &maze);

};


#endif //HWASSIGNMENT3_CREATURE_H
