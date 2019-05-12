#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

int main()
{
    int kases;
    scanf("%d", &kases);

    while (kases--)
    {

        int ferryLength;
        cin >> ferryLength;
        ferryLength *= 100;

        int cars[205]; //cars' lengths
        int sums[205]; //sum of cars' length
        int count = 0; // number of cars
        int num = 0;
        memset(cars, 0, sizeof(cars));
        memset(sums, 0, sizeof(sums));

        while (cin >> num, num){
            ++count;
            cars[count] = num;
            sums[count] = sums[count - 1] + num;
        }
        // possible(count, ferryLength(left)) = possible(count- 1, ferryLength(left) - sums[count])
        //                                   || possible(count- 1, ferryLength(right) - sums[count])
        // table[i][j] = 1 means we can put i cars with total length of j at the left lane
        // ferryLength(right) = sums[i] - j; at the ith, jth step
        int maxCar = -1;                       //maximum number of cars that we will load
        int maxJ = -1;                         // maximum length we can get to, used to recover answer
        int table[count + 5][ferryLength + 5]; //dp table
        int path[count + 5][ferryLength + 5];
        memset(table, 0, sizeof(table));
        memset(path, 0, sizeof(path));

        table[0][0] = 1;
        for (int i = 1; i <= count; i++)
        {
            for (int j = 0; j <= ferryLength; j++)
            {
                //left
                if (j - sums[i] >= 0 && (table[i - 1][j - sums[i]]))
                {
                    maxCar = i;
                    maxJ = j;
                    table[i][j] = 1;
                    path[i][j] = j - sums[i]; //chose left
                }
                //right
                else if (sums[i] - j <= ferryLength && (table[i - 1][j]))
                {
                    maxCar = i;
                    maxJ = j;
                    table[i][j] = 1;
                    path[i][j] = j; // we chose right
                }
            }
        }
        //recover answer
        int i = maxCar;
        int cursor = 0;
        int ans[205]; // at most 205 cars
        memset(ans, 0, sizeof(ans));

        while (i--)
        {
            cursor = path[i + 1][maxJ];
            if (cursor == maxJ)
            {
                ans[i] = 1;
            }
            else
            {
                ans[i] = 0;
            }
            maxJ = cursor;
        }
        printf("%d\n", maxCar);
        for (int k = 1; k <= maxCar; k++)
        {
            if (ans[k - 1])
            {
                printf("starboard\n"); //right
            }
            else
            {
                printf("port\n");
            }
        }
        if (kases > 0)
        {
            printf("\n");
        }
        return 0;
    }
}
