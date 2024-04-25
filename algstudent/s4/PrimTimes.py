import time
import Helper
import Prim

def main():
    size = 256

    for i in range(10):
        m = Helper.triangularMatrixRandomIntegers(size, 100, 999)
        start = time.time()
        weights, visited, total_cost = Prim.prim(m)
        end = time.time()
        print("Size: ", size, " - Time: ", end-start)
        print("Total cost: ", total_cost)
        size *= 2
    return 0


m = main()