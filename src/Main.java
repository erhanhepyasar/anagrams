import java.util.*;

/**
 * Anagram examples:
 * arc = car
 * dusty = study
 * peach = cheap
 * state = taste
 */

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<String> textSet = new HashSet<>();

    public static void main(String[] args) {
        featureOne();
        featureTwo();
    }

    private static void featureOne() {
        System.out.println("Feature #1: Enter texts to check if they are anagrams");
        System.out.print("How many times do you want to enter a pair of texts (enter a number): ");
        int entryCounter = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < entryCounter; i++) {
            System.out.println("\nEntry-" + (i + 1));
            System.out.print("Enter the first text: ");
            String str1 = sc.nextLine();
            System.out.print("Enter the second text: ");
            String str2 = sc.nextLine();

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            if (isAnagram(str1, str2)) {
                System.out.println(str1 + " and " + str2 + " are anagram.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagram.");
            }

            textSet.add(str1);
            textSet.add(str2);
        }
    }

    private static void featureTwo() {
        System.out.println("\n==============================================\n");
        System.out.println("Now we start Feature#2.");
        System.out.print("How many times do you want to play Feature#2 ? (enter a number): ");
        int entryCounter = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < entryCounter; i++) {
            System.out.println("\n==============================================\n");
            System.out.println("Play-" + (i + 1));
            System.out.println("Feature #2: Write one of the texts below you have entered in Feature#1 " +
                    "and I will provide you all anagrams of this text");
            System.out.println(textSet);
            final String str1 = sc.nextLine().toLowerCase();


            if (!textSet.contains(str1)) {
                System.out.println("Please enter a text from the list");
                continue;
            }

            List<String> anagramList = textSet.stream().filter(text -> !text.equals(str1) && isAnagram(text, str1)).toList();
            System.out.println("Anagrams: " + anagramList);
        }
    }


    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}