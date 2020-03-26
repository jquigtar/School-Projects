//
// Created by Jordan Quigtar on 12/2/19.
//

#include "clientAccount.h"

clientAccount::clientAccount(const string &firstName, const string &lastName, const int &idNumber) {
    if(idNumber > 999 && idNumber < 10000) {
        //as long as id number is 4 digits
        this->firstName = firstName;
        this->lastName = lastName;
        this->idNumber = idNumber;
        for (int i = 0; i < NUMBER_OF_FUNDS; i++) {
            funds[i] = 0;
            fundsHistory[i] = "";
        }
    }else{
        //do not set account
        cout << "invalid ID Number." << endl;
        delete this;
    }

}

void clientAccount::withdrawFunds(int fund, int toWithdraw) {
    if(toWithdraw >= 0) {
        //can not withdraw negative values
        if (funds[fund] >= toWithdraw) {
            //fund has enough to withdraw
            funds[fund] -= toWithdraw;
            switch (fund) {//sending transaction to correct
                //fund history
                case 0:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 1:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 2:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 3:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 4:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 5:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 6:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 7:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 8:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                case 9:
                    fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                          + " " + to_string(toWithdraw) + "\n";
                    break;
                default:
                    cout << "ERROR: invalid fund";
            }
        } else {//handling if fund did not have enough money
            //funds 0, and 1 connected
            //funds 2, and 3 connected
            if (fund == 0 && toWithdraw - funds[0] <= funds[1]) {
                //can withdraw from fund 1 to help fund 0
                transferFunds(1, this, 0, toWithdraw - funds[0]);
                withdrawFunds(fund, toWithdraw);
            } else if (fund == 1 && toWithdraw - funds[1] <= funds[0]) {
                transferFunds(0, this, 1, toWithdraw - funds[1]);
                withdrawFunds(fund, toWithdraw);
            } else if (fund == 2 && toWithdraw - funds[2] <= funds[3]) {
                transferFunds(3, this, 2, toWithdraw - funds[2]);
                withdrawFunds(fund, toWithdraw);
            } else if (fund == 3 && toWithdraw - funds[3] <= funds[2]) {
                transferFunds(2, this, 3, toWithdraw - funds[3]);
                withdrawFunds(fund, toWithdraw);
            } else {
                switch (fund) {// error messages
                    case 0:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Money Market fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 1:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Prime Money Market fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 2:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Long-Term Bond fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 3:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Short-Term Bond fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 4:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " 500 Index fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 5:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Capital Value fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 6:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Growth Equity fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 7:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Growth Index fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 8:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Value fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    case 9:
                        cout << "ERROR: Not enough funds to withdraw " << toWithdraw << " from "
                             << this->firstName << " " << this->lastName << " Value Stock Index fund" << endl;
                        fundsHistory[fund] += "  W " + to_string(getIDNumber()) + to_string(fund)
                                              + " " + to_string(toWithdraw) + " (Failed)\n";
                        break;
                    default:
                        cout << "ERROR: invalid fund";
                }
            }
        }
    }else{
        cout << "ERROR: can not withdraw negative values." << endl;
    }
}

void clientAccount::depositFunds(int fund, int toDeposit) {
    if(toDeposit >= 0) {//can not deposit negative values
        funds[fund] += toDeposit;
        switch (fund) {
            //store fund transaction history for deposits
            case 0:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 1:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 2:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 3:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 4:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 5:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 6:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 7:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 8:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            case 9:
                fundsHistory[fund] += "  D " + to_string(getIDNumber()) + to_string(fund)
                                      + " " + to_string(toDeposit) + "\n";
                break;
            default:
                cout << "ERROR: invalid fund";
        }
    }else{
        cout << "ERROR: Can not deposit negative values." << endl;
    }
}

void clientAccount::transferFunds(int fromFund, clientAccount *to, int toFund, int toTransfer) {
    if(toTransfer >= 0) {
        //can not transfer negative values
        if (toTransfer >= 0 && funds[fromFund] >= toTransfer) {
            //as long as funds have enough money
            funds[fromFund] -= toTransfer;
            funds[toFund] += toTransfer;
            switch (fromFund) {
                case 0:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 1:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 2:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 3:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 4:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 5:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 6:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 7:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 8:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                case 9:
                    fundsHistory[fromFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                              + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                              + to_string(toFund) + "\n";
                    break;
                default:
                    cout << "ERROR: invalid fund";
            }

            switch (toFund) {
                case 0:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 1:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 2:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 3:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 4:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 5:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 6:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 7:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 8:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                case 9:
                    fundsHistory[toFund] += "  T " + to_string(getIDNumber()) + to_string(fromFund)
                                            + " " + to_string(toTransfer) + " " + to_string(to->getIDNumber())
                                            + to_string(toFund) + "\n";
                    break;
                default:
                    cout << "ERROR: invalid fund";
            }
        }
    }else{
        cout << "ERROR: can not transfer negative values." << endl;
    }
}

void clientAccount::printHistory() const {
    cout << "Transaction history for " << firstName << " " << lastName << " by fund.\n";
    for(int i = 0; i < NUMBER_OF_FUNDS; i++){
        if(fundsHistory[i] != ""){
            switch(i) {
                case 0:
                    cout << "Money Market: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 1:
                    cout << "Prime Money Market: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 2:
                    cout << "Long-Term Bond: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 3:
                    cout << "Short-Term Bond: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 4:
                    cout << "500 Index Fund: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 5:
                    cout << "Capital Value Fund: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 6:
                    cout << "Growth Equity Fund: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 7:
                    cout << "Growth Index Fund: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 8:
                    cout << "Value Fund: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                case 9:
                    cout << "Value Stock Index: $" << funds[i] << endl;
                    cout << fundsHistory[i];
                    break;
                default:
                    cout << "ERROR: invalid fund";
            }
        }
    }
}

void clientAccount::printHistory(int fund) const {
    switch(fund) {
        case 0:
            cout << "Transaction history for " << firstName << " " << lastName << " Money Market Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 1:
            cout << "Transaction history for " << firstName << " " << lastName << " Prime Money Market Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 2:
            cout << "Transaction history for " << firstName << " " << lastName << " Long-Term Bond Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 3:
            cout << "Transaction history for " << firstName << " " << lastName << " Short-Term Bond Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 4:
            cout << "Transaction history for " << firstName << " " << lastName << " 500 Index Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 5:
            cout << "Transaction history for " << firstName << " " << lastName << " Capital Value Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 6:
            cout << "Transaction history for " << firstName << " " << lastName << " Growth Equity Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 7:
            cout << "Transaction history for " << firstName << " " << lastName << " Growth Index Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 8:
            cout << "Transaction history for " << firstName << " " << lastName << " Value Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        case 9:
            cout << "Transaction history for " << firstName << " " << lastName << " Value Stock Index Fund: $" << funds[fund] << endl;
            cout << fundsHistory[fund];
            break;
        default:
            cout << "invalid fund";
    }
}

int clientAccount::getIDNumber() const {
    return idNumber;
}

ostream &operator<<(ostream &os, const clientAccount &account){
    os << account.firstName << " " << account.lastName << " Account ID: "
    << account.getIDNumber() << endl <<
    "    Money Market: $" << account.funds[0] << endl <<
    "    Prime Money Market: $" << account.funds[1] << endl <<
    "    Long-Term Bond: $" << account.funds[2] << endl <<
    "    Short-Term Bond: $" << account.funds[3] << endl <<
    "    Index Fund: $" << account.funds[4] << endl <<
    "    Capital Value Fund: $" << account.funds[5] << endl <<
    "    Growth Equity Fund: $" << account.funds[6] << endl <<
    "    Growth Index Fund: $" << account.funds[7] << endl <<
    "    Value Fund: $" << account.funds[8] << endl <<
    "    Value Stock Index: $" << account.funds[9] << endl << endl;
    return os;
}

clientAccount::~clientAccount() {

}
