//
// Created by Jordan Quigtar on 12/3/19.
//

#ifndef HWASSIGNMENT6_BANK_H
#define HWASSIGNMENT6_BANK_H

#include "BSTree.h"
#include <queue>
#include "clientAccount.h"
#include <string>

/**
 * bank
 *
 * This is a class bank that holds a BSTree of clientAccounts as well
 * as a string queue of transactions being passed into the bank.
 * there are functions to: read in from a file and initialize the transactions
 * queue, perform the transactions from the transactions queue on accounts in the
 * BSTree, and to print all bank accounts to the console in the BSTree
 */
class bank {
public:

    //destructor
    ~bank();

    /**
     * readInFromFile
     *
     * this is a function that reads in from a file with the name
     * that was passed in as a parameter. it then enters each line
     * from the file into the transactions queue as a string.
     * @param fileName
     * @pre the file has well formed transactions
     * @post the transactions queue is filled
     */
    void readInFromFile(string fileName);

    /**
     * performTransactions
     *
     * this is a function that performs each transaction in
     * the transactions queue as FIFO order. these transactions
     * can be open, withdraw, deposit, transfer, and print history.
     */
    void performTransactions();

    /**
     * printBankAccounts
     *
     * this is a function that will print out each account in the form
     * first name last name ID: XXXX
     * fund: $XXXX
     * for each fund within an account and for each account in the bank.
     * the order of which the accounts are printed are from the lowest
     * ID number to the greatest.
     */
    void printBankAccounts();

private:
    BSTree *accounts = new BSTree();
    queue<string> transactions;
};


#endif //HWASSIGNMENT6_BANK_H
