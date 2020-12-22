import time
import pprint
import math

vertex_size = 0
bridge_num = 0

count = 0

position=[]
low=[]
bridge=[]
graph=[]


def input_Vertex():
    global graph,vertex_size,low,bridge,position
    vertex_size = int(input("정점의 수를 입력하세요 : "))

    graph = [[0 for i in range(int(vertex_size))] for i in range(int(vertex_size))]
    low = [0 for i in range(int(vertex_size))]
    bridge = [0 for i in range(int(vertex_size))]
    position = [0 for i in range(int(vertex_size))]

    while(1):
        print("\n *** -1 입력시 종료 ***")
        temp = int(vertex_size)-1
        try :
            u = int(input("간선의 양 끝에 해당하는 정점 입력 1 ( 0 부터 %s까지 ) : "%(temp)))
            v = int(input("간선의 양 끝에 해당하는 정점 입력 2 ( 0 부터 %s까지 ) : "%(temp)))

            if u == -1 or v == -1:
                break

            print("입력")
            graph[u][v] = 1
            graph[v][u] = 1
        except:
            print("오류 발생")


def bridge_test():
    global vertex_size,low,position,bridge
    count = 0
    print("\n브릿지 테스트 시작")
    print("** 브릿지 테스트에서 count = %s"%(count))
    print("** 브릿지 테스트에서 vertex_size = %s\n"%(vertex_size))

    #-1로 초기화
    for a in range(int(vertex_size)):
        low[a] = -1
        position[a] = -1
        bridge[a] = -1
    print("<low,position,bridge -1로 초기화>")
    print(" low => ",low,"\n","position => ",position,"\n","bridge => ",bridge)
    print("\n")
    for i in range(vertex_size):
        if position[i] == -1:
            print("DFS 테스트 실행")
            DFS(i,i)

def DFS(u,v):
    global vertex_size,position,low,bridge,graph,count
    count = count +1
    print("** DFS count => %s"%(count))
    position[v] = count
    low[v] = position[v]

    for w in range(vertex_size):
        if graph[w][v] == 1:
            if position[w] == -1:
                DFS(v,w)

                # put min value
                low[v] = min(low[v], low[w])
                # check bridge
                if low[w] == position[w]:
                     bridge[v] = w

            elif w != u:
                # put min value
                low[v] = min(low[v],position[w])



def adj_list():

    print("=======================================================================================")
    global vertex_size,graph

    print("\n 각 정점의 인접 리스트")
    for i in range(vertex_size):
        print("▶ 정점 %s의 인접 리스트 : ",i, end=' ')
        for j in range(vertex_size):
            if graph[i][j]!=0:
                print("%s"%(j),end=' ')

    print("=======================================================================================\n")



def is_Bridge():
    global bridge
    print("bridge => ",bridge)

    u = int(input("간선에 양 끝에 해당하는 정점 입력 1 : "))
    v = int(input("간선에 양 끝에 해당하는 정점 입력 2 : "))


    if bridge[u] != -1 and bridge[u] == v:
        print("▶ <%s,%s>는 브릿지입니다."%(u,v))
    else:
        print("▶ <%s,%s>는 브릿지가 아닙니다."%(u,v))



def show_Bridges():
    bridge_num = 0
    global vertex_size,bridge

    for a in range(vertex_size):
        if bridge[a] != -1:
            print("▶ <%s,%s>\n"%(a,bridge[a]))
            bridge_num = bridge_num + 1

    if bridge_num == 0:
        print("▶ 브릿지가 존재하지 않습니다. \n")




if __name__ == "__main__":

    print("*** Bridge Test 프로그램을 시작합니다. ***\n\n");
    input_Vertex()
    bridge_test()

    print(" low => ",low,"\n","position => ",position,"\n","bridge => ",bridge)

    while(1):
        print("=======================================================================================\n")
        print("[원하는 동작 번호를 입력해주세요]\n")
        print("1. 간선 브릿지 테스트        (입력 : 1)\n")
        print("2. 각 정점의 인접리스트 출력  (입력 : 2)\n")
        print("3. 전체 브릿지 출력          (입력 : 3)\n")
        print("4. 종료                    (입력 : 4)\n")
        print("=======================================================================================\n")
        option = input("선택 번호 : ")

        if option == '1':
            print("브릿지 테스트 시작")
            is_Bridge()
        elif option == '2':
            print("각 정점의 인접리스트 출력")
            adj_list()
        elif option == '3':
            print("전체 브릿지 출력")
            show_Bridges()
        elif option == '4':
            print("종료")
            break
        else:
            print("다시 입력하세요")
