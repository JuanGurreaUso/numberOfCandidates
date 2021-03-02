import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {

        Candidates candidates = new Candidates();

        try {
            candidates.readAndStoreFile(new File("Colfuturo-Seleccionados.csv"));
            candidates.removeDuplicates();
            candidates.countCandidates();
            candidates.pairAndSortInList();
            candidates.printResults();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
