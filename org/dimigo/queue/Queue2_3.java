package org.dimigo.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// 소득 격차
class City implements Comparable<City>{
    public final int index;     // 도시의 인덱스
    public final int income;    // 해당 도시의 소득

    public City(int index, int income){
        this.index = index;
        this.income = income;
    }

    @Override
    public int compareTo(City o) {
        // 소득에 대해 우선순위를 가지도록 대소관계를 정의해준다
        return this.income - o.income;
    }
}

public class Queue2_3 {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMaximumRangeDifference(int n, int k, City[] cities){
        int answer = 0;

         PriorityQueue<City> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
         PriorityQueue<City> minQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            City c = cities[i];

            int rightEnd = i;
            int leftEnd = rightEnd - k + 1;

            // c를 각 우선순위 큐에 추가한다.
            maxQueue.offer(c);
            minQueue.offer(c);

            // 큐에 있는 값 중 검사 범위 밖에 있는 경우 불필요한 정보이므로 pop하여 제거
            while (!maxQueue.isEmpty() && maxQueue.peek().index < leftEnd) {
                maxQueue.poll();
            }
            while (!minQueue.isEmpty() && minQueue.peek().index < leftEnd) {
                minQueue.poll();
            }

            // 검사 범위 내에 있는 큐 데이터 중 최대/최소 소득간의 차이를 계산한다.
            int minIncome = minQueue.peek().income;
            int maxIncome = maxQueue.peek().income;
            int diff = maxIncome - minIncome;

            // 최대 차이를 갱신한다.
            answer = Math.max(answer, diff);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        City[] cities = new City[n];

        for(int i = 0 ; i < n ; i += 1){
            int income = scanner.nextInt();
            cities[i] = new City(i, income);
        }

        int answer = getMaximumRangeDifference(n, k, cities);

        System.out.println(answer);
    }

}


