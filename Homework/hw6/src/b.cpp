#include<cstdio>
#include<iostream>
using namespace std;

int parents[200002];
int distances[200002];

int find(int x){
    if (parents[x] == x){
        return x;
    }else{
        int root = find(parents[x]);
        distances[x] += distances[parents[x]];
        parents[x] = root;
        return root;
    }
}


int absolute(int x){
    return (x>0)? x: -x;
}

void Union(int x, int y){
    parents[x] = y;
    distances[x] = absolute(x-y) % 1000;
}


int main() {
    int kcases;
    cin >> kcases;
    while(kcases--){
        int enterprises;
        cin >> enterprises;
        for (int i = 0 ; i < enterprises + 1; i++){
            parents[i] = i;
            distances[i] = 0;
        }
        char inst;
        int A,B;
        int x;
        while(1){
            cin >> inst;
            if (inst == 'O'){
                break;
            }else if (inst == 'I'){
                cin >> A >> B;
                Union(A,B);
            }else{
                //inst == 'E'
                cin >> x;
                find(x);
                cout << distances[x] << endl;
            }
        }
    }
    return 0;
}
