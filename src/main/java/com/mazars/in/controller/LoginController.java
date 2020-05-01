package com.mazars.in.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.common.Constants;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.model.transactionmodel.Login;
import com.mazars.in.model.transactionmodel.LoginResponseModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.report.generator.AdvanceMISReport;
import com.mazars.in.service.LoginService;
import com.mazars.in.service.RoleMasterService;
import com.mazars.in.service.RoleToTilemappingService;
import com.mazars.in.service.UserService;


@RestController
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleToTilemappingService roleToTilemappingService;
	@Autowired
	private RoleMasterService roleMasterService;
	
	@Autowired
	private CommonController commonController;
	
	@Autowired
	private AdvanceMISReport advanceMISReport;
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Login login(@RequestHeader("token") String token,@RequestBody Login login) { 
		System.out.println("a");
	Login l2=loginservice.getLoginDetails("samit","jgklll");
	Login l=loginservice.save(login);
		return l;	
	}*/
	
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponseModel login(@RequestHeader("token") String token,@RequestBody Login login) {
		if(ObjectUtils.isEmpty(commonController.masterResponseModelData))
		{
			
			commonController.getMasterDataFromDB();
		}	
		
		
		
		
		advanceMISReport.createAdvanceMISReport();
		
		
		
		String userEmail=login.getUserEmail();
		LoginResponseModel res= new LoginResponseModel();
		boolean isAllowedForTe=false;
		String userId="";
		
		User user1=userService.loginVerification(userEmail);
		if(user1!=null)
		{
		userId=String.valueOf(user1.getEmployeeCode());
		isAllowedForTe=user1.isUserIsAllowedForTE();
		System.out.println("isAllowedForTe"+isAllowedForTe);
		}
		
		MasterResponseModel masterResponseModel=new MasterResponseModel();
		if(isAllowedForTe==false)

		{
			res.setResponseCode(201);
			if(user1==null)
			{
			res.setResponseMessage(Constants.user_Does_Not_Exist_In_System);
			}
			else
			{
				res.setResponseMessage(Constants.user_Not_Allowed_To_Access);
			}
			res.setUser(null);
			res.setLogin(null);
			res.setTileMaster(null);

		}
		else
		{
			//res.setRoleMaster(CommonController.roleMaster);
			//masterResponseModel.setRoleToTilemapping(roleToTilemappingService.tripListByEmailId(userEmail));
			//CommonController commonController=new CommonController();
			
			res.setTileMaster(roleMasterService.getTilesForUser(user1));
			res.setMasterResponseModel(commonController.masterResponseModelData);
			//res.setMasterResponseModel(commonController.getMasterDataFromDB());
			
			
			
			if(user1!=null)
			{
				res.setUser(user1);
			}
			res.setLogin(loginService.getLogin(token,userId,userEmail));
			if(user1!=null)
			{
				//res.setTileMaster(roleMasterService.getTilesForUser(user1));
				//tileList=userService.getRoleData(user1,roleMaster);
				
			}

		}return res;
	}

	
	/*@GetMapping("/downloadFile1/{fileName:.+}")
	public ResponseEntity<Resource> loadFileAsResourceWithoutZip(@RequestParam("filePath") String filePath,HttpServletRequest request) {
		// Load file as Resource
		logger.info("In downloadFile1 method entry---->");
		ResponseEntity<Resource> response;
		Resource resource = fileStorageService.loadFileAsResourceWithoutZip(filePath );
		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			logger.info("contentType--->" + contentType);
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}
		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		if (resource.exists()) {
			response = ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		} else {
			response = ResponseEntity.badRequest().contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		}
		logger.info("In downloadFile1 method exit---->");
		return response;
	}*/
}

