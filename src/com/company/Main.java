package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String[]> dictionaryM = new HashMap<>();

        dictionaryM.put("ужас", new String[]{"жуть", "кошмар", "мрак", "страх", "мандраж"});
        dictionaryM.put("ложь", new String[]{"неправда", "вранье","лганье", "обман", "заблуждение", "дезинформация", "вымысел", "жульничество"});
        dictionaryM.put("прекрасный", new String[]{"красивый","благовидный", "благолепный", "благообразный", "великолепный",
                "взрачный", "видный", "живописный", "изящный", "казистый", "картинный", "миловидный"});
        dictionaryM.put("песня", new String[]{"песенка", "песнопения", "песнь", "ода", "рапсодия", "романс", "ария"});
        dictionaryM.put("разум", new String[]{"ум", "рассудительность", "рассудок", "сметка", "интеллект",  "разумение", "трезвость"});


        Set<String> setKey = dictionaryM.keySet();
        List<String> arrayListOfSynonyms = new ArrayList<>();
        Map<String, String[]> dictionary = new HashMap<>();

        for (String key : setKey) {
            Collections.addAll(arrayListOfSynonyms, dictionaryM.get(key));
            for (int i = 0; i < arrayListOfSynonyms.size(); i++) {
                String newKey = arrayListOfSynonyms.get(i);
                arrayListOfSynonyms.remove(i);
                arrayListOfSynonyms.add(key);

                Object[] o = arrayListOfSynonyms.toArray();
                String[] s = new String[o.length];
                for (int j = 0; j < s.length - 1; j++) {
                    s[j] = (String) o[j];
                }

                dictionary.put(newKey, s);
                arrayListOfSynonyms.clear();
                Collections.addAll(arrayListOfSynonyms, dictionaryM.get(key));
            }
        }
        dictionary.putAll(dictionaryM);

        do {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println(" Введите слово , синоним к которому вам нужен : ");
            String[] strings = dictionaryM.get(scanner.nextLine());
            if (strings != null)
                System.out.println(strings[random.nextInt(strings.length - 1)]);
            else
                System.out.println(" Такого слова не существует , используйте другое ! ");

        } while (true);
    }
}







