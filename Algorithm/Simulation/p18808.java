package Simulation;

import java.io.*;
import java.util.*;
public class p18808 {
    private static int row, col;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int stickerCount = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        List<Sticker> stickers = new ArrayList<>(stickerCount);

        for (int i = 0; i < stickerCount; i++) {
            st = new StringTokenizer(br.readLine());
            int wide = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            int[][] pos = new int[wide][height];
            for (int w = 0; w < wide; w++) {
                st = new StringTokenizer(br.readLine());
                for (int h = 0; h < height; h++) {
                    pos[w][h] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(wide, height, pos));
        }

        for (int s = 0; s < stickerCount; s++) {
            // 붙일 수 있는지를 먼저 확인한 후에 회전시키니까 바깥쪽에 회전을 위한 for 루프가 존재
            for (int dir = 0; dir < 4; dir++) {
                boolean attached = false;
                for (int i = 0; i <= row - stickers.get(s).wide; i++) { // wide를 세로길이로 입력받아놔서 이렇게 사용함;
                    if (attached) {
                        break;
                    }
                    for (int j = 0; j <= col - stickers.get(s).height; j++) {
                        if (canAttachSticker(i, j, stickers.get(s))) {
                            attached = true;
                            break;
                        }

                    }
                }
                if (attached) {
                    break;
                }
                rotateStickerRight(stickers.get(s));
            }
        }

        System.out.println(stickerBlanks());
    }

    // 마지막으로 원본 배열에서 스티커가 붙은 칸의 개수를 센다.
    private static int stickerBlanks() {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean canAttachSticker(int startX, int startY, Sticker sticker) {
        for (int i = startX; i < startX + sticker.wide; i++) {
            for (int j = startY; j < startY + sticker.height; j++) {
                if (map[i][j] == 1 && sticker.pos[i-startX][j-startY] == 1) {
                    return false;
                }
            }
        }

        for (int i = startX; i < startX + sticker.wide; i++) {
            for (int j = startY; j < startY + sticker.height; j++) {
                if (sticker.pos[i-startX][j-startY] == 1) {
                    map[i][j] = 1;
                }
            }
        }
        return true;
    }

    private static void rotateStickerRight(Sticker sticker) {
        int originWide = sticker.wide;
        int originHeight = sticker.height;

        sticker.wide = originHeight;
        sticker.height = originWide;

        int[][] nPos = new int[sticker.wide][sticker.height];

        for (int i = 0; i < originWide; i++) {
            for (int j = 0; j < originHeight; j++) {
                nPos[j][originWide-i-1] = sticker.pos[i][j];
            }
        }

        sticker.pos = nPos;
    }

    private static class Sticker {
        int wide;
        int height;
        int[][] pos;
        Sticker (int wide, int height, int[][] pos) {
            this.wide = wide;
            this.height = height;
            this.pos = pos;
        }
    }
}
