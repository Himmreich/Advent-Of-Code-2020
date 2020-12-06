package app.enigm;

import com.google.common.base.Strings;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class DayFour {

    private static final List<String> FIELDS = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static List<Map<String, String>> resolver(List<String> puzzle) {
        Map<String, String> passport = new HashMap<>();
        List<Map<String, String>> passports = new ArrayList<>();
        List<Map<String, String>> validPassports = new ArrayList<>();

        for (String line : puzzle) {
            if(Strings.isNullOrEmpty(line)) {
                passports.add(passport);
                passport = new HashMap<>();
            } else {
                String[] datas = line.split(" ");
                for (int i = 0; i < datas.length; i++){
                    String[] element = datas[i].split(":");
                    passport.put(element[0], element[1]);
                }
            }
        }
        passports.add(passport);
        int nbValidPassports = 0;
        for(Map<String, String> currentPassport : passports){
            boolean isValid = true;
            for(String field : FIELDS) {
                if(!currentPassport.containsKey(field)) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) validPassports.add(currentPassport);
        }
        return validPassports;
    }

    /**
     *
     byr (Birth Year) - four digits; at least 1920 and at most 2002.
     iyr (Issue Year) - four digits; at least 2010 and at most 2020.
     eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
     hgt (Height) - a number followed by either cm or in:
     If cm, the number must be at least 150 and at most 193.
     If in, the number must be at least 59 and at most 76.
     hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
     ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
     pid (Passport ID) - a nine-digit number, including leading zeroes.
     cid (Country ID) - ignored, missing or not.

     * @param passport
     * @return
     */
    public static Boolean checkPassportDatas(Map<String, String> passport) {
        Boolean isValid = false;

        if(NumberUtils.isDigits(passport.get("byr")) &&
                Integer.parseInt(passport.get("byr")) >= 1920 &&
                Integer.parseInt(passport.get("byr")) <= 2002) {
            isValid = true;
        } else
            return false;

        if(NumberUtils.isDigits(passport.get("iyr")) &&
                Integer.parseInt(passport.get("iyr")) >= 2010 &&
                Integer.parseInt(passport.get("iyr")) <= 2020) {
            isValid = true;
        } else
            return false;

        if(NumberUtils.isDigits(passport.get("eyr")) &&
                Integer.parseInt(passport.get("eyr")) >= 2020 &&
                Integer.parseInt(passport.get("eyr")) <= 2030) {
            isValid = true;
        } else
            return false;

        if(passport.get("hgt").contains("cm") || passport.get("hgt").contains("in")) {
            if(passport.get("hgt").contains("cm")) {
                String hgt = passport.get("hgt").substring(0, passport.get("hgt").indexOf("cm"));
                if(NumberUtils.isDigits(hgt) && Integer.parseInt(hgt) >= 150 && Integer.parseInt(hgt) <= 193) {
                    isValid = true;
                } else
                    return false;
            } else {
                String hgt = passport.get("hgt").substring(0, passport.get("hgt").indexOf("in"));
                if(NumberUtils.isDigits(hgt) && Integer.parseInt(hgt) >= 59 && Integer.parseInt(hgt) <= 76) {
                    isValid = true;
                } else
                    return false;
            }
        } else
            return false;

        if(passport.get("hcl").startsWith("#") && passport.get("hcl").substring(1).length() == 6){
            for (int i = 0; i < passport.get("hcl").substring(1).length(); i++) {
                if(passport.get("hcl").substring(1).charAt(i) == '0' ||
                        passport.get("hcl").substring(1).charAt(i) == '1' ||
                        passport.get("hcl").substring(1).charAt(i) == '2' ||
                        passport.get("hcl").substring(1).charAt(i) == '3' ||
                        passport.get("hcl").substring(1).charAt(i) == '4' ||
                        passport.get("hcl").substring(1).charAt(i) == '5' ||
                        passport.get("hcl").substring(1).charAt(i) == '6' ||
                        passport.get("hcl").substring(1).charAt(i) == '7' ||
                        passport.get("hcl").substring(1).charAt(i) == '8' ||
                        passport.get("hcl").substring(1).charAt(i) == '9' ||
                        passport.get("hcl").substring(1).charAt(i) == 'a' ||
                        passport.get("hcl").substring(1).charAt(i) == 'b' ||
                        passport.get("hcl").substring(1).charAt(i) == 'c' ||
                        passport.get("hcl").substring(1).charAt(i) == 'd' ||
                        passport.get("hcl").substring(1).charAt(i) == 'e' ||
                        passport.get("hcl").substring(1).charAt(i) == 'f'){
                    isValid = true;
                } else
                    return false;
            }
        } else
            return false;

        //amb blu brn gry grn hzl oth
        if(passport.get("ecl").compareTo("amb") == 0 ||
                passport.get("ecl").compareTo("blu") == 0 ||
                passport.get("ecl").compareTo("brn") == 0 ||
                passport.get("ecl").compareTo("gry") == 0 ||
                passport.get("ecl").compareTo("grn") == 0 ||
                passport.get("ecl").compareTo("hzl") == 0 ||
                passport.get("ecl").compareTo("oth") == 0)
            isValid = true;
        else
            return false;

        if(passport.get("pid").length() == 9 && NumberUtils.isDigits(passport.get("pid")))
            isValid = true;
        else
            return false;
        return isValid;
    }
}
