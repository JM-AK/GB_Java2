package ru.gb.lesson2;

/*
*Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
10 3 1 2
2 3 2 2
5 6 7 1
300 3 1 0
Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
3. Ваши методы должны бросить исключения в случаях:
Если размер матрицы, полученной из строки, не равен 4x4;
Если в одной из ячеек полученной матрицы не число; (например символ или слово)
4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
5. * Написать собственные классы исключений для каждого из случаев
* */

public class MainClass {

    public static void main(String[] args) throws NotSquareMatrixException {
        String [][] stringMatrix = getStringMatrix("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0");
        printStringMatrix(stringMatrix);

        int[][] intMatrix = divMatrixByTwo(stringMatrix);
        printIntMatrix(intMatrix);

    }

    public static String [][] getStringMatrix (String str) throws NotSquareMatrixException {

        String [] linesArray = str.split("\\n");
        String[][] result = new String[linesArray.length][linesArray.length];
        for (int i = 0; i < linesArray.length; i++){
            String [] line = linesArray[i].split(" ");

            if (line.length == linesArray.length) {

                for (int j = 0; j < line.length; j++) {
                    result[i][j] = line[j];
                }
            } else{
                throw new NotSquareMatrixException("Не квадратная матрица");
            }
        }

        return result;
    }

    public static void printStringMatrix(String[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printIntMatrix(int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] divMatrixByTwo (String[][] array){
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                try {
                    result[i][j] = Integer.parseInt(array[i][j]) / 2;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static class NotSquareMatrixException extends Exception{
        public NotSquareMatrixException (String message){
            super(message);
        }
    }



}
