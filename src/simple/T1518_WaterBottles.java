package simple;

public class T1518_WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numWaterBottles(numBottles, 0, numExchange);
    }

    public int numWaterBottles(int numBottles, int emptyNumBottles, int numExchange) {
        if (numBottles + emptyNumBottles < numExchange) {
            return numBottles;
        }
        return numBottles + numWaterBottles((numBottles + emptyNumBottles) / numExchange, (numBottles + emptyNumBottles) % numExchange, numExchange);
    }
}
