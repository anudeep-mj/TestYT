package challenges;


//str: pebmmsv avrwvlbeg ce vv wvlb
//        str: lincekrbv r
//        str: eg jat kavr
//        str: jatzhce ekhevrhm svdh hceuae
//        str: ytnijbtcgs zhc m b krbvvvy
//        str: xhlin vv ncekrb jatz wffacn noa facntzw
//        str: jueg  aekh qpc incekrb khevr gz cpgju vdhgnoa h gzdcxhl

public class CamelCase {
    public static String camelCase(String str) {
        if (str.length() < 1) {
            return "";
        }
        String[] strings = str.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.length() > 0) {
                stringBuilder.append(string.substring(0, 1).toUpperCase() + string.substring(1));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        camelCase("ab  c");
    }

}
