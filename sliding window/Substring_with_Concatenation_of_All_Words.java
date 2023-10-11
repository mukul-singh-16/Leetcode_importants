class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words)
    {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }


        int i=0;int j=0;
        int x=words[0].length();

        while(j < s.length())
        {
            if(j-i+1 == words.length * words[0].length())
            {
                HashMap<String, Integer> map1 = new HashMap<>();
                String st=s.substring(i,j+1);

                for(int a=0; a<st.length(); a=a+x)
                {
                    String temp=st.substring(a,a+x);
                    map1.put(temp,map1.getOrDefault(temp,0)+1);
                }

                if(map.equals(map1))
                ans.add(i);

                i++;

            }
        j++;

        }
        return ans;
    }
}
