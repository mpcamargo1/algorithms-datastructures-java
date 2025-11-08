package TaskScheduler;

import java.util.*;

public class TaskScheduler {

    private int leastInterval(char[] tasks, int interval) {

        PriorityQueue<TaskEntry> priorityQueue = instantiatePriorityQueue(tasks);
        LinkedList<TaskCooldown> cooldownQueue = new LinkedList<>();

        int time = 0;
        while (!priorityQueue.isEmpty() || !cooldownQueue.isEmpty()) {
            updatePriorityQueue(priorityQueue, cooldownQueue, time);

            TaskEntry taskEntry;

            if (priorityQueue.isEmpty()) {
                time++;
                continue;
            }

            taskEntry = priorityQueue.poll();

            // Code to Execute task

            int frequency = taskEntry.getFrequency() - 1;

            boolean isExecutionRemaining = frequency > 0;

            if (isExecutionRemaining) {
                cooldownQueue.add(new TaskCooldown(taskEntry.getName(), frequency, (time + 1) + interval));
            }

            time++;
        }


        return time;
    }

    private void updatePriorityQueue(PriorityQueue<TaskEntry> priorityQueue, LinkedList<TaskCooldown> cooldownQueue,
                                     int time) {
        TaskCooldown taskCooldown = cooldownQueue.peek();

        if (taskCooldown == null) {
            return;
        }

        if (taskCooldown.getAvailability() <= time) {
            priorityQueue.add(new TaskEntry(taskCooldown.getName(), taskCooldown.getFrequency()));
            cooldownQueue.removeFirst();
        }

    }

    private PriorityQueue<TaskEntry> instantiatePriorityQueue(char[] tasks) {
        HashMap<Character, Integer> mapFrequency = new HashMap<>();

        for (char c : tasks) {
            mapFrequency.put(c, mapFrequency.getOrDefault(c,0) + 1);
        }

        PriorityQueue<TaskEntry> queue = new PriorityQueue<>(tasks.length);
        for (Map.Entry<Character, Integer> entry : mapFrequency.entrySet()) {
            queue.add(new TaskEntry(entry.getKey(), entry.getValue()));
        }

        return queue;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int interval = 3;

        System.out.println(new TaskScheduler().leastInterval(tasks, interval));
    }
}
