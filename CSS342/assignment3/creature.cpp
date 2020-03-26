//
// Created by Jordan Quigtar on 10/18/19.
//

#include "creature.h"
#include <string>
#include <iostream>


Creature::Creature(int row, int column){
    this->columnPosition = column;
    this->rowPosition = row;
}

string Creature::Solve(Maze &maze) {
    if(maze.IsWall(rowPosition,columnPosition) || rowPosition < 0 ||
    columnPosition < 0 || rowPosition > maze.getRow() || columnPosition > maze.getColumn()){
        cout << "invalid creature position for this maze" << endl;
        exit(0);
    }else {
        maze.MarkAsPath(rowPosition, columnPosition);
        if (maze.IsExit(rowPosition, columnPosition)) {
            return path;
        } else if (maze.IsClear(rowPosition - 1, columnPosition)) {
            goNorth(maze);
        } else if (maze.IsClear(rowPosition, columnPosition + 1)) {
            goEast(maze);
        }else if (maze.IsClear(rowPosition + 1, columnPosition)) {
            goSouth(maze);
        }else if (maze.IsClear(rowPosition, columnPosition - 1)) {
            goWest(maze);
        } else {
            path = "X";
        }
        if(path == ""){
            path = "X";
        }
        return path;
    }
}

bool Creature::goNorth(Maze &maze) {
    //followed algorithm in book example
    //goSouth is analogous to this function
    bool success;
    if(maze.IsClear(rowPosition - 1, columnPosition)){
        //if you can move in north direction go that way
        rowPosition = rowPosition - 1;
        maze.MarkAsPath(rowPosition, columnPosition);
        //mark as part of the path and set add this direction to path
        path = path + "N";
        if(maze.IsExit(rowPosition, columnPosition)){
            success = true;
            //if you hit exit break recursion
        }else{
            success = goNorth(maze);
            //otherwise
            if(!success){
                success = goWest((maze));
                //try the west direction
                if(!success){
                    //if this doesnt work try the east direction
                    success = goEast(maze);
                    if(!success){
                        //if none work go back to position you came from
                        //from the south of your current position
                        //and mark the position you just visited as visited
                        maze.MarkAsVisited(rowPosition, columnPosition);
                        rowPosition = rowPosition + 1;
                        //remove the direction you added to the path since it did
                        //not result as the path to exit
                        path.pop_back();
                    }
                }
            }
        }
    }else{
        success = false;
    }
    //success is only true when you reach the exit and false otherwise
    return success;
}

bool Creature::goEast(Maze &maze) {
    //from book similar to goNorth
    //but prioritizes north then south after going east
    //goWest is analogous to this function
    bool success;
    if(maze.IsClear(rowPosition, columnPosition + 1)){
        columnPosition = columnPosition + 1;
        maze.MarkAsPath(rowPosition, columnPosition);
        path = path + "E";
        if(maze.IsExit(rowPosition, columnPosition)){
            success = true;
        }else{
            success = goEast(maze);
            if(!success){
                success = goNorth((maze));
                if(!success){
                    success = goSouth(maze);
                    if(!success){
                        maze.MarkAsVisited(rowPosition, columnPosition);
                        columnPosition = columnPosition - 1;
                        path.pop_back();
                    }
                }
            }
        }
    }else{
        success = false;
    }
    return success;
}

bool Creature::goSouth(Maze &maze) {
    bool success;
    if(maze.IsClear(rowPosition + 1, columnPosition)){
        rowPosition = rowPosition + 1;
        maze.MarkAsPath(rowPosition, columnPosition);
        path = path + "S";
        if(maze.IsExit(rowPosition, columnPosition)){
            success = true;
        }else{
            success = goSouth(maze);
            if(!success){
                success = goWest((maze));
                if(!success){
                    success = goEast(maze);
                    if(!success){
                        maze.MarkAsVisited(rowPosition, columnPosition);
                        rowPosition = rowPosition - 1;
                        path.pop_back();
                    }
                }
            }
        }
    }else{
        success = false;
    }
    return success;
}

bool Creature::goWest(Maze &maze) {
    bool success;
    if(maze.IsClear(rowPosition, columnPosition - 1)){
        columnPosition = columnPosition - 1;
        maze.MarkAsPath(rowPosition, columnPosition);
        path = path + "W";
        if(maze.IsExit(rowPosition, columnPosition)){
            success = true;
        }else{
            success = goWest(maze);
            if(!success){
                success = goNorth((maze));
                if(!success){
                    success = goSouth(maze);
                    if(!success){
                        maze.MarkAsVisited(rowPosition, columnPosition);
                        columnPosition = columnPosition + 1;
                        path.pop_back();
                    }
                }
            }
        }
    }else{
        success = false;
    }
    return success;
}

ostream &operator<<(ostream &out, const Creature &creature) {
    out << "C(" << creature.columnPosition << ", " << creature.rowPosition <<
    ")" << endl;
    return out;
}

Creature& Creature::operator=(const Creature &creature) {
    this->rowPosition = creature.rowPosition;
    this->columnPosition = creature.columnPosition;

    return *this;
}

Creature::Creature(const Creature &creature) {
    this->rowPosition = creature.rowPosition;
    this->columnPosition = creature.columnPosition;
}
