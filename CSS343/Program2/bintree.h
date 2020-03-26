// ------------------------------------------------ bintree.h ---------------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 27, 2020

// February 1, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - creates a binary search tree class

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#ifndef PROGRAM2_BINTREE_H
#define PROGRAM2_BINTREE_H

#include "nodedata.h"
#include <iostream>
#include <string>

/**
 * BinTree
 *
 * this is a binary search tree class with overloaded <<, =, ==, != operators as well
 * as functions to insert, retrieve, display sideways, get the height of a given node
 * if it exists, create an array from the tree, or create a balanced tree from an array
 */
class BinTree {
public:
    /**
     * constructor
     *
     * this is the constructor for the binary search tree class to initialize the
     * root of the tree
     * @pre None
     * @post tree is initialized with empty root
     */
    BinTree();								// constructor

    /**
     * copy constructor
     *
     * this copy constructor will initialize a new tree with the same data
     * as the tree passed into the parameter using a deep copy
     * @pre tree passed into the parameter is well formed
     * @post this tree will be initialized with same data as tree passed into
     *       the parameter
     */
    BinTree(const BinTree &);				// copy constructor

    /**
     * Destructor
     *
     * this destructor will clean up dynamically allocated memory at the end
     * of the program
     * @pre trees are well formed
     * @post tree and its data will be deleted from memory
     */
    ~BinTree();								// destructor, calls makeEmpty

    /**
     * isEmpty
     *
     * this function will return true if a tree has no data, and false if it does
     * contain data
     * @return true if root is null, false if root is not null
     * @pre Tree has been initialized
     * @post will return a true or false
     */
    bool isEmpty() const;					// true if tree is empty, otherwise false

    /**
     * makeEmpty
     *
     * this is a helper function to help delete the data of a tree and clean up
     * dynamically allocated memory
     * @pre tree is well formed
     * @post tree and its data will be set to null
     */
    void makeEmpty();						// make the tree empty so isEmpty returns true

    /**
    * operator<<
    *
    * this function overloads the << operator to print out a tree in the form
    * a, b, c, d, etc.
    * @param output
    * @param tree
    * @return output
    * @pre tree is well formed
    * @post data in the tree will be printed inorder
    */
    friend ostream& operator<<(ostream &output, const BinTree& tree);

    /**
     * operator=
     *
     * this overloaded = operator will set the tree this function is called on
     * to be equivalent to the tree passed into the parameter
     * @return this tree with same data as tree passed into parameter
     * @pre tree passed into the paramter is well formed and this tree has been intialized
     * @post this tree will have same data as tree passed into parameter
     */
    BinTree& operator=(const BinTree &);

    /**
     * operator==
     *
     * this function overloads the == operator and returns true or false on
     * whether or not the tree passed into the parameter is equivalent to the
     * tree this function is called on
     * @return true if trees are equivalant, false if they are not
     * @pre both trees are well formed
     * @post true or false will be returned
     */
    bool operator==(const BinTree &) const;

    /**
     * operator!=
     *
     * this function overloads the != operator and returns true or false on
     * whether or not the tree passed into the parameter is not equal to the
     * tree this function is called on
     * @return true if trees are not equivalent, false if they are
     * @pre both trees are well formed
     * @post true or false will be returned
     */
    bool operator!=(const BinTree &) const;

    /**
     * insert
     *
     * this function will insert a NodeData into the tree in the correct position,
     * this function will not allow duplicate data to be added to the tree
     * @return true if data was added to the tree, false if not
     * @pre tree is well formed
     * @post leaf node will be added to tree if function returns true
     */
    bool insert(NodeData*);

    /**
     * retrieve
     *
     * this is a function to retrieve data from the true and returns true or false on
     * whether or not the data was retrieved
     * @return true if data is found, false if not
     * @pre tree is well formed
     * @post true or false is returned, second parameter passed in references data
     *       in the tree
     */
    bool retrieve(const NodeData &, NodeData* &) const;

    /**
     * displaySideways
     *
     * this function displays the tree sideways
     * @pre tree is well formed
     * @post tree will be printed sideways to the console
     */
    void displaySideways() const;			// provided below, displays the tree sideways

    /**
     * getHeight
     *
     * this function returns the height of the data given in the parameter if found in the
     * tree. will return 0 if data is not found in the tree
     * @return height of data in the tree as an int, 0 if data not found
     * @pre tree is well formed
     * @post int will be returned for height of data in the tree
     */
    int getHeight(const NodeData &)const;

    /**
     * bsTreeToArray
     *
     * this function initializes the array passed into the parameter
     * to be an ordered array, from the tree this function is called
     * on using inorder traversal of the tree
     * @pre tree is well formed
     * @post tree data will be deleted and array will be intialized
     */
    void bstreeToArray(NodeData* []);

    /**
     * arrayToBsTree
     *
     * this function takes the array given in the parameter and creates
     * a balanced tree
     * @pre array is ordered
     * @post this tree will be initialized and balanced, array will be set to null
     */
    void arrayToBSTree(NodeData* []);
private:
    /**
     * Node
     *
     * this is a struct Node to hold the data for each node in the tree
     * and point to the left and right leaves
     */
    struct Node {
        NodeData* data;						// pointer to data object
        Node* left;							// left subtree pointer
        Node* right;						// right subtree pointer
    };
    Node* root;								// root of the tree

// utility functions

    /**
     * inorderHelper
     *
     * this is a helper function for the << operator to help print
     * the tree inorder to the console
     * @param current
     * @pre tree is well formed
     * @post trees data will be printed to the console
     */
    void inorderHelper(Node* current) const;

    /**
     * sideways
     *
     * helper for displaySideways()
     */
    void sideways(Node*, int) const;

    /**
    * makeEmpty
    *
    * this is a helper function for the makeEmpty function
    * that takes in a Node to recursively clear up memory in the tree
    * using post order traversal
    * @pre tree is well formed
    * @post memory for tree is deleted
    */
    void makeEmpty(Node *&current);

    /**
    * recursiveAssignment
    *
    * this is the helper function for the assignment operator
    * to recursively copy the data of the tree passed into the parameter
    * @pre both trees are well formed
    * @post this tree will have same data as tree passed into the paramter
    */
    void recursiveAssignment(Node *&changeThis, Node *copyThis);

    /**
     * recursiveEquality
     *
     * this is a helper function for the = operator to recursively check that each node
     * in both trees are equivalent, will return false if one node is found to be not equal
     * and return true otherwise
     * @return true if all nodes are equal, false if they are not
     * @pre both trees are well formed
     * @post true or false is returned on whether or not all nodes are equal or not
     */
    bool recursiveEquality(const Node *checkThis,const Node *checkOther) const;

    /**
    * insert
    *
    * this is a helper function for the insert method to recursively search through
    * the tree to find the correct spot to insert the data. will return true if data is inserted
    * false if duplicate data and data is not inserted
    * @return true if data is inserted, false if not
    * @pre tree is well formed
    * @post true or false is returned and data is added to tree if true
    */
    bool insert(NodeData *toInsert, Node *current);

    /**
    * retrieve
    *
    * this is the helper function for retrieve to recursively search the tree until
    * the data is found. true is returned if found and the second parameter is set to
    * the data in the tree, false otherwise
    * @return true if data is retrieved, false otherwise
    * @pre tree is well formed
    * @post true or false is returned, second parameter is set to correct data
    *       if true is returned
    */
    bool retrieve(const NodeData &, NodeData* &, Node *current) const;

    /**
    *  getHeight
    *
    * this is a helper function to recursively search the tree for the data
    * given in the parameter, will return the height of the node in the tree if the
    * data is found, will return 0 if data is not found
    * @return int for height of node with correct data in tree, 0 if data is not found
    * @pre tree is well formed
    * @post int is returned
    */
    int getHeight(const NodeData &toFind, const Node* current)const;

    /**
     * depthOfTree
     *
     * this is a helper function for getHeight that will find the height
     * of the subtree from the node given in the parameter
     * @return int of height of the tree
     * @pre tree is well formed
     * @post int is returned
     */
    int depthOfTree(const Node* current) const;

    /**
    * bsTreeToArray
    *
    * this is a helper function to recursively traverse the tree inorder
    * to initialize the array
    * @return index position to insert into array as int
    * @pre tree is well formed
    * @post array is created
    */
    int bstreeToArray(NodeData* [], Node *);

    /**
     * arrayToBsTree
     *
     * this is a helper function to help create a balanced tree from an ordered
     * array. this function will recursively find the correct index from the
     * array to insert into the tree and keep the tree balanced
     * @pre array is ordered, ints in parameter are set correctly
     * @post tree is initalized and array memory is cleaned up
     */
    void arrayToBalancedBSTree(NodeData* [], int, int);
};

#endif //PROGRAM2_BINTREE_H
