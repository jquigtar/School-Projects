#include <iostream>
#include "inventorymanager.h"

using namespace std;

int main() {
    ifstream moviesFile("data4movies.txt");
    if (!moviesFile) {
        cout << "File could not be opened." << endl;
        return 1;
    }
    ifstream customersFile("data4customers.txt");
    if (!customersFile) {
        cout << "File could not be opened." << endl;
        return 1;
    }

    ifstream transactionsFile("data4commands.txt");
    if (!transactionsFile) {
        cout << "File could not be opened." << endl;
        return 1;
    }

    InventoryManager storeInventoryManager;
    storeInventoryManager.buildCustomers(customersFile);
    storeInventoryManager.buildMovies(moviesFile);
    storeInventoryManager.processTransactions(transactionsFile);

    moviesFile.close();
    customersFile.close();
    transactionsFile.close();

    return 0;
}