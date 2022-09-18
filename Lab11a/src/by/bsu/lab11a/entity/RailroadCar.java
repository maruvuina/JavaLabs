package by.bsu.lab11a.entity;

import java.util.Objects;

public class RailroadCar {

    private int idRailroadCar;

    private TypeRailroadCar typeCar;

    private int mass;

    private int loadCapacity;

    public RailroadCar() {}

    public RailroadCar(int idRailroadCar, TypeRailroadCar typeCar, int mass, int loadCapacity) {
        this.idRailroadCar = idRailroadCar;
        this.typeCar = typeCar;
        this.mass = mass;
        this.loadCapacity = loadCapacity;
    }

    public int getIdRailroadCar() {
        return idRailroadCar;
    }

    public void setIdRailroadCar(int idRailroadCar) {
        this.idRailroadCar = idRailroadCar;
    }

    public TypeRailroadCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeRailroadCar typeCar) {
        this.typeCar = typeCar;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RailroadCar)) return false;
        RailroadCar that = (RailroadCar) o;
        return getIdRailroadCar() == that.getIdRailroadCar() &&
                getMass() == that.getMass() &&
                getLoadCapacity() == that.getLoadCapacity() &&
                getTypeCar() == that.getTypeCar();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRailroadCar(), getTypeCar(), getMass(), getLoadCapacity());
    }

    @Override
    public String toString() {
        return "RailroadCar{" +
                "idRailroadCar=" + idRailroadCar +
                ", typeCar=" + typeCar +
                ", mass=" + mass +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}
