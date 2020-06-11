import java.util.Arrays;

public class Task_2 {

    //1
    //Создайте функцию, которая повторяет каждый символ в строке n раз.

    public static String repeat(String word, int n){
        String newWord = " ";
        for (int i = 0; i< word.length() ; i++){
            for (int j = 0; j<n; j++){
                newWord+= word.charAt(i);
            }
        }
        return newWord;
    }

    //2
    //Создайте функцию, которая принимает массив и возвращает разницу между
    //самыми большими и самыми маленькими числами.

    public static int differenceMaxMin(int [] mass){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : mass) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max - min;
    }

    //3
    //Создайте функцию, которая принимает массив в качестве аргумента и возвращает
    //true или false в зависимости от того, является ли среднее значение всех элементов
    //массива целым числом или нет.

    public static boolean isAvgWhole(int mass[]){
        double sum=0;

        for (int value : mass) {
            sum += value;
        }
        if ((sum%mass.length)%100<1)
            return true;
        else
            return false;

    }

    //4
    //Создайте метод, который берет массив целых чисел и возвращает массив, в
    //котором каждое целое число является суммой самого себя + всех предыдущих
    //чисел в массиве.

    public static int[] cumulativeSum( int [] mass){

        for (int i = 1; i < mass.length; i++){
            mass[i] = mass[i] + mass[i-1];
        }
        return mass;
    }

    //5
    //Создайте функцию, которая возвращает число десятичных знаков, которое имеет
    //число (заданное в виде строки). Любые нули после десятичной точки
    //отсчитываются в сторону количества десятичных знаков.

    public static int getDecimalPlaces(String number){
        if (number.indexOf('.')!=0){
            return number.length()-number.indexOf('.')-1;
        }
        else
            return 0;
    }

    //6
    //Создайте функцию, которая при заданном числе возвращает соответствующее
    //число Фибоначчи.

    public static int Fibonacci (int n){
        switch (n) {
            case 0:
            case 1:
                return 1;
            default:
                return Fibonacci(n - 2) + Fibonacci(n - 1);
        }
    }

    //7
    //Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
    //напишите функцию, чтобы определить, является ли вход действительным
    //почтовым индексом. Действительный почтовый индекс выглядит следующим
    //образом:
    //– Должно содержать только цифры (не допускается использование нецифровых цифр).
    //– Не должно содержать никаких пробелов.
    //– Длина не должна превышать 5 цифр.

    public static boolean isValid(String index){
        int buf = 0;
        for (int i = 0; i < index.length(); i++) {
            if (!Character.isDigit(index.charAt(i)))
                buf++;
            else if (index.charAt(i) == ' ')
                buf++;
            else if (index.length() != 5)
                buf++;
        }
        return buf == 0;
    }

    //8
    //Пара строк образует странную пару, если оба из следующих условий истинны:
    //– Первая буква 1-й строки = последняя буква 2-й строки.
    //– Последняя буква 1-й строки = первая буква 2-й строки.
    //– Создайте функцию, которая возвращает true, если пара строк представляет собой
    //странную пару, и false в противном случае.

    public static boolean isStrangePair (String word1, String word2){
        return word1.charAt(0) == word2.charAt(word2.length() - 1) &&
                word2.charAt(0) == word2.charAt(word1.length() - 1);
    }

    //9
    //Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
    //– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
    //– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
    //– В противном случае верните false.

    public static boolean isPrefix(String word, String pref){
        pref =  pref.substring(0,  pref.length()-1);
        //System.out.println(pref);
        return word.startsWith(pref);
    }
    public static boolean isSuffix(String word, String suf){
        suf = suf.substring(1);
        //System.out.println(suf);
        return word.endsWith(suf);
    }

    //10
    //Создайте функцию, которая принимает число (шаг) в качестве аргумента и
    //возвращает количество полей на этом шаге последовательности.
    //Шаг 0: начните с 0
    //Шаг 1: Добавьте 3
    //Шаг 2: Вычтите 1
    //Повторите Шаги 1 И 2 ...
    public static int boxSeq(int shag){
        if (shag == 0) return 0;
        int count = 0;
        for (int i = 0; i < shag; i++) {
            if (i % 2 != 0) count--;
            else count += 3;
        }
        return count;
    }

    public static void main(String[] args) {
        // Тест 1 - вернет  hhheeellllllooo
        System.out.println(repeat("hello", 3));
        // Тест 2 - вернет 82
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        // Тест 3 - вернет false
        System.out.println(isAvgWhole(new int[]{1, 2 , 3 , 4}));
        // Тест 4 - вернет [3, 6, 4, 412, 415, 418]
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
        // Тест 5 - вернет 2
        System.out.println(getDecimalPlaces("43.20"));
        // Тест 6 - вернет 21
        System.out.println(Fibonacci(7));
        // Тест 7 - вернет true
        System.out.println(isValid("15006"));
        // Тест 8 - вернет false
        System.out.println(isStrangePair("bush", "hubris") );
        // Тест 9 - вернет true и true
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        // Тест 10 - вернет 5
        System.out.println(boxSeq(3));

    }



}