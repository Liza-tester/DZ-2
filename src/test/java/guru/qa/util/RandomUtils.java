package guru.qa.util;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class RandomUtils {

    //генератор случайной даты рождения

    public static LocalDate getRandomBirthday() {
        return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 100))));
    }

    //выбор случайного подмассива String[]

    public static ArrayList<String> getRandomSubArray(String[] array) {
        Random random = new Random();
        ArrayList<String> subArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (random.nextBoolean()) subArray.add(array[i]);
        }
        return subArray;
    }

    //выбор случайной пары  HashMap<String,String[]>

    public static String[] getMapRandomCouple(HashMap<String, String[]> map) {
        String randomKey = getSetRandomItem(map.keySet());
        String[] randomKeyValues = map.get(randomKey);
        String randomValue = randomKeyValues[new Random().nextInt(randomKeyValues.length)];
        return new String[]{randomKey, randomValue};
    }

    //выбор случайного значения Set<String>

    public static String getSetRandomItem(Set<String> set) {
        int randomItem = new Random().nextInt(set.size());
        int i = 0;
        for (Object obj : set) {
            if (i == randomItem)
                return obj.toString();
            i++;
        }
        return "";
    }

}


