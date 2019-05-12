#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
const int M = 8 + 5;
const int N = 8 * 8 + 5;

long long Rb[M][N], Rw[M][N], B[M], W[M];

void calc(int n, int k, long long R[][N], long long C[]){
    int i, j;
    memset(R, 0, sizeof(R));
    for (i = 0; i <= n; i++){
        R[i][0] = 1;
    }
    for (i = 1; i <= n; i++){
        for (j = 1; j <= C[i]; j++){
            R[i][j] = R[i - 1][j] + R[i - 1][j - 1] * (C[i] - j + 1);
        }
    }
}

int main(){
    int i, j, n, k;
    long long ans;
    while (scanf("%d%d", &n, &k), n){
        memset(B, 0, sizeof(B));
        memset(W, 0, sizeof(W));
        for (i = 1; i <= n; i++){
            for (j = 1 ; j <= n; j++){
                if ((i + j) & 1) {
                    ++W[(i + j) >> 1];
                }
                else {
                    ++B[(i + j) >> 1];
                }
            }
        }
        sort(B + 1, B + n + 1);
        sort(W + 1, W + n);
        calc(n, k, Rb, B);
        calc(n - 1, k, Rw, W);
        ans = 0;
        for (i = 0; i <= k; i++){
            ans += Rb[n][i] * Rw[n - 1][k - i];
        }
        printf("%lld\n", ans);
    }
    return 0;
}
