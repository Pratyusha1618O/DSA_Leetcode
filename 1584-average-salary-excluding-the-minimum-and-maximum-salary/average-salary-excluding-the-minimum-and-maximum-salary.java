class Solution {
    public double average(int[] salary) {

        Arrays.sort(salary);

        int min = salary[0];
        int max = salary[salary.length-1];

        int n = salary.length;
        int totalSalary = 0;
        for(int i=0; i<n; i++){
            totalSalary += salary[i];
        }

        double avg = (double)(totalSalary - (max + min)) / (n-2);

        return avg;
    }
}