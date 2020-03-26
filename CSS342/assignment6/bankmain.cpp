//
// Created by Jordan Quigtar on 12/2/19.
//

#include "bank.h"
#include <iostream>

using namespace std;

/**
 * main
 *
 * This is the main function for the banking assignment for CSS 342
 * and has parameters argc and argv to count the number of items put into
 * the command line and store them as strings. This is used to pass in a
 * txt file from the command line to read in. This text file should have
 * transactions for a bank as explained in the banking assignment instructions
 * to be processed in this main function. otherwise error messages will appear
 * and the program will exit.
 * @param argc
 * @param argv
 * @return 0
 */
int main(int argc, char *argv[]) {
    if(argc == 2){
        bank bank;
        bank.readInFromFile(argv[1]);
        //read well formed transactions from file with
        //name given on command line
        bank.performTransactions();
        //perform transactions from banks transactions queue
        cout << endl;
        bank.printBankAccounts();
        //print final totals for each account in bank after all
        //transactions are finished from queue
    }else{//file was not entered on command line to read from
        cout << "Must enter file name in command line" << endl;
        cout << "ending program" << endl;
    }

    return 0;
}