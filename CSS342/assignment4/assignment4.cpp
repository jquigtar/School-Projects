//
// Created by Jordan Quigtar on 11/6/19.
//

#include <iostream>
#include "skiplist.h"
#include <climits>
#include <cstdlib>
#include <cassert>
using namespace std;

/*
 * test01
 *
 * this test function tests that you can not Remove on an empty list as well
 * as tests the Add function works correctly and show that the operator<<
 * overloaded function works correctly
 */
void test01(){
    cout << "test 1\n\n";
    SkipList s(5);

    assert(s.Remove(0) == false);

    for (int i = 0; i < 20; ++i) {
        int number = rand() % 100;
        if(!s.Contains(number)) {
            assert(s.Add(number) == true);
            cout << "After adding " << number << endl;
            cout << s << endl;
        }
    }
}

/*
 * test02
 *
 * this test function tests that the Contains function of the skip list class
 * works correctly
 */
void test02(){
    cout << "test 2\n\n";
    SkipList s(5);
    for (int i = 0; i < 20; ++i) {
        int number = rand() % 100;
        s.Add(number);
        cout << "After adding " << number << endl; cout << s << endl;
        assert(s.Contains(number) == true);
    }
}

/*
 * test03
 *
 * this method tests that there can be no duplicates in a SkipList as well as
 * tests that the Contains function of the SkipList class works correctly.
 * it also tests the functionality of the Remove function of the SkipList class
 */
void test03(){
    cout << "test 3\n\n";
    SkipList s(5);
    for (int i = 0; i < 20; ++i) {
        int number = i * 5;
        if(!s.Contains(number)) {
            assert(s.Add(number) == true);
            cout << "After adding " << number << endl;
            cout << s;
            assert(s.Add(number) == false);
        }
    }
    for (int i = 0; i < 20; ++i) {
        int number = i * 5;
        if(s.Contains(number)) {
            assert(s.Remove(number) == true);
            assert(s.Remove(number) == false);
            cout << "After removing " << number << endl;
            cout << s << endl;
        }
    }
}

/*
 * test04
 *
 * this test method tests that you can not Remove the front and rear
 * guards of a skiplist. as well as tests that you can not have a skiplest with
 * a depth less than 0
 */
void test04() {
    cout << "test 4\n\n";
    SkipList s(5);
    cout << s << endl;
    assert(s.Remove(INT_MIN) == false);
    cout << s << endl;
    assert(s.Remove(INT_MAX) == false);
    cout << s << endl;
    //SkipList s2(0);
}

/*
 * testAll
 *
 * this is a method to run all the test methods
 * test01, test02, test03, test04
 */
void testAll(){
    test01();
    test02();
    test03();
    test04();
}

/*
 * main
 *
 * this is the main function to run tests on the SkipList class
 */
int main() {
    cout << "running tests\n\n";
    testAll();
    cout << "done\n";
    return 0;
}