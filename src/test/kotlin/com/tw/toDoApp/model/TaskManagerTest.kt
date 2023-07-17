package com.tw.toDoApp.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TaskManagerTest {
  private val taskManager = TaskManager()
  private val objectMapper = ObjectMapper()

  @Test
  fun `should add given task into list with id, description and status`() {
    val taskDes = "Read book"
    val expected = Task(1, taskDes, false)

    val actual = taskManager.add(taskDes)
    assertTrue(expected == actual)
  }

  @Test
  fun `should return all tasks in list`() {
    val taskDes1 = "Check mails"
    val taskDes2 = "Read book"
    val expected = mutableListOf(
      Task(1, taskDes1, false),
      Task(2, taskDes2, false))

    taskManager.add(taskDes1)
    taskManager.add(taskDes2)
    val actual = taskManager.display()
    assertEquals(expected, actual)
  }

  @Test
  fun `should find a task based on given id`(){
    val taskDes1 = "Pay electricity bill"
    val taskDes2 = "Write blog"
    val expected = Task(2, taskDes2, false)

    taskManager.add(taskDes1)
    taskManager.add(taskDes2)
    val actual = taskManager.findTask(2)
    assertTrue(expected == actual)
  }

  @Test
  fun `should mark task as done`(){
    val expected = Task(1, "Cycling", true)

    taskManager.add("Cycling")
    taskManager.add("Reading")
    taskManager.changeStatus(1)

    val actual = taskManager.findTask(1)
    assertTrue(expected == actual)
  }

  @Test
  fun `should mark task as undone`(){
    val expected = Task(2, "Reading", false)

    taskManager.add("Swimming")
    taskManager.add("Reading")
    taskManager.changeStatus(2)
    taskManager.changeStatus(2)

    val actual = taskManager.findTask(2)
    assertTrue(expected == actual)
  }

  @Test
  fun `should delete task from list of given id`(){
    val expected = mutableListOf(Task(2, "Swimming", false))
    taskManager.add("Check mails")
    taskManager.add("Swimming")

    taskManager.delete(1)
    val actual = taskManager.display()
    assertTrue(expected == actual )
  }

  @Test
  fun `should modify description of task`(){
    val modifiedTaskDes = "swimming for an hour everyday morning"
    val expected = mutableListOf(Task(1, modifiedTaskDes, false))

    taskManager.add("Swimming")
    taskManager.modifyTask(1, modifiedTaskDes)
    val actual = taskManager.display()

    assertTrue(expected == actual)
  }
}