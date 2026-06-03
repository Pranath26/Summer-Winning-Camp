package Q2;

class PowerNode {

    byte sectorStates = 0; // all OFF initially

    public void turnOnSector(int sectorIndex) {
        sectorStates = (byte)(sectorStates | (1 << sectorIndex));
    }

    public void turnOffSector(int sectorIndex) {
        sectorStates = (byte)(sectorStates & ~(1 << sectorIndex));
    }

    public boolean isSectorOn(int sectorIndex) {
        return (sectorStates & (1 << sectorIndex)) != 0;
    }
}

public class Main {
    public static void main(String[] args) {

        PowerNode node = new PowerNode();

        node.turnOnSector(0);
        node.turnOnSector(3);
        node.turnOnSector(7);

        System.out.println(node.isSectorOn(3)); // true
        System.out.println(node.isSectorOn(2)); // false

        node.turnOffSector(3);

        System.out.println(node.isSectorOn(3)); // false
    }
}
