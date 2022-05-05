package ru.tasks.taskList.main;

import ru.bgpu.task.list.ITaskList;
import ru.taskListSourse.TaskList;

public class Main {
	public static void main(String[] args) {
		TaskList<Integer> test = new TaskList<>();
		long time = System.currentTimeMillis();
		for (int x = 0; x < 1000000; x++) {
			test.add(i);
		}
		ITaskList<Integer> items = test.subList(800000, 900000);
		System.out.println(System.currentTimeMillis() - time + " millisecond");
	}
}