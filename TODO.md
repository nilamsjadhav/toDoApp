TODO

Do :

* **Backend**
- [ ] **Add task**

  - [ ] Find a way to notify user after adding task to list.

- [ ] **Display tasks**
  
- [ ] **Mark task as done**

  - [ ] Rethink about contract of changeStatus method.
  - [ ] Write test

- [ ] **Delete task**

  - [ ] Write test

- [ ] **Modify task description**

  - [ ] Write test

- [ ] Add content in README.md
- [ ] Add animation effect on textbox used to enter task
- [ ] Solve bug : after hitting `http://localhost:3000/` url server should give black page not html text on page
- [ ] Throw error when id is not present in list
- [ ] Write a script to run backend and frontend together in a command.
- [ ] Think about storing data more effectively
- [ ] Containerize application

* **Frontend**

- [x] Connect frontend and backend through webpack
- [ ] create task list
- [ ] Create task item component
- [ ] Create task container (includes input and tasks)

Done :

- [x] Add task

  - [x] Create '/add-task' endpoint for adding task.
  - [x] Decide how user can give input.
  - [x] Create class to manage tasks.
  - [x] Store task in richer data structure.
  - [x] Write test for add feature

- [x] Display tasks

  - [x] Create '/display-tasks' endpoint for displaying all added tasks.
  - [x] Write test for add feature
  - [x] Display tasks name properly.

- [x] Mark task as done

  - [x] Create '/mark-as-done' endpoint for marking task as done.
  - [x] Create '/mark-as-undone' endpoint for marking task as undone.

- [x] Delete task

  - [x] Create '/delete-task' endpoint for deleting task.

- [x] Modify task description

  - [x] Create '/modify-task' endpoint for modifying task description

- [x] version control the app.
- [x] push repo to github
- [x] Create mockups for frontend
