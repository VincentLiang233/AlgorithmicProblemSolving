//setting even positions to be on
x = x|0x5555 ;
//calculating hamming distance between x and y
Integer.bitCount(x^y);
//Bitmasks to represent sets (32 elements or 64 elements)
Set intersection: a&b
Set union : a|b
Set difference: a & (~b)
//Sieve of Eratosthenes
O(NloglogN) performance
Generate all prime numbers in the range from 0 to N
for p in 2 to N:
	if p is probably prime
		set p to definitely prime
		set all multiples of p except for p itself to not prime

//Sieve of Sundaram (1934)
Constant operations deducation
