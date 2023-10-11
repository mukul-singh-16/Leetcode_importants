package sliding_window;
class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int fre1[]=new int [123];
        for(int i=0;i<t.length();i++)
        {
            fre1[t.charAt(i)]++;
        }
        int startw =0;
        int endw=0;
        int len=Integer.MAX_VALUE;
        int start=-1;
        int count =0;
        int fre2[]=new int[123];
        while(endw < s.length())
        {
            // window grow
            fre2[s.charAt(endw)]++;
            if(fre1[s.charAt(endw)] >= fre2[s.charAt(endw)])
                count++;
            // window shrink
            if(count == t.length())
            {
                while((fre2[s.charAt(startw)] > fre1[s.charAt(startw)]) && (startw <= endw))
                {
                        fre2[s.charAt(startw)]--;
                        startw++;
                }
                // ans calculate
                if(len> endw-startw + 1)
                {
                    len= endw - startw + 1;
                    start=startw;
                }

            }
            endw++;
            
        }
        if(start==-1)
            return "";
        return s.substring(start,start+len);
    }
}