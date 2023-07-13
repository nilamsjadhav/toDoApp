package com.tw.toDoApp.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TaskTest{

  @Test
  fun `should set isDone flag to true`(){
    val task = Task(1, "Playing football", false);
    task.markTask()
    assertTrue(task.isDone)
  }

  @Test
  fun `should set isDone flag to false`(){
    val task = Task(1, "Playing football", true);
    task.markTask()
    assertFalse(task.isDone)
  }

  @Test
  fun `should return true when both tasks ids are same`(){
    val task = Task(1, "Exercise", true);
    assertTrue(task.isTaskSame(1))
  }

  @Test
  fun `should return false when both tasks ids are different`(){
    val task = Task(3, "Exercise", true);
    assertFalse(task.isTaskSame(1))
  }

  @Test
  fun `should add new description of task in list using given id`(){
    val task = Task(5, "Visit shop", false);
    val modifiedDes = "Visit grocery shop"
    val expected = Task(5, modifiedDes, false);
    task.modify(modifiedDes)

    assertTrue(expected.task == modifiedDes )
  }
}
