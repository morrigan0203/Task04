import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> fNames = new ArrayList<>();
        List<String> lNames = new ArrayList<>();
        List<String> mNames = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        Scanner nameScanner = new Scanner(System.in);
        Scanner ageScanner = new Scanner(System.in);
        //Start of input data
        boolean stopInput = false;
        while (!stopInput) {
            System.out.println("Enter please name (LastName FirstName MiddleName) :");
            String fio = nameScanner.nextLine();
            System.out.println("Enter please age :");
            ages.add(ageScanner.nextInt());
            String[] fioArr = fio.split(" ");
            lNames.add(fioArr[0]);
            if (fioArr.length == 3) {
                fNames.add(fioArr[1]);
                mNames.add(fioArr[2]);
            } else if (fioArr.length == 2) {
                fNames.add(fioArr[1]);
                mNames.add("");
            } else {
                fNames.add("");
                mNames.add("");
            }
            indexes.add(fNames.size()-1);
            System.out.println("Do you want to add one more? Y/N");
            String yesNo = new Scanner(System.in).nextLine();
            if (yesNo.equalsIgnoreCase("N")) {
                stopInput = true;
            }
        }
        //End of input data
        //Start of sorting
        int lastIndex = indexes.size() - 1;
        while (lastIndex > -1) {
            int max_age = ages.get(indexes.get(lastIndex));
            int index = lastIndex;
            for (int i = 0; i < lastIndex; i++) {
                if (max_age < ages.get(indexes.get(i))) {
                    max_age = ages.get(indexes.get(i));
                    index = i;
                }
            }

            int tmp = indexes.get(lastIndex);
            indexes.set(lastIndex, indexes.get(index));
            indexes.set(index, tmp);
            lastIndex--;
        }
        //End of sorting
        //Output
        indexes.forEach(n ->
                System.out.println(
                        (fNames.get(n).length() > 0 ? fNames.get(n) + " " : "") +
                        lNames.get(n) + " " +
                        (mNames.get(n).length() > 0 ? mNames.get(n) + " " : "") +
                        ages.get(n)));
    }
}