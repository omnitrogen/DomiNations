import java.awt.*;

public class Domino {
    private int number_;
    private TerrainType leftTerrain_;
    private TerrainType rightTerrain_;
    private int leftCrowns_;
    private int rightCrowns_;

    public Domino()
    {

    }

    public int getNumber() {
        return number_;
    }

    public void setNumber(int number_) {
        this.number_ = number_;
    }

    public TerrainType getLeftTerrain() {
        return leftTerrain_;
    }

    public void setLeftTerrain(TerrainType leftTerrain_) {
        this.leftTerrain_ = leftTerrain_;
    }

    public TerrainType getRightTerrain() {
        return rightTerrain_;
    }

    public void setRightTerrain(TerrainType rightTerrain_) {
        this.rightTerrain_ = rightTerrain_;
    }

    public int getLeftCrowns() {
        return leftCrowns_;
    }

    public void setLeftCrowns(int leftCrowns_) {
        this.leftCrowns_ = leftCrowns_;
    }

    public int getRightCrowns() {
        return rightCrowns_;
    }

    public void setRightCrowns(int rightCrowns_) {
        this.rightCrowns_ = rightCrowns_;
    }


    public enum TerrainType
    {
        FIELDS("Champs", Color.yellow),
        FOREST("Foret", Color.GREEN),
        MEADOW("Prairie", Color.green),
        MINE("Mine", Color.lightGray),
        MOUNTAIN("Montagne", Color.orange),
        SEA("Mer", Color.blue),
        CASTLE("Chateau", Color.white);

        private final String name_;
        private final Color color_;

        private TerrainType(String name, Color color)
        {
            name_ = name;
            color_ = color;
        }

        private TerrainType fromName(String name)
        {
            for (TerrainType type: TerrainType.values())
                if (type.getName() == name)
                    return type;
        }

        public String getName() {
            return name_;
        }

        public Color getColor() {
            return color_;
        }
    }
}
