import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.util.Collection;
public class CrystalReader {
    public static int numberOfCrystals;

    public static List<Crystal> readCrystalsFromFile(String filePath) throws FileNotFoundException {
        List<Crystal> crystals = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));

        numberOfCrystals = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            crystals.add(new Crystal(x, y, z));
        }
        scanner.close();
        //Collections.reverse(crystals);
        return  crystals;
    }
    public static void printCrystals(List<Crystal> crystals) {
        for (Crystal crystal : crystals) {
            System.out.println(crystal.toString());
        }
    }
}