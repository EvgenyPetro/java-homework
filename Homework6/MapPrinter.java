package Homework6;

public class MapPrinter {
    public String printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(String.format("%3d", map[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String printColorMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -3) {
                    sb.append(String.format("%3s ", "😍"));
                } else if (map[i][j] == -2) {
                    sb.append(String.format("%3s ", "==="));
                } else if (map[i][j] == -1) {
                    sb.append(String.format("%3s ", "###"));
                } else if (map[i][j] == 1) {
                    sb.append(String.format("%3s ", "😀"));
                } else {
                    sb.append(String.format("%3s ", "  "));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
