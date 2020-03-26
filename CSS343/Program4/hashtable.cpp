//
// Created by Jordan Quigtar on 3/11/20.
//

#include "hashtable.h"

HashTable::HashTable() {
    for(int i = 0; i <100; i++){
        for(int j = 0; j < 100; j++){
            table[i][j] = nullptr;
        }
    }
}

HashTable::~HashTable() {
    for(int i = 0; i < 100; i++){
        for(int j = 0; j < 100; j++){
            if(table[i][j] != nullptr) {
                delete table[i][j];
                table[i][j] = nullptr;
            }
        }
    }
}

bool HashTable::insert(Customer *customer) {
    int key = customer->getID();
    int mod = key % 100;
    int hash = mod % 10;
    if (table[mod][hash] == nullptr) {
        table[mod][hash] = customer;
        return true;
    } else if (table[mod][hash]->getID() == key) {
        return false;
    } else {
        for (int i = hash + hashFunction(mod); i < 100; i += hashFunction(mod)) {
            if(i == hash){
            return false;
            }
            if (table[mod][i] == nullptr) {
                table[mod][i] = customer;
                return true;
            } else if (table[mod][i]->getID() == key) {
                return false;
            }
            if(i + hashFunction(mod) > 100){
                i = i - 100;
            }
        }
    }
}

int HashTable::hashFunction(const int &key) const {
    return 7 - (key % 7);
}

bool HashTable::remove(const int &key) {
    int mod = key % 100;
    int hash = mod % 10;
    if (table[mod][hash] != nullptr) {
        if (table[mod][hash]->getID() == key) {
            delete table[mod][hash];
            table[mod][hash] = nullptr;
            return true;
        } else {
            for (int i = hash + hashFunction(mod); i < 100; i += hashFunction(mod)) {
                if (i == hash) {
                    return false;
                }
                if (table[mod][i] != nullptr) {
                    if (table[mod][hash]->getID() == key) {
                        delete table[mod][hash];
                        table[mod][hash] = nullptr;
                        return true;
                    }
                } else {
                    return false;
                }
                if (i + hashFunction(mod) > 100) {
                    i = i - 100;
                }
            }
        }
    }else{
        return false;
    }
}

bool HashTable::retrieve(const int &key, Customer *&toReturn) const {
    int mod = key % 100;
    int hash = mod % 10;
    if (table[mod][hash] != nullptr) {
        if (table[mod][hash]->getID() == key) {
            toReturn = table[mod][hash];
            return true;
        } else {
            for (int i = hash + hashFunction(mod); i < 100; i += hashFunction(mod)) {
                if (i == hash) {
                    return false;
                }
                if (table[mod][i] != nullptr) {
                    if (table[mod][i]->getID() == key) {
                        toReturn = table[mod][i];
                        return true;
                    }
                } else {
                    return false;
                }
                if (i + hashFunction(mod) > 100) {
                    i = i - 100;
                }
            }
        }
    }else{
        return false;
    }
}
