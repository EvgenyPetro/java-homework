package Homework6;

import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgoritm {

    public int[][] searchWave(int[][] map, Point startPoint, Point endPoint) {
        int[][] mapWave = map;
        Queue<Point> queue = new LinkedList();
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (isExit(map, endPoint, poll)) break;
            if (map[poll.getX() - 1][poll.getY()] == 0) {
                map[poll.getX() - 1][poll.getY()] = poll.getVal() + 1;
                queue.add(new Point(poll.getX() - 1, poll.getY(), poll.getVal() + 1));
            }
            if (map[poll.getX()][poll.getY() + 1] == 0) {
                map[poll.getX()][poll.getY() + 1] = poll.getVal() + 1;
                queue.add(new Point(poll.getX(), poll.getY() + 1, poll.getVal() + 1));
            }
            if (map[poll.getX() + 1][poll.getY()] == 0) {
                map[poll.getX() + 1][poll.getY()] = poll.getVal() + 1;
                queue.add(new Point(poll.getX() + 1, poll.getY(), poll.getVal() + 1));
            }
            if (map[poll.getX()][poll.getY() - 1] == 0) {
                map[poll.getX()][poll.getY() - 1] = poll.getVal() + 1;
                queue.add(new Point(poll.getX(), poll.getY() - 1, poll.getVal() + 1));
            }

        }
        return getWay(mapWave, startPoint, endPoint);
    }

    private boolean isExit(int[][] map, Point endPoint, Point currentPoint) {
        if (map[currentPoint.getX() - 1][currentPoint.getY()] == endPoint.getVal()) {
            return true;
        } else if (map[currentPoint.getX()][currentPoint.getY() + 1] == endPoint.getVal()) {
            return true;
        } else if (map[currentPoint.getX() + 1][currentPoint.getY()] == endPoint.getVal()) {
            return true;
        } else if (map[currentPoint.getX()][currentPoint.getY() - 1] == endPoint.getVal()) {
            return true;
        }
        return false;
    }

    private int[][] getWay(int[][] map, Point startPoint, Point endPoint) {
        int startWay = getStartWay(map[endPoint.getX() + 1][endPoint.getY()],
                map[endPoint.getX()][endPoint.getY() - 1],
                map[endPoint.getX() - 1][endPoint.getY()],
                map[endPoint.getX()][endPoint.getY() + 1]);


        while (startWay > 1) {
            if (map[endPoint.getX() + 1][endPoint.getY()] == startWay) {
                map[endPoint.getX() + 1][endPoint.getY()] = -2;
                endPoint.setX(endPoint.getX() + 1);
                startWay--;
            } else if (map[endPoint.getX()][endPoint.getY() - 1] == startWay) {
                map[endPoint.getX()][endPoint.getY() - 1] = -2;
                endPoint.setY(endPoint.getY() - 1);
                startWay--;
            } else if (map[endPoint.getX() - 1][endPoint.getY()] == startWay) {
                map[endPoint.getX() - 1][endPoint.getY()] = -2;
                endPoint.setX(endPoint.getX() - 1);
                startWay--;
            } else if (map[endPoint.getX()][endPoint.getY() + 1] == startWay) {
                map[endPoint.getX()][endPoint.getY() + 1] = -2;
                endPoint.setY(endPoint.getY() + 1);
                startWay--;
            }
        }
        return map;
    }

    private int getStartWay(int d, int l, int u, int r) {
        return Math.max(Math.max(d, l), Math.max(r, u));
    }

}