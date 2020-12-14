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
    }

    public static int resolverPartOne(List<String> puzzle) {
        List<Rule> rules = new ArrayList<>();
        for(String line : puzzle){
            Rule rule = lineParser(line);
            rules.add(rule);
        }
        List<String> colorsNotConcerned = new ArrayList<>();
        List<String> colorsConcerned = new ArrayList<>();
        List<String> colorsNotDefined = new ArrayList<>();
       for(Rule rule : rules) {
           if(!rule.getColor().contains(SHINY_GOLD))
            colorsNotDefined.add(rule.getColor());
       }

        int i = 0;
        boolean stop = false;
        int nbColors = rules.size() - 1;
        do{
            Rule rule = rules.get(i);

            //Si ce n'est pas la couleur concernee
            if(rule.getColor().compareToIgnoreCase(SHINY_GOLD) != 0){
                //Cas couleur sans enfants
                if(rule.getContainer().isEmpty()){
                    if(!colorsNotConcerned.contains(rule.getColor())){
                        colorsNotConcerned.add(rule.getColor());
                        colorsNotDefined.remove(rule.getColor());
                    }
                }//On ne s'occupe que des enfants
                else{
                    int childsNotConcerned = 0;
                    //Pour chaque mouflet
                    for (Map.Entry child : rule.container.entrySet()) {
                        String childColor = (String) child.getKey();
                        if(!colorsNotConcerned.contains(childColor)){
                            //Si la couleur est une couleur concernee on ajoute le parent
                            if(colorsConcerned.contains(childColor)) {
                                if(!colorsConcerned.contains(rule.getColor())) {
                                    colorsConcerned.add(rule.getColor());
                                    colorsNotDefined.remove(rule.getColor());
                                }
                            }
                            //Si la couleur est shiny gold on ajoute a la liste
                            if(childColor.compareToIgnoreCase(SHINY_GOLD) == 0) {
                                if(!colorsConcerned.contains(rule.getColor())){
                                    colorsConcerned.add(rule.getColor());
                                    colorsNotDefined.remove(rule.getColor());
                                }
                            }
                        } else {
                            childsNotConcerned++;
                        }
                    }
                    if(childsNotConcerned == rule.container.size()) {
                        colorsNotConcerned.add(rule.getColor());
                        colorsNotDefined.remove(rule.getColor());
                    }
                }
            }

            i++;
            if(i == rules.size())
                i = 0;
            if(colorsConcerned.size() + colorsNotConcerned.size() == nbColors && colorsNotDefined.isEmpty())
                stop = true;
        }while (!stop);
        return colorsConcerned.size();
    }

    public static int resolverPartOne2(List<String> puzzle) {
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
            String[] containers = line.split(" contain ")[1].split(",");
            for(String container : containers) {
                container = container.replace("bags", "").replace("bag", "").replace(".", "").trim();
                String containerColor = container.substring(container.indexOf(" ")).trim();
                Integer number = Integer.valueOf(container.substring(0, container.indexOf(" ")).trim());
                rule.container.putIfAbsent(containerColor, number);
            }
        }
        return rule;
    }

    public static Object resolverPartTwo(List<String> puzzle) {
        return null;
    }
}
