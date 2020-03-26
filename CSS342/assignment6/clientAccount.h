//
// Created by Jordan Quigtar on 12/2/19.
//

#ifndef HWASSIGNMENT6_CLIENTACCOUNT_H
#define HWASSIGNMENT6_CLIENTACCOUNT_H

#include <iostream>

using namespace std;

/**
 * clientAccount
 *
 * this is a class to that is a client account for a bank. it holds
 * the first and last name of account holder and also their account ID
 * number. each account has 10 funds stored as an int array. with history of
 * transactions for each fund being stored as string array. an account has functions
 * withdraw, deposit, transfer, print history for each fund or individual funds,
 * and and overloaded << operator.
 */
class clientAccount {
public:

    //constructor
    clientAccount(const string &firstName, const string &lastName, const int &idNumber);

    //destructor
    ~clientAccount();

    /**
     * withdrawFunds
     *
     * this is a function to withdraw money from a specific fund
     * within the clients bank account.
     * @param fund
     * @param toWithdraw
     */
    void withdrawFunds(int fund, int toWithdraw);

    /**
     * depositFunds
     *
     * this is a function to deposit money from a specific fund
     * within the clients bank account.
     * @param fund
     * @param toDeposit
     */
    void depositFunds(int fund, int toDeposit);

    /**
     * transferFunds
     *
     * this is a function to transfer money from one fund in someones bank account
     * to another fund in the same or different bank account.
     * @param fromFund
     * @param to
     * @param toFund
     * @param toTransfer
     */
    void transferFunds(int fromFund, clientAccount *to, int toFund, int toTransfer);

    /**
     * printHistory
     *
     * this is  a function to print the transaction history for all
     * fund within a bank account.
     */
    void printHistory() const;

    /**
     * printHistory
     *
     * this is  a function to print the transaction history for one
     * specific fund within a bank account.
     * @param fund
     */
    void printHistory(int fund) const;

    //getter for IDNumber
    int getIDNumber() const;

    /**
     * operator<<
     *
     * this is the function to overload the << operator
     * to print a bank account in the form
     * first name last name Account ID: XXXX
     * fund: $XXXX
     * for all funds within the account.
     * @param os
     * @param account
     * @return
     */
    friend ostream &operator<<(ostream &os, const clientAccount &account);

private:
    string firstName;
    string lastName;
    int idNumber;
    static const int NUMBER_OF_FUNDS = 10;
    int funds[NUMBER_OF_FUNDS];
    string fundsHistory[NUMBER_OF_FUNDS];
};


#endif //HWASSIGNMENT6_CLIENTACCOUNT_H
