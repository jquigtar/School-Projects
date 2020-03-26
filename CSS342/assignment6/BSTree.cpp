//
// Created by Jordan Quigtar on 12/2/19.
//

#include "BSTree.h"
#include <iostream>
using namespace std;

BSTree::BSTree() {
    root = nullptr;
}

BSTree::~BSTree() {
    Empty();
}

bool BSTree::Insert(clientAccount *account) {
    return Insert(account, root);
}

bool BSTree::Retrieve(const int &idNumber, clientAccount *& toRetrieve) const {
    return Retrieve(idNumber, toRetrieve, root);
}

void BSTree::Display() const {
    Display(root);
}

void BSTree::Empty() {
    Empty(root);
}

bool BSTree::isEmpty() const {
    return root == nullptr;
}

bool BSTree::Insert(clientAccount *account, Node *&root) {
    if(root == nullptr){
        //at a point where node can be inserted
        root = new Node(account);
        return true;
    }
    else if(root->pAcct->getIDNumber() == account->getIDNumber()){
        //account already exists in the tree
        cout << "ERROR: Account " << account->getIDNumber() << " is already open."
             << " Transaction refused.\n";
        return false;
    }
    else if(root->pAcct->getIDNumber() > account->getIDNumber()){
        //go left if IDNumber being added is less then current root
        if(root->left == nullptr){
            //add the node to the left of root if a left leaf does not exist
            root->left = new Node(account);
            return true;
        }else {
            //if leaf does exists recursive call to the root to the left
            return Insert(account, root->left);
        }
    }
    else {//same for going right
        if(root->right == nullptr){
            root->right = new Node(account);
            return true;
        }else {
            return Insert(account, root->right);
        }
    }
}

bool BSTree::Retrieve(const int &idNumber, clientAccount *& toRetrieve, Node *root) const {
    if(root == nullptr){
        //account not found
        return false;
    }
    else if(root->pAcct->getIDNumber() == idNumber){
        //account found set reference to a pointer to be equal to this account
        toRetrieve = root->pAcct;
        return true;
    }
    else if(root->pAcct->getIDNumber() > idNumber){
        //go left if target ID is less then current account ID
        return Retrieve(idNumber,toRetrieve, root->left);
    }
    else {
        //go right
        return Retrieve(idNumber, toRetrieve, root->right);
    }
}

void BSTree::Display(Node *root) const {
    if(root != nullptr){
        //print left first then root then right to be in order
        Display(root->left);
        cout << *root->pAcct;
        Display(root->right);
    }
}

void BSTree::Empty(Node *root) {
    if(root != nullptr){
        //go in order to make sure all roots are deleted
        Empty(root->left);
        Empty(root->right);
        delete root->pAcct;
        root->pAcct = nullptr;
        delete root;
        root = nullptr;
    }
}
