package LeetCode;

public class SameDomino {
    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int count = 0;
        for(int i=0; i<dominoes.length;i++){
            for(int j=i+1; j<dominoes.length; j++){
                if(isEqual(dominoes[i], dominoes[j]) == true || isEqual(dominoes[i], exchange(dominoes[j])) == true){
                    count++;
                }
                if(isEqual(dominoes[i], dominoes[j]) == true || isEqual(dominoes[i], exchange(dominoes[j])) == true){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int[] exchange(int[] domino){
        int exchange = domino[0];
        domino[0] = domino[1];
        domino[1] = exchange;
        return domino;
    }

    public static boolean isEqual(int[] domino1, int[] domino2){
        return (domino1[0] == domino2[0] && domino1[1]==domino2[1]);
    }
}
