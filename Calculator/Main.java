package Calculator;

import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("��� �� ������ �������������� ��������?");
        } else if (parts.length > 3) {
            throw new ArithmeticException("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� ��������");
        }

        String first = parts[0];
        String operator = parts[1];
        String second = parts[2];

        boolean firstIsRoman = isRoman(first);
        boolean secondIsRoman = isRoman(second);

        if (firstIsRoman != secondIsRoman) {
            throw new IllegalArgumentException("�� ���, ��������� ��������� ������ ������� ���������?");
        }

        if (firstIsRoman == false | secondIsRoman == false) {
            if (Integer.parseInt(first) < 1 || Integer.parseInt(first) > 10 || Integer.parseInt(second) < 1 || Integer.parseInt(second) > 10) {
                throw new IllegalArgumentException("������� ����� �� 1 �� 10");
            }
        }

        int firstNum = firstIsRoman ? RomanNumeral.fromString(first).getValue() : Integer.parseInt(first);
        int secondNum = secondIsRoman ? RomanNumeral.fromString(second).getValue() : Integer.parseInt(second);

        int result;

        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            default:
                throw new IllegalArgumentException("������������ ��������");
        }

        String resultStr = String.valueOf(result);

        if (firstIsRoman && secondIsRoman) {
            resultStr = arabicToRoman(result);
        }

        return resultStr;
    }

    private static boolean isRoman(String input) {
        return input.matches("[IVX]+");
    }

    private static String arabicToRoman(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("���� � ������ �� ���� ������������� ����� - �� ����� ������?");
        }
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();
        int i = 0;

        while (number > 0) {
            if (number >= romanValues[i]) {
                roman.append(romanSymbols[i]);
                number -= romanValues[i];
            } else {
                i++;
            }
        }

        return roman.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �������������� ���������:");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("���������: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("������: " + e.getMessage());
        }
    }
}