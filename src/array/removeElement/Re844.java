package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/28
 * @description:比较含退格的字符串
 **/
public class Re844 {
    public boolean backspaceCompare(String s, String t) {
        boolean flag = true;
        int sIdx = s.length() - 1, tIdx = t.length() - 1;
        while (true) {
            if (sIdx >= 0 && s.charAt(sIdx) == '#') {
                int count = 0;
                while (sIdx >= 0 && s.charAt(sIdx) == '#') {
                    count++;
                    sIdx--;
                }
                sIdx -= count;
            }
            if (tIdx >= 0 && t.charAt(tIdx) == '#') {
                int count = 0;
                while (tIdx >= 0 && t.charAt(tIdx) == '#') {
                    count++;
                    tIdx--;
                }
                tIdx -= count;
            }
            if ((sIdx < 0 && tIdx == 0) || (sIdx == 0 && tIdx < 0) || (sIdx >= 0 && tIdx >= 0 && s.charAt(sIdx) != t.charAt(tIdx))) {
                flag = false;
                break;
            }
            sIdx = sIdx >= 0 ? --sIdx : sIdx;
            tIdx = tIdx >= 0 ? --tIdx : tIdx;

        }
        return flag || (sIdx == -1 && tIdx == -1);
    }

    public static void main(String[] args) {
//        String s = "ab#c", t = "ad#c";
//        String s = "ab##", t = "c#d#";
//        String s = "a#c", t = "b";
        String s = "ab##", t = "c#d#";
        boolean res = new Re844().backspaceCompare(s, t);
        System.out.println("res = " + res);
    }
}
