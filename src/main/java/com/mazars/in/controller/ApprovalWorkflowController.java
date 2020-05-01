//package com.mazars.in.controller;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.activiti.engine.task.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mazars.in.serviceimpl.ApprovalWorkflowServiceImpl;
//
//@RestController
//public class ApprovalWorkflowController {
//
//    @Autowired
//    private ApprovalWorkflowServiceImpl myService;
//
//    @RequestMapping(value="/process1", method= RequestMethod.POST)
//    public void   startProcessInstance1(@RequestBody StartProcessRepresentation startProcessRepresentation) {
//        // myService.startProcess(startProcessRepresentation.getAssignee());
//    }
//
//    @RequestMapping(value="/tasks1", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//    public List<TaskRepresentation> getTasks1(@RequestParam("assignee") String assignee) {
//        List<Task> tasks = myService.getTasks(assignee);
//        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
//        for (Task task : tasks) {
//            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
//        }
//        return dtos;
//    }
//    
//    @RequestMapping(value = "/process")
//	public String startProcessInstance(@RequestParam String initiator) {
//		return myService.startProcess(initiator);
//	}
//
//	@RequestMapping(value = "/tasks/{assignee}")
//	public String getTasks(@PathVariable("assignee") String assignee) {
//		List<Task> tasks = myService.getTasks(assignee);
//		return tasks.toString();
//	}
//
//	@RequestMapping(value = "/completetask")
//	public String completeTask(@RequestParam String id,@RequestParam String approvalStatus) {
//		myService.completeTask(id,approvalStatus);
//		return "Task with id " + id + " has been completed!";
//	}
//
//	
//	
//	@RequestMapping(value = "/delegateTask")
//	public String delegateTask(@RequestParam String id,@RequestParam String assignee) {
//		myService.delegateTask(id,assignee);
//		return "Task with id " + id + " has been reassigned!";
//	}
//	
//	
//    static class TaskRepresentation {
//
//        private String id;
//        private String name;
//
//        public TaskRepresentation(String id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    static class StartProcessRepresentation {
//
//        private String assignee;
//
//        public String getAssignee() {
//            return assignee;
//        }
//
//        public void setAssignee(String assignee) {
//            this.assignee = assignee;
//        }
//    }
//
//
//
//}
