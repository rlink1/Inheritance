package TwoD_Arrays;

import Utilities.Library;

public class As5_Vigenere {
    public static void run() {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[][] vigenere =createVSquare(alphabet);
        printSquare(vigenere);

        String keyword = "SCONA";

        System.out.println(deCode(vigenere, "OGOGTSEYNTVCKA", keyword));



    }

    private static char[][] createVSquare(char[] alphabet) {
        char[][] square = new char[alphabet.length][alphabet.length];
//code to be written

        for (int r = 0; r < 26; r++) {
            for (int c = 0; c < square[r].length; c++) {
                if(r+c <= 25){
                    square[r][c] = alphabet[r+c];
                }
                else if(r+c > 25){
                    square[r][c] = alphabet[(r+c) - 26];
                }

            }
        }

        return square;

    }//createVSquare

    public static void printSquare(char[][] square) {
        System.out.print("  ");
        for (int i = 0; i < 26; i++) {
            System.out.print(Library.TEXT_YELLOW + square[i][0] + " ");
        }
        System.out.println();
        for (int r = 0; r < 26; r++) {
            System.out.print(Library.TEXT_YELLOW + square[r][0] + " ");
            for (int c = 0; c < 26; c++) {
                System.out.print(Library.TEXT_RESET + square[r][c] + " ");
            }
            System.out.println();
        }

    }//end printSquare

    public static int linearSearch (char[] arr, char searchTerm){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == searchTerm){
                return i;
            }
        }
        return -1;
    }

    public static char getChar(char[][] arr, int row, int col){
        return arr[row][col];
    }

    public static String[] deCode(char[][] arr, String m, String key){
        char [] keyWord = key.toCharArray();
        char [] message = m.toCharArray();
        char [] exp = new char[message.length];
        char [] e = new char[message.length];
        String [] decoded = new String[message.length];
        for (int i = 0; i < message.length; i++) {
            if(i > keyWord.length - 1 ){
                exp[i] = keyWord[i%keyWord.length];
            }
            else{
                exp[i] = keyWord[i];
            }
        }

        for (int x = 0; x < message.length; x++) {
            for (int j = 0; j < exp.length; j++) {
                for (int i = 0; i < 26; i++) {
                    if(arr[i].equals(exp[j])){
                        for (int l = 0; l < message.length; l++) {
                            int tempi = linearSearch(arr[0], message[l]);
                            if(tempi > -1){
                                decoded[x] = ((getChar(arr, i, tempi)) + ",");
                            }
                        }

                    }
                }
            }
        }
            return decoded;
        }

    }

//end class

