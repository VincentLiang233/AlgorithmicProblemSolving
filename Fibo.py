def Fibo(n):
	#1 1 2 3 5 8 13
	if n == 0:
		return 1
	if n == 1 or n == 2:
		return n
	a = 1
	b = 1
	for i in range(2,n+1):
		b = a + b
		a = b - a
	return b

print(Fibo(5))

