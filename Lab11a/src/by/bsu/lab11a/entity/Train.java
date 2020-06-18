package by.bsu.lab11a.entity;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Train {
    private int idTrain;
    private List<RailroadCar> railRoadCar;
    ExecutorService executor = Executors.newFixedThreadPool(2);
    ReentrantLock lock = new ReentrantLock();

    public Train() {}

    public Train(int idTrain, List<RailroadCar> railRoadCar) {
        this.idTrain = idTrain;
        this.railRoadCar = railRoadCar;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public List<RailroadCar> getRailRoadCar() {
        return railRoadCar;
    }

    public void setRailRoadCar(List<RailroadCar> railRoadCar) {
        this.railRoadCar = railRoadCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return getIdTrain() == train.getIdTrain() &&
                getRailRoadCar().equals(train.getRailRoadCar()) &&
                executor.equals(train.executor) &&
                lock.equals(train.lock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTrain(), getRailRoadCar(), executor, lock);
    }

    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", railRoadCar=" + railRoadCar +
                '}';
    }
}
