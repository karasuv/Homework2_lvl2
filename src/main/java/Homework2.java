public class Homework2 {
    public static   String[][] array = {
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"9","10","11","12"},
            {"13","14","15","gg"},
    };
    public static String[][] array1 = {
            {"1","2","3"},
            {"5","6","7"},
            {"9","10","11"},
            {"13","14","15"},
    };

    public static   String[][] array2 = {
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"9","10","11","12"},
            {"13","14","15","16"},
    };


    public static void main(String[] args)  {

        try{
            System.out.println(metodForHomework2WithException(array2));
        }catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try{
            System.out.println(metodForHomework2WithException(array1));
        }catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try{
            System.out.println(metodForHomework2WithException(array));
        }catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int metodForHomework2WithException (String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int sum=0;
        if (arr[0].length!=4||arr.length!=4) throw new MyArraySizeException("в массиве ошибочная размерность (кол-во строк или столбцов не равно 4)");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try{
                    sum+=Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    String message;
                    message="невозможно преобозобавть данные (" + arr[i][j] +  ") в ячейке: (" + (i+1) +" , "+ (j+1)+")";
//                   // System.out.println("невозможно преобозобавть данные  " + arr[i][j] +  " в ячейке: " + (i+1) +" , "+ (j+1));
                    throw new MyArrayDataException(message);
//
               }

            }

        }
        return sum;
    }


static class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super(message);
    }
}
static  class MyArrayDataException extends Exception {
        MyArrayDataException(String message){
            super(message);
        }

}
}



