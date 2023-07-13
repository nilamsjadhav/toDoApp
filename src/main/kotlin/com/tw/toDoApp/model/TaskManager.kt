package com.tw.toDoApp.model

import org.springframework.stereotype.Component

@Component
class TaskManager(val taskList: MutableList<Task> = mutableListOf() ) {
  var count = 1;

  fun add(task: String): Task {
    val recentlyAddedTask = Task(count++, task, false)
    taskList.add(recentlyAddedTask)
    return recentlyAddedTask
  }

  fun display(): MutableList<Task> {
    return taskList
  }

  fun findTask(id: Int): Task{
    return taskList.first { it.isTaskSame(id) }
  }

  fun changeStatus(id: Int) {
    val recentTask = findTask(id)
    recentTask.markTask()
  }

  fun delete(id: Int) {
    taskList.removeIf { it.isTaskSame(id) }
  }

  fun modifyTask(id: Int, taskDes : String) {
    val recentTask = findTask(id)
    recentTask.modify(taskDes)
  }
}