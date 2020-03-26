// ------------------------------------------------ bintree.cpp -------------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 27, 2020

// February 1, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - This is the implementation for the bintree class

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------


#include "bintree.h"

BinTree::BinTree() {
    root = nullptr;
}

BinTree::BinTree(const BinTree &other) {
    root = nullptr;
    *this = other;      // uses = operator to initialize data
}

BinTree::~BinTree() {
    this->makeEmpty();
}

bool BinTree::isEmpty() const {
    return root == nullptr;     //tree is empty if root is null
}

void BinTree::makeEmpty() {
    makeEmpty(this->root);
}

void BinTree::makeEmpty(BinTree::Node *&current) {
    if(current != nullptr) { // only delete if current is not null
        makeEmpty(current->left); // post order traversal
        makeEmpty(current->right);
        delete current->data;//first delete NodeData
        current->data = nullptr;
        delete current; // then delete node
        current = nullptr;
    }
}

BinTree &BinTree::operator=(const BinTree &other) {
    if(*this != other){
        this->makeEmpty(); // delete tree to reassign its values
        recursiveAssignment(this->root, other.root);
    }
    return *this;
}

void BinTree::recursiveAssignment(Node*& changeThis, Node *copyThis) {
    if(copyThis != nullptr){ // if node to be copied is not null
        changeThis = new Node;
        NodeData *temp = new NodeData(*copyThis->data);
        changeThis->data = temp; // make data in this tree to be equal to same data
        //as the other tree
        recursiveAssignment(changeThis->left, copyThis->left);
        recursiveAssignment(changeThis->right, copyThis->right);
    }else{ // copy over null data
        changeThis = nullptr;
    }
}

bool BinTree::operator==(const BinTree &other) const {
    if(this->isEmpty() && other.isEmpty()){ // if both trees are empty they are equal
        return true;
    }else {
        return recursiveEquality(this->root, other.root);
    }
}

bool BinTree::recursiveEquality(const Node *checkThis, const Node *checkOther) const {
    if(checkThis == nullptr && checkOther == nullptr){// if you reach a nullptr for both
        //then data is equivalent
        return true;
    }
    if(checkThis == nullptr && checkOther != nullptr){// if one data is null and the other
        //is not then return false
        return false;
    }
    if(*checkThis->data != *checkOther->data){// if data at each node is not equal
        return false;// return false
    }else{
        return recursiveEquality(checkThis->left,checkOther->left) &&
        recursiveEquality(checkThis->right, checkOther->right);
        //check that left and right subtrees are equivalent
    }
}

bool BinTree::operator!=(const BinTree &other) const {
    return !(*this == other);//use = operator logic
}

bool BinTree::insert(NodeData *toInsert) {
    if(root == nullptr){ // if tree is empty insert at root
        root = new Node;
        root->data = toInsert;
        root->left = nullptr;
        root->right = nullptr;
        return true;
    }
    return insert(toInsert, this->root);
}

bool BinTree::insert(NodeData *toInsert, Node* current) {
    if(current->data == toInsert) { // no duplicates
        return false;
    }else if(*toInsert > *current->data && current->right != nullptr) {
        return insert(toInsert, current->right);
    }else if(*toInsert > *current->data && current->right == nullptr){//insert to right
        current->right = new Node;
        current->right->data = toInsert;
        current->right->right = nullptr;
        current->right->left = nullptr;
        return true;
    }else if(*toInsert < *current->data && current->left != nullptr) {
        return insert(toInsert, current->left);
    }else if(*toInsert < *current->data && current->left == nullptr){//insert to left
        current->left = new Node;
        current->left->data = toInsert;
        current->left->right = nullptr;
        current->left->left = nullptr;
        return true;
    }else{
        return false;
    }
}

bool BinTree::retrieve(const NodeData &toRetrieve, NodeData* &toReturn) const {
    return retrieve(toRetrieve,toReturn,this->root);
}

bool BinTree::retrieve(const NodeData &toRetrieve, NodeData *&toReturn, Node *current) const {
    if(current == nullptr) { //data not found
        return false;
    }
    else if(*current->data == toRetrieve){ //data is found
        toReturn = current->data;
        return true;
    }
    else if(*current->data > toRetrieve){//check left
        return retrieve(toRetrieve,toReturn,current->left);
    }
    else if(*current->data < toRetrieve){ //check right
        return retrieve(toRetrieve,toReturn,current->right);
    }
    else{
        return false;
    }
}

int BinTree::getHeight(const NodeData &toFind) const {
    return getHeight(toFind, this->root);
}

int BinTree::getHeight(const NodeData &toFind, const BinTree::Node *current) const {
    if(current == nullptr){ //data not found
        return 0;
    }
    if(*current->data == toFind){ //data found find height of subtree
        int left = depthOfTree(current->left);
        int right = depthOfTree(current->right);
        return 1 + max(left, right);
    }else{//data not found continue searching
        return max(getHeight(toFind, current->left), getHeight(toFind,current->right));
    }
}

int BinTree::depthOfTree(const BinTree::Node *current) const {
    if(current == nullptr) {//at bottom of tree
        return 0;
    }else{ //count levels of tree and return max depth
        return 1 + max(depthOfTree(current->left), depthOfTree(current->right));
    }
}

ostream &operator<<(ostream &output, const BinTree& tree) {
    tree.inorderHelper(tree.root);//prints data
    output << endl;
    return output;
}

void BinTree::inorderHelper(Node* current) const {
    if(current != nullptr){//only print if data is not null
        inorderHelper(current->left);//inorder traversal
        cout << *current->data << " ";
        inorderHelper(current->right);
    }
}

void BinTree::bstreeToArray(NodeData *array[]) {
    bstreeToArray(array, this->root);
    this->makeEmpty();// deletes tree memory
}

int BinTree::bstreeToArray(NodeData *array[], BinTree::Node *current) {
    if(current == nullptr){
        return 0;
    }
    int left = bstreeToArray(array, current->left); // finding index to insert
    NodeData* temp;
    temp = current->data;
    current->data = nullptr;
    *(array + left) = temp;
    temp = nullptr;
    int right = 1 + bstreeToArray(array + left + 1, current->right);
    return left + right; // adding number of nodes added from each side
}

void BinTree::arrayToBSTree(NodeData *array[]) {
    this->makeEmpty();
    int length = 0;
    for(int i = 0; i < 100; i++){// data assumed to never go over 100 elements
        if(array[i] != nullptr){
            length++;//finding number of elements in array
        }
    }
    arrayToBalancedBSTree(array, 0, length - 1);
}

void BinTree::arrayToBalancedBSTree(NodeData *array[], int low, int high) {
    if(low <= high){
        int index = (low + high) / 2;//find data in middle of sub array
        NodeData *temp;
        temp = array[index];
        array[index] = nullptr;// clearing array
        this->insert(temp);// insert data into tree
        arrayToBalancedBSTree(array, low, index - 1);//left sub array
        arrayToBalancedBSTree(array, index + 1, high);//right sub array
    }
}

//------------------------- displaySideways ---------------------------------
// Displays a binary tree as though you are viewing it from the side;
// hard coded displaying to standard output.
// Preconditions: NONE
// Postconditions: BinTree remains unchanged.
void BinTree::displaySideways() const {
    sideways(root, 0);
}

//---------------------------- Sideways -------------------------------------
// Helper method for displaySideways
// Preconditions: NONE
// Postconditions: BinTree remains unchanged.
void BinTree::sideways(Node* current, int level) const {
    if (current != NULL) {
        level++;
        sideways(current->right, level);

        // indent for readability, 4 spaces per depth level
        for (int i = level; i >= 0; i--) {
            cout << "    ";
        }

        cout << *current->data << endl;        // display information of object
        sideways(current->left, level);
    }
}
