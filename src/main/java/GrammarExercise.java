import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {

        String firstWordList = "";
        String secondWordList = "apple,,juice,mother,people,beautiful,apple,dog";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);


    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> ff = Arrays.asList(firstWordList.split(","));
        List<Boolean> firstIsFalse = new ArrayList<>();
        ff.forEach(x->{
            firstIsFalse.add(x.matches("[a-zA-Z]+"));
        });
        List<String> sf = Arrays.asList(secondWordList.split(","));
        List<Boolean> secondIsFalse = new ArrayList<>();
        sf.forEach(x->{
            secondIsFalse.add(x.matches("[a-zA-Z]+"));
        });
        if(firstIsFalse.toString().contains("false")||secondIsFalse.toString().contains("false")
                ||firstWordList.contains(",,")||secondWordList.contains(",,")){
            throw new RuntimeException("input not valid");
        }else{
            String [] fi =firstWordList.toUpperCase().split(",");
            String [] se =secondWordList.toUpperCase().split(",");
            List<String> fir = Arrays.asList(fi);
            List<String> sec = Arrays.asList(se);
            List<String> first = fir.stream().distinct().collect(Collectors.toList());
            List<String> second = sec.stream().distinct().collect(Collectors.toList());
            List<String> result = new ArrayList<>();
            first.forEach(i->{
                second.forEach(n->{
                    if(i.equals(n)){
                        result.add(i.replace(""," ").trim());
                    }
                });
            } );
            return result;
        }

    }
}
