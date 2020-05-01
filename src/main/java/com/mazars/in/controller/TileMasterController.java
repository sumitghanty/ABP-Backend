package com.mazars.in.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.service.TileMasterService;

@RestController
public class TileMasterController {
	@Autowired
	private TileMasterService tileMasterService;
	@RequestMapping(value = "/createTile", method = RequestMethod.POST)
	public String createTile(@RequestBody List<TileMaster> tileMaster,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {
		String toFrontEnd=tileMasterService.save(tileMaster);
		return toFrontEnd ;

	}

}
