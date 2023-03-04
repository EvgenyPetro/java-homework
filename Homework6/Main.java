package Homework6;

public class Main {
    public static void main(String[] args) {
        MapGenerator mapGenerator = new MapGenerator();
        MapPrinter mapPrinter = new MapPrinter();
        WaveAlgoritm algoritm = new WaveAlgoritm();

        Point startPoint = new Point(15, 4, 1);
        Point endPoint = new Point(17, 17, -3);

        mapGenerator.addStartAndStop(startPoint, endPoint);

        String map = mapPrinter.printColorMap(mapGenerator.getMap());
        System.out.println(map);

        int[][] waveOnMap = algoritm.searchWave(mapGenerator.getMap(), startPoint, endPoint);

        System.out.println(mapPrinter.printColorMap(waveOnMap));
    }
}
