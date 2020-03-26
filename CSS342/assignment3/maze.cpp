//
// Created by Jordan Quigtar on 10/18/19.
//

#include "maze.h"
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

Maze::Maze(string mazeFile) {
    string line;
    ifstream inFile(mazeFile);

    if(inFile.is_open()){

        inFile >> columns >> rows >> rowExit >> columnExit;
        //store first 4 ints in this order from txt file
        if(columns > 2 && columns < 101 && rows > 2 && rows < 101) {
            //check to make sure the maze is formed well and not
            //over max 100 rows and columns
            getline(inFile, line);

            for (int i = 0; i < rows; i++) {
                getline(inFile, line);
                for (int j = 0; j < columns; j++) {
                    if(line[j] != '\t') {
                        maze[i][j] = line[j];
                        //as long as no tabs store the maze into
                        //2d char array
                    }else{
                        cout << "file has tabs instead of spaces" << endl;
                        exit(0);
                    }
                }
            }
            inFile.close();
        }else{
            cout << "invalid maze"<< endl;
            inFile.close();
        }
    } else {
        cout << "Unable to open file." << endl;
    }

}

ostream &operator<<(ostream &out, const Maze &maze) {
    for(int i = 0; i < maze.rows; i++){
        for(int j = 0; j < maze.columns; j++){
            out << maze.maze[i][j];
        }
        out << endl;
        //print each line of maze on its own line
    }
    return out;
}

int Maze::getRow() const{
    return this->rows;
}

int Maze::getColumn() const{
    return this->columns;
}

int Maze::getRowExit() const{
    return this->rowExit;
}

int Maze::getColumnExit() const{
    return this->columnExit;
}

void Maze::MarkAsPath(int row, int column) {
    maze[row][column] = '*';
}

void Maze::MarkAsVisited(int row, int column) {
    maze[row][column] = '+';
}

bool Maze::IsClear(int row, int column) const {
    if(maze[row][column] == ' '){
        return true;
    }
    return false;
}

bool Maze::IsWall(int row, int column) const {
    if(!IsClear(row, column) && !IsExit(row, column) &&
    !IsPath(row, column) && !IsVisited(row, column)){
        //since some mazes have 'x' and some have '#' as a wall
        //i made sure any character could be a wall besides
        //' ', '+', '*'
        return true;
    }
    return false;
}

bool Maze::IsPath(int row, int column) const {
    if(maze[row][column] == '*'){
        return true;
    }
    return false;
}

bool Maze::IsVisited(int row, int column) const {
    if(maze[row][column] == '+'){
        return true;
    }
    return false;
}

bool Maze::IsExit(int row, int column) const {
    if(row == this->rowExit && column == this->columnExit){
        return true;
    }
    return false;
}

Maze::Maze(Maze &maze) {
    this->rows = maze.rows;
    this->columns =  maze.columns;
    this->rowExit = maze.rowExit;
    this->columnExit = maze.columnExit;
    for(int i =0; i < rows; i++){
        for(int j = 0; i< columns; j++){
            this->maze[i][j] = maze.maze[i][j];
        }
    }
}

Maze &Maze::operator=(const Maze &maze) {
    this->rows = maze.rows;
    this->columns =  maze.columns;
    this->rowExit = maze.rowExit;
    this->columnExit = maze.columnExit;
    for(int i =0; i < rows; i++){
        for(int j = 0; i< columns; j++){
            this->maze[i][j] = maze.maze[i][j];
        }
    }
    return *this;
}
