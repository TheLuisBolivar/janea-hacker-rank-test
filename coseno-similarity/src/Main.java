import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> a_keys = List.of(2, 4, 5, 8);
        List<Double> a_values = List.of(7D, 5D, 12D, 1D);

        List<Integer> b_keys = List.of(1, 3, 7, 8,  9, 13);
        List<Double> b_values = List.of(2D, 3D, 5D, 5D, 10D, 2D);

        System.out.printf(String.valueOf(cosine_similarity(a_keys, a_values, b_keys, b_values)));
    }

    /**
     * The main method, here distribute the parts of formula.
     * @param a_keys  indexes of a
     * @param a_values  values of a
     * @param b_keys indexes of b
     * @param b_values values of b
     * @return double, that is a cosine_similarity value
     */
    public static double cosine_similarity(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values) {
        double dot = gerDot(a_keys, a_values, b_keys, b_values);
        double magA = getMag(a_keys, a_values);
        double magB = getMag(b_keys, b_values);
        return dot / ((Math.sqrt(magA)) * (Math.sqrt(magB)));
    }

    // With this method

    /**
     *
     * @param keys are the indexes about the values
     * @param values values of vector.
     * @return double thar is the sum of pow of the vector values
     */
    public static double getMag(List<Integer> keys, List<Double> values){
        double result = 0D;
        for(int i = 0; i < keys.size(); i++) {
            result += Math.pow(values.get(i), 2);
        }

        return result;
    }

    /**
     * Here I created a other List, for storage all results, with this I make sure that the O notation is n: 0(n)
     * @param a_keys  indexes of a
     * @param a_values  values of a
     * @param b_keys indexes of b
     * @param b_values values of b
     * @return double, that is a cosine_similarity value
     */
    public static double gerDot(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values){
        double result = 0D;
        List<Integer> res_keys = new ArrayList<>();
        List<Double> res_values = new ArrayList<>();
        checkVector(a_keys, a_values, res_keys, res_values, b_keys, b_values); // iterate a, and check b values.
        checkVector(b_keys, b_values, res_keys, res_values, a_keys, a_values); // iterate b, and check a values

        for (int i = 0; i < res_keys.size(); i++) {
            result += res_values.get(i);
        }

        return result;
    }

    /**
     * With this method, only iterate in the keys, that are the base to compare with the other one vector.
     * Add the result of operation in other aux vector, with this I make sure that the O(n)
     * @param keys base keys
     * @param values base values
     * @param res_keys result keys
     * @param res_values result values
     * @param check_keys keys to check respect with base keys
     * @param check_values values to check respect with base keys
     */
    public static void checkVector(List<Integer> keys, List<Double> values, List<Integer> res_keys, List<Double> res_values, List<Integer> check_keys, List<Double> check_values){
        for(int i = 0; i < keys.size(); i++) {
            double val = values.get(i);
            double valCheck = check_keys.contains(keys.get(i)) ? check_values.get(i) : 0;
            res_keys.add(keys.get(i));
            res_values.add(val * valCheck);
        }
    }
}