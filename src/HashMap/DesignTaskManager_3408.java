//3408. Design Task Manager
//Medium
//Topics
//premium lock icon
//Companies
//There is a task management system that allows users to manage their tasks, each associated with a priority. The system should efficiently handle adding, modifying, executing, and removing tasks.
//
//Implement the TaskManager class:
//
//TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples. Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.
//
//void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId. It is guaranteed that taskId does not exist in the system.
//
//void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority. It is guaranteed that taskId exists in the system.
//
//void rmv(int taskId) removes the task identified by taskId from the system. It is guaranteed that taskId exists in the system.
//
//int execTop() executes the task with the highest priority across all users. If there are multiple tasks with the same highest priority, execute the one with the highest taskId. After executing, the taskId is removed from the system. Return the userId associated with the executed task. If no tasks are available, return -1.
//
//Note that a user may be assigned multiple tasks.
//
//
//
//Example 1:
//
//Input:
//["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
//[[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
//
//Output:
//[null, null, null, 3, null, null, 5]
//
//Explanation
//
//TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // Initializes with three tasks for Users 1, 2, and 3.
//taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
//taskManager.edit(102, 8); // Updates priority of task 102 to 8.
//taskManager.execTop(); // return 3. Executes task 103 for User 3.
//taskManager.rmv(101); // Removes task 101 from the system.
//taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
//taskManager.execTop(); // return 5. Executes task 105 for User 5.
//
//
//Constraints:
//
//1 <= tasks.length <= 105
//0 <= userId <= 105
//0 <= taskId <= 105
//0 <= priority <= 109
//0 <= newPriority <= 109
//At most 2 * 105 calls will be made in total to add, edit, rmv, and execTop methods.
//The input is generated such that taskId will be valid.

package HashMap;

import java.util.*;
class TaskManagerBruteForce  {
    class Task implements Comparable<Task>{
        private int userId;
        private int taskId;
        private int priority;

        // adding tostrings etc


        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTaskId() {
            return taskId;
        }
// this will treat object to be sorted as descending order sorting
        @Override
        public int compareTo(Task o){
            if(o.priority-this.priority==0){
                return o.taskId-this.taskId;
            }
            return o.priority -this.priority;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "userId=" + userId +
                    ", taskId=" + taskId +
                    ", priority=" + priority +
                    '}';
        }
    }


    HashMap<Integer, TreeSet<Task>> userToTask= new HashMap<>();
    HashMap<Integer,Integer> taskToUser= new HashMap<>();
//| Function    | Time Complexity  |
//| ----------- | ---------------- |
//| Constructor | O(n log n) worst |
//| add         | O(log m)         |
//| edit        | O(m)             |
//| rmv         | O(m)             |
//| execTop     | O(U + m)         |
    public TaskManagerBruteForce(List<List<Integer>> tasks) {
        for(List<Integer> taskData: tasks){
            int userId= taskData.get(0);
            int taskId= taskData.get(1);
            int priority= taskData.get(2);

            Task task = new Task(userId,taskId,priority);
//            build userto task mapping
            if(userToTask.containsKey(userId)){
                userToTask.get(userId).add(task);
            }else{
                TreeSet<Task> userTasks= new TreeSet<>();
                userTasks.add(task);
                userToTask.put(userId,userTasks);
            }
//            build task to user map:
//            its said task ids are unique
            taskToUser.put(taskId,userId);
        }


    }

    public void add(int userId, int taskId, int priority) {
        // create a map of uses with userid who will map the userid with there tasks
        taskToUser.put(taskId,userId);
        if(userToTask.containsKey(userId)){
            userToTask.get(userId).add(new Task(userId,taskId,priority));
        }else{
            TreeSet<Task> userTasks= new TreeSet<>();
            userTasks.add(new Task(userId,taskId,priority));
            userToTask.put(userId,userTasks);
        }

    }

    public void edit(int taskId, int newPriority) {
    // here we will get which user assigned this task using taskToUsermap and then update the
    // task priority in usertotask map
        int userId=taskToUser.get(taskId);// user who is performing task
        SortedSet<Task> userTasks=userToTask.get(userId);// userAssigned tasks
        Task updateTask =null;
        for(Task task : userTasks){
            if(task.getTaskId()==taskId){
                updateTask=task;
                break;
            }
        }
        if(updateTask==null){
            System.out.println("Soory cannot found the task !");
        }else{
            userTasks.remove(updateTask);
            updateTask.setPriority(newPriority);
            userTasks.add(updateTask);
        }
    }

    public void rmv(int taskId) {
        // remove task from userToTask map and task to user id map:
        int userId=taskToUser.get(taskId);// user who is performing task
        SortedSet<Task> userTasks=userToTask.get(userId);// userAssigned tasks
        Task removeTask =null;
        for(Task task : userTasks){
            if(task.getTaskId()==taskId){
                removeTask=task;
                break;
            }
        }
        if(removeTask==null){
            System.out.println("Soory cannot found the task !");
        }else{
            userTasks.remove(removeTask);
            taskToUser.remove(taskId);
        }
    }

    public int execTop() {
        // get all usersmap and take the first task they have and keep track of maxTask id task and max priority task if the priority remains same we can return maxTask one else max priority one
        Task maxPriority = null;
        for(Map.Entry<Integer,TreeSet<Task>> e:userToTask.entrySet()) {
            TreeSet<Task> userTasks = e.getValue();
            if (userTasks.isEmpty()) {
                continue;
            }
            Task task = userTasks.getFirst();
            if(maxPriority==null){
                maxPriority=task;
            }else if(maxPriority.getPriority()< task.getPriority()){
                maxPriority=task;
            }else if(maxPriority.getPriority()== task.getPriority() && maxPriority.getTaskId()<task.getTaskId()){
                maxPriority=task;
            }
        }
        if(maxPriority==null){
            return -1;
        }else{
            this.rmv(maxPriority.getTaskId());
            return maxPriority.getUserId();
        }
    }
}
//  here approch  is using lazy deletiong
//what we are doing we manage a  task id maping to task object
// and a priority queue which handle the sequence of task but the priority queue is sorted according to priority and task id
// once done we can add every thing simply
// when deletion we can just remove the map entry from the map and let it be in priority queue
// when edit we can create a new task obeject assign it to old task object and override it entry
// now when executing we have to get first entry from the priority queue
// and check its task id is present in the task map and if present the object form queue is same as map one
// if both are true then we can execute other wise the object are old ones and we can skip to get next one
//
//| Function                          | Operation Details                                                                                                                                                | Time Complexity        |
//| --------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
//| **add(userId, taskId, priority)** | - Insert task into heap (PriorityQueue) → O(log n) <br> - Put task into map → O(1)                                                                               | **O(log n)**           |
//| **edit(taskId, newPriority)**     | - Create new Task object → O(1) <br> - Insert new task into heap → O(log n) <br> - Update map → O(1) <br> *(old task remains in heap for lazy deletion)*         | **O(log n)**           |
//| **rmv(taskId)**                   | - Remove task from map → O(1) <br> *(old task remains in heap for lazy deletion)*                                                                                | **O(1)**               |
//| **execTop()**                     | - Pop tasks from heap until top task matches map reference → O(log n) per pop <br> - Each task is popped at most once across all operations → amortized O(log n) | **O(log n) amortized** |
class TaskManagerBetter {
    class Task implements Comparable<Task> {
        private int userId;
        private int taskId;
        private int priority;

        // adding tostrings etc

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTaskId() {
            return taskId;
        }

        // this will treat object to be sorted as descending order sorting
        @Override
        public int compareTo(Task o) {
            if (o.priority - this.priority == 0) {
                return o.taskId - this.taskId;
            }
            return o.priority - this.priority;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "userId=" + userId +
                    ", taskId=" + taskId +
                    ", priority=" + priority +
                    '}';
        }
    }

    HashMap<Integer, Task> taskMap = new HashMap();
    PriorityQueue<Task> queue = new PriorityQueue();

    public TaskManagerBetter(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            this.add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        queue.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldtask = taskMap.get(taskId);
        this.add(oldtask.getUserId(), oldtask.getTaskId(), newPriority);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!queue.isEmpty()) {
            Task task = queue.peek();
            int taskId = task.getTaskId();
            if (taskMap.containsKey(taskId) && taskMap.get(taskId) == task) {
                taskMap.remove(taskId);
                Task res = queue.poll();
                return res.getUserId();
            } else {// invalid task
                queue.poll();
            }
        }
        return -1;
    }
}
public class DesignTaskManager_3408 {

    public static void main(String[] args) {
        List<List<Integer>> tasks1 = new ArrayList<>( Arrays.asList(Arrays.asList(1, 101, 10), Arrays.asList(2, 102, 20), Arrays.asList(3, 103, 15)));
        TaskManagerBruteForce taskManager1 = new TaskManagerBruteForce(tasks1); // Initializes with three tasks for Users 1, 2, and 3.
        taskManager1.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager1.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager1.execTop(); // return 3. Executes task 103 for User 3.
        taskManager1.rmv(101); // Removes task 101 from the system.
        taskManager1.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        taskManager1.execTop(); // return 5. Executes task 105 for User 5.

        TaskManagerBetter taskManager2 = new TaskManagerBetter(tasks1); // Initializes with three tasks for Users 1, 2, and 3.
        taskManager2.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager2.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager2.execTop(); // return 3. Executes task 103 for User 3.
        taskManager2.rmv(101); // Removes task 101 from the system.
        taskManager2.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        taskManager2.execTop(); // return 5. Executes task 105 for User 5.



    }
}
