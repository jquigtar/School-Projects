//
// Created by Jordan Quigtar on 11/6/19.
//

#include "skiplist.h"
#include <iostream>
#include <climits>
#include <cassert>
#include <cstdlib>

using namespace std;

SkipList::SkipList(int depth) {
    if (depth > 0) {
        this->depth = depth;
        frontGuards = new SNode *[depth];
        rearGuards = new SNode *[depth];
        //initialized depth of skipList and
        //made arrays for front and rear guards of the skiplist
        for (int i = 0; i < depth; i++) {
            frontGuards[i] = new SNode(INT_MIN);
            rearGuards[i] = new SNode(INT_MAX);
            //front and rear guards are nodes with the min and max integers as data
            frontGuards[i]->next = rearGuards[i];
            frontGuards[i]->prev = nullptr;
            rearGuards[i]->prev = frontGuards[i];
            rearGuards[i]->next = nullptr;
            //they point to each other as well as point to nullptr outside of the list
        }
        for (int i = 0; i < depth; i++) {
            if (i > 0) {
                //if not at bottom level of list set downLevel pointer to
                //Guards below this level
                frontGuards[i]->downLevel = frontGuards[i - 1];
                rearGuards[i]->downLevel = rearGuards[i - 1];
            } else {
                //nodes on bottom level point to null below
                frontGuards[i]->downLevel = nullptr;
                rearGuards[i]->downLevel = nullptr;
            }
            if (i == depth - 1) {
                //if at top level point to null above this level
                frontGuards[i]->upLevel = nullptr;
                rearGuards[i]->upLevel = nullptr;
            } else {
                //if not at top level set upLevel pointer to
                //to guards above this level
                frontGuards[i]->upLevel = frontGuards[i + 1];
                rearGuards[i]->upLevel = rearGuards[i + 1];
            }
        }
    } else {
        cout << "can not have depth below 1" << endl;
        exit(0);
    }
}

SkipList::~SkipList() {
    clear();
}

bool SkipList::Add(int data) {
    if (Contains(data)) {
        cout << "can not Add duplicates" << endl << endl;
        return false;
    } else {

        SNode *current = this->frontGuards[0];
        //point to front guard on bottom level
        while (current->next != nullptr && current->data < data) {
            //go until either you hit the end of the list of data or
            //stop when you reach a data that is greater then the data you are trying to Add
            current = current->next;
        }

        SNode *toAdd = new SNode(data);
        //create a new node to be added to the skiplist
        addBefore(toAdd, current);
        //Add before the current node you are pointing at

        int levelCounter = 2;
        //levelCounter is 2 because you just added to the bottom level which is the
        //first level in terms of depth
        while (levelCounter <= depth && alsoHigher()) {
            //while the coin flip is true and you haven't reached the last level
            //level counter goes up because you are now adding to the next level
            SNode *newUpper = new SNode(data);
            //create new node with same data for upper level
            //point at the current node you added at the below level
            current = toAdd;

            while (current->upLevel == nullptr) {
                //going backwards in the list while you haven't reached the
                //frontGuard, searching for a node with a upLevel link
                current = current->prev;
            }
            //addBefore will search for the node with data that is greater
            //then the data you are adding and at the new node before this one
            addBefore(newUpper, current->upLevel);
            //new node to be added above current level
            //link this newUpper to the node you just added in the bottom level
            toAdd->upLevel = newUpper;
            newUpper->downLevel = toAdd;
            //point to this node now to repeat process
            toAdd = toAdd->upLevel;
            levelCounter++;
        }
        //return true if data has been added to the list
        return true;
    }
}

bool SkipList::Remove(int data) {
    if (data == INT_MAX || data == INT_MIN) {
        cout << "cannot Remove front and rear guards." << endl;
        //safety precaution so front and rear guards can not be removed
        return false;
    } else if (!Contains(data)) {
        //return false if data is not in the list
        cout << "data not in list to Remove" << endl;
        return false;
    }
    SNode *current = this->frontGuards[0];
    //start at bottom left since all data is placed in bottom level
    while (current->next != nullptr) {
        //going right until you reach end of data
        if (current->data == data) {
            //break links between the data you are removing and
            //link its previous and next to point to each other
            current->prev->next = current->next;
            current->next->prev = current->prev;
            for (int i = 0; i < depth; i++) {
                if (current->upLevel != nullptr) {
                    //do the same for upper levels if there is a upLevel
                    current = current->upLevel;
                    delete current->downLevel;
                    current->downLevel = nullptr;
                    current->prev->next = current->next;
                    current->next->prev = current->prev;
                }
            }
            delete current;
            current = nullptr;
            //return true if data is removed
            return true;
        }
        current = current->next;
    }
    return true;
}

bool SkipList::Contains(int data) {
    SNode *current = frontGuards[depth - 1];
    //starting at top left of skiplist
    while (current != nullptr) {
        if (current->next->data <= data) {
            //go right until the next data is no
            //longer less than data you are looking for
            if (current->next->data == data) {
                return true;
            }
            current = current->next;
        } else {
            //if data you are looking for is less then the next data
            //then go down a level
            current = current->downLevel;
        }
    }
    return false;
}


ostream &operator<<(ostream &os, const SkipList &list) {
    for (int i = list.depth - 1; i > -1; i--) {
        SkipList::SNode *current = list.frontGuards[i];
        os << "Level: " << i << " -- ";
        //starting at level 0 and going to level = depth - 1
        while (current->next != nullptr) {
            if (current->next->data != INT_MAX) {
                os << current->data << ", ";
                //prints all nodes except for last two
            } else {
                os << current->data << ", " << current->next->data << endl;
                //once you are pointing at the node before rear guard
                //print data and print rearGuard without comma
            }
            current = current->next;
        }

    }
    return os;
}

void SkipList::addBefore(SNode *newNode, SNode *nextNode) {
    assert(newNode != nullptr && nextNode != nullptr);
    //make sure the nodes are not null

    while (nextNode->data < newNode->data) {
        nextNode = nextNode->next;
    }
    //previous node points to new node
    nextNode->prev->next = newNode;
    //new node points to previous
    newNode->prev = nextNode->prev;
    //new node points to next node
    newNode->next = nextNode;
    //next node points to new node
    nextNode->prev = newNode;

    //make sure next and previous are pointing to correct nodes
    assert (newNode->next == nextNode &&
            nextNode->prev == newNode);
    //make sure new node is ordered and points to previous node
    assert (newNode->prev != nullptr &&
            newNode->prev->data < newNode->data);
}

bool SkipList::alsoHigher() const {
    if ((rand() % 2) == 1) {
        //50% chance this will return an odd number
        return true;
    } else {
        //50% chance it will return an even number
        return false;
    }
}

void SkipList::clear() {
    for (int i = 0; i < depth; i++) {
        //first delete all data within the skiplist that is not the
        //front and rearGuards
        SNode *current = frontGuards[i]->next;
        SNode *temp = current->prev;
        while (current->next != nullptr) {
            //store this node to delete and move to next node
            delete temp;
            temp = nullptr;
            current = current->next;
            temp = current->prev;
            //delete previous node you stored

        }
        delete temp;
        temp = nullptr;
        delete current;
        current = nullptr;
    }

    //delete the arays that stored the front and rear guards
    delete[] frontGuards;
    delete[] rearGuards;
    frontGuards = nullptr;
    rearGuards = nullptr;
}
