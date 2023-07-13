package com.tw.toDoApp.model

class Task(val id: Int, var task : String, var isDone: Boolean){

  fun markTask() {
    this.isDone = !this.isDone
  }

  fun isTaskSame(givenTaskId: Int) = this.id == givenTaskId

  fun modify(taskDes : String) {
    this.task = taskDes
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Task

    if (id != other.id) return false
    if (task != other.task) return false
    if (isDone != other.isDone) return false

    return true
  }
}