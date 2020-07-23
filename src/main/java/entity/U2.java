package entity;

public class U2 extends Rocket {

    public U2(){
        this.rocketWeight = 18000;
        this.maxWeight = 29000;
        this.rocketCosts = 120;
    }

    @Override
    public boolean launch() {
        int randomNumber = (int) (Math.random()*100) + 1;
        int chanceToCrash = (4*getCarriedWeight()/(maxWeight-rocketWeight));

        if (chanceToCrash >= randomNumber) {
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public boolean land() {
        int randomNumber = (int) (Math.random()*100) + 1;
        int chanceToLand = (8*getCarriedWeight()/(maxWeight-rocketWeight));

        if (chanceToLand >= randomNumber) {
            return false;
        }
        else {
            return true;
        }
    }
}
