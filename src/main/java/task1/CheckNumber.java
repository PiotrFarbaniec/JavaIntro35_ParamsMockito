package task1;

public class CheckNumber {

    static boolean isEvenNumber (int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }


    static int addSingleNumbersOfValue(int value) {
        String toText = Integer.toString(value);
        String[] valArray = new String[toText.length()];
        int sum = 0;

        for (int i = 0; i < toText.length(); i++) {
            valArray[i] = String.valueOf(toText.charAt(i));
            sum += Integer.decode(valArray[i]);
        }
        return sum;
    }
}