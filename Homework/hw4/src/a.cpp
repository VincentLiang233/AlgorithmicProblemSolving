#include <cstdio>
using namespace std;

int main(){
    long long N,L,U;
    while (scanf("%lld %lld %lld", &N, &L, &U) != EOF){
        long long ans = 0;
        for (int i = 32; i >= 0; i--){
            long long temp = 0;
            if ((N & (1ll << i)) == 0){
                //if this bit is 0
                temp = ans | (1ll << i);
                if (temp <= U){
                    ans = temp;
                }
            }else{
                //if this is 1
                //set this bit of ans to 0 if possible
                temp = (N & (1ll << i))-1 ;
                temp |= ans;
                if (temp < L){
                    ans |= (N & (1ll << i));
                }
            }
        }
        printf("%lld\n", ans);
    }
    return 0;
}


