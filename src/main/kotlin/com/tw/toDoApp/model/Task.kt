package com.tw.toDoApp.model

class Task(val id: Int, var task : String, var isDone: Boolean){

  fun markTask() {
    this.isDone = !this.isDone
  }

  fun isTaskSame(givenTaskId: Int) = this.id == givenTaskId

  fun modify(taskDes : String) {
    this.task = taskDes
  }
}