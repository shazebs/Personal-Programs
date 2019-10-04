/* 
 * File:   FourIntegerStats.cpp
 * Author: Shazebs (Paladin Sapheron)
 * Created on October 3, 2019, 8:00 PM
 */

#include <cstdlib>
#include <cstdio>
#include <iostream>
#include <iomanip>
using namespace std;
/*
 * 
 */
int main(int argc, char** argv) {
    
    // variable declaration
    int int1,int2,int3,int4;    // to hold integer values
    int smallest;
    int largest;
    int sum;
    int avg;     // setprecision(0)
    
    // get the input for the four integer values
    cout << "Enter four integer values: "; 
    cin >> int1 >> int2 >> int3 >> int4;
    
    /*// scanf function example which can be used to complete assignment
     * //---------------------------------------------------------------
     * Notes:
     * LSL_n: logical shift n-bits left (multiplies by 2^n)
     * LSR_n: logical shift n-bits right (divide by 2^n)
     * 
     * scanf("%d %d %d %d", &num1,&num2,&num3,&num4)
     * 
     * //     Registers 
     * //--------------------
     *    R0 = "%d %d %d %d"
     *    R1 = &num1
     *    R2 = &num2
     *    R3 = &num3
     * //--------------------
     * 
     * LDR R0, = scan_str4
     * LDR R1, = num1
     * LDR R2, = num2
     * LDR R3, = num3
     * LDR R4, = num4
     * PUSH {R4}
     * BL scanf
     * 
     * //---------------------------------------------------------------
     * scanf("%d", &num1)
     * scanf("%d", &num2)
     * scanf("%d", &num3)
     * scanf("%d", &num4)
     * 
     * scanf("%d %d", &num1 num2)
     * scanf("%d %d", &num3 num4)
     * 
     * LDR r0, = scanf_str2
     * LDR r1, =num1
     * LDR r2, = num2
     * BL scanf
     * LDR r0, = scan_str2
     * LDR r1, = num3
     * LDR r2, = num4
     * BL scanf
     */
    
    // Test Calculations
    smallest = int2;
    largest = int3;
    sum = int1 + int2 + int3 + int4;
    avg = sum/4;
    
    // Test Ouptut For Final Code 
    cout << "The smallest value is " << smallest << endl;
    cout << "The largest value is " << largest << endl;
    cout << "The sum of all values is: " << sum << endl;
    cout << "The average of the four values is: " << avg << endl;

    // end program
    cout << endl << "Program has Successfully Ended.";
    return 0;
}

