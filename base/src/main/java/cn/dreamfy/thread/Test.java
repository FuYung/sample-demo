package cn.dreamfy.thread;

/**
 * Title:
 * Description:
 *
 * @version 2.0
 * @author: Yung Fu(FUYUNGCN AT GMAIL DOT com)
 * @since: 14-8-31 上午10:46
 */
public class Test {

    public static void main(String[] args) {
        intTest();

//        byteTest();

        System.out.println((2 << 30) +1);
    }

    private static void intTest() {
        int i = 2147483647;
        if (i + 1 < i) {
            System.out.println("逆天了！");
        }
    }

    public static void byteTest() {
        byte i = (byte) 128;

        if ((byte) (i+1)< i) {
            System.out.println("逆天了！");
        } else {
            System.out.println(i);
        }
    }


}
