# 나는야 포켓몬 마스터 이다솜
import sys
input = sys.stdin.readline

N,M = map(int, input().split())

# trie = [[None] * 26, 0]
pokemon = []
pokemon_d = {}

def inputDic(name, idx):
    pokemon.append(name)
    pokemon_d[name] = idx
# def inputTrie(trie, name, idx):
#     offsetA = ord('A')
#     offseta = ord('a')
#     cur = trie
#     pokemon.append(name)
#     k = 0
#     for c in name:
#         if k == 0:
#             if not cur[0][ord(c) - offsetA]:
#                 cur[0][ord(c) - offsetA] = [[None] * 26, 0]
#             k = 1
#             cur = cur[0][ord(c) - offsetA]
#         else:
#             if not cur[0][ord(c) - offseta]:
#                 cur[0][ord(c) - offseta] = [[None] * 26, 0]
#             cur = cur[0][ord(c) - offseta]
#     cur[-1] = idx

# def checkName(trie, name):
#     offsetA = ord('A')
#     offseta = ord('a')
#     cur = trie

#     k = 0
#     for c in name:
#         if k == 0:
#             cur = cur[0][ord(c) - offsetA]
#             k = 1
#         else:
#             cur = cur[0][ord(c) - offseta]
    
#     return cur[-1]

for idx in range(N):
    name = input().strip()
    inputDic(name, idx+1)

for _ in range(M):
    command = input().strip()
    result = ""
    if command.isdigit():
        result = pokemon[int(command)-1]
    else:
        result = pokemon_d[command]

    print(result)