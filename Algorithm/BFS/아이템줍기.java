package BFS;
import java.util.*;
public class 아이템줍기 {
    class Solution {
        private int[][] map = new int[102][102];

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int[][] visited = new int[102][102];
            for (int[] row : visited) {
                Arrays.fill(row, -1);
            }

            int[] dirX = new int[] {-1, 0, 1, 0}; // NESW
            int[] dirY = new int[]{0 , 1, 0, -1};

            for (int i = 0; i < rectangle.length; i++) {
                fill(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2);
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { characterX * 2, characterY * 2});
            visited[characterX * 2][characterY * 2] = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == itemX * 2 && cur[1] == itemY * 2) {
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = cur[0] + dirX[i];
                    int nextY = cur[1] + dirY[i];

                    if (nextX < 0 || nextX > 101 || nextY < 0 || nextY > 101) {
                        continue;
                    }

                    if (visited[nextX][nextY] != -1 || map[nextX][nextY] != 1) {
                        continue;
                    }

                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = visited[cur[0]][cur[1]] + 1;
                }
            }
            return visited[itemX * 2][itemY * 2] / 2;
        }


        void fill(int startX, int startY, int endX, int endY) {
            for (int i = startX + 1; i < endX; i++) {
                for (int j = startY + 1; j < endY; j++) {
                    map[i][j] = 2;
                }
            }

            for (int i = startX; i <=endX; i++) {
                if (map[i][startY] != 2) {
                    map[i][startY] = 1;
                }
                if (map[i][endY] != 2) {
                    map[i][endY] = 1;
                }
            }

            for (int i = startY; i <= endY; i++) {
                if (map[startX][i] != 2) {
                    map[startX][i] = 1;
                }
                if (map[endX][i] != 2) {
                    map[endX][i] = 1;
                }
            }
        }
    }
}
