package Test;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class treeSetTest {
    public static void main(String[] args) {
        TreeSet<Double> scores = new TreeSet<>();
        Scanner input = new Scanner(System.in);
        System.out.println("---Students Scores Management System---");
        for(int i=0; i<5; i++){
            System.out.println("No." + i + ":");
            double score = input.nextDouble();
            scores.add(Double.valueOf(score));
        }

        // Output all scores
        Iterator<Double> it = scores.iterator();
        System.out.println("All scores:");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Whether contains the input score
        System.out.println("The score wanted to search:");
        double searchScore = input.nextDouble();
        if(scores.contains(searchScore)){
            System.out.println("Here it is a student with "+ searchScore);
        } else {
            System.out.println("There is no such a student with "+ searchScore);
        }

        // Check scores under 60
        SortedSet<Double> scoreSet = scores.headSet(60.0);
        System.out.println("All scores under 60:");
        for(int i=0; i<scoreSet.toArray().length; i++){
            System.out.println(scoreSet.toArray()[i]);
        }

        // Check scores higher than 90
        SortedSet<Double> sortedSet2 = scores.tailSet(90.0);
        System.out.println("All scores higher than 90:");
        for(int i=0; i<sortedSet2.toArray().length; i++){
            System.out.println(sortedSet2.toArray()[i]);
        }
    }
}
