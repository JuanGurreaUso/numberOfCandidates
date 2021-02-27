import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Candidates {

    private File file;
    private Map<String, String> map;
    private Map<String, Integer> resultMap;
    private Set<String> keySet;
    private List<String> keyList;
    private List<Integer> valueList;

    public Candidates() {
        map = new HashMap<>();
        resultMap = new HashMap<>();
        keySet = new HashSet<>();
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
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
        for(Map.Entry<String, String> value: map.entrySet()) {
            keySet.add(value.getValue());
        }

        keyList.addAll(keySet);
        Collections.sort(keyList);
    }

    public void countCandidates() {
        int count;

        for (String key: keyList) {
            count = 0;
            for (Map.Entry<String, String> value : map.entrySet()) {
                if (key.equals(value.getValue())) {
                    count++;
                }
            }
            valueList.add(count);
        }
    }

    public void pairInHashMap() {
        for (int i = 0; i < keyList.size(); i++) {
            resultMap.put(keyList.get(i), valueList.get(i));
        }
        Collections.sort(valueList);
    }

    // I made this program thinking only in sorting by numbers (like the exercise says),
    // and not in sorting alphabetically too when it has repeated numbers
    public void printResults() {
        List<String> temp = new ArrayList<>(keyList);

        System.out.println("Candidates list by countries, sorted by number: \n");
        for (Integer value: valueList) {
            for (Map.Entry<String, Integer> values : resultMap.entrySet()) {
                if (value.equals(values.getValue()) && temp.contains(values.getKey())) {
                    System.out.println(values.getValue() + " candidates for " + values.getKey());
                    temp.remove(values.getKey());
                }
            }
        }
    }
}
