package com.company;

public class GradeAverage {

    private int [] scores;

    public GradeAverage(int [] s)
    {
        scores = s;
    }

    // returns the mean (average) of the values in the scores array
    // whose indexes are between first and last (including first and last).
    //You may assume that first and last are > 0 and < scores.length
    private double mean(int first, int last)
    {
        double add = 0;
        int k = first;
        while(k <= last ) {
            add = add + scores[k];
            k++;
        }
        return  add/((last-first)+1);
    }

    // returns true if each successive value in scores is greater than
    // or equal to the previous value.  Otherwise returns false
    private boolean showsImprovement()
    {
        int n = 1;
        while(n < scores.length){
            if(scores[n] < scores[n-1]){
                return false;
            }
            n++;
        }
        return true;
    }

    // if the values in the scores array show improvement, returns the
    // average of the elements in scores with indexes greater than or
    // equal to scores.length()/2
    public double finalGrade()
    {
        if(showsImprovement())
        {
            return mean(scores.length / 2, scores.length - 1);
        }

        return mean(0,scores.length - 1);
    }

    public static void main(String[] args)
    {
        int [] s1 = {50,50,20,80,53};   // not improved, finalGrade is 50.6
        int [] s2 = {20,50,50,53,80};   // improved, final grade is 61.0
        int [] s3 = {20,50,50,85};      // improved, final grade is 67.5

        GradeAverage sr1 = new GradeAverage(s1);
        System.out.println("Student A");
        System.out.println(sr1.mean(0,4));
        System.out.println(sr1.showsImprovement());
        System.out.println(sr1.finalGrade() + "\n");

        GradeAverage sr2 = new GradeAverage(s2);
        System.out.println("Student B");
        System.out.println(sr2.mean(0,4));
        System.out.println(sr2.showsImprovement());
        System.out.println(sr2.finalGrade() + "\n");

        System.out.println("Student C");
        GradeAverage sr3 = new GradeAverage(s3);
        System.out.println(sr3.mean(0,3));
        System.out.println(sr3.showsImprovement());
        System.out.println(sr3.finalGrade() + "\n");
    }

}