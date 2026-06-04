package Q1;

abstract class SmartDevice{
    protected String deviceId;
    protected String deviceName;
    public SmartDevice(String deviceID, String deviceName){
        this.deviceId = deviceID;
        this.deviceName = deviceName;
    }

    public abstract void runDiagnostic();
}

interface BatteryOperated{
    int getBatteryLevel();
    void triggerRechargeAlert();
}

class SmartLight extends SmartDevice{
    public SmartLight(String deviceID, String deviceName){
        super(deviceID, deviceName);
    }

    @Override
    public void runDiagnostic(){
        System.out.println(deviceName + " Light diagnostic completed!!");
    }
}

class SmartCamera extends SmartDevice implements BatteryOperated{
    private int batterylevel;
    public SmartCamera(String deviceID, String deviceName, int batterylevel){
        super(deviceID, deviceName);
        this.batterylevel = batterylevel;
    }

    @Override
    public void runDiagnostic(){
        System.out.println(deviceName + " Light diagnostic completed!!");
    }

    @Override
    public int getBatteryLevel(){
        return batterylevel;
    }

    @Override
    public void triggerRechargeAlert(){
        System.out.println(deviceName + "Battery low! Recharge required.");
    }
}

class SmartLock extends SmartDevice implements BatteryOperated{
    private int batterylevel;
    public SmartLock(String deviceID, String deviceName, int batterylevel){
        super(deviceID, deviceName);
        this.batterylevel = batterylevel;
    }

    @Override
    public void runDiagnostic(){
        System.out.println(deviceName + " Light diagnostic completed!!");
    }

    @Override
    public int getBatteryLevel(){
        return batterylevel;
    }

    @Override
    public void triggerRechargeAlert(){
        System.out.println(deviceName + "Battery low! Recharge required.");
    }
}

class HomeHub{
    public void executeNightlyRoutine(SmartDevice[] devices){
        for(SmartDevice device : devices){
            device.runDiagnostic();

            if(device instanceof BatteryOperated){
                BatteryOperated batteryDevice = (BatteryOperated) device;

                if(batteryDevice.getBatteryLevel() < 20){
                    batteryDevice.triggerRechargeAlert();
                }
            }
        }
     }
}

public class Main {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("L101", "Living Room Light"),
            new SmartCamera("C101", "Front Door Camera", 15),
            new SmartLock("SL101", "Main Gate Lock", 50),
            new SmartCamera("C102", "Garage Camera", 10)
        };

        HomeHub hub = new HomeHub();
        hub.executeNightlyRoutine(devices);
    }
}
