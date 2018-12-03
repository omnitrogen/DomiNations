import java.awt.*;

public class HalfDomino {
    private int nbCrowns_;
    private TerrainType terrain_;

    public HalfDomino(int nbCrowns, String type)
    {
        nbCrowns_ = nbCrowns;
        terrain_ = TerrainType.fromName(type);
    }

    public int getNbCrowns() {
        return nbCrowns_;
    }

    public void setNbCrowns(int nbCrowns_) {
        this.nbCrowns_ = nbCrowns_;
    }

    public TerrainType getTerrain() {
        return terrain_;
    }

    public void setTerrain(TerrainType terrain_) {
        this.terrain_ = terrain_;
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

        private final String type_;
        private final Color color_;

        TerrainType(String type, Color color)
        {
            type_ = type;
            color_ = color;
        }

        public static TerrainType fromName(String name)
        {
            switch (name)
            {
                case "Champs":
                    return TerrainType.FIELDS;
                case "Foret":
                    return TerrainType.FOREST;
                case "Prairie":
                    return TerrainType.MEADOW;
                case "Mine":
                    return TerrainType.MINE;
                case "Montagne":
                    return TerrainType.MOUNTAIN;
                case "Mer":
                    return TerrainType.SEA;
                case "Chateau":
                    return TerrainType.CASTLE;
                default:
                    return null;
            }
        }

        public String getType() {
            return type_;
        }

        public Color getColor() {
            return color_;
        }
    }
}
