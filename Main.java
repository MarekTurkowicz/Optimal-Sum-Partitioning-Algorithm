import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Crystal> crystals = CrystalReader.readCrystalsFromFile("krzyznadroge");
            long startTime = System.nanoTime();
            StarFleetFuelProblem problemSolver = new StarFleetFuelProblem();
            CrystalCombination result = problemSolver.findOptimalFuelAmount(crystals);
            long endTime = System.nanoTime();
            if (result.fuelAmount == 0) {
                System.out.println("NIE");
            } else {
                System.out.println("Maksymalna ilość paliwa: " + result.fuelAmount);
                System.out.println("Minimalna liczba kryształów: " + result.crystalCount);
            }
            long durationInNano = (endTime - startTime);  // Czas trwania w nanosekundach
            System.out.println("Czas wykonania w nanosekundach: " + durationInNano + " ns");
            long durationInMillis = (endTime - startTime) / 1_000_000;  // Czas trwania w milisekundach
            System.out.println("Czas wykonania w milisekundach: " + durationInMillis + " ms");
            ResultWriter.writeResult("out.txt", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

