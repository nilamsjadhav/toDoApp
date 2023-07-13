package com.tw.toDoApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.tw.toDoApp.constant.TASK_MODIFIED_SUCCESSFULLY
import com.tw.toDoApp.dto.Response
import com.tw.toDoApp.dto.TaskInfo
import com.tw.toDoApp.model.Task
import com.tw.toDoApp.model.TaskManager
import io.mockk.every
import io.mockk.mockkClass
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class ToDoControllerTest {
  private val taskManager = mockkClass(TaskManager::class)
  private var toDoController = ToDoController(taskManager)
  private val objectMapper = ObjectMapper()

  private val mockMvc: MockMvc = MockMvcBuilders
    .standaloneSetup(toDoController)
    .build()

  @Test
  fun `should greet a user`() {
    mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpectAll(
      status().is2xxSuccessful)
  }

  @Test
  fun `should add a task`() {
    val taskDes = "Check mails"
    val task = Task(1, taskDes, false)

    every { taskManager.add(taskDes) }.returns(task)
    mockMvc.perform(
      MockMvcRequestBuilders.post("/add-task").content(taskDes).contentType(
        MediaType.APPLICATION_JSON
      )
    ).andExpect(status().isOk)
  }

  @Test
  fun `should display all available tasks`(){
    val task1 = Task(1, "Check mails", false)
    val task2 = Task(2, "Read book", false)
    val tasks = mutableListOf(task1, task2)

    every { taskManager.display() }.returns(tasks)
    mockMvc.perform(MockMvcRequestBuilders.get("/display-tasks"))
      .andExpect(status().is2xxSuccessful)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string(objectMapper.writeValueAsString(tasks)))
  }

 @Test
 fun `should modify given tasks`(){
   val task1 = Task(1, "Check mails", false)
   val task2 = Task(2, "Read book", false)
   val tasks = mutableListOf(task1, task2)
   val taskManager = TaskManager(tasks)
   toDoController = ToDoController(taskManager)

   val modifiedTaskDes = "Read historical books"
   val requestBody = TaskInfo(1, modifiedTaskDes)
   val expected = Response(TASK_MODIFIED_SUCCESSFULLY, task2.task, modifiedTaskDes)

   mockMvc.perform(MockMvcRequestBuilders.post("/modify-task")
     .content(objectMapper.writeValueAsString(requestBody)))
     .andExpect(status().is2xxSuccessful)
     .andExpect(content().contentType(MediaType.APPLICATION_JSON))
     .andExpect(content().string(objectMapper.writeValueAsString(expected)))
 }
}