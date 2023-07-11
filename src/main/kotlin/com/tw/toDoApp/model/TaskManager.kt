package com.tw.toDoApp.model

import org.springframework.stereotype.Component

@Component
class TaskManager {
  val taskList = mutableListOf<Task>()
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
    return taskList.filter { it.isTaskSame(id) }.first()
  }

  fun changeStatus(id: Int) {
    val recentTask = findTask(id)
    return recentTask.markTask()
  }

  fun delete(id: Int) {
    taskList.removeIf { it.isTaskSame(id) }
  }

  fun modifyTask(id: Int, taskDes : String) {
    val recentTask = findTask(id)
    recentTask.modify(taskDes)
  }
}