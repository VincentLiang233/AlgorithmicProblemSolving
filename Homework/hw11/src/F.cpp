#include <cstdio>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int n,m;
int nums[100010]; //at most 100000
int parents[100010];
int sum[100010];

int find(int p){
    if (parents[p] != p){
        //regular find
        parents[p] = find(parents[p]);
    }
    return parents[p]; // here is a VIRTUAL parent
}

void Union(int p, int q){
    int px = find(p);
    int py = find(q);
    if (px != py){
        parents[px] = py; //usual union-find operation
        sum[py] += sum[px]; //maintain the sum for command 3
        nums[py] += nums[px]; //number of elements in the set
    }
}

void Move(int p, int q){
    //move p to q
    int px = find(p);
    int py = find(q);
    if (px != py){
        //set the virtual parent to virtual parent of q
        parents[p] = py;
        //subtract p from set of p
        //add that to set of q
        sum[py] += p;
        sum[px] -= p;
        //decrement set of x
        //decrement set of y
        nums[py]++;
        nums[px]--;
    }
}

int main(){
    int command, p, q;
    while(scanf("%d%d", &n, &m) != EOF){
        // for the 2nd command, since we might we move p to set of q when p is a root node
        // we set the parent of each cell to something else so that we DID NOT move the real val
        for (int i = 1; i <= n; i++){
            parents[i] = i + n;
            parents[i+n] = i + n; //itself
            sum[i+n] = i;
            nums[i+n] = 1;
        }
        for (int i = 0; i < m; i++){
            cin >> command;
            if (command == 1) {
                scanf("%d%d", &p, &q);
                Union(p,q);
            }else if (command == 2){
                scanf("%d%d", &p, &q);
                Move(p,q);
            }else{
                //command = 3
                scanf("%d", &p);
                int px = find(p);
                printf("%d %d\n", nums[px], sum[px]);
            }
        }
    }
    return 0;
}
