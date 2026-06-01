import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최대, 최소 우선순위 큐 선언하기
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = 
            new PriorityQueue<>(Collections.reverseOrder());
        // 값 삭제 시 두 큐중 한 곳만 삭제되므로 나머지 다른 큐 삭제용으로 map 선언
        Map<Integer, Integer> map = new HashMap<>();

        for (String temp : operations) {
            String[] s = temp.split(" ");
            int num = Integer.parseInt(s[1]);

            if (s[0].equals("I")) {
                min.offer(num);
                max.offer(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (s[0].equals("D")) {
                if (num == 1) {
                    while (!max.isEmpty() &&
                           map.getOrDefault(max.peek(), 0) == 0) {
                        max.poll();
                    }

                    if (!max.isEmpty()) {
                        int value = max.poll();
                        map.put(value, map.get(value) - 1);
                    }
                } else {
                    while (!min.isEmpty() &&
                           map.getOrDefault(min.peek(), 0) == 0) {
                        min.poll();
                    }

                    if (!min.isEmpty()) {
                        int value = min.poll();
                        map.put(value, map.get(value) - 1);
                    }
                }
            }
        }

        while (!max.isEmpty() &&
               map.getOrDefault(max.peek(), 0) == 0) {
            max.poll();
        }

        while (!min.isEmpty() &&
               map.getOrDefault(min.peek(), 0) == 0) {
            min.poll();
        }

        if (max.isEmpty() || min.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max.peek(), min.peek()};
    }
}