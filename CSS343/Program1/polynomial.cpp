// ----------------------------------------------- polynomial.cpp -----------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 15, 2020

// January 18, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this file holds the implementation of all the methods of the polynomial class

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#include "polynomial.h"

Polynomial::Polynomial() {
    //initialize dummy header
    head = new Term();
    head->coeff = 0.0;
    head->power = 0;
    head->next = head;
    head->prev = head;
}

Polynomial::Polynomial(const Polynomial &p) {
    if(p.head->next == p.head){// if p has no terms only initialize dummy header
        head = new Term();
        head->coeff = 0.0;
        head->power = 0;
        head->next = head;
        head->prev = head;
    }else{// if p does have terms
        //initialize dummy header
        head = new Term();
        head->coeff = 0.0;
        head->power = 0;
        head->next = head;
        head->prev = head;

        Term *currentOld = p.head->next;
        Term *currentNew = head;
        while (currentOld != p.head){ // cycle through polynomial to be copied
            //copy term from p
            Term *temp = new Term();
            temp->coeff = currentOld->coeff;
            temp->power = currentOld->power;
            //set pointers for new term
            temp->prev = currentNew;
            temp->next = currentNew->next;
            //connect term to new polynomial
            currentNew->next->prev = temp;
            currentNew->next = temp;
            //increase size
            this->size++;
            //
            currentNew = currentNew->next;
            currentOld = currentOld->next;
        }
    }
}

Polynomial::~Polynomial() {
    Term *current = head->next;
    while(current != head){// delete all terms except head
        //create temp to delete and move to next term
        Term *temp = current;
        current = current->next;
        //delete past term
        remove(temp);
    }
    //then delete head
    delete head;
    head = nullptr;
}

int Polynomial::degree() const {
    //return the highest degree of the polynomial
    return head->next->power;
}

double Polynomial::coefficient(const int power) const {
    Term *current = head->next;
    while(current != head && current->power != power){//cycle until you find power
        current = current->next;
    }
    //will return coeff of power, if power not found will return 0 (from dummy header)
    return current->coeff;
}

bool Polynomial::changeCoefficient(const double newCoefficient, const int power) {
    Term *current = head->next;
    if(power != 0) { // if the power is not 0
        while (current != head && current->power > power) {// cycle until you can insert
            //the power before the current term so it is in order
            current = current->next;
        }
        if (current->power == power) {// if the term you are at already has the same
            //power change teh coefficient only
            current->coeff = newCoefficient;
            if (current->coeff == 0) {// if changed to zere remove this term
                remove(current);
            }
        } else {// if power does not exist insert new term
            this->insert(current, newCoefficient, power);
        }
    }else{// if power is 0
        if(current != head) { // if terms exist in list
            while (current->next != head) {// move to last term in polynomial
                current = current->next;
            }
            if (current->power == power) { // check if 0 power term is in polynomial
                current->coeff = newCoefficient;// if so change coefficient
                if (current->coeff == 0) {//if coefficient is 0 remove term
                    remove(current);
                }
            } else if (current->power != 0) {// if 0 power term does not exist
                current = current->next;
                this->insert(current, newCoefficient, power);// insert at end of polynomial
            }
        }else{// if list is empty add 0 power term
            this->insert(current, newCoefficient, power);
        }
    }
    return true;
}

Polynomial Polynomial::operator+(const Polynomial &p) const {
    Polynomial toReturn;// new polynomial being created
    Term *current = toReturn.head;
    Term *currentP1 = head->next;
    Term *currentP2 = p.head->next;
    while(currentP1 != head && currentP2 != p.head){// going through both polynomials
        //until you reach the end of one of them
        if(currentP1->power == currentP2->power){// compare terms if they are equal
            // add coefficients and add term to new polynomial
            Term *temp = new Term;
            temp->coeff = currentP1->coeff + currentP2->coeff;
            temp->power = currentP1->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            current = current->next;
            currentP1 = currentP1->next;
            currentP2 = currentP2->next;
        }else if(currentP1->power > currentP2->power){// if term in polynomial being added
            //to is greater copy over this term
            Term *temp = new Term;
            temp->coeff = currentP1->coeff;
            temp->power = currentP1->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            current = current->next;
            currentP1 = currentP1->next;
        }else{// if term in polynomial being added is greater copy over this term
            Term *temp = new Term;
            temp->coeff = currentP2->coeff;
            temp->power = currentP2->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            current = current->next;
            currentP2 = currentP2->next;
        }
    }

    while(currentP1 != head){// if you did not reach the end of this polynomial
        // continue copying over terms
        Term *temp = new Term;
        temp->coeff = currentP1->coeff;
        temp->power = currentP1->power;
        temp->prev = current;
        temp->next = current->next;
        current->next->prev = temp;
        current->next = temp;
        current = current->next;
        currentP1 = currentP1->next;
    }

    while(currentP2 != p.head){// if you did not reach the end of this polynomial
        // continue copying over terms
        Term *temp = new Term;
        temp->coeff = currentP2->coeff;
        temp->power = currentP2->power;
        temp->prev = current;
        temp->next = current->next;
        current->next->prev = temp;
        current->next = temp;
        current = current->next;
        currentP2 = currentP2->next;
    }
    return toReturn;
}

Polynomial Polynomial::operator-(const Polynomial &p) const {
    //same logic as operator+ except you subtract terms
    Polynomial toReturn;
    Term *current = toReturn.head;
    Term *currentP1 = head->next;
    Term *currentP2 = p.head->next;
    while(currentP1 != head && currentP2 != p.head){
        if(currentP1->power == currentP2->power){
            Term *temp = new Term;
            temp->coeff = currentP1->coeff - currentP2->coeff;
            temp->power = currentP1->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            current = current->next;
            toReturn.size++;
            currentP1 = currentP1->next;
            currentP2 = currentP2->next;
        }else if(currentP1->power > currentP2->power){
            Term *temp = new Term;
            temp->coeff = currentP1->coeff;
            temp->power = currentP1->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            toReturn.size++;
            current = current->next;
            currentP1 = currentP1->next;
        }else{
            Term *temp = new Term;
            temp->coeff = -1 * currentP2->coeff;
            temp->power = currentP2->power;
            temp->prev = current;
            temp->next = current->next;
            current->next->prev = temp;
            current->next = temp;
            toReturn.size++;
            current = current->next;
            currentP2 = currentP2->next;
        }
    }

    while(currentP1 != head){
        Term *temp = new Term;
        temp->coeff = currentP1->coeff;
        temp->power = currentP1->power;
        temp->prev = current;
        temp->next = current->next;
        current->next->prev = temp;
        current->next = temp;
        toReturn.size++;
        current = current->next;
        currentP1 = currentP1->next;
    }

    while(currentP2 != p.head){
        Term *temp = new Term;
        temp->coeff = -1* currentP2->coeff;
        temp->power = currentP2->power;
        temp->prev = current;
        temp->next = current->next;
        current->next->prev = temp;
        current->next = temp;
        toReturn.size++;
        current = current->next;
        currentP2 = currentP2->next;
    }

    current = toReturn.head->next;
    while(current != toReturn.head){
        if(current->coeff == 0){
            Term *temp = current;
            current = current->next;
            temp->prev->next = temp->next;
            temp->next->prev = temp->prev;
            delete temp;
            temp = nullptr;
            toReturn.size--;
        }else {
            current = current->next;
        }
    }

    return toReturn;
}

bool Polynomial::operator==(const Polynomial &p) const {
    if(this->size != p.size){// if they do not have the same size they can not be equal
        return false;
    }else {// if they are the same size check if terms are equal
            Term *currentP1 = head->next;
            Term *currentP2 = p.head->next;
            while (currentP1 != head && currentP2 != p.head) {// go through polynomials
                if (currentP1->power != currentP2->power || currentP1->coeff != currentP2->coeff) {
                    //if terms have different power, or coefficient then polynomials are not equal
                    return false;
                }
                currentP1 = currentP1->next;
                currentP2 = currentP2->next;
            }
            //if all terms are equal in same size polynomials they are equal
            return true;
    }
}

bool Polynomial::operator!=(const Polynomial &p) const {
    //same logic as == operator
    if(this->size != p.size){
        return true;
    }else {
            Term *currentP1 = head->next;
            Term *currentP2 = p.head->next;
            while (currentP1 != head && currentP2 != p.head) {
                if (currentP1->power != currentP2->power || currentP1->coeff != currentP2->coeff) {
                    return true;
                }
                currentP1 = currentP1->next;
                currentP2 = currentP2->next;
            }
            return false;
    }
}

Polynomial &Polynomial::operator=(const Polynomial &p) {
    if(this != &p){// not reassigning polynomial to itself
        if(this->size != p.size){// if polynomials are not the same size remove
            //terms in current polynomial
            Term *current = head->next;
            while(current != head){//removing terms
                Term *temp = current;
                current = current->next;
                remove(temp);
            }
            current = head;
            Term *currentOther = p.head->next;
            while(currentOther != p.head){//copy terms from other polynomial and
                //add them to this polynomial
                Term *temp = new Term;
                temp->coeff = currentOther->coeff;
                temp->power = currentOther->power;
                temp->prev = current;
                temp->next = current->next;
                current->next->prev = temp;
                current->next = temp;
                current = current->next;
                currentOther = currentOther->next;
            }
            size = p.size;
        }else{// if polynomials are the same size
            Term *current = head->next;
            Term *currentOther = p.head->next;
            while(current != head && currentOther != p.head){//cycle through both polynomials
                //change coefficient and power of this polynomial term to other polynomial term
                current->coeff = currentOther->coeff;
                current->power = currentOther->power;
                current = current->next;
                currentOther = currentOther->next;
            }
        }
    }
    return *this;
}

Polynomial &Polynomial::operator+=(const Polynomial &p) {
    Term *currentP1 = head->next;
    Term *currentP2 = p.head->next;
    while(currentP1 != head && currentP2 != p.head){//looking at both polynomials
        if(currentP1->power == currentP2->power){// if they are of same power add
            //coefficients and change this term coefficient
            currentP1->coeff = currentP1->coeff + currentP2->coeff;
            currentP1 = currentP1->next;
            currentP2 = currentP2->next;
        }else if(currentP1->power > currentP2->power){//if this power is greater move to
            //the next
            currentP1 = currentP1->next;
        }else{// if other power is greater add this polynomial
            Term *temp = new Term;
            temp->coeff = currentP2->coeff;
            temp->power = currentP2->power;
            temp->prev = currentP1->prev;
            temp->next = currentP1;
            currentP1->prev->next = temp;
            currentP1->prev = temp;
            this->size++;
            currentP2 = currentP2->next;
        }
    }

    while(currentP2 != p.head){// adding rest of other polynomial terms to this polynomial
        Term *temp = new Term;
        temp->coeff = currentP2->coeff;
        temp->power = currentP2->power;
        temp->prev = currentP1->prev;
        temp->next = currentP1;
        currentP1->prev->next = temp;
        currentP1->prev = temp;
        this->size++;
        currentP2 = currentP2->next;
    }
    simplify(this);
    return *this;
}

Polynomial &Polynomial::operator-=(const Polynomial &p) {
    // same logic as -= operator
    Term *currentP1 = head->next;
    Term *currentP2 = p.head->next;
    while(currentP1 != head && currentP2 != p.head){
        if(currentP1->power == currentP2->power){
            currentP1->coeff = currentP1->coeff - currentP2->coeff;
            currentP1 = currentP1->next;
            currentP2 = currentP2->next;
        }else if(currentP1->power > currentP2->power){
            currentP1 = currentP1->next;
        }else{
            Term *temp = new Term;
            temp->coeff = -1 * currentP2->coeff;
            temp->power = currentP2->power;
            temp->prev = currentP1->prev;
            temp->next = currentP1;
            currentP1->prev->next = temp;
            currentP1->prev = temp;
            this->size++;
            currentP2 = currentP2->next;
        }
    }

    while(currentP2 != p.head){
        Term *temp = new Term;
        temp->coeff = -1 * currentP2->coeff;
        temp->power = currentP2->power;
        temp->prev = currentP1->prev;
        temp->next = currentP1;
        currentP1->prev->next = temp;
        currentP1->prev = temp;
        this->size++;
        currentP2 = currentP2->next;
    }
    simplify(this);
    return *this;
}

bool Polynomial::insert(Polynomial::Term *pos, const double newCoefficient, const int power) {
    Term *toInsert = new Term();
    toInsert->coeff = newCoefficient;
    toInsert->power = power;
    //new terms data assigned
    toInsert->prev = pos->prev;
    toInsert->next = pos;
    //set new terms pointers
    pos->prev->next = toInsert;
    pos->prev = toInsert;
    //connected new term before current pos in the polynomial
    size++;
    return true;
}

bool Polynomial::remove(Polynomial::Term *pos) {
    //disconnect pointers
    pos->prev->next = pos->next;
    pos->next->prev = pos->prev;
    //delete current term from polynomial
    delete pos;
    pos = nullptr;
    size--;
    return true;
}

ostream &operator<<(ostream &output, const Polynomial &p) {
    Polynomial::Term *current = p.head;
    if(current->next == p.head) {//if only dummy header there are no terms
        output << "No Terms" << endl;
    }else {
        current = current->next;
        while (current != p.head) {// going through terms
            if(current->prev == p.head){// first term
                if(current->power > 1 || current->power < 0){// power is 2 or greater or
                    //-1 or less
                    if(current->coeff > 1){//coefficient is 2 or greater
                        output << current->coeff << "X^" << current->power;
                    }else if(current->coeff < -1){//coefficient is -2 or less
                        output << current->coeff << "X^" << current->power;
                    }else if(current->coeff == 1){//coefficient is 1
                        output << "X^" << current->power;
                    }else {// coefficient is -1
                        output << "-X^" << current->power;
                    }
                }else if(current->power == 0){// no x term if power is 0
                    output << current->coeff;
                }else{//if power is 1 or -1
                    if(current->coeff > 1){
                        output << current->coeff << "X";
                    }else if(current->coeff < -1){
                        output << -1 * current->coeff << "X";
                    }else if(current->coeff == 1){
                        output << "X";
                    }else {
                        output << "X";
                    }
                }
            }else{// cycling through list adding a + or - before term
                if(current->power > 1 || current->power < 0){
                    if(current->coeff > 1){
                        output << " + " << current->coeff << "X^" << current->power;
                    }else if(current->coeff < -1){
                        output << " - " << -1 * current->coeff << "X^" << current->power;
                    }else if(current->coeff == 1){
                        output << " + " << "X^" << current->power;
                    }else {
                        output << " - " << "X^" << current->power;
                    }
                }else if(current->power == 0){
                    if(current->coeff > 0){
                        output << " + " << current->coeff;
                    }else{
                        output << " - " << -1 * current->coeff;
                    }
                }else{
                    if(current->coeff > 1){
                        output << " + " << current->coeff << "X";
                    }else if(current->coeff < -1){
                        output << " - " << -1 * current->coeff << "X";
                    }else if(current->coeff == 1){
                        output << " + " << "X";
                    }else {
                        output << " - " << "X";
                    }
                }
            }
            current = current->next;
        }
        output << endl;
    }

    return output;
}

void Polynomial::simplify(Polynomial *pos){
    //removing a term if coefficient is 0
    Term *current = pos->head->next;
    while(current != pos->head){
        if(current->coeff == 0){
            Term *temp = current;
            current = current->next;
            remove(temp);
        }else {
            current = current->next;
        }
    }
}

int Polynomial::getSize() const {
    //return number of terms in polynomial
    int size = this->size;
    return size;
}
