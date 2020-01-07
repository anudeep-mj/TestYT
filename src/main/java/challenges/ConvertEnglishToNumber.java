package challenges;

import java.util.Arrays;
import java.util.List;

public class ConvertEnglishToNumber {
    public static int parseInt(String numStr) {
        int result = 0;
        int finalResult = 0;

        List<String> allowedStrings = Arrays.asList
                (
                        "zero","one","two","three","four","five","six","seven",
                        "eight","nine","ten","eleven","twelve","thirteen","fourteen",
                        "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
                        "thirty","forty","fifty","sixty","seventy","eighty","ninety",
                        "hundred","thousand","million","billion","trillion"
                );

        if (numStr != null && numStr.length() > 0) {
            numStr = numStr.replaceAll("-", " ");
            numStr = numStr.toLowerCase().replaceAll(" and", " ");
            String[] numStrArray = numStr.trim().split(" ");
            for (String string : numStrArray) {
                if (string.equals("zero")) {
                    result = result + 0;
                }
                else if (string.equals("one")) {
                    result = result + 1;
                }
                else if (string.equals("two")) {
                    result = result + 2;
                }
                else if (string.equals("three")) {
                    result = result + 3;
                }
                else if (string.equals("four")) {
                    result = result + 4;
                }
                else if (string.equals("five")) {
                    result = result + 5;
                }
                else if (string.equals("six")) {
                    result = result + 6;
                }
                else if (string.equals("seven")) {
                    result = result + 7;
                }
                else if (string.equals("eight")) {
                    result = result + 8;
                }
                else if (string.equals("nine")) {
                    result = result + 9;
                }
                else if (string.equals("ten")) {
                    result = result + 10;
                }
                else if(string.equals("eleven")) {
                    result += 11;
                }
                else if(string.equals("twelve")) {
                    result += 12;
                }
                else if(string.equals("thirteen")) {
                    result += 13;
                }
                else if(string.equals("fourteen")) {
                    result += 14;
                }
                else if(string.equals("fifteen")) {
                    result += 15;
                }
                else if(string.equals("sixteen")) {
                    result += 16;
                }
                else if(string.equals("seventeen")) {
                    result += 17;
                }
                else if(string.equals("eighteen")) {
                    result += 18;
                }
                else if(string.equals("nineteen")) {
                    result += 19;
                }
                else if(string.equals("twenty")) {
                    result += 20;
                }
                else if(string.equals("thirty")) {
                    result += 30;
                }
                else if(string.equals("forty")) {
                    result += 40;
                }
                else if(string.equals("fifty")) {
                    result += 50;
                }
                else if(string.equals("sixty")) {
                    result += 60;
                }
                else if(string.equals("seventy")) {
                    result += 70;
                }
                else if(string.equals("eighty")) {
                    result += 80;
                }
                else if(string.equals("ninety")) {
                    result += 90;
                }
                else if (string.equals("hundred")) {
                    result = result * 100;
                }
                else if (string.equals("thousand")) {
                    result = result * 1000;
                    finalResult = finalResult + result;
                    result = 0;
                }
                else if (string.equals("million")) {
                    result = result * 1000000;
                    finalResult = finalResult + result;
                    result = 0;
                }
                else if (string.equals("billion")) {
                    result = result * 1000000000;
                    finalResult = finalResult + result;
                    result = 0;
                }
            }
            finalResult = finalResult + result;
        }

        return finalResult;
    }
    public static void main(String[] args) {
        parseInt("two hundred forty-six");
    }
}
