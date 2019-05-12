#include<iostream>

using namespace std;

int main() {
    int input;
    int output;
    while(cin >> input) {
        output = 0;
        for (int i = 0; i < 4; ++i) {
            output = output << 8 | ((input >> i * 8) & 255);
        }
        cout << input << " converts to " << output << endl;
    }
    return 0;
}