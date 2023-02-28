package Homework5;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {


        int[][] map = createMap();
        System.out.println(printColorMap(map));
        Point startPoint = new Point(8, 4, 1);
        Point endPoint = new Point(12, 12, -3);
        int[][] map2 = searchWave(map, startPoint, endPoint);
        System.out.println(printMap(map2));
        int[][] way = getWay(map2, startPoint, endPoint);
        System.out.println(printMap(way));
    }

    public static int[][] createMap() {
        int[][] map = new int[][]{
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1},
                {-1, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 01, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, -1, -1, -3, -1, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, -1, -1, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };


//        int[][] map = {{-1, -1, -1, -1, -1, -1},
//                {-1, 00, 00, 00, 00, -1},
//                {-1, 00, 1, 00, 00, -1},
//                {-1, 00, 00, 00, 00, -1},
//                {-1, -1, -1, -1, -1, -1}};
        return map;
    }

    public static String printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(String.format("%3d", map[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printColorMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case -3 -> sb.append(String.format("%3s ", "😍"));
                    case -2 -> sb.append(String.format("%3s", "+++"));
                    case -1 -> sb.append(String.format("%3s ", "@@@"));
                    case 0 -> sb.append(String.format("%3s ", "  "));
                    case 1 -> sb.append(String.format("%3s ", "😀"));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static int[][] searchWave(int[][] map, Point startPoint, Point endPoint) {
        int[][] mapWave = map;
        Queue<Point> queue = new LinkedList();
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (isExit(map, endPoint, poll)) break;
            if (map[poll.x - 1][poll.y] == 0) {
                map[poll.x - 1][poll.y] = poll.val + 1;
                queue.add(new Point(poll.x - 1, poll.y, poll.val + 1));
            }
            if (map[poll.x][poll.y + 1] == 0) {
                map[poll.x][poll.y + 1] = poll.val + 1;
                queue.add(new Point(poll.x, poll.y + 1, poll.val + 1));
            }
            if (map[poll.x + 1][poll.y] == 0) {
                map[poll.x + 1][poll.y] = poll.val + 1;
                queue.add(new Point(poll.x + 1, poll.y, poll.val + 1));
            }
            if (map[poll.x][poll.y - 1] == 0) {
                map[poll.x][poll.y - 1] = poll.val + 1;
                queue.add(new Point(poll.x, poll.y - 1, poll.val + 1));
            }

        }
        return mapWave;
    }

    private static boolean isExit(int[][] map, Point endPoint, Point currentPoint) {
        if (map[currentPoint.x - 1][currentPoint.y] == endPoint.val) {
            return true;
        } else if (map[currentPoint.x][currentPoint.y + 1] == endPoint.val) {
            return true;
        } else if (map[currentPoint.x + 1][currentPoint.y] == endPoint.val) {
            return true;
        } else if (map[currentPoint.x][currentPoint.y - 1] == endPoint.val) {
            return true;
        }
        return false;
    }

    public static int[][] getWay(int[][] map, Point startPoint, Point endPoint) {
        int startWay = getStartWay(map[endPoint.x + 1][endPoint.y],
                map[endPoint.x][endPoint.y - 1],
                map[endPoint.x - 1][endPoint.y],
                map[endPoint.x][endPoint.y + 1]);

        while (startWay > 1) {
            if (map[endPoint.x + 1][endPoint.y] == startWay) {
                map[endPoint.x + 1][endPoint.y] = -2;
                endPoint.x++;
                startWay--;
            } else if (map[endPoint.x][endPoint.y - 1] == startWay) {
                map[endPoint.x][endPoint.y - 1] = -2;
                endPoint.y--;
                startWay--;
            } else if (map[endPoint.x - 1][endPoint.y] == startWay) {
                map[endPoint.x - 1][endPoint.y] = -2;
                endPoint.x--;
                startWay--;
            } else if (map[endPoint.x][endPoint.y + 1] == startWay) {
                map[endPoint.x][endPoint.y + 1] = -2;
                endPoint.y++;
                startWay--;
            }
        }
        return map;
    }

    public static int getStartWay(int d, int l, int u, int r) {
        return Math.max(Math.max(d, l), Math.max(r, u));
    }

    static class Point {
        int x, y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }


}
