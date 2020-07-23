package entity;

public class U1 extends Rocket {

    public U1(){
        this.rocketWeight = 10000;
        this.maxWeight = 18000;
        this.rocketCosts = 100;
    }

    @Override
    public boolean launch() {
        int randomNumber = (int) (Math.random()*100) + 1;
        int chanceToCrash = 5*getCarriedWeight()/(this.maxWeight-this.rocketWeight);

        if (chanceToCrash >= randomNumber) {
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public boolean land() {
        int randomNumber = (int) (Math.random()*100)+ 1;
        int chanceToLand = (1*getCarriedWeight()/(this.maxWeight-this.rocketWeight));
        if (chanceToLand >= randomNumber) {
            return false;
        }
        else {
            return true;
        }
    }
}
