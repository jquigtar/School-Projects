//
// Created by Jordan Quigtar on 12/3/19.
//

#include "bank.h"
#include <iostream>
#include <fstream>
#include <sstream>

void bank::readInFromFile(string fileName) {
    string line;
    ifstream inFile(fileName);
    if (inFile.is_open()) {
        while (getline(inFile, line)) {
            //entering each line from the file into the queue
            //until you reach the end of the file
            transactions.push(line);
        }
    } else {
        cout << "Unable to open file." << endl;
    }
}

void bank::performTransactions() {
    while (!this->transactions.empty()) {
        string popped = transactions.front();
        istringstream iss(popped);
        //store the string at front of queue
        //then pop it off of the queue

        char type;
        iss >> type;
        //first letter of string is the type of transaction

        int idNumber;
        int amount;

        if (type == 'O') {//open an account
            string first;
            string last;
            iss >> last >> first >> idNumber;
            clientAccount *newAccount = new clientAccount(first, last, idNumber);
            if (!accounts->Insert(newAccount)) {
                //if the account already exists clean up memory
                //if the account was inserted this code will not run
                delete newAccount;
                newAccount = nullptr;
            }
        }
        if (type == 'D') {//deposit
            int fund;
            iss >> idNumber >> amount;

            //modulo of 10 on a number between 10000 and 99999 should leave
            // a remainder of 0-9 for a fund
            fund = idNumber % 10;
            //dividing by 10 will cut last number off of the number
            //read in from the file 10010 = account 1001 fund 0
            idNumber = idNumber / 10;

            clientAccount *toRetrieve = nullptr;
            if (accounts->Retrieve(idNumber, toRetrieve)) {
                //will retrieve the correct account from the tree if
                //the function returns true
                //and then deposit the correct amount to the correct fund
                //in this account
                toRetrieve->depositFunds(fund, amount);
            } else {//account not retrieved
                cout << "ERROR: Account " << idNumber <<
                     " not found. Deposit refused.\n";
            }
        }
        if (type == 'W') {// withdraw
            int fund;
            iss >> idNumber >> amount;
            fund = idNumber % 10;
            idNumber = idNumber / 10;
            clientAccount *toRetrieve = nullptr;
            if (accounts->Retrieve(idNumber, toRetrieve)) {
                //retrieve and withdraw
                toRetrieve->withdrawFunds(fund, amount);
            } else {//account not in bank
                cout << "ERROR: Account " << idNumber <<
                     " not found. Withdrawl refused.\n";
            }
        }
        if (type == 'T') {//transfer
            int fund;
            int otherAccount;
            int otherAccountFund;
            iss >> idNumber >> amount >> otherAccount;
            // line read in as T 10010 500 10020
            fund = idNumber % 10;
            otherAccountFund = otherAccount % 10;
            idNumber = idNumber / 10;
            otherAccount = otherAccount / 10;
            clientAccount *toRetrieveOne = nullptr;
            clientAccount *toRetrieveTwo = nullptr;

            if (accounts->Retrieve(idNumber, toRetrieveOne)) {
                if (accounts->Retrieve(otherAccount, toRetrieveTwo)) {
                    //if both accounts are retrieved transfer from first account
                    //to second account into correct funds
                    toRetrieveOne->transferFunds(fund, toRetrieveTwo, otherAccountFund, amount);
                } else {// second account not found
                    cout << "ERROR: Account " << otherAccount <<
                         " not found. Transferal refused.\n";
                }
            } else {//first account not found
                cout << "ERROR: Account " << idNumber <<
                     " not found. Transferal refused.\n";
            }
        }
        if (type == 'H') {//history
            iss >> idNumber;
            if (idNumber > 999 && idNumber < 10000) {
                //if account number was entered in with no specified fund
                clientAccount *toRetrieve = nullptr;
                if (accounts->Retrieve(idNumber, toRetrieve)) {
                    //print history of account by fund if found in bank
                    toRetrieve->printHistory();
                } else {//account not found
                    cout << "ERROR: Account " << idNumber <<
                         " not found. History display refused.\n";
                }
            } else {
                //if account number given with specified fund
                int fund = idNumber % 10;
                idNumber = idNumber / 10;
                clientAccount *toRetrieve = nullptr;
                if (accounts->Retrieve(idNumber, toRetrieve)) {
                    //print history of specified fund
                    toRetrieve->printHistory(fund);
                } else {//account not found
                    cout << "ERROR: Account " << idNumber <<
                         " not found. History display refused.\n";
                }
            }
        }
        transactions.pop();//pop transaction off queue
    }
}

void bank::printBankAccounts() {
    cout << "Processing Done. Final Balances\n\n";
    accounts->Display();
}

bank::~bank() {
    delete accounts;
    accounts = nullptr;
}

