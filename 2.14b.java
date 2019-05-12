//Set kth bit to 1
n = ((1 << k) | n)
//Set kth bit to 0
n = (n & (~(1 << k)))
//Flip the kth bit
n = (n ^(1 << k))

//invert all bits but the last (left) bit
n = n | (n-1)
//set the last one bit in x to 0
n = n & (n-1)
//test if x a power of two
(n & (n-1) == 0)
