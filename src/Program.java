import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Program {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        byte task;
        boolean check = true;

        while(check)
        {
            System.out.println("Введіть номер завдання: ");
            task = in.nextByte();

            switch(task){
                case 1:
                    task1();
                    System.out.println("Ще одне завдання? true/false");
                    check = in.nextBoolean();
                    break;
                case 2:
                    task2();
                    System.out.println("Ще одне завдання? true/false");
                    check = in.nextBoolean();
                    break;
                case 3:
                    task3();
                    System.out.println("Ще одне завдання? true/false");
                    check = in.nextBoolean();
                    break;
            }

        }
    }
    public static void task1()
    {
        System.out.println("Введіть текст:");
        in.nextLine();
        StringBuilder sbd = new StringBuilder(in.nextLine());
        System.out.println(sbd);
        char t;
        for (int i = 0; i < sbd.length(); i++)
        {
            t = sbd.charAt(i);
            if(Character.isLowerCase(t))
            {
                sbd.replace(i,i+1,Character.toString(Character.toUpperCase(t)));
            }
        }
        System.out.println(sbd);
        String[] words = sbd.toString().split(" ");
        int maxLen = words[0].length();
        String maxWord = words[0];
        for (String word : words)
        {
            if(maxLen < word.length()) {maxLen = word.length(); maxWord = word;}
        }

        System.out.println("Найдовше слово: " + maxWord);
        System.out.println("Максимальна довжина слова з введеного тексту: " + maxLen);
    }

    public static void task2()
    {
        File file = new File("C:\\Users\\Администратор\\Desktop\\text.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Не вдалося відкрити файл.");
        }
        String text = scanner.nextLine();
        scanner.close();
        char ch1 = text.charAt(0);
        char ch2 = text.charAt(1);
        if (Character.isDigit(ch1) && Character.isDigit(ch2)) System.out.println("Два перших символа є цифрами.");
        else System.out.println("Два перших символа не є цифрами.");
    }
    public static void task3()
    {
        Integer maxLen = null;
        String maxWords = null;

        try(BufferedReader br = new BufferedReader(new FileReader("input.txt")))
        {
            String text = br.readLine();
            System.out.println("Зчитаний рядок з файла: " + text);
            String[] words = text.split("\\.");
            maxLen = words[0].length();
            maxWords = words[0];
            for (String word : words)
            {
                if(maxLen < word.length()) {maxLen = word.length(); maxWords = word;}
            }
            System.out.println("Максимальна довжина речення з введеного тексту: " + maxLen);
            System.out.println("Найдовше речення: " + maxWords);

        }
        catch (IOException e)
        {
            System.out.println("Не вдалося зчитати дані з файлу");
        }
        File file = new File("output.txt");
        try{
            if(file.createNewFile()) System.out.println("Вдалося створити файл");
            else System.out.println("Не вдалося створити файл");
            FileWriter fw = new FileWriter(file);
            fw.write("Максимальна довжина слова з введеного тексту: " + maxLen);
            fw.write("Найдовше речення: " + maxWords);
            fw.close();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}
