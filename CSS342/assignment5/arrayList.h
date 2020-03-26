//
// Created by Jordan Quigtar on 11/18/19.
//

#ifndef HWASSIGNMENT5_ARRAYLIST_H
#define HWASSIGNMENT5_ARRAYLIST_H

#include "listInterface.h"
#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
#include <cstdio>

using namespace std;


/*
 * ArrayList
 *
 * this is an template class for an ArrayList that inherits the methods
 * from the template class ListInterface. Within this class you can
 * sort the ArrayList with insertion, merge, and quick sorts. you can also
 * insertAt, remove, swap, and append items to the ArrayList. this class
 * also overs instrumentation to count the number of times certain methods
 * are called such the access operator, swap, remove, insertAt, and append.
 * there are also methods to read in from a file and convert the items in the file
 * to an arrayList and sort them and present the statistics of how many
 * times the methods were called when sorted
 */
template<class T>
class ArrayList : public ListInterface<T> {
private:
    int maxLength;
    int currentLength = 0;
    T *items;
    static int NumAccess;
    static int NumSwap;
    static int NumRemove;
    static int NumInsertAt;
    static int NumAppends;

    /*
     * growArray
     *
     * this is a private helper method to help change the size of the
     * arrayList when needed. this method also clears up previously allocated
     * memory.
     */
    void growArray() {
        T *newItems = new T[maxLength * 2];
        memcpy(newItems, items, maxLength * sizeof(T));
        maxLength *= 2;
        delete[] items;
        items = newItems;
    }

    /*
     * merge
     *
     * this is a helper private method for the mergeSort method
     * to merge and sort two halves of an arrayList passed in
     * logic taken from Carrano pg 316
     */
    void merge(int first, int mid, int last) {
        T tempArray[last]; // Temporary array
        //first sub array
        int first1 = first;
        int last1 = mid;
        //second subarray
        int first2 = mid + 1;
        int last2 = last;
        //adding to beginning of subarray
        int index = first1;
        while ((first1 <= last1) && (first2 <= last2)) {
            //sort by adding smallest from each subarray to temp array
            //until one of the subarrays is empty
            if (this->operator[](first1) <= this->operator[](first2)) {
                tempArray[index] = this->operator[](first1);
                first1++;
            } else {
                tempArray[index] = this->operator[](first2);
                first2++;
            }
            index++;
        }
        while(first1 <= last1){
            //if first sub array was not finished
            tempArray[index] = this->operator[](first1);
            first1++;
            index++;
        }
        //if second sub array was not finished
        while (first2 <= last2) {
            tempArray[index] = this->operator[](first2);
            first2++;
            index++;
        }
        //make index of the subarrays equal in the original
        //since the subarrays are sorted within these indices
        for (index = first; index <= last; index++) {
            this->operator[](index) = tempArray[index];
        }
    }

    /*
     * partition
     *
     * this is a private helper method to help the quicksort method
     */
    int partition(int first, int last){
        T pivotPoint = this->operator[](last);
        //choose last index as pivot
        int minIndex = first;

        for (int j = first; j <= last - 1; j++)
        {
            if (this->operator[](j) <= pivotPoint)
            {
                swap(minIndex, j);
                minIndex++;
            }
        }
        swap(minIndex, last);

        return minIndex;
    }

public:

    /*
     * ArrayList
     *
     * this is the constructor for the ArrayList class
     * if no parameter is passed in the maxLength is set to 10
     * and array items is initialized
     */
    explicit ArrayList(int maxLength = 10) {
        this->maxLength = maxLength;
        items = new T[this->maxLength];
    }

    ~ArrayList() {
        clearAll();
    }

    /*
     * insertAt
     *
     * this is a method to insert an item into the arraylist at the index
     * passed into the parameter. the method will also shift the rest of the
     * items in the array list accordingly. this method also throws an error
     * if the index is out of range of the arraylist.
     */
    void insertAt(int newPosition, const T &newEntry) throw(std::out_of_range) {
        if (newPosition > currentLength || newPosition < 0) {
            throw std::out_of_range("Invalid index on insert");
        }
        if (currentLength == maxLength)
            growArray();
        //need to grow array if can not add past max length
        for (int i = currentLength - 1; i >= newPosition; i--) {
            items[i + 1] = items[i];
        }
        items[newPosition] = newEntry;
        currentLength++;
        NumInsertAt++;
    };

    /*
     * append
     *
     * this is a method to append the item passed into the parameter
     * to the end of the arraylist. the method will change the size of the array
     * accordingly
     */
    void append(const T &newEntry) {
        if (currentLength == maxLength - 1)
            growArray();
        items[currentLength++] = newEntry;
        NumAppends++;
    }

    /*
     * clearAll
     *
     * this is a method to clear up dynamically allocated memory
     */
    void clearAll() {
        clearStatistics();
        delete[] items;
        items = nullptr;
    }

    /*
     * clearStatistics
     *
     * this is a method to reset the instrumentation of counting
     * different method calls
     */
    void clearStatistics() {
        NumRemove = 0;
        NumSwap = 0;
        NumInsertAt = 0;
        NumAppends = 0;
        NumAccess = 0;
    }

    int getNumAccess() const {
        return NumAccess;
    }

    int getNumSwap() const {
        return NumSwap;
    }

    int getNumRemove() const {
        return NumRemove;
    }

    int getNumInsertAt() const {
        return NumInsertAt;
    }

    int getNumAppends() const {
        return NumAppends;
    }

    /*
     * getAt
     *
     * this is a method to return the item at the index passed
     * into the parameter
     */
    T &getAt(int index) const throw(std::out_of_range) {
        if (index >= currentLength || index < 0) {
            throw std::out_of_range("Invalid index on getAt");
        }
        return this->items[index];
    }

    /*
     * swap
     *
     * this is a method to swap two items at the given indices
     * in the parameter
     */
    void swap(int from, int to) throw(std::out_of_range) {
        if ((from >= currentLength || from < 0) || (to >= currentLength || to < 0)) {
            throw std::out_of_range("Invalid index on swap");
        }
        T temp = this->items[from];
        this->items[from] = this->items[to];
        this->items[to] = temp;
        NumSwap++;
    }

    /*
     * removeAt
     *
     * this is a method to remove an item in the arrayList at the index passed
     * into the parameter and will shift the other items in the list accoriingly
     */
    void removeAt(int index) throw(std::out_of_range) {
        if (index >= currentLength || index < 0) {
            throw std::out_of_range("Invalid index on Remove");
        }
        if (index == currentLength - 1) {
            currentLength--;
        } else {
            for (int i = index; i < currentLength - 1; i++) {
                T temp = this->items[i];
                this->items[i] = this->items[i + 1];
                this->items[i + 1] = temp;
            }
            currentLength--;
        }
        NumRemove++;
    }

    /*
     * operator[]
     *
     * this is the overloaded function for the [] operator
     * to return the item at the index passed into the paramter
     */
    T &operator[](int index) const throw(std::out_of_range) {
        if (index >= currentLength || index < 0) {
            throw std::out_of_range("Invalid index on operator[]");
        }
        NumAccess++;
        return this->items[index];
    }

    /*
     * isEmpty
     *
     * this is a method that will return a boolean whether or not
     * the arraylist is empty or not.
     */
    bool isEmpty() const {
        if (currentLength == 0) {
            return true;
        } else {
            return false;
        }
    }

    int getSize() const {
        return currentLength;
    }

    /*
     * operator=
     *
     * this it the function to overload the = operator
     * and assign the arraylist to be equal to the arraylist
     * passed into the parameter.
     */
    ArrayList<T> &operator=(const ArrayList<T> &other) {
        if (this != &other) { // self-assignment check expected
            if (other.getSize() != this->getSize()) {         // storage cannot be reused
                delete[] items;              // destroy storage in this
                currentLength = 0;
                maxLength = 0;
                items = nullptr;             // preserve invariants in case next line throws
                items = new T[other.getSize()]; // create storage in this
                currentLength = other.getSize();
                maxLength = other.maxLength;
            }
            for (int i = 0; i < this->getSize(); i++) {
                items[i] = other.items[i];
            }
            currentLength = other.getSize();
            maxLength = other.maxLength;
        }

        return *this;
    }

    /*
     * ArrayList
     *
     * this is the copy constructor for the arraylist class
     */
    ArrayList(const ArrayList<T> &other) {
        currentLength = other.currentLength;
        maxLength = other.maxLength;
        items = new T[this->maxLength];
        for (int i = 0; i < currentLength; i++) {
            items[i] = other.items[i];
        }
        NumAccess = 0;
        NumSwap = 0;
        NumRemove = 0;
        NumInsertAt = 0;
        NumAppends = 0;
    }

    /*
     * operator<<
     *
     * this is the function to overload the << operator
     * and will print out the arrayList in the form
     * item1, item2, item3, etc
     */
    friend ostream& operator<<(ostream &outstream, const ArrayList<T> &other){
        for(int i = 0; i < other.getSize(); i++){
            if(i < other.getSize() - 1) {
                outstream << other.items[i] << ", ";
            }else {
                outstream << other.items[i] << endl;
            }
        }
        return outstream;
    }

    /*
     * QuickSort
     *
     * this is a recursive method to sort the arraylist
     * using a quicksort using logic from carrano pg 319
     */
    void QuickSort(int first, int last) {
        if (first < last)
        {
            int partIndex = partition(first, last);

            QuickSort(first, partIndex - 1);
            QuickSort(partIndex + 1, last);
        }
    }


    /*
     * InsertionSort
     *
     * this is a method to sort the arraylist
     * using an insertionsort using logic from carrano pg 312-313
     */
    void InsertionSort() {
        for (int unsorted = 1; unsorted < this->getSize(); unsorted++) {
            T nextItem = this->operator[](unsorted);
            int loc = unsorted;
            while ((loc > 0) && (this->operator[](loc - 1) > nextItem))
            {
                this->operator[](loc) = this->operator[](loc - 1);
                loc--;
            }
            this->operator[](loc) = nextItem;
        }
    }

    /*
     * mergeSort
     *
     * this is a recursive method to sort the arraylist
     * using a mergesort using logic from carrano pg 314
     */
    void mergeSort(int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;
            mergeSort(first, mid);
            mergeSort(mid + 1, last);
            merge(first, mid, last);
        }
    }

    /*
     * readFileWithSortedArrays
     *
     * this is a method to print out read in data from a file
     * and create an arraylist from that data.
     * it will then sort the arraylist using the insertion, merge, and quick sorts
     * and print out the filename, number of items in the araylist,
     * and results of the array after each sort
     * as well as the statistics of how many times each sort used
     * the access, swap, remove, insertAt, and append methods.
     */
    void readFileWithSortedArrays(string s){
        string line;
        int numberOfItems = 0;
        ifstream inFile(s.c_str());
        ArrayList<T> unsortedList;
        if(inFile.is_open()){
            T toAppend;
            inFile >> toAppend;
            while(getline(inFile, line)){
                unsortedList.append(toAppend);
                inFile >> toAppend;
                numberOfItems++;
            }
            //clearStatistics();

            ArrayList<T> insertionSortList = unsortedList;
            insertionSortList.InsertionSort();
            int islNumAccess = insertionSortList.getNumAccess();
            int islNumSwap = insertionSortList.getNumSwap();
            int islNumRemove = insertionSortList.getNumRemove();
            int islNumInsertAt = insertionSortList.getNumInsertAt();
            int islNumAppends = insertionSortList.getNumAppends();
            insertionSortList.clearStatistics();

            ArrayList<T> mergerSortList = unsortedList;
            mergerSortList.mergeSort(0,mergerSortList.getSize() - 1);
            int mslNumAccess = mergerSortList.getNumAccess();
            int mslNumSwap = mergerSortList.getNumSwap();
            int mslNumRemove = mergerSortList.getNumRemove();
            int mslNumInsertAt = mergerSortList.getNumInsertAt();
            int mslNumAppends = mergerSortList.getNumAppends();
            mergerSortList.clearStatistics();

            ArrayList<T> quickSortList = unsortedList;
            quickSortList.QuickSort(0,quickSortList.getSize() - 1);
            int qslNumAccess = quickSortList.getNumAccess();
            int qslNumSwap = quickSortList.getNumSwap();
            int qslNumRemove = quickSortList.getNumRemove();
            int qslNumInsertAt = quickSortList.getNumInsertAt();
            int qslNumAppends = quickSortList.getNumAppends();
            insertionSortList.clearStatistics();

            cout << "FileName: " << s << endl;
            cout << "Number of items: " << numberOfItems << endl;
            cout << "InsertionSort results: \n" << insertionSortList;
            cout << "MergeSort results: \n" << mergerSortList;
            cout << "QuickSort results: \n" << quickSortList;

            string access = "Access";
            string swap = "Swap";
            string remove = "Remove";
            string insertAt = "InsertAt";
            string append = "Append";

            printf( "Number of      %10s %10s %10s %10s %10s\n", access.c_str(), swap.c_str(),
                    remove.c_str(), insertAt.c_str(), append.c_str());
            printf("InsertionSort: %10d %10d %10d %10d %10d\n", islNumAccess, islNumSwap,
                    islNumRemove, islNumInsertAt, islNumAppends);
            printf("MergeSort:     %10d %10d %10d %10d %10d\n", mslNumAccess, mslNumSwap,
                   mslNumRemove, mslNumInsertAt, mslNumAppends);
            printf("QuickSort:     %10d %10d %10d %10d %10d\n", qslNumAccess, qslNumSwap,
                   qslNumRemove, qslNumInsertAt, qslNumAppends);
        } else {
            cout << "Unable to open file." << endl;
        }
    }

    /*
     * readFile
     *
     * this is a method to print out read in data from a file
     * and create an arraylist from that data.
     * it will then sort the arraylist using the insertion, merge, and quick sorts
     * and print out the filename, number of items in the araylist,
     * and the statistics of how many times each sort used
     * the access, swap, remove, insertAt, and append methods.
     */
    void readFile(string s){
        string line;
        int numberOfItems = 0;
        ifstream inFile(s.c_str());
        ArrayList<T> unsortedList;
        if(inFile.is_open()){
            T toAppend;
            inFile >> toAppend;
            while(getline(inFile, line)){
                unsortedList.append(toAppend);
                inFile >> toAppend;
                numberOfItems++;
            }

            ArrayList<T> insertionSortList = unsortedList;
            insertionSortList.InsertionSort();
            int islNumAccess = insertionSortList.getNumAccess();
            int islNumSwap = insertionSortList.getNumSwap();
            int islNumRemove = insertionSortList.getNumRemove();
            int islNumInsertAt = insertionSortList.getNumInsertAt();
            int islNumAppends = insertionSortList.getNumAppends();
            insertionSortList.clearStatistics();

            ArrayList<T> mergerSortList = unsortedList;
            mergerSortList.mergeSort(0,mergerSortList.getSize() - 1);
            int mslNumAccess = mergerSortList.getNumAccess();
            int mslNumSwap = mergerSortList.getNumSwap();
            int mslNumRemove = mergerSortList.getNumRemove();
            int mslNumInsertAt = mergerSortList.getNumInsertAt();
            int mslNumAppends = mergerSortList.getNumAppends();
            mergerSortList.clearStatistics();

            ArrayList<T> quickSortList = unsortedList;
            quickSortList.QuickSort(0,quickSortList.getSize() - 1);
            int qslNumAccess = quickSortList.getNumAccess();
            int qslNumSwap = quickSortList.getNumSwap();
            int qslNumRemove = quickSortList.getNumRemove();
            int qslNumInsertAt = quickSortList.getNumInsertAt();
            int qslNumAppends = quickSortList.getNumAppends();
            insertionSortList.clearStatistics();

            cout << "FileName: " << s << endl;
            cout << "Number of items: " << numberOfItems << endl;

            string access = "Access";
            string swap = "Swap";
            string remove = "Remove";
            string insertAt = "InsertAt";
            string append = "Append";

            printf( "Number of      %10s %10s %10s %10s %10s\n", access.c_str(), swap.c_str(),
                    remove.c_str(), insertAt.c_str(), append.c_str());
            printf("InsertionSort: %10d %10d %10d %10d %10d\n", islNumAccess, islNumSwap,
                   islNumRemove, islNumInsertAt, islNumAppends);
            printf("MergeSort:     %10d %10d %10d %10d %10d\n", mslNumAccess, mslNumSwap,
                   mslNumRemove, mslNumInsertAt, mslNumAppends);
            printf("QuickSort:     %10d %10d %10d %10d %10d\n", qslNumAccess, qslNumSwap,
                   qslNumRemove, qslNumInsertAt, qslNumAppends);
        } else {
            cout << "Unable to open file." << endl;
        }
    }
};

template<class T> int ArrayList<T>::NumAccess = 0;
template<class T> int ArrayList<T>::NumSwap = 0;
template<class T> int ArrayList<T>::NumRemove = 0;
template<class T> int ArrayList<T>::NumInsertAt = 0;
template<class T> int ArrayList<T>::NumAppends = 0;
#endif //HWASSIGNMENT5_ARRAYLIST_H
