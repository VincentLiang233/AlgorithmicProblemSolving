#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

struct Sprinkler{
	double start;
	double end;
	bool operator < (const Sprinkler &b) const{
		return start < b.start;
	}
}sprinklers[10005];

int n;
double l,w;
int main(){
	while(scanf("%d %lf %lf", &n, &l, &w)!= EOF){
		int id = 0;
		for (int i = 0; i < n; i++){
			int p,r;
			scanf("%d %d", &p, &r);
			//p is the position of the sprinkler (center)
			//r is the radius
			//if the radius is less than w/2 then this one shouldn't be considered
			if (r < w/2){
				continue;
			}else{
				double l = sqrt(pow(r,2) - pow(w/2 , 2)); // the length from center that it covers
				sprinklers[id].start = p-l;
				sprinklers[id].end = p+l;
				id += 1;
			}
		}
		sort(sprinklers,sprinklers+id);
		//meeting room problem
		int counter = 0;
		double rightBound = 0;
		double leftBound = 0;
		bool flag = false;
		for (int i = 0; i < id; i++){
			if (sprinklers[i].start > l){
				break;
			}
			if (sprinklers[i].end > rightBound){
				counter += 1;
				for (int j = i; j < id && sprinklers[j].start <= leftBound; j++){
					rightBound = rightBound > sprinklers[j].end ? rightBound : sprinklers[j].end;
				}
				if (rightBound >= l){
					flag = true;
					break;
				}
				leftBound = rightBound;
			}
		}

		if (flag){
			printf("%d\n", counter);
		}else{
			printf("-1\n");
		}
	}
	return 0;
}

