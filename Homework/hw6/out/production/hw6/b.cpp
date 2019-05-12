
#include<bits/stdc++.h>
using namespace std;
const int maxn = 20005;

int pa[maxn], d[maxn];

inline void pushdown(int x)
{
	d[x] += d[pa[x]];
}

int find(int x)
{
	if (pa[x])
	{
		int root = find(pa[x]);
		pushdown(x); ///在递归后调用，以便从根节点往下更新值
		return pa[x] = root;
	}
	return x;
}

int main()
{
	//freopen("in.txt","r",stdin);
	int T, u, v;
	char op;
	scanf("%d", &T);
	while (T--)
	{
		memset(d, 0, sizeof(d));
		memset(pa, 0, sizeof(pa));
		scanf("%*d");
		getchar();
		while ((op = getchar()) != 'O')
		{
			if (op == 'E')
			{
				scanf("%d", &u);
				find(u);
				printf("%d\n", d[u]);
			}
			else
			{
				scanf("%d%d", &u, &v);
				pa[u] = v;
				d[u] = abs(u - v) % 1000;
			}
			getchar();
		}
	}
	return 0;
}
