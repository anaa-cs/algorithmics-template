import Helper
import sys

def prim(file):
    m = Helper.triangularMatrixFromFile(file)
    V = len(m)
    parent = [-1] * V
    key = [sys.maxsize] * V
    set = [False] * V
    key[0] = 0
    parent[0] = -1
    for i in range(V):
        u = min_key(key, set)
        set[u] = True

        for v in range(V):
            if(m[u][v] and not set[v] and key[v] > m[u][v]):
                key[v] = m[u][v]
                parent[v] = u
    print(key)  

def min_key(key, set):
    min_value = sys.maxsize
    min_index = -1
    for v in range(len(key)):
        if(key[v] < min_value and not set[v] and min_value != 0):
            min_value = key[v]
            min_index = v
    return min_index


prim("graph8.txt")

""""
def prim(file):
    m = Helper.triangularMatrixFromFile(file)
    visited = []
    optimumCost = 0
    weights = []
    visited.append(0)
    counter = 0
    while (visited and counter<4):
        minimum = 1000
        position = 0
        for i in range(len(visited)):
            weight, pos = min(m,i)
            print(i)
            if(weight<minimum):
                minimum = weight
                position = pos
        visited.append(position)
        weights.append(minimum)
        optimumCost = optimumCost + minimum
        counter += 1
        print(weights)

def min(m, row):
    minimum = max(m[row])
    pos = 0
    for i in range(row+1,len(m[row])):
        if(minimum>m[row][i]):
            minimum = m[row][i]
            pos = i
    return minimum, pos
"""