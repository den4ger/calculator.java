import java.util.Locale;
import java.util.Scanner;


public class Calculator {
    public static int a;
    public static void main(String[] args) throws Exception {
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        System.out.println("Введите выражение:");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String input = myObj.nextLine();  // Read user input
        System.out.println(calculatorHelper.calc(input));
    }
}

class CalculatorHelper {

    public String calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        Boolean rome = false;
        int letter1, letter2;
        int countLetters = 0;
        int selectedItems = splitText.length;

        if (selectedItems > 3) {
            throw new Exception("letter format do not consist");
        }

        letter1 = getLetter(splitText[0]);
        letter2 = getLetter(splitText[2]);

        if(letter1 >= 11){
            throw new Exception("Arab letter should be between 0 and 10");
        }
        if(letter2 >= 11){
            throw new Exception("Arab letter should be between 0 and 10");
        }
        if(letter1 <= 0){
            throw new Exception("Arab letter should be between 0 and 10");
        }
        if(letter2 <= 0){
            throw new Exception("Arab letter should be between 0 and 10");
        }
        if(letter2 <= 0){
            throw new Exception("Arab letter should be between 0 and 10");
        }
        int result = getResult(letter1, letter2, splitText[1]);
        String output;

        if (rome) {
            if (result > 10 || result < 0) {
                throw new Exception("Arab letter result should be between 0 and 10");
            } else output = getRomeNumber(result);
        } else {

            if (result <= -99) {
                throw new Exception("Arab letter should be < 0");
            } else output = String.valueOf(result);

        }
        return output;
    }

    public Integer getLetter(String letter) throws Exception {

        int integer = 0;

        try {
            integer = Integer.parseInt(letter);
        } catch (Exception e) {
            switch (letter.toLowerCase(Locale.ROOT)) {
                case "i":
                    integer = 1;
                    Calculator.a++;
                    break;
                case "ii":
                    integer = 2;
                    Calculator.a++;
                    break;
                case "iii":
                    integer = 3;
                    Calculator.a++;
                    break;
                case "iv":
                    integer = 4;
                    Calculator.a++;
                    break;
                case "v":
                    integer = 5;
                    Calculator.a++;
                    break;
                case "vi":
                    integer = 6;
                    Calculator.a++;
                    break;
                case "vii":
                    integer = 7;
                    Calculator.a++;
                    break;
                case "viii":
                    integer = 8;
                    Calculator.a++;
                    break;
                case "ix":
                    integer = 9;
                    Calculator.a++;
                    break;
                case "x":
                    integer = 10;
                    Calculator.a++;
                    break;
                default:
                    throw new Exception("Rome letter > 10");
            }
        }

        return integer;

    }

    public String getRomeNumber(int num) throws Exception {
        String romeNum = null;
        switch (num) {
            case 1:
                romeNum = "I";
                break;
            case 2:
                romeNum = "II";
                break;
            case 3:
                romeNum = "III";
                break;
            case 4:
                romeNum = "IV";
                break;
            case 5:
                romeNum = "V";
                break;
            case 6:
                romeNum = "VI";
                break;
            case 7:
                romeNum = "VII";
                break;
            case 8:
                romeNum = "VIII";
                break;
            case 9:
                romeNum = "IX";
                break;
            case 10:
                romeNum = "X";
                break;
            default:
                throw new Exception("The result > 10");
        }
        return romeNum;
    }

    public Integer getResult(int letter1, int letter2, String s) throws Exception {
        int result = 0;
        switch (s) {
            case "/":
                result = letter1 / letter2;
                break;
            case "+":
                result = letter1 + letter2;
                break;
            case "-":
                result = letter1 - letter2;
                break;
            case "*":
                result = letter1 * letter2;
                break;
            default:
                throw new Exception("Wrong operation format");
        }

        if((Calculator.a > 0) && (result <= 0))
        {
            throw new Exception("The result < 0");

        }
        return result;
    }
}