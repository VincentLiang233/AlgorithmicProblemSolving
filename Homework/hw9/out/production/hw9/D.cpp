#include <cstdio>
#include <cmath>

int nums[7]; // at most 6
int main(){
    FILE *fp;
    fp = fopen("do.txt","w");
    while(true){
        int sum = 0;
        for (int i = 1; i < 7; i++){
            scanf("%d", &nums[i]);
            sum += nums[i];
        }
        if (sum == 0) break;
        //a box is of 6*6
        int ans = 0;
        ans += nums[6]; //new box for 6 by 6
        ans += nums[5]; //new box for 5 by 5, 11 1*1 left
        ans += nums[4]; //new box for 4 by 4, 5 2*2 left
        ans += (nums[3]/4);
        nums[1] -= 11 * nums[5];
        nums[2] -= 5 * nums[4];
        switch(nums[3] % 4){
            case 1:
            //5 2*2 and 7 1*1
                nums[2] -=5;
                nums[1] -=7;
                ans += 1;
                break;
            case 2:
            //3 2*2 and 6 1*1
                nums[2] -=3;
                nums[1] -=6;
                ans += 1;
                break;
            case 3:
            //1 2*2 and 5 1*1
                nums[2] -=1;
                nums[1] -=5;
                ans += 1;
                break;
        }
        if (nums[2] < 0){
            nums[1] += 4 * nums[2];
            nums[2] = 0;
        }
        if (nums[1] < 0) nums[1] = 0;
        ans += ceil((nums[1] + 4 * nums[2]) / 36.);

        fprintf(fp,"%d\n", ans);
    }
    return 0;
}
