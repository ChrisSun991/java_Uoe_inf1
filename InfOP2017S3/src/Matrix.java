public class Matrix {

    public static int[][] readMatrix(String[] s){
        int size = Integer.parseInt(s[0]);
        int number = (s.length-1)/size;
        int[][] output = new int[number][size];
        for (int i = 0; i < number; i++){
            for (int j = 0; j < size; j++){
                output[i][j] = Integer.parseInt(s[(j+1) * (1+i)]);
            }
        }
        return output;
    }

    public static String toString(int[][] m){

    }

}
