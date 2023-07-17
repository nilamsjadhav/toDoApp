package com.tw.toDoApp.dto

data class Response(val message: String, val task: String, val newTask: String? = null)