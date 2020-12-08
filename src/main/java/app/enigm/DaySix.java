package app.enigm;

import com.google.common.base.Strings;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.list.SetUniqueList;

import java.util.*;

public class DaySix {

    public static Object resolverPartTwo(List<String> puzzle) {
        @Data
        @NoArgsConstructor
        class Group {
             int nbPerson = 0;
             Map<Character, Integer> responses = new HashMap<>();
         }

         List<Group> groups = new ArrayList<>();
         Group currentGroup = new Group();

        for (String line : puzzle) {
            if(Strings.isNullOrEmpty(line)) {
                groups.add(currentGroup);
                currentGroup = new Group();
            } else {
                currentGroup.nbPerson++;
                for(char character : line.toCharArray()) {
                    if(currentGroup.responses.containsKey(character)) {
                        currentGroup.responses.put(character, currentGroup.responses.get(character) + 1);
                    } else {
                        currentGroup.responses.put(character, 1);
                    }
                }
            }
        }
        groups.add(currentGroup);

        int result = 0;

        for(Group group : groups) {
            if(group.nbPerson == 1) {
                result = result + group.responses.size();
            } else {
                for (Map.Entry mapentry : group.responses.entrySet()) {
                    if((Integer)mapentry.getValue() == group.nbPerson){
                        result = result + 1;
                    }

                }

//                if(group.responses.containsValue(group.nbPerson)) {
//                    result = result + group.nbPerson;
//                }
            }
        }

        return result;
    }

    public static Object resolverPartOne(List<String> puzzle) {
        @Data
        @NoArgsConstructor
        class Group {
            int nbPerson = 0;
            List<Character> responses = SetUniqueList.setUniqueList(new ArrayList<>());
        }

        List<Group> groups = new ArrayList<>();
        Group currentGroup = new Group();

        for (String line : puzzle) {
            if(Strings.isNullOrEmpty(line)) {
                groups.add(currentGroup);
                currentGroup = new Group();
            } else {
                currentGroup.nbPerson++;
                for(char character : line.toCharArray()) {
                    currentGroup.responses.add(character);
                }
            }
        }
        groups.add(currentGroup);

        int result = 0;

        for(Group group : groups) {
            result = result + group.responses.size();
        }

        return result;
    }
}
