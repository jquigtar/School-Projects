//
// Created by Jordan Quigtar on 12/2/19.
//

#ifndef HWASSIGNMENT6_BSTREE_H
#define HWASSIGNMENT6_BSTREE_H

#include "clientAccount.h"

/**
 * BSTree
 *
 * this is a binary search tree class to be used in a bank. this tree
 * holds client bank accounts for a bank. you can insert an account, retrieve
 * an account, display all accounts, empty, and check if it is empty.
 */
class BSTree {
public:

    //constructor
    BSTree();

    //destructor
    ~BSTree();

    /**
     * Insert
     *
     * This is a function to insert an account into the tree.
     * @param account
     * @return true if account inserted, false if account already exists
     */
    bool Insert(clientAccount *account);


    /**
     * Retrieve
     *
     * this is a function that will search the tree if an account exists
     * that matches the ID number passed in as the first parameter,
     * second parameter holds pointer to found object, NULL if not found.
     * @return true if account exists in tree, false if it does not
     */
    bool Retrieve(const int &, clientAccount *&) const;

    /**
     * Display
     *
     * displays the contents of a tree inorder
     */
    void Display() const;

    /**
     * Empty
     *
     * this is a function that will help clean up all dynamically allocated
     * memory in the tree
     */
    void Empty();

    /**
     * isEmpty
     *
     * this is a function that will check if the tree is empty
     * @return true if tree is empty, false if not
     */
    bool isEmpty() const;

private:

    /**
     * Node
     *
     * this is a struct within a tree to hold an account
     * and point down the tree to leaf accounts
     */
    struct Node {
        clientAccount *pAcct;
        Node *right;
        Node *left;

        //constructor
        Node(clientAccount *account){
            pAcct = account;
            right = nullptr;
            left = nullptr;
        }
    };
    Node *root;

    /**
     * Insert
     *
     * this is a helper recursive function for the insert function that
     * will bubble down the tree to the correct leaf node. and then
     * insert the account at the correct position in the tree.
     * @param account
     * @param root
     * @return true if node was inserted, false if not.
     */
    bool Insert(clientAccount *account, Node *&root);

    /**
     * Retrieve
     *
     * this is a helper recursive function for the retrieve function.
     * it will bubble down the tree to the correct leaf node and set the
     * account passed in to be equal to the correct account.
     * @param idNumber
     * @param root
     * @return true if account was retrieved, false if not.
     */
    bool Retrieve(const int &idNumber, clientAccount *&, Node *root) const;

    /**
     * Display
     *
     * this is a helper recursive function for the display method that will
     * bubble down the tree and print the account nodes inorder.
     * @param root
     */
    void Display(Node *root) const;

    /**
     * Empty
     *
     * this is a recursive helper function for the empty method that will
     * clean up memory in the tree in the correct order.
     * @param root
     */
    void Empty(Node *root);

};


#endif //HWASSIGNMENT6_BSTREE_H
