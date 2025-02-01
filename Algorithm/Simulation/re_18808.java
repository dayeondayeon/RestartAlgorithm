package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class re_18808 {
    private static int row, col;
    private static int[][] map;
    private static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapRow = Integer.parseInt(st.nextToken());
        int mapCol = Integer.parseInt(st.nextToken());
        int stickerCount = Integer.parseInt(st.nextToken());
        map = new int[mapRow][mapCol];

        for (int i = 0; i < stickerCount; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            sticker = new int[row][col];

            for (int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                boolean canPaste = false;
                for (int x = 0; x <= mapRow- row; x++) {
                    if (canPaste)
                        break;
                    for (int y = 0; y <= mapCol - col; y++) {
                        if (canAttachSticker(x, y)) {
                            canPaste = true;
                            break;
                        }
                    }
                }
                if (canPaste) {
                    break;
                }
                rotateSticker();
            }
        }

        int answer = 0;
        for (int i = 0; i < mapRow; i++) {
            for (int j = 0; j < mapCol; j++) {
                answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void rotateSticker() {
        int[][] rotated = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotated[j][row-1-i] = sticker[i][j];
            }
        }

        int temp = row;
        row = col;
        col = temp;
        sticker = rotated;
    }

    private static boolean canAttachSticker(int x, int y) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[x + i][y + j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sticker[i][j] == 1) {
                    map[x+i][y+j] = 1;
                }
            }
        }
        return true;
    }
}
