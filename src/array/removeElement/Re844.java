package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/28
 * @description:比较含退格的字符串
 **/
public class Re844 {
    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare_0(String s, String t) {
        int sIdx = s.length() - 1, tIdx = t.length() - 1;
        while (sIdx >= 0 || tIdx >= 0) {
            sIdx = findNextElement(s, sIdx);
            tIdx = findNextElement(t, tIdx);
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

    /**
     * 栈
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        String s1 = removeElement(s);
        String t1 = removeElement(t);
        return s1.equals(t1);
    }


    public int findNextElement(String s, int idx) {
        int count = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                count++;
                idx--;
            } else if (count > 0) {
                count--;
                idx--;
            } else {
                break;
            }
        }
        return idx;
    }


    public String removeElement(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            if (s.charAt(idx) != '#') {
                sb.append(s.charAt(idx));
            } else {
                if (sb.length() > 0) {
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "ab#c", t = "ad#c";
//        String s = "a#c", t = "b";
//        String s = "ab##", t = "c#d#";
        String s = "a##c", t = "#a#c";
        boolean res = new Re844().backspaceCompare(s, t);
        System.out.println("res = " + res);
    }


}
