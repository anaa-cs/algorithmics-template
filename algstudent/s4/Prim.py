import Helper

def prim(m):
    visited = [0]
    nodes = len(m)
    weights = [0]
    truth = [False] * nodes
    truth[0] = True

    while(len(visited) < nodes):
        min_weight = float("inf")
        min_pos = -1
        for i in range(len(visited)):
            aux, pos = minimum(m, visited, i, truth)
            if(aux < min_weight):
                min_weight = aux
                min_pos = pos
        weights.append(min_weight)
        visited.append(min_pos)
        truth[min_pos] = True
    return weights, visited

def minimum(matrix, nodes, pos_node, array):
    min_weight = float("inf")
    pos = -1
    node = nodes[pos_node]
    for i in range(len(matrix)):
        weight = matrix[i][node]
        if(weight < min_weight and weight != 0 and not array[i]):
            min_weight = matrix[i][node]
            pos = i
        weight = matrix[node][i]
        if(weight < min_weight and weight != 0 and not array[i]):
            min_weight = matrix[node][i]
            pos = i
    return min_weight, pos