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
| 백준 | [1182](https://www.acmicpc.net/problem/1182) | n개의 원소를 가진 부분수열은 그 원소를 넣을지 / 말지 2가지 경우라 2^n -> 넣는 경우, 안 넣는 경우 각각에 재귀호출, s=0일 경우 공집합 제외해주는거 까먹지 않기 |
| 백준 | [6603](https://www.acmicpc.net/problem/6603) | 사용 된 원소는 backtracking 대상에서 제외하는 if 조건 까먹지 않기 |
| 백준 | [15650](https://www.acmicpc.net/problem/15650) | 기본적인 순열 구하는 문제 |
| 백준 | [15651](https://www.acmicpc.net/problem/15651) | 중복이 가능하므로 used 배열 사용 안함, index 없이 for문은 1부터 시작 |

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
| 백준 | [12852](https://www.acmicpc.net/problem/12852) | pre 배열 만들어두고 이전에 어디가 최적의 경로인지를 저장하고 출력하기 |
| 백준 | [9461](https://www.acmicpc.net/problem/9461) | DP[i] : 나선에서 가장 긴 변 길이, DP[i] = DP[i-2] + DP[i-3] , long 처리 필요 |
| 백준 | [1932](https://www.acmicpc.net/problem/1932) | List 형태로 DP 배열, DP[i].add(Math.max(DP[i-1].get(j-1), DP[i-1].get(j)) + num[i].get(j)) |
| 백준 | [11053](https://www.acmicpc.net/problem/11053) | 다시 풀기, 2중 for문 통해 DP = i에서의 증가 부분 수열 최대길이가 맞는 지 확인 |
| 백준 | [11055](https://www.acmicpc.net/problem/11055) | DP[i] : 각 원소 값으로 초기화, i위치에서 합이 최대값인 부분수열의 합 |
| 백준 | [2294](https://www.acmicpc.net/problem/2294) | DP 배열 설정시 동전의 금액이 k보다 클수 있으므로 배열 크기에 주의 |
| 백준 | [2225](https://www.acmicpc.net/problem/2225) | DP는 long으로 초기화, D[i][j-1] + D[i-1][j-1] …D[i-2][j-1]…D[0][j-1] |
| 백준 | [15989](https://www.acmicpc.net/problem/15989) | DP[i] = DP[i-1] + DP[i-2] - DP[i-3], i % 3 == 0이라면 +1도 |

## Simulation
| 플랫폼 | 문제 | 대략 설명 |
| ---- | --- | ------- |
| 백준 | [15683](https://www.acmicpc.net/problem/15683) | 카메라 개수 k라 하면 0 ~ 4^k-1로 각 카메라 끼리의 방향 조합을 구할 수 있음 |
| 백준 | [18808](https://www.acmicpc.net/problem/18808) | 배열 회전시키기, break-for 루프 중첩문 부분 로직 잘 살필것 : flag 방식으로 attached = true면 루프 나오기 |
| 백준 | [12100](https://www.acmicpc.net/problem/12100) | 기존의 배열 회전시키기, 카메라 방향조합 찾기 재탕, tilt 메소드에 대해 다시 이해하기 |
| 백준 | [15686](https://www.acmicpc.net/problem/15686) | 조합을 구하는 부분만 잘 기억하기 |

## BinSearch 
| 플랫폼 | 문제 | 대략 설명 |
| ---- | --- | ------- |
| 백준 | [1920](https://www.acmicpc.net/problem/1920) | 기본적인 이분탐색 문제 |
| 백준 | [10816](https://www.acmicpc.net/problem/10816) | 정렬을 유지한 채 원소를 넣을 수 있는 가장 왼쪽과 가장 오른쪽을 찾아서 차이 구하기 |
| 백준 | [18870](https://www.acmicpc.net/problem/18870) | 배열 정렬 - 배열의 중복 제거 후 이분탐색을 통해 각 숫자의 인덱스를 확인 |
| 백준 | [2295](https://www.acmicpc.net/problem/2295) | 2개의 수를 미리 묶은 후, 원본 배열에서 나머지 한 수 골라서 뺀 값이 2개 묶은 배열에 존재하는지 판단하여 갱신 / 또는 Hash 응용하여 이분탐색 없이 풀기도 함 |
| 백준 | [1654](https://www.acmicpc.net/problem/1654) | 기본적인 parametric Search 문제 |
| 백준 | [2467](https://www.acmicpc.net/problem/2467) | 투포인터 기반의 이분탐색 문제 |

## 자유 문제 풀이
| 플랫폼 | 문제 | 문제 유형 | 대략 설명 |
| ---- | --- | ------- | ------- | 
| 백준 | [13144](https://www.acmicpc.net/problem/13144) | 투 포인터 | 갹 end마다 가능한 부분수열 개수 end-start+1, 중복 숫자 발견시 없어질때까지 start++, long으로 카운팅 |
| 백준 | [14002](https://www.acmicpc.net/problem/14002) | 동적계획법 | DP[n-1][0]이 무조건 최장길이라는 보장이 없으므로 한번더 반복문 돌면서 최장길이 찾아야 함 |