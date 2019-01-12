public class King {
    private int nbPlayer_;
    private Domino location_;

    public King(int player) {
        nbPlayer_ = player;
        location_ = null;
    }

    public Domino getLocation() {
        return location_;
    }

    public void setLocation(Domino location) {
        this.location_ = location;
        if (location_ != null)
            location.setLinkedKing(this);
    }

    public int getNbPlayer() {
        return nbPlayer_;
    }
}
