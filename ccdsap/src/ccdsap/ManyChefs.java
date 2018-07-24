package ccdsap;

import java.util.Scanner;
class ManyChefs {

   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       int testCase = scanner.nextInt();
//       scanner.nextLine();

       for (int i = 0; i < testCase; i++) {
           String str = scanner.next();
           char ch[] = str.toCharArray();
           if (ch.length < 4) {
               for (int j = 0; j < ch.length; j++) {
                   if ('?' == ch[j]) {
                       ch[j] = 'A';
                   }
               }
               System.out.println(new String(ch));
               continue;
           }

           String s = "CHEF";
           int len = ch.length;
           for (int j = len - 4; j >= 0; j--) {
               boolean status = true;
               for (int k = 0; k < 4; k++) {
                   if (!('?' == ch[j+k] || s.charAt(k) == ch[k+j])) {
                       status = false;
                       break;
                   }
               }

               if (status) {
                   ch[j] = 'C';
                   ch[j + 1] = 'H';
                   ch[j + 2] = 'E';
                   ch[j + 3] = 'F';
                   j -=3;
               }
           }

           for(int j = 0; j < len; j++)
           {
               if('?' == ch[j])
                   ch[j] = 'A';
           }


           System.out.println(new String(ch));
       }


   }

}