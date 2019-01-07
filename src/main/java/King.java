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
        location.setLinkedKing(this);
    }
}
