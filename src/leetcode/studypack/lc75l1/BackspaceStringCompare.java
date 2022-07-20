package lc75l1;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sRes = new StringBuilder();
        StringBuilder tRes = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(sRes.length() != 0) {
                    sRes.deleteCharAt(sRes.length() - 1);
                }
            } else {
                sRes.append(s.charAt(i));
            }
        }

        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == '#') {
                if(tRes.length() != 0) {
                    tRes.deleteCharAt(tRes.length() - 1);
                }
            } else {
                tRes.append(t.charAt(i));
            }
        }

        return sRes.toString().equals(tRes.toString());
    }

    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while(i >= 0 || j>=0) {
            int nBackspace = 0;
            while(i >= 0) {
                if(s.charAt(i) == '#') {
                    i--;
                    nBackspace++;
                } else if (nBackspace > 0) {
                    i--;
                    nBackspace--;
                } else {
                    break;
                }
            }
            nBackspace = 0;
            while(j >= 0) {
                if(t.charAt(j) == '#') {
                    j--;
                    nBackspace++;
                } else if (nBackspace > 0) {
                    j--;
                    nBackspace--;
                } else {
                    break;
                }
            }

            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;

            if((i >= 0) != (j >= 0))
                return false;

            i--;
            j--;
        }
        return true;
    }
}
