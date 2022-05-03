import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList<T> {
    public static void main(String[] args) {
        Integer[] data_list = new Integer[10];
        data_list[0] = 1;

        Integer data_list1[][][] = {
                {
                        {1,2,3},
                        {4,5,6}
                },
                {
                        {7,8,9},
                        {10,11,12}
                }
        };
        Integer[] data_list2 = {1,2,3,4,5};

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.set(0,5);
        list1.get(0);
        list1.size();


//        연습해보기 1 data_list1 배열의 8,10,2를 순서대로 라인에 출력
//        System.out.println(data_list1[1][0][1]);
//        System.out.println(data_list1[1][1][0]);
//        System.out.println(data_list1[0][0][1]);


//        연습해보기 2 database 1차원 배열에서 문자M을 가지고 있는 아이템의 수를 출력
        String dataset[] = {
                "Braund, Mr. Owen Harris",
                "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                "Heikkinen, Miss. Laina",
                "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                "Allen, Mr. William Henry",
                "Moran, Mr. James",
                "McCarthy, Mr. Timothy J",
                "Palsson, Master. Gosta Leonard",
                "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                "Nasser, Mrs. Nicholas (Adele Achem)",
                "Sandstrom, Miss. Marguerite Rut",
                "Bonnell, Miss. Elizabeth",
                "Saundercock, Mr. William Henry",
                "Andersson, Mr. Anders Johan",
                "Vestrom, Miss. Hulda Amanda Adolfina",
                "Hewlett, Mrs. (Mary D Kingcome) ",
                "Rice, Master. Eugene",
                "Williams, Mr. Charles Eugene",
                "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                "Masselmani, Mrs. Fatima",
                "Fynney, Mr. Joseph J",
                "Beesley, Mr. Lawrence",
                "McGowan, Miss. Anna",
                "Sloper, Mr. William Thompson",
                "Palsson, Miss. Torborg Danira",
                "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                "Emir, Mr. Farred Chehab",
                "Fortune, Mr. Charles Alexander",
                "Dwyer, Miss. Ellen",
                "Todoroff, Mr. Lalio"
        };
        Integer count = 0;
        for(int i=0;i< dataset.length;i++){
            if(dataset[i].indexOf("M") >= 0){
            count++;
        }
    }
}
