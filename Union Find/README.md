
Worst-case time of algorithms (M union-find operations on a set of N objects):
- Quick-Find = M N
- Quick-Union = M N
- weighted QU = N + M logN
- QU + path compression = N + M logN
- weighted QU + path compression = N + M lg!N

where lg!N < 5 for each N < 2^65536

