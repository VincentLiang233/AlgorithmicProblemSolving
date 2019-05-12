#include<bitset>
#include<iostream>

using namespace std;

int main() {
    int n, m, start, end, repeat;
    cin >> n >> m;
    while(n || m) {
        bitset<1000000> intervals;
        bool conflict = false;
        for(int i = 0; i < n; ++i) {
            cin >> start >> end;
            for(int j = start; j < end; ++j) {
                if(intervals[j]) {
                    conflict = true;
                }
                intervals.set(j);
            }
        }
        for(int i = 0; i < m; ++i) {
            cin >> start >> end >> repeat;
            while(start < 1000000) {
                for(int j = start; j < end && j < 1000000; ++j) {
                    if(intervals[j]) {
                        conflict = true;
                    }
                    intervals.set(j);
                }
                start += repeat;
                end += repeat;
            }
        }
        if(!conflict) {
            cout << "NO CONFLICT" << endl;
        } else {
            cout << "CONFLICT" << endl;
        }
        cin >> n >> m;
    }
    return 0;
}