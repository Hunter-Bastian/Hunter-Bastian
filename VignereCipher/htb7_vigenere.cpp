//Description: A program to encrypt and decrype alphabetical symbols using the vigenere approach
//Author : Hunter Bastian
//Email : Htb7@students.uwf.edu
//Course : CEN 4078 Secure Software Development
//Project number : 03
//Date : 14th March, 2022
//Version 0.01 
//File Name : htb7_vigenere.cpp

#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <fstream>
using namespace std;

string vigenereEncrypt(string plaintext, string key, map <char, int> values) {
    string converted = plaintext;
    string newKey = plaintext;
    int j = 0;
    char buffer;

    //establish full key
    for (int i = 0; i < plaintext.length(); i++) {
        j = (i % key.length());
        newKey[i] = tolower(key[j]);
    }

    //shift
    for (int i = 0; i < plaintext.length(); i ++) {
        if (plaintext[i] >= 'a' and plaintext[i] <= 'z') {
            buffer = plaintext[i] + values[newKey[i]];
            if (buffer <= 'z') {
                converted[i] = buffer;
            }
            else {
                buffer =  'a' + (buffer - 'z') -1;
                converted[i] = buffer;
            }
        }
        else if (plaintext[i] >= 'A' and plaintext[i] <= 'Z') {
            buffer = plaintext[i] + values[newKey[i]];
            if (buffer <= 'Z') {
                converted[i] = buffer;
            }
            else {
                buffer = 'A' + (buffer - 'Z')-1;
                converted[i] = buffer;
            }
        }
    }

    return converted;
}

string vigenereDecrypt(string cipher, string key, map <char, int> values) {
    string converted = cipher;
    string newKey = cipher;
    int j = 0;
    char buffer;

    //establish full key
    for (int i = 0; i < cipher.length(); i++) {
        j = (i % key.length());
        newKey[i] = tolower(key[j]);
    }

    //shift
    for (int i = 0; i < cipher.length(); i++) {
        if (cipher[i] >= 'a' and cipher[i] <= 'z') {
            buffer = cipher[i] - values[newKey[i]];
            if (buffer >= 'a') {
                converted[i] = buffer;
            }
            else {
                buffer = 'z' - ('a'- buffer) + 1;
                converted[i] = buffer;
            }
        }
        else if (cipher[i] >= 'A' and cipher[i] <= 'Z') {
            buffer = cipher[i] - values[newKey[i]];
            if (buffer >= 'A') {
                converted[i] = buffer;
            }
            else {
                buffer = 'Z' - ('A' - buffer) +1;
                converted[i] = buffer;
            }
        }
    }

    return converted;
}


int main()
{
    ifstream in;
    ofstream out;
    bool flag = true;
    int selectionBuffer;
    char tryAgain;

    string input;
    string output;

    string plaintext;
    string plaintextBuffer;
    string cipherBuffer;
    
    string key;

    string cipher;
    string deciphered;

    map <char, int> alphabetL;
    alphabetL.emplace('a', 0);
    alphabetL.emplace('b', 1);
    alphabetL.emplace('c', 2);
    alphabetL.emplace('d', 3);
    alphabetL.emplace('e', 4);
    alphabetL.emplace('f', 5);
    alphabetL.emplace('g', 6);
    alphabetL.emplace('h', 7);
    alphabetL.emplace('i', 8);
    alphabetL.emplace('j', 9);
    alphabetL.emplace('k', 10);
    alphabetL.emplace('l', 11);
    alphabetL.emplace('m', 12);
    alphabetL.emplace('n', 13);
    alphabetL.emplace('o', 14);
    alphabetL.emplace('p', 15);
    alphabetL.emplace('q', 16);
    alphabetL.emplace('r', 17);
    alphabetL.emplace('s', 18);
    alphabetL.emplace('t', 19);
    alphabetL.emplace('u', 20);
    alphabetL.emplace('v', 21);
    alphabetL.emplace('w', 22);
    alphabetL.emplace('x', 23);
    alphabetL.emplace('y', 24);
    alphabetL.emplace('z', 25);

    while (flag) {
    menu:
        cout << "Select an option:\n1. Encrypt\n2. Decrypt\n3. Quit\n";
        while (flag) {
            cin >> selectionBuffer;
            if (cin.good() and selectionBuffer >= 0 and selectionBuffer <= 3) {
                break;
            }
            else {
                cout << "Invalid input. Please try again\n";
                goto menu;
            }
        }
        switch (selectionBuffer) {
        case 1: {
            plaintext.clear();
            cout << "Please enter an alphabetical key: ";
            cin >> key;
            while (flag) {
                cout << "Please input the filename of the plaintext file\n";
                cin >> input;
                in.open(input);
                if (in.is_open()) {
                    break;
                }
                else {
                    cout << "Invalid input. Would you like to input another file?\n y/n\n";
                    cin >> tryAgain;
                    if (tryAgain != 'y' and tryAgain != 'Y') {
                        goto menu;
                    }
                }
            }
            while (!getline(in, plaintextBuffer).eof()) {
                plaintext.append(plaintextBuffer);
            }
            plaintext.append(plaintextBuffer);
            in.close();
           
            cout << plaintext << '\n';
            cipher = vigenereEncrypt(plaintext, key, alphabetL);

            cout << cipher << '\n';

            out.open("cipherLog.txt");
            out << cipher << '\n';
            out.close();
            cout << "Ciphertext written to cipherLog.txt\n";
            break;
        }
        case 2: {
            cipher.clear();
            cout << "Please enter an alphabetical key: ";
            cin >> key;
            while (flag) {
                cout << "Please input the filename of the encrypted file\n";
                cin >> input;
                in.open(input);
                if (in.is_open()) {
                    break;
                }
                else {
                    cout << "Invalid input. Would you like to input another file?\n y/n\n";
                    cin >> tryAgain;
                    if (tryAgain != 'y' and tryAgain != 'Y') {
                        goto menu;
                    }
                }
            }
            while (!getline(in, cipherBuffer).eof()) {
                cipher.append(cipherBuffer);
            }
            cipher.append(cipherBuffer);
            in.close();

            cout << cipher << '\n';
            plaintext = vigenereDecrypt(cipher, key, alphabetL);

            cout << plaintext << '\n';

            out.open("plaintextLog.txt");
            out << plaintext << '\n';
            out.close();
            cout << "Plaintext written to plaintextLog.txt\n";
            break;
        }
        case 3: {
            exit(0);
        }
        default: {
            goto menu;
        }
        }
    }
}
   

