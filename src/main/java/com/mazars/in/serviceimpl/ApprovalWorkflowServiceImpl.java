//package com.mazars.in.serviceimpl;
//
//import com.mazars.in.dao.UserDAO;
//import com.mazars.in.model.mastermodel.User;
//import com.mazars.in.service.ApprovalWorkflowService;
//
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.activiti.engine.task.Task;
//
//
//@Service
//@Transactional
//public class ApprovalWorkflowServiceImpl implements ApprovalWorkflowService{
//
//	
//	@Autowired
//	private RepositoryService repositoryService;
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    
//    @Autowired
//    private UserDAO userRepository;
//    
//    
//   
//
//    public String startProcess(String assignee) {
//		User user = userRepository.getUserData(assignee);
//        //user.setApprover3(user.getApprover3());--method to get aprover 3
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("user", user);
//
//		runtimeService.startProcessInstanceByKey("approvalProcess", variables);
//		
//
//		return processInfo();
//	}
//
//	public List<Task> getTasks(String assignee) {
//		return taskService.createTaskQuery().taskAssignee(assignee).list();
//	
//	}
//	
//	public void completeTask(String taskId,String approvalStatus) {
//		//user user = userRepository.findByName(assignee);
//
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("approvalStatus", approvalStatus);
//		taskService.complete(taskId,variables);
//	
//	//	taskService.complete(taskId);
////		
////		variables.put("secondLevelApproverExists", true);
////        taskService.complete(taskId, variables);
//
//		
//	
//	}
//	public void delegateTask(String taskId,String assignee) {
//		//User user = userRepository.getUserData(assignee);
//		
//		taskService.delegateTask(taskId, assignee);
//	
//	}
//	/*public void createusers() {
//		if (userRepository.findAll().size() == 0) {
//
//			userRepository.save(new user("John", new Date(),"David","Katherin","murchanahazarika@gmail.com"));
//			userRepository.save(new user("David", new Date(),"Katherin","","murchanahazarika@gmail.com"));
//			userRepository.save(new user("Katherin", new Date(),"","","murchanahazarika@gmail.com"));
//		}
//	}*/
//
//	private String processInfo() {
//		List<Task> tasks = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
//		
//		StringBuilder stringBuilder = new StringBuilder();
//
//		stringBuilder.append("Number of process definitions : "
//				+ repositoryService.createProcessDefinitionQuery().count() + "--> Tasks >> ");
//
//		for (Task task : tasks) {
//			stringBuilder
//					.append(task + " | Assignee: " + task.getAssignee() + " | Description: " + task.getDescription());
//		}
//
//		return stringBuilder.toString();
//	}
//
//    /*public void createDemoUsers() {
//        if (user1Repository.findAll().size() == 0) {
//            user1Repository.save(new user1("jbarrez", "Joram", "Barrez", new Date()));
//            user1Repository.save(new user1("trademakers", "Tijs", "Rademakers", new Date()));
//        }
//    }*/
//
//	
//	
//}
