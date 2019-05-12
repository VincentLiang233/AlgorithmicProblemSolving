#include <iostream>
#include <limits>
#include <vector>

using namespace std;

int main() {
    int testCases, nStores, location;
    cin >> testCases;
    for(int i = 0; i < testCases; i++) {

        cin >> nStores;
        vector<int> stores;
        for(int j = 0; j < nStores; j++) {
            cin >> location;
            stores.push_back(location);
        }

        int minLocation = numeric_limits<int>::max();
        int maxLocation = numeric_limits<int>::min();

        for (std::vector<int>::iterator i = stores.begin(); i != stores.end(); ++i) {
            int store = (*i);
            if(store < minLocation) {
                minLocation = store;
            }
            if(store > maxLocation) {
                maxLocation = store;
            }
        }

        cout << (2 * (maxLocation - minLocation)) << endl;
    }

    return 0;
}