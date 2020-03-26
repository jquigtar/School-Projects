/*
 * Jordan Quigtar
 * HWAssignment #3
 */
#include "creature.h"
#include <iostream>
#include <fstream>
#include <string>


/*
 * main
 *
 * this is the main function for HW assignment3 where there are
 * tests for the maze and creature class
 */
int main() {
    Maze m1("mazeSimple.txt");
    cout << m1 << endl;

    Maze m2("maze.txt");
    cout << m2 << endl;

    Maze m3("maze0.txt");
    cout << m3 << endl;

    Maze m4("maze1.txt");
    cout << m4 << endl;

    Maze m5("maze2.txt");
    cout << m5 << endl;

    Creature c1(3, 2);
    cout << c1 << endl;
    string c1m1 = c1.Solve(m1);
    cout << c1m1 << endl;
    cout << m1 << endl;
    cout << c1 << endl;

    Creature c2(2, 14);
    cout << c2 << endl;
    string c2m2 = c2.Solve(m2);
    cout << c2m2 << endl;
    cout << m2 << endl;
    cout << c2 << endl;

    Creature c3(2, 7);
    cout << c3 << endl;
    string c3m3 = c3.Solve(m3);
    cout << c3m3 << endl;
    cout << m3 << endl;
    cout << c3 << endl;

    Creature c4(1, 1);
    cout << c4 << endl;
    string c4m4 = c4.Solve(m4);
    cout << c4m4 << endl;
    cout << m4 << endl;
    cout << c4 << endl;

    Creature c5(4, 6);
    cout << c5 << endl;
    string c5m5 = c5.Solve(m5);
    cout << c5m5 << endl;
    cout << m5 << endl;
    cout << c5 << endl;
    return 0;

}