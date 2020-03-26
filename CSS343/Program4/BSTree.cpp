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

bool BSTree::InsertFunny(Funny *movie) {
    return InsertFunny(movie, root);
}

bool BSTree::InsertFunny(Funny *movie, Node *&root) {
    if(root == nullptr){
        //at a point where node can be inserted
        root = new Node(movie);
        return true;
    }
    else if(root->theMovie == movie){
        //account already exists in the tree
        cout << "ERROR: Account " << movie << " is already open."
             << " Transaction refused.\n";
        return false;
    }
    else if(root->theMovie > movie){
        //go left if IDNumber being added is less then current root
        if(root->left == nullptr){
            //add the node to the left of root if a left leaf does not exist
            root->left = new Node(movie);
            return true;
        }else {
            //if leaf does exists recursive call to the root to the left
            return InsertFunny(movie, root->left);
        }
    }
    else {//same for going right
        if(root->right == nullptr){
            root->right = new Node(movie);
            return true;
        }else {
            return InsertFunny(movie, root->right);
        }
    }
}

bool BSTree::InsertDrama(Drama *movie) {
    return InsertDrama(movie, root);
}

bool BSTree::InsertDrama(Drama *movie, Node *&root) {
    if(root == nullptr){
        //at a point where node can be inserted
        root = new Node(movie);
        return true;
    }
    else if(root->theMovie == movie){
        //account already exists in the tree
        cout << "ERROR: Account " << movie << " is already open."
             << " Transaction refused.\n";
        return false;
    }
    else if(root->theMovie > movie){
        //go left if IDNumber being added is less then current root
        if(root->left == nullptr){
            //add the node to the left of root if a left leaf does not exist
            root->left = new Node(movie);
            return true;
        }else {
            //if leaf does exists recursive call to the root to the left
            return InsertDrama(movie, root->left);
        }
    }
    else {//same for going right
        if(root->right == nullptr){
            root->right = new Node(movie);
            return true;
        }else {
            return InsertDrama(movie, root->right);
        }
    }
}

bool BSTree::InsertClassic(ClassicMovie *movie) {
    return InsertClassic(movie, root);
}

bool BSTree::InsertClassic(ClassicMovie *movie, Node *&root) {
    if(root == nullptr){
        //at a point where node can be inserted
        root = new Node(movie);
        return true;
    }
    else if(root->theMovie == movie){
        //account already exists in the tree
        cout << "ERROR: Account " << movie << " is already open."
             << " Transaction refused.\n";
        return false;
    }
    else if(root->theMovie > movie){
        //go left if IDNumber being added is less then current root
        if(root->left == nullptr){
            //add the node to the left of root if a left leaf does not exist
            root->left = new Node(movie);
            return true;
        }else {
            //if leaf does exists recursive call to the root to the left
            return InsertClassic(movie, root->left);
        }
    }
    else {//same for going right
        if(root->right == nullptr){
            root->right = new Node(movie);
            return true;
        }else {
            return InsertClassic(movie, root->right);
        }
    }
}


bool BSTree::RetrieveFunny(const string &title, Movie *& toRetrieve) const {
    return RetrieveFunny(title, toRetrieve, root);
}

bool BSTree::RetrieveFunny(const string &title, Movie *& toRetrieve, Node *root) const {
    if(root == nullptr){
        //account not found
        return false;
    }
    else if(root->theMovie->getTitle() == title){
        //account found set reference to a pointer to be equal to this account
        toRetrieve = root->theMovie;
        return true;
    }
    else if(root->theMovie->getTitle() > title){
        //go left if target ID is less then current account ID
        return RetrieveFunny(title,toRetrieve, root->left);
    }
    else {
        //go right
        return RetrieveFunny(title, toRetrieve, root->right);
    }
}

bool BSTree::RetrieveDrama(const string &director, Movie *& toRetrieve) const {
    return RetrieveDrama(director, toRetrieve, root);
}

bool BSTree::RetrieveDrama(const string &director, Movie *& toRetrieve, Node *root) const {
    if(root == nullptr){
        //account not found
        return false;
    }
    else if(root->theMovie->getDirector() == director){
        //account found set reference to a pointer to be equal to this account
        toRetrieve = root->theMovie;
        return true;
    }
    else if(root->theMovie->getDirector() > director){
        //go left if target ID is less then current account ID
        return RetrieveDrama(director,toRetrieve, root->left);
    }
    else {
        //go right
        return RetrieveDrama(director, toRetrieve, root->right);
    }
}

bool BSTree::RetrieveClassic(const int &year, Movie *& toRetrieve) const {
    return RetrieveClassic(year, toRetrieve, root);
}

bool BSTree::RetrieveClassic(const int &year, Movie *& toRetrieve, Node *root) const {
    if(root == nullptr){
        //account not found
        return false;
    }
    else if(root->theMovie->getYear() == year){
        //account found set reference to a pointer to be equal to this account
        toRetrieve = root->theMovie;
        return true;
    }
    else if(root->theMovie->getYear() > year){
        //go left if target ID is less then current account ID
        return RetrieveClassic(year,toRetrieve, root->left);
    }
    else {
        //go right
        return RetrieveClassic(year, toRetrieve, root->right);
    }
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

void BSTree::Display(Node *root) const {
    if(root != nullptr){
        //print left first then root then right to be in order
        Display(root->left);
        cout << *root->theMovie;
        Display(root->right);
    }
}

void BSTree::Empty(Node *root) {
    if(root != nullptr){
        //go in order to make sure all roots are deleted
        Empty(root->left);
        Empty(root->right);
        delete root->theMovie;
        root->theMovie = nullptr;
        delete root;
        root = nullptr;
    }
}
