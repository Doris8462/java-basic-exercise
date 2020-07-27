import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();

      

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(result);

    }

    public static Map<String, Integer> findRepetition(String[] list) {
        Map<String, Integer> map = new HashMap<>();
        if (list == null || list.length < 0) {
            return null;
        }
        for (String s:list) {
            s=s.toUpperCase().replace("", " ").trim();;
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else map.put(s, 1);
        }
        return map;
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String pattern= "^([[A-Za-z]+,])*([A-Za-z]+)$";
        if(firstWordList.contains(",,")||secondWordList.contains(",,")||
        !Pattern.compile(pattern).matcher(firstWordList).matches()||
        !Pattern.compile(pattern).matcher(secondWordList).matches())
        throw new RuntimeException("input not valid");
        String arr1[] =firstWordList.split(",");
        String arr2[] =secondWordList.split(",");
        String list[]=new String[arr1.length+arr2.length];
        System.arraycopy(arr1,0,list,0,arr1.length);
        System.arraycopy(arr2,0,list,arr1.length,arr2.length);   
        List<String> res = new ArrayList<String>();
        Map<String, Integer> map = findRepetition(list);
        if(map!=null){
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue()>1){
                    res.add(entry.getKey());
                }
        }  
        Collections.sort(res);   
    }  
    return res;
    }
}
