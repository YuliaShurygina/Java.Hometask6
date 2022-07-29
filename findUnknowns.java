import java.util.ArrayList;

//Задано уравнение вида q + w = e, q, w, e >= 0. 
//Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
//Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
public class findUnknowns {

    public static String[] stringParsing(String str) {
        String[] parts = new String[3];
        char[] array = str.toCharArray();
        String someString = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                continue;
            } else if (array[i] == '+') {
                parts[0] = someString;
                someString = "";
                continue;
            } else if (array[i] == '=') {
                parts[1] = someString;
                someString = "";
                continue;
            } else if (i == array.length - 1) {
                someString = someString + array[i];
                parts[2] = someString;
                break;
            } else {
                someString = someString + array[i];
            }
        }
        return parts;
    }

    public static String[] replacing(String[] parts) {
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace('?', '0');
        }
        return parts;
    }

    public static String toString(char[] a) {
        String string = new String(a);
        return string;
    }

    public static ArrayList<Integer> findItems(char[] a, char[] b, char[] c) {
        ArrayList<Integer> t = new ArrayList<>();
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (((int) c[i] > (int) b[i]) && ((int) c[i] > (int) a[i])) {
                    t.add(0);
                    int q;
                    if (a[i] == '0') {
                        q = (int) c[i] - (int) b[i];
                        a[i] = Integer.toString(q).charAt(0);
                    }
                    int w;
                    if (b[i] == '0') {
                        w = (int) c[i] - (int) a[i];
                        b[i] = Integer.toString(w).charAt(0);
                    }
                } else if (((int) c[i] <= (int) b[i]) && ((int) c[i] <= (int) a[i])) {
                    if (c[i] == '0' && b[i] == '0' && a[i] == '0') {
                        int k = 9;
                        int borderForRandom = 5;
                        int number = (int) (Math.random() * borderForRandom);
                        char d = Integer.toString(number).charAt(0);
                        c[i] = Integer.toString(k).charAt(0);
                        int l = (int) c[i] - (int) d;
                        a[i] = Integer.toString(l).charAt(0);
                        int m = (int) c[i] - (int) a[i];
                        b[i] = Integer.toString(m).charAt(0);
                    } else {
                        if (((int) c[i] == 0) && ((int) b[i] != 0) && ((int) a[i] != 0)) {
                            int e = (int) a[i] + (int) b[i];
                            c[i] = Integer.toString(e).charAt(0);
                        } else {
                            int k = 9;
                            c[i] = Integer.toString(k).charAt(0);
                            if ((int) a[i] == 0) {
                                int l = (int) c[i] - (int) b[i];
                                a[i] = Integer.toString(l).charAt(0);
                            } else {
                                int l = (int) c[i] - (int) a[i];
                                b[i] = Integer.toString(l).charAt(0);
                            }
                        }
                    }
                } else {
                    t.add(1);
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        String expression = "2? + ?5 = 69";
        String[] partsExpression = stringParsing(expression);
        String[] partsReplace = replacing(partsExpression);
        for (int i = 0; i < partsExpression.length; i++) {
            System.out.println(partsExpression[i]);
        }
        char[] a = partsReplace[0].toCharArray();
        char[] b = partsReplace[1].toCharArray();
        char[] c = partsReplace[2].toCharArray();
        if (findItems(a, b, c).contains(1))
            System.out.println("Нет решения");
        else {
            System.out.printf("%s + %s = %s", toString(a), toString(b), toString(c));
        }
    }
}
