package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Traingle_2 {
    public static void main(String[] args) {
        List<Integer> res = pascalTraingle2(3);
        System.out.println(res);
    }
    private static List<Integer> pascalTraingle2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
