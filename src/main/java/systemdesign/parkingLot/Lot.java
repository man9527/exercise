package systemdesign.parkingLot;

abstract class Lot {
    private String id;
    private int level;
    private int row;
    private Size size;

    public Lot(String id, int level, int row, Size size) {
        this.id = id;
        this.level = level;
        this.row = row;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
