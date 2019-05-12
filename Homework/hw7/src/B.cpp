
#include <cstdio>
#include <stack>
#include <cstring>
using namespace std;

int dp[10005];
int N,tracks; //tracks <= 20
int cds[21];
bool visited[21][10005];

//knapsack problem
int main(){
    //N, tracks, cds get overwritten
    while(scanf("%d%d", &N, &tracks) != EOF){
        int i,j;
        for (i = 0; i < tracks; i++){
            scanf("%d", &cds[i]);
        }
        memset(dp, 0, sizeof(dp));
        memset(visited, false, sizeof(visited));
        for (i = 0; i < tracks; i++){
            for (j = N; j>=cds[i]; j--){
                //dp[j] = max (dp[j], dp[j-cds[i]] + cds[i])
                if (dp[j] < dp[j - cds[i]] + cds[i]){
                    visited[i][j] = true; //if we decide to take on this
                    dp[j] = dp[j-cds[i]] + cds[i];
                }
            }
        }
        //print out the result
        stack<int> s;
        j = N;
		for (i = tracks - 1; i >= 0; --i){
			if (visited[i][j])
			{
                s.push(cds[i]);
				j -= cds[i];
			}
		}
        while (!s.empty()){
            printf("%d ",s.top());
            s.pop();
        }
        printf("sum:%d\n",dp[N]);
    }
    return 0;
}
