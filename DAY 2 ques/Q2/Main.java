package Q2;

abstract class DeliveryDrone{
    protected String droneID;

    public DeliveryDrone(String droneID){
        this.droneID = droneID;
    }

    public abstract void deliverPackage();
}

interface Airborne{
    abstract public void flyToDestination();
    
    default void requestAirTrafficClearance(){
        System.out.println("Air Traffic Clearance Granted. You may proceed.");
    }
}

interface GroundBased{
    abstract void navigateSidewalks();
}

class Quadcopter extends DeliveryDrone implements Airborne{
    public Quadcopter(String droneID){
        super(droneID);
    }

    @Override
    public void deliverPackage(){
        System.out.println("Quadcopter" + droneID + " delivering package");
    }

    @Override
    public void flyToDestination(){
        System.out.println("Quadcopter" + droneID + " flying to destination");
    }
}

class CityRover extends DeliveryDrone implements GroundBased{
    public CityRover(String droneID){
        super(droneID);
    }

    @Override
    public void deliverPackage(){
        System.out.println("CityRover" + droneID + " delivering package");
    }

    @Override 
    public void navigateSidewalks(){
        System.out.println("CityRover" + droneID + " navigating sidewalks");
    }
}

class HybridVTOL extends DeliveryDrone implements Airborne, GroundBased{
    public HybridVTOL(String droneID){
        super(droneID);
    }

    @Override
    public void deliverPackage(){
        System.out.println("HybridVTOL" + droneID + " delivering package");
    }

    @Override
    public void flyToDestination(){
        System.out.println("HybridVTOL" + droneID + " flying to destination");
    }

    @Override
    public void navigateSidewalks(){
        System.out.println("HybridVTOL" + droneID + " navigating sidewalks");
    }
}

public class Main {
    public static void main(String[] args) {

        Quadcopter q = new Quadcopter("Q11");
        q.requestAirTrafficClearance();
        q.flyToDestination();
        q.deliverPackage();

        System.out.println();

        CityRover c = new CityRover("C11");
        c.navigateSidewalks();
        c.deliverPackage();

        System.out.println();

        HybridVTOL h = new HybridVTOL("H11");
        h.requestAirTrafficClearance();
        h.flyToDestination();
        h.navigateSidewalks();
        h.deliverPackage();
    }
}
