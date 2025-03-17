import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqMap.values()) {
            maxHeap.add(freq);
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.add(cooldownQueue.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll() - 1;
                if (remainingFreq > 0) {
                    cooldownQueue.add(new int[]{remainingFreq, time + n + 1});
                }
            }
        }

        return time;
    }
}
