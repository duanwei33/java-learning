public class TwoDimensionalArrays {
    public static void main(String[] args) {
        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 }, // 学生甲的语数英成绩
                { 68, 72, 64 }, // 学生乙的语数英成绩
                { 95, 91, 89 }, // ...
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        // TODO:
        double sum = 0;
        int scoreCount = 0;

        int studentCount = scores.length;
        System.out.println("The student number is: " + studentCount);
        int subjectCount = scores[0].length;
        System.out.println("The subject number is: " + subjectCount);

        for (int[] studentScores : scores) {
            for (int score : studentScores) {
                if (score > 0) {
                    sum += score;
                    scoreCount++;
                }
            }
        }
        double average = (double) sum / scoreCount;
        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
