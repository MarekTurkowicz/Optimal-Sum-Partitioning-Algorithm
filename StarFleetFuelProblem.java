import java.util.List;

public class StarFleetFuelProblem {

    private static final int maxFuelForSingleElement = 100;
    private CrystalCombination[][][] seenCrystals;

    public StarFleetFuelProblem() {
        seenCrystals = new CrystalCombination[maxFuelForSingleElement + 1]
                [maxFuelForSingleElement + 1][maxFuelForSingleElement + 1];
    }

    public CrystalCombination findOptimalFuelAmount(List<Crystal> crystals) {
        return findOptimal(crystals, 0, 0, 0, 0, crystals.size());
    }

    private CrystalCombination findOptimal(List<Crystal> crystals, int index, int sumX, int sumY, int sumZ, int n) {
        if (sumX > maxFuelForSingleElement || sumY > maxFuelForSingleElement || sumZ > maxFuelForSingleElement) {
            return new CrystalCombination(0, 0);
        }

        if (index == n) {
            if (sumX == sumY && sumY == sumZ && sumX != 0) {
                return new CrystalCombination(sumX * 3, 0);
            }
            return new CrystalCombination(0, 0);
        }

        if (seenCrystals[sumX][sumY][sumZ] != null) {
            return seenCrystals[sumX][sumY][sumZ];
        }

        Crystal currentCrystal = crystals.get(index);
        CrystalCombination includeCurrent = findOptimal(crystals, index + 1, sumX + currentCrystal.x,
                sumY + currentCrystal.y, sumZ + currentCrystal.z, n);
        CrystalCombination excludeCurrent = findOptimal(crystals, index + 1, sumX, sumY, sumZ, n);

        CrystalCombination bestCombination;
        if (includeCurrent.fuelAmount > excludeCurrent.fuelAmount ||
                (includeCurrent.fuelAmount == excludeCurrent.fuelAmount &&
                        includeCurrent.crystalCount < excludeCurrent.crystalCount)) {
            bestCombination = new CrystalCombination(includeCurrent.fuelAmount, includeCurrent.crystalCount + 1);
        } else {
            bestCombination = excludeCurrent;
        }

        seenCrystals[sumX][sumY][sumZ] = bestCombination;
        return bestCombination;
    }
}
