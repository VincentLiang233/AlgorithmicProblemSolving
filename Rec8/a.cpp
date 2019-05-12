    #include <cstdlib>
    #include <cstring>
    #include <cstdio>
    #include <cmath>
    
    char map[101][101];
    char run[] = "@IEHOVA#";
    char forward[4][8] = {"forth","right","","left"};
    int  path[8];
    
    int  dxy[4][2] = {-1,0,0,1,1,0,0,-1};//上右下左 
    void find(int i, int j, int r, int l, int d, int f)
    {
        if (!run[d]) {
            for (int k = 1 ; k < d ; ++ k) {
                if (k > 1) printf(" ");
                printf("%s",forward[path[k]]);
            }
            printf("\n");return;
        }else {
            for (int k = 0 ; k < 4 ; ++ k) {
                if (abs(f-k) == 2) continue;
                int x = i+dxy[k][0];
                int y = j+dxy[k][1];
                if (x >= 0 && x < r && y >= 0 && y < l)
                if (map[x][y] == run[d]) {
                    path[d] = k;
                    find(x, y, r, l, d+1, k);
                }
            }
        }
    }
    
    int main()
    {
        int n,r,l;
        while (~scanf("%d",&n)) 
        while (n --){
            scanf("%d%d",&r,&l);
            for (int i = 0 ; i < r ; ++ i)
                scanf("%s",map[i]);
            
            for (int i = 0 ; i < r ; ++ i)
            for (int j = 0 ; j < l ; ++ j)
                if (map[i][j] == '@')
                    find(i, j, r, l, 1, 0);
        }
        return 0;
    }