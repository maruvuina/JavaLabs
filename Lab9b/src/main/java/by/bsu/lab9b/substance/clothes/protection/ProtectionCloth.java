package by.bsu.lab9b.substance.clothes.protection;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;

public class ProtectionCloth extends Cloth {

    private static final long serialVersionUID = 2710318647714567932L;

    private transient boolean motoTurtle;

    private transient boolean backProtector;

    private transient boolean elbowPads;

    private transient boolean kneePads;

    public boolean isMotoTurtle() {
        return motoTurtle;
    }

    public void setMotoTurtle(boolean motoTurtle) {
        this.motoTurtle = motoTurtle;
    }

    public boolean isBackProtector() {
        return backProtector;
    }

    public void setBackProtector(boolean backProtector) {
        this.backProtector = backProtector;
    }

    public boolean isElbowPads() {
        return elbowPads;
    }

    public void setElbowPads(boolean elbowPads) {
        this.elbowPads = elbowPads;
    }

    public boolean isKneePads() {
        return kneePads;
    }

    public void setKneePads(boolean kneePads) {
        this.kneePads = kneePads;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nmotoTurtle: " + motoTurtle +
                "\nbackProtector: " + backProtector +
                "\nelbowPads: " + elbowPads +
                "\nkneePads: " + kneePads +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }
}
