package com.kh.pratice.object;

import java.util.Scanner;

public class Practice4 {
   /*
    * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
    *  따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
    */
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0 ; i<croatia.length ; i++) {
            word = word.replace(croatia[i] , "0"); // 임의의 한 글자로 치환
        }

        System.out.println(word.length());
    }
		
	}


/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i < word.length() - 2 && word.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 2; // dz= 건너뛰기
            } else if (i < word.length() - 1) {
                String two = word.substring(i, i + 2);
                if (two.equals("c=") || two.equals("c-") || two.equals("d-") ||
                    two.equals("lj") || two.equals("nj") || two.equals("s=") || two.equals("z=")) {
                    count++;
                    i++; // 두 글자 건너뛰기
                    continue;
                }
                count++;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}

*/