public class Airplane {
    private String model;
    private int capacity;
    private double maxSpeed;
    private int fuelCapacity;
    private boolean isFlying;

    public Airplane(String model, int capacity, double maxSpeed, int fuelCapacity) {
        this.model = model;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
        this.isFlying = false;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }
}
