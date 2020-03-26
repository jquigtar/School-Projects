Purpose

This programming assignment exercises dynamic memory allocation, pointer operations, and copy constructor design through designing a doubly-linked circular list with a dummy header. Using such a list, you will implement an ADT polynomial.

 

ADT Polynomial

polynomial.hPreview the document lists  the specification of our ADT polynomial.

 

A Sparse Polynomial Implementation Using A List

The ADT polynomial can be implemented using a doubly-linked circular list that stores only the terms with nonzero coefficients. For example, you can represent the polynomial p1 = -3x7 + 4x3 + 9 as follows.

   

 polynomial.png

 

 To implement the ADT polynomial with this list, you must add the following members in your polynomial class.

default constructor

When construct a Polynomial object without parameter, you should initialize the size as zero, and should construct a dummy header. Note that your polynomial is doubly-linked circular list.

copy constructor

Takes care of a deep copy of the original link representation.

destructor

Takes care of de-allocating all link nodes to the system.

struct Term

This structure must be defined as a class private struct and include double coeffocient and int power as well as prev and next pointers, each pointing to a previous and a next Term node

insert( pos, newCoefficient, power )

This private member function inserts a new Term node with newCoefficient and power just before the existing Term pointed by the pos pointer. The insert function will be used bychangeCoefficient to insert a new term.

remove( pos )

This private member function deletes the existing Term node pointed by the pos pointer. The remove function will be used by changeCoefficient to delete an existing term when its coefficient is changed in 0. In addition, it will be used by a destructor and the operator= to de-allocates all Term nodes.
