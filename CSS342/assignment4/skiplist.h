//
// Created by Jordan Quigtar on 11/6/19.
//

#ifndef HWASSIGNMENT4_SKIPLIST_H
#define HWASSIGNMENT4_SKIPLIST_H

#include <iostream>
#include <climits>
#include <cassert>
#include <cstdlib>
using namespace std;

/*
 * SkipList
 *
 * this is a class that represents a skip list that you can integers as
 * data with no duplicates, as well as set the depth of the list.
 * when adding data to the list each data has a 50% chance of going to a higher
 * depth level in the list. this is to make searching through the list for
 * data run faster then O(n)
 */
class SkipList {
public:

    /*
     * SkipList
     *
     * this is the constructor for the skipList class that inititalizes the
     * depth as well as the front a rear guards of the list
     * a default SkipList has depth of 1, just one doubly-linked list
     */
    explicit SkipList(int depth = 1);

    /*
     * ~SkipList
     *
     * this is the destructor for the class skipList to clean up and delete
     * all dynamically allocated memory
     */
    virtual ~SkipList();

    /*
     * add
     *
     * this is a add function of a skip list that will add a data to the
     * first level of the skip list and toss a coin for a 50% chance that
     * it will be added to higher levels
     * return true if successfully added
     * return false if attempting to Add duplicates
     */
    bool Add(int data);

    /*
     * remove
     *
     * this is the remove function for the class skiplist
     * and will remove the data passed in to the parameter from all levels of
     * the list this function is called on
     * return true if successfully removed
     * return false if data is not in the list to Remove
     */
    bool Remove(int data);

    /*
     * contains
     *
     * this is a function contains that will search the skipList this function
     * is called on to see if list Contains the data passed into the parameter
     * return true if found in skipList
     * return false if not found in skipList
     */
    bool Contains(int data);

    /*
     * operator<<
     *
     * this is the function to overload the << operator for th skipList class
     * and will print the skipList in the form
     * Level: X -- #, #, #
     * Level: X -- #, #, #, #
     */
    friend ostream &operator<<(ostream &os, const SkipList &list);
private:
    /*
     * SNode
     *
     * this is a private class within the skipList class that
     * represents each node within the skipList that holds the data
     * as well as points to a next, previous, upLevel, and downLevel node
     * in the skipList
     */
    class SNode{
    public:
        int data;
        SNode *next;
        SNode *prev;
        SNode *upLevel;
        SNode *downLevel;

        /*
         * SNode
         *
         * this is the constructor for the SNode class to
         * initialize the data in the node as well as set the pointers to null
         */
        explicit SNode(int data){
            this->data = data;
            next = nullptr;
            prev = nullptr;
            upLevel = nullptr;
            downLevel = nullptr;
        }
    };

    int depth;
    SNode **frontGuards;
    SNode **rearGuards;

    /*
     * addBefore
     *
     * this is a helper method for the add method that will Add the
     * newNode being added from the parameter before the node that it is
     * less than in the skipList
     * PreCondition: both nodes are not null
     * PostCondition: newNode is added to the list ordered between the
     * data in the list that it is between such that X < newNode->data < Y
     */
    void addBefore(SNode *newNode, SNode *nextNode);

    /*
     * alsoHigher
     *
     * this is a helper method for the Add method that will
     * return true 50% of the time, to see if the new node should be added
     * to each level
     * each node has a 50% chance of being at a higher level
     */
    bool alsoHigher() const;

    void clear();
};


#endif //HWASSIGNMENT4_SKIPLIST_H
