package ch07.poker;

public class BlackjackCard extends Card {
    @Override
    public int getPoints() {
        if (this.getPoint()==Point.ACE) {
            return 1;
        } else if (this.getPoint()==Point.JACK || this.getPoint()==Point.QUEEN || this.getPoint()==Point.KING) {
            return 10;
        } else {

        }

        return 0;
    }
}
