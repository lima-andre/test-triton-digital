package com.test.triton;

import java.util.Stack;

public class NumberToWords {

        /**
         *
         * provide English Word to a number between 1 and 10
         * 
         */
        private String provideWordToNumberOneTo(int i) {

                String numberInEnglishWord = "";
                
                switch (i) {
	                case 1:
	                        numberInEnglishWord = "one";
	                        break;
	                case 2:
	                        numberInEnglishWord = "two";
	                        break;
	                case 3:
	                        numberInEnglishWord = "three";
	                        break;
	                case 4:
	                        numberInEnglishWord = "four";
	                        break;
	                case 5:
	                        numberInEnglishWord = "five";
	                        break;
	                case 6:
	                        numberInEnglishWord = "six";
	                        break;
	                case 7:
	                        numberInEnglishWord = "seven";
	                        break;
	                case 8:
	                        numberInEnglishWord = "eight";
	                        break;
	                case 9:
	                        numberInEnglishWord = "nine";
	                        break;
	                case 10:
	                        numberInEnglishWord = "ten";
	                        break;
	                default:
	                        numberInEnglishWord = "";
	                        break;
                }
                
                return numberInEnglishWord;
        }

        /**
         *
         * provide English Word to a number between 11 and 19
         * 
         */
        private String provideWordToNumberElevenToNineteen(int i) {
        	
                String numberInEnglishWord = "";
                int remainder = i % 10;
               
                switch (i % 20) {
	                case 11:
	                        numberInEnglishWord = "eleven";
	                        break;
	                case 12:
	                        numberInEnglishWord = "twelve";
	                        break;
	                case 13:
	                        numberInEnglishWord = "thirteen";
	                        break;
	                default:
	                        numberInEnglishWord = provideWordToNumberOneTo(remainder) + "teen";
	                        break;
	            }
                
                return numberInEnglishWord;
        }

        /**
         *
         * provide English Word to a number between 20 and 100
         *
         */
        private String provideWordToNumberTwentyToNinetyNine(int i) {
        	
                int remainder = i % 10;
                int quotient = i / 10;
                
                StringBuilder numberInEnglishWord = new StringBuilder();

                switch (quotient) {
	                case 2:
	                        numberInEnglishWord.append("twen");
	                        break;
	                case 3:
	                        numberInEnglishWord.append("thir");
	                        break;
	                case 4:
	                        numberInEnglishWord.append("for");
	                        break;
	                case 5:
	                        numberInEnglishWord.append("fif");
	                        break;
	                case 8:
	                        numberInEnglishWord.append("eigh");
	                        break;
	                default:
	                        numberInEnglishWord.append(provideWordToNumberOneTo(quotient));
	                        break;
                }
                
                numberInEnglishWord.append("ty ");
                
                if (remainder != 0)
                        numberInEnglishWord.append(provideWordToNumberOneTo(remainder));

                return numberInEnglishWord.toString();
        }

        /**
         *
         * provide English Word to a number between 1 and 99
         * 
         */
        public String numberLessThanOneHundred(int i) {
                String numberInEnglishWord = "";
                
                if (i <= 10) {
                        numberInEnglishWord = provideWordToNumberOneTo(i);
                }

                if ((i > 10) && (i < 20)) {
                        numberInEnglishWord = provideWordToNumberElevenToNineteen(i);
                }

                if (i > 20) {
                        numberInEnglishWord = provideWordToNumberTwentyToNinetyNine(i);
                }
                return numberInEnglishWord;
        }

        /**
         *
         * provide English Word to a number less than 1000
         * 
         */
        public String numberLessThanOneThousand(int i) {
                i = i % 1000;
                int hundreds = i / 100;
                int remainder = i % 100;
                
                StringBuilder numberInEnglishWord = new StringBuilder();
                
                if (hundreds > 0){
                	numberInEnglishWord.append(provideWordToNumberOneTo(hundreds)).append(" ").append("hundred");
                }                        
                if (remainder > 0){
                	 numberInEnglishWord.append(" ").append(numberLessThanOneHundred(remainder));
                }
                       
                return numberInEnglishWord.toString();
        }

        /**
         *
         * Method responsible to provide the String with
         * in English to received number.
         * 
         */
        public String convertNumberInEnglishWord(long i) {

                if (i == 0) {
                        return "Zero";
                }

                byte thousandOccurrence = 0;
                String numberToConvertInEnglishWords = "";
                Stack<String> stk = new Stack<String>();

                do {
                        int remainder = (int) (i % 1000);
                        if (remainder != 0) {
                                numberToConvertInEnglishWords += (numberLessThanOneThousand(remainder)) + " "
                                                + thousandNumbersInEnglishWord(thousandOccurrence);
                                stk.push(numberToConvertInEnglishWords);
                        }

                        numberToConvertInEnglishWords = "";
                        i = i / 1000;

                        if (i > 0) {
                        	thousandOccurrence += 1;
                        }
                } while (i > 0);

                StringBuilder sb = new StringBuilder();
                while (!stk.isEmpty()) {
                        sb.append(stk.pop());
                        if (!stk.empty())
                                sb.append(", ");
                }

                String firstCharacter = (sb.charAt(0) + "").toUpperCase();
                sb.replace(0, 1, firstCharacter);
                return sb.toString().trim();
        }

        private String thousandNumbersInEnglishWord(byte b) {
                String numberInEnglishWord = "";
                switch (b) {
	                case 1:
	                        numberInEnglishWord = "thousand";
	                        break;
	                case 2:
	                        numberInEnglishWord = "million";
	                        break;
                }
                return numberInEnglishWord;
        }

        public static void main(String[] args) {
                NumberToWords numToWord = new NumberToWords();
               
                System.out.println(numToWord.convertNumberInEnglishWord(100282));
                
                //Others tests
                System.out.println(numToWord.convertNumberInEnglishWord(8));
                System.out.println(numToWord.convertNumberInEnglishWord(19));
                System.out.println(numToWord.convertNumberInEnglishWord(136));
                System.out.println(numToWord.convertNumberInEnglishWord(1413));
                System.out.println(numToWord.convertNumberInEnglishWord(10124));
        }

}
