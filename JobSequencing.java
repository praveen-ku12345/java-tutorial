//Job Sequencing with Dead Line Problem
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void jobSequence(Job[] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, Comparator.comparingInt(job -> -job.profit)); // Sort jobs in descending order of profit

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        char[] result = new char[maxDeadline];
        Arrays.fill(result, ' ');

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int i = Math.min(maxDeadline - 1, job.deadline - 1); i >= 0; i--) {
                if (result[i] == ' ') {
                    result[i] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Job sequence with maximum profit:");
        System.out.println(new String(result));
        System.out.println("Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter job id: ");
            char id = scanner.next().charAt(0);
            System.out.print("Enter job deadline: ");
            int deadline = scanner.nextInt();
            System.out.print("Enter job profit: ");
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobSequence(jobs);

        scanner.close();
    }
}
