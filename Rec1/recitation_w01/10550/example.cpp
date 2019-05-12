#include <cstdio>

using namespace std;

int main() {
    int startPos, pos1, pos2, pos3;
    int degreePerTick = 9;
    int totalTicks = 0;
    scanf("%d %d %d %d", &startPos, &pos1, &pos2, &pos3);

    while(startPos || pos1 || pos2 || pos3) {
        totalTicks = (startPos + 40 - pos1) % 40 +
                        (pos2 + 40 - pos1) % 40 +
                        (pos2 + 40 - pos3) % 40 +
                        3 * 40;
        printf("%d\n", totalTicks * degreePerTick);
        scanf("%d %d %d %d", &startPos, &pos1, &pos2, &pos3);
    }

    return 0;
}