public class PairCandidates implements Comparable<PairCandidates> {

    private String country;
    private int frequency;

    public PairCandidates(String country, int frequency) {
        this.country = country;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(PairCandidates pair) {
        if (frequency < pair.frequency) {
            return -1;
        } else if (frequency > pair.frequency) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return country + " have " + frequency + " candidates";
    }
}
