import java.util.Arrays;

public class LC955 {
    public static void main(String[] args) {

        String[] str= {"ca","ac","bb"};
        System.out.println(delete(str));

        
    }


    public static int delete(String[] str){
        int count=0;
        boolean[] flag = new boolean[str.length];
        for(int i=0;i<str[0].length();i++){
            boolean flag1 = false;
            for(int j=0;j<str.length-1;j++){
                if(!flag[j] && str[j].charAt(i) > str[j+1].charAt(i)){
                    flag1= true;
                    break;
                }
            }

            if(flag1 == true){
                count++;
                continue;
            }
            
            /**
             * consider this example : "xc","yb","za"
             * why this loop required
             * since we know x < y , then xa < yb or xqz < yxa or x.... < y...
             * similarly yb < za , so over all xa < yb < zc 
             * , what if we have sth like this
             *  "ca","ac","bb"
             * here if we see. c > a , so ca > ac but ac < bb
             * then for character 1 , below loop mark the row 1 or will mark true, that means 
             * if we will delete the one character from count var (line 26) , then ca and ac are in sorted order 
             * but ac and bb are not sorted order , then 
             *  
             * 
             */
            for(int j=0;j<str.length-1;j++){
                if(!flag[j] && str[j].charAt(i) < (str[j+1]).charAt(i)){
                    flag[j] = true;
                }
            }



        }
        return count;
    }

    private static int deleteColumn(String[] str){
        int count = 0;
        int len = str[0].length();
        int n = str.length;
        String[] current = new String[n];
        for(int i=0;i<len;i++){

            String[] current1 = Arrays.copyOf(current,n);
            for(int j=0;j<n;j++){
                current1[j]+= str[j].charAt(i);
            }
            
            if(isSorted(current1)){
                current = current1;
                continue;
            }
            count++;
        }
        return count;
    }

    private static boolean   isSorted(String[] str){
        for(int i = 0;i<str.length-1;i++){
            if(str[i].compareTo(str[i+1]) >= 1){
                return false;
            }
        }
        return true;
    }
}
