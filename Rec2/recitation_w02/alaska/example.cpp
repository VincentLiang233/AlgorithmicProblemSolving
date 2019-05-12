#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

int main() {
    int nStations;
    int station;
    scanf("%d", &nStations);
    
    while(nStations != 0) {
        vector<int> stations;
        for(int i = 0; i < nStations; ++i) {
            scanf("%d", &station);
            stations.push_back(station);
        }
        sort(stations.begin(), stations.end());

        bool possible = true;
        for(int i = 0; i < stations.size() - 1; ++i) {
            if(stations.at(i + 1) - stations.at(i) > 200) {
                possible = false;
            }
        }
        if(1422 - stations.back() > 100) {
            possible = false;
        }

        if(possible) {
            printf("POSSIBLE\n");
        } else {
            printf("IMPOSSIBLE\n");
        }

        scanf("%d", &nStations);
    }
    return 0;
}