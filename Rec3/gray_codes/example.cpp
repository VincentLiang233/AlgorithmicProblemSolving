#include <cstdio>
#include <vector>

int grey(int n, int k) {
    if(n == 1) {
        if(k == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    int halfInd = (1 << (n - 1)) - 1;
    if(k <= halfInd) {
        return grey(n - 1, k);
    } else {
        int diff = k - halfInd - 1;
        k = halfInd - diff;
        return grey(n - 1, k) | 1 << (n - 1);
    }
}

int main() {
    int nExamples, n, k;
    scanf("%d", &nExamples);
    for(int i = 0; i < nExamples; i++) {
        scanf("%d %d", &n, &k);
        printf("%d\n", grey(n, k));
    }
    return 0;
}