package entity;

public class Rocket implements SpaceShip {

    int rocketCosts;
    int rocketWeight;
    int maxWeight;

    public int getRocketCosts() {
        return rocketCosts;
    }

    public void setRocketCosts(int rocketCosts) {
        this.rocketCosts = rocketCosts;
    }

    public int getCarriedWeight() {
        return carriedWeight;
    }

    public void setCarriedWeight(int carriedWeight) {
        this.carriedWeight = carriedWeight;
    }

    private int carriedWeight;

    @Override
    public String toString() {
        return "Rocket{" +
                "rocketWeight=" + rocketWeight +
                ", maxWeight=" + maxWeight +
                ", carriedWeight=" + carriedWeight +
                '}';
    }

    public boolean launch() {
        return false;
    }

    public boolean land() {
        return false;
    }

    public boolean canCarry(Item item) {
        if (this.maxWeight < this.rocketWeight + this.carriedWeight + item.getWeight()) {
            return false;
        }
        else{
            return true;
        }
    }

    public int carry(Item item) {
        return this.carriedWeight = this.carriedWeight + item.getWeight();
    }
}
