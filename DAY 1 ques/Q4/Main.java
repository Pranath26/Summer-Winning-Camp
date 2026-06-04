package Q4;

class HardwareLockException extends Exception {
    public HardwareLockException(String message) {
        super(message);
    }
}

class SensorCorruptionException extends RuntimeException {
    public SensorCorruptionException(String message) {
        super(message);
    }
}

class TelemetryStream implements AutoCloseable {

    public void readData() {
        System.out.println("Reading telemetry data...");
    }

    @Override
    public void close() {
        System.out.println("TelemetryStream closed safely.");
    }
}


public class Main {

    public static void parseTelemetry() throws HardwareLockException {

        try (TelemetryStream stream = new TelemetryStream()) {

            stream.readData();

            // Simulating sensor issues
            int temperature = 500;

            if (temperature > 100) {
                throw new SensorCorruptionException("Sensor reading invalid!");
            }

            // Simulating hardware issue
            boolean fileLocked = true;

            if (fileLocked) {
                throw new HardwareLockException("File is locked by OS!");
            }

            System.out.println("Telemetry processed successfully.");
        }
    }

        public static void main(String[] args) {

        try {
            parseTelemetry();
        }
        catch (HardwareLockException e) {
            System.out.println("FATAL ERROR: " + e.getMessage());
        }
        catch (SensorCorruptionException e) {
            System.out.println("WARNING: " + e.getMessage());
        }
    }
}
