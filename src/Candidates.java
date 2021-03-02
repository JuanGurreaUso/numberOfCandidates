import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Candidates {

    private File file;
    private Map<String, String> map;
    private Set<String> keySet;
    private List<String> keyList;
    private List<Integer> valueList;
    private List<PairCandidates> pairCandidates;

    public Candidates() {
        map = new HashMap<>();
        keySet = new HashSet<>();
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
        pairCandidates = new ArrayList<>();
    }

    public void readAndStoreFile(File file) throws IOException {

        String s;
        this.file = file;
        BufferedReader in = null;
        String[] values;

        try {
            in = new BufferedReader(new FileReader(file));

            s = in.readLine();

            while ((s = in.readLine()) != null) {
                values = s.split(",");
                map.put(values[1], values[6]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void removeDuplicates() {

        keySet.addAll(map.values());
        keyList.addAll(keySet);
        Collections.sort(keyList);
    }

    public void countCandidates() {
        int count;

        // WOW, discovered frequency method, it's crazy!
        for (String key: keyList) {
            count = Collections.frequency(map.values(), key);
            valueList.add(count);
        }
    }

    public void pairAndSortInList() {
        pairCandidates = new ArrayList<>();
        for (int i = 0; i < keyList.size(); i++) {
            pairCandidates.add(new PairCandidates(keyList.get(i), valueList.get(i)));
        }
        Collections.sort(pairCandidates);
    }

    public void printResults() {
        for (PairCandidates value: pairCandidates) {
            System.out.println(value);
        }
    }
}
