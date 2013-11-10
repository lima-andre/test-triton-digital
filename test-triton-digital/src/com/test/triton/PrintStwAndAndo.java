package com.test.triton;

public class PrintStwAndAndo {

	public static void printStwAndAndo() {
		
        final String STRING_TO_MULTIPLE_OF_THREE = "Stw";
        final String STRING_TO_MULTIPLE_OF_FIVE = "Ando";
                
                for (int i = 1; i <= 100; i++) {
                        StringBuilder sb = new StringBuilder("");                        

                        if ((i % 3) == 0) {
                                sb.append(STRING_TO_MULTIPLE_OF_THREE);
                        }

                        if ((i % 5) == 0) {
                                sb.append(STRING_TO_MULTIPLE_OF_FIVE);
                        }

                        if (sb.length() == 0) {
                                sb.append(i);
                        }

                        System.out.print(sb.toString() + ", ");

                }
        }

        public static void main(String[] args) {
        	printStwAndAndo();
        }
}
