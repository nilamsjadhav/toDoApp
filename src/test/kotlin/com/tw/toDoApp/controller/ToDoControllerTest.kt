package com.tw.toDoApp.controller

import com.tw.toDoApp.model.Task
import com.tw.toDoApp.model.TaskManager
import io.mockk.every
import io.mockk.mockkClass
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class ToDoControllerTest {
  private val taskManager = mockkClass(TaskManager::class)
  private val toDoController = ToDoController(taskManager)

  private val mockMvc: MockMvc = MockMvcBuilders
    .standaloneSetup(toDoController)
    .build()

  @BeforeEach
  private fun setup() {

  }

  @Test
  fun greet() {
    mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpectAll(
      MockMvcResultMatchers.status().is2xxSuccessful)
  }

  @Test
  fun addTask() {
    val taskDes = "Check mails"
    val task = Task(1, taskDes, false)

    every { taskManager.add(taskDes) }.returns(task)
    mockMvc.perform(
      MockMvcRequestBuilders.post("/add-task").content(taskDes).contentType(
        MediaType.APPLICATION_JSON
      )
    ).andExpect(MockMvcResultMatchers.status().isOk)
  }
}