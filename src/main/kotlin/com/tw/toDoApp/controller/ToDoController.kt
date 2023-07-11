package com.tw.toDoApp.controller

import com.tw.toDoApp.constant.*
import com.tw.toDoApp.dto.Response
import com.tw.toDoApp.dto.TaskInfo
import com.tw.toDoApp.model.Task
import com.tw.toDoApp.model.TaskManager
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class ToDoController(val taskManager: TaskManager) {

  @GetMapping("/")
  fun greet() = GREET_USER

  @PostMapping("/add-task", produces = [(MediaType.APPLICATION_JSON_VALUE)])
  fun addTask(@RequestBody task: String): Response {
    taskManager.add(task)
    return Response(TASK_ADDED_SUCCESSFULLY, task)
  }

  @GetMapping("/display-tasks")
  fun displayTasks(): MutableList<Task> {
    return taskManager.display()
  }

  @PostMapping("/mark-as-done/{id}")
  fun markTaskAsDone(@PathVariable id: Int): Response {
    taskManager.changeStatus(id)
    val currentTask = taskManager.findTask(id)
    return Response(TASK_MARKED_AS_DONE, currentTask.task)
  }

  @PostMapping("/mark-as-undone/{id}")
  fun markTaskAsUndone(@PathVariable id: Int): Response {
    taskManager.changeStatus(id)
    val currentTask = taskManager.findTask(id)
    return Response(TASK_MARKED_AS_UNDONE, currentTask.task)
  }

  @DeleteMapping("/delete-task/{id}")
  fun deleteTask(@PathVariable id: Int): Response {
    taskManager.delete(id)
    val currentTask = taskManager.findTask(id)
    return Response(TASK_DELETED_SUCCESSFULLY, currentTask.task)
  }

  @PostMapping("/modify-task")
  fun modifyTask(@RequestBody taskInfo: TaskInfo): Response {
    taskManager.modifyTask(taskInfo.id, taskInfo.task)
    val modifiedDesOfTask = taskManager.findTask(taskInfo.id)
    return Response(TASK_MODIFIED_SUCCESSFULLY, taskInfo.task, modifiedDesOfTask.task)
  }
}