#include <cstdio>
#include <stack>
#include <string.h>
#include <vector>

using namespace std;

int main() {
    int nOperations, fun;
    char operation[4];
    scanf("%d", &nOperations);
    stack<int> funs;
    stack<int> min_funs;
    for(int i = 0; i < nOperations; i++) {
        scanf("%s", operation);
        if(strcmp(operation, "PUSH") == 0) {
            scanf("%d", &fun);
            funs.push(fun);
            if(min_funs.empty()) {
                min_funs.push(fun);
            } else {
                int min_fun = min_funs.top();
                if(fun < min_fun) {
                    min_fun = fun;
                }
                min_funs.push(min_fun);
            }
        } else if(strcmp(operation, "POP") == 0) {
            if(funs.empty()) {
                printf("EMPTY\n");
            } else {
                funs.pop();
                min_funs.pop();
            }
        } else {
            // MIN
            if(min_funs.empty()) {
                printf("EMPTY\n");
            } else {
                printf("%d\n", min_funs.top());
            }
        }
    }
    return 0;
}
