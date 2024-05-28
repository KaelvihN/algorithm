package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/28
 * @description:比较含退格的字符串
 **/
public class Re844 {
    /**
     *
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int sIdx = s.length() - 1, tIdx = t.length() - 1;
        int sCount = 0, tCount = 0;
        while (sIdx >= 0 || tIdx >= 0) {
            while (sIdx >= 0) {
                if (s.charAt(sIdx) == '#') {
                    sCount++;
                    sIdx--;
                } else if (sCount > 0) {
                    sCount--;
                    sIdx--;
                } else {
                    break;
                }
            }
            while (tIdx >= 0) {
                if (t.charAt(tIdx) == '#') {
                    tCount++;
                    tIdx--;
                } else if (tCount > 0) {
                    tCount--;
                    tIdx--;
                } else {
                    break;
                }
            }
            if (tIdx >= 0 && sIdx >= 0) {
                if (s.charAt(sIdx) != t.charAt(tIdx)) {
                    return false;
                }
            } else {
                if (tIdx >= 0 || sIdx >= 0) {
                    return false;
                }
            }
            tIdx--;
            sIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
//        String s = "a#c", t = "b";
//        String s = "ab##", t = "c#d#";
//        String s = "a##c", t = "#a#c";
        boolean res = new Re844().backspaceCompare(s, t);
        System.out.println("res = " + res);
    }
}
