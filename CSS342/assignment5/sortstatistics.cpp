//
// Created by Jordan Quigtar on 11/18/19.
//
#include <iostream>
#include <cstdio>
#include "arrayList.h"
using namespace std;

/*
 * main
 *
 * this is the main function of sortStatistics
 * to test reading in data from a file and creating an arrayList
 * to be sorted using an insertion, merge, and quick sort, and display
 * the statistics of how many times different methods were used in those sorts
 * when being ran from the command line there is an option for -d to dump
 * the results of the sorts into the console before displaying the statistics.
 * other wise you will still need to insert the name of the file you are
 * reading from on the command line as an argumnert
 * the order being either
 * -d nameOfFile
 * or
 * nameOfFile
 */
int main(int argc, char* argv[]){

    if(argc == 3 && string(argv[1]) == "-d"){
        ArrayList<int> arr;
        arr.readFileWithSortedArrays(argv[2]);
    }else{
        ArrayList<int> arr;
        arr.readFile(argv[1]);
    }

    return 0;
}
