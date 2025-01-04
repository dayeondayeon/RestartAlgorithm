# Restart Algorithm

## BFS
| 플랫폼 | 문제 | 대략 설명 | 
| ---- |-----| ------ |
| 백준 | [1926](https://www.acmicpc.net/problem/1926) | 기본적인 BFS 문제 |
| 백준 | [2178](https://www.acmicpc.net/problem/2178) | BFS로 최단 거리 계산 |
| 백준 | [7576](https://www.acmicpc.net/problem/7576) | 시작점이 여러 곳인 BFS |
| 백준 | [4179](https://www.acmicpc.net/problem/4179) | 2개의 BFS, 불 먼저 퍼뜨린 후 불보다 늦게 도착하면 못간다고 판단 |
| 백준 | [1697](https://www.acmicpc.net/problem/1697) | 1차원 BFS |
| 백준 | [13913](https://www.acmicpc.net/problem/13913) | 이전 방문 점 저장하기, 데크에 넣고 스택처럼 역순으로 꺼내기 |
| 백준 | [7562](https://www.acmicpc.net/problem/7562) | 방향만 잘 잡으면 되는 기본적인 BFS |
| 백준 | [6593](https://www.acmicpc.net/problem/6593) | 3차원 BFS | 
| 백준 | [3197](https://www.acmicpc.net/problem/3197) | 물이 된 칸들 대상으로 주변 얼음을 녹이기, while(!water.isEmpty()) 하면 계속 탐색하니까 water.size 만큼만 탐색(하루에 녹는양) |

## Recursion
| 플랫폼 | 문제 | 대략 설명 |
| ---- | --- | ------- |
| 백준 | [1629](https://www.acmicpc.net/problem/1629) | 지수 2k인 경우를 구한다고 했을 때 k를 재귀로 계산 후 그 값을 다시 곱해서 2k를 구하기 |
| 백준 | [11729](https://www.acmicpc.net/problem/11729) | n번째 원판을 옮기기 위해서는 n-1번까지의 원판을 6-start-end 기둥에, n을 3에 옮긴 뒤 다시 n-1까지를 3번기둥으로 / print 잦은 호출은 시간초과 |
| 백준 | [1074](https://www.acmicpc.net/problem/1074) | 4등분 해가면서 몇 번째 사각형이냐 따라 칸수를 더해주기, n=3일때 3번째 사각형의 2,2라면 n=2일때 3번째 사각형의 2,2 값에 앞서 계산된 칸수 32 더해주기 |

## BackTracking
| 플랫폼 | 문제 | 대략 설명 |
| ---- | --- | ------ |
| 백준 | [15649](https://www.acmicpc.net/problem/15649) | 순열은 index부터 반복문 도는게 아니고 1부터 계속 도는것! |
| 백준 | [9663](https://www.acmicpc.net/problem/9663) | 대각선 상에 있는지 여부는 방문배열로 만들어둔 x+y, x-y+(n-1) 값 가지고 비교 |
| 백준 | [1182](https://www.acmicpc.net/problem/1182) | n개의 원소를 가진 부분수열은 그 원소를 넣을지 / 말지 2가지 경우라 2^n -> 넣는 경우, 안 넣는 경우 각각에 재귀호출 |

## DP
| 플랫폼 | 문제 | 대략 설명 |
| ---- | --- | ------- |
| 백준 | [1912](https://www.acmicpc.net/problem/1912) | 이전까지의 합이 더 클지, 현재의 숫자부터 다시 시작할지 2가지를 비교 |
| 백준 | [1463](https://www.acmicpc.net/problem/1463) | DP[i] = i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값 |
| 백준 | [9095](https://www.acmicpc.net/problem/9095) | DP[i] = DP[i-1] + DP[i-2] + DP[i-3] | 
| 백준 | [2579](https://www.acmicpc.net/problem/2579) | DP[i][j] : i번째 계단 포함 현재까지 j개의 계단을 연속해서 밟았을 때 점수 합의 최대값 | 
| 백준 | [1149](https://www.acmicpc.net/problem/1149) | DP[i][j] : i번쨰 집을 j컬러로 칠했을 때 최소비용 |
| 백준 | [11726](https://www.acmicpc.net/problem/11726) | DP[i] = DP[i-1](왼쪽이 1*2짜리 사각형) + DP[i-2](왼쪽이 2*1짜리 사각형) |
| 백준 | [11659](https://www.acmicpc.net/problem/11659) | DP[i] = i까지의 숫자 합, i부터 j까지의 구간합은 DP[j] - DP[i-1] |