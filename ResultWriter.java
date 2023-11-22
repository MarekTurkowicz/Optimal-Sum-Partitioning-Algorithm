import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public static void writeResult(String filePath, CrystalCombination result) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(result.fuelAmount + " "+ result.crystalCount);
           }
    }
}