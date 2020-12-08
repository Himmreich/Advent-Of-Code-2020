package app.enigm;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


public class DaySeven {

    private static final String SHINY_GOLD = "shiny gold";

    @Data
    @NoArgsConstructor
    static class Rule {
        String color;
        Map<String, Integer> container = new HashMap<>();
        boolean isLeaf;
        boolean containsColor = false;
    }

    public static int resolverPartOne(List<String> puzzle) {
        int nbColors = 0;
        List<String> isGold = new ArrayList<>();
        List<String> isNotGold = new ArrayList<>();

        for (String line : puzzle){
            String firstColor = line.split(" contain ")[0].replace("bags", "").trim();
            if(firstColor.compareToIgnoreCase(SHINY_GOLD) == 0) {
                //nothing
            }
            if(!line.split(" contain ")[1].contains("no other bags")){
                String[] secondColors = line.split(" contain ")[1].split(",");
                for(String col : Arrays.asList(secondColors))
                    if(col.compareToIgnoreCase(SHINY_GOLD) == 0) isGold.add(col);
            }




        }
        return nbColors;
    }

    public static int resolverPartOne1(List<String> puzzle) {
        int numberBagColor = 0;

        Map<String, Rule> rules = new HashMap<>();

        for (String line : puzzle){
            Rule newRule = lineParser(line);
            rules.put(newRule.color, newRule);
        }

        for (Map.Entry rule : rules.entrySet()) {

        }

        return numberBagColor;
    }


    public static Rule lineParser(String line) {
        Rule rule = new Rule();
        //shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
        //dotted black bags contain no other bags.
        rule.color = line.split(" contain ")[0].replace("bags", "").trim();

        if(!line.split(" contain ")[1].contains("no other bags")){
            rule.isLeaf = false;
            String[] containers = line.split(" contain ")[1].split(",");
            for(String container : containers) {
                container = container.replace("bags", "").replace("bag", "").replace(".", "").trim();
                String containerColor = container.substring(container.indexOf(" ")).trim();
                if(containerColor == SHINY_GOLD)
                    rule.containsColor = true;
                Integer number = Integer.valueOf(container.substring(0, container.indexOf(" ")).trim());
                rule.container.putIfAbsent(containerColor, number);
            }
        } else rule.isLeaf = true;
        return rule;
    }

    public static Object resolverPartTwo(List<String> puzzle) {
        return null;
    }
}
