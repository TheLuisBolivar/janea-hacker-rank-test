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

    public static double cosine_similarity(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values) {
        double dot = gerDot(a_keys, a_values, b_keys, b_values);
        double magA = getMag(a_keys, a_values);
        double magB = getMag(b_keys, b_values);
        return dot / ((Math.sqrt(magA)) * (Math.sqrt(magB)));
    }

    public static double getMag(List<Integer> keys, List<Double> values){
        double result = 0D;
        for(int i = 0; i < keys.size(); i++) {
            result += Math.pow(values.get(i), 2);
        }

        return result;
    }

    public static double gerDot(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values){
        double result = 0D;
        List<Integer> res_keys = new ArrayList<>();
        List<Double> res_values = new ArrayList<>();
        checkVector(a_keys, a_values, res_keys, res_values, b_keys, b_values);
        checkVector(b_keys, b_values, res_keys, res_values, a_keys, a_values);

        for (int i = 0; i < res_keys.size(); i++) {
            result += res_values.get(i);
        }

        return result;
    }

    public static void checkVector(List<Integer> keys, List<Double> values, List<Integer> res_keys, List<Double> res_values, List<Integer> check_keys, List<Double> check_values){
        for(int i = 0; i < keys.size(); i++) {
            double val = values.get(i);
            double valCheck = check_keys.contains(keys.get(i)) ? check_values.get(i) : 0;
            res_keys.add(keys.get(i));
            res_values.add(val * valCheck);
        }
    }
}