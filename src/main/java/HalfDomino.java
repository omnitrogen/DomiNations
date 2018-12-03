import java.awt.*;

public class HalfDomino extends Domino {
    private int nbCrowns_;
    private TerrainType terrain_;

    public HalfDomino()
    {

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

            return null;
        }

        public String getName() {
            return name_;
        }

        public Color getColor() {
            return color_;
        }
    }
}
