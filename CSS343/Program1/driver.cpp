// ------------------------------------------------ driver.cpp --------------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 15, 2020

// January 18, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - CSS343 program1 driver

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#include <iostream>
using namespace std;

#include "polynomial.h"

/**
 * main
 *
 * this is the main function for the driver given to us in CSS343 c
 * @return
 */
int main( )

{

  Polynomial p1;



  p1.changeCoefficient( 1, 1 );

  p1.changeCoefficient( 4, 4 );

  p1.changeCoefficient( 2.2, 2 );

  p1.changeCoefficient( -3.8, 3 );

  cout << "p1 = " << p1 << endl;



  p1.changeCoefficient( 0, 2 );

  cout << "p1 = " << p1 << endl;



  Polynomial p2 = p1;

  p2.changeCoefficient( 9.5, 2 );

  cout << "p1 = " << p1 << endl;

  cout << "p2 = " << p2 << endl;



  Polynomial p3 = p1 + p2;

  cout << "p3 = " << p3 << endl;

}
