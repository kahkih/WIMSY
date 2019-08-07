package io.wimsy.projectwimsy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.wimsy.projectwimsy.domain.Form;
import io.wimsy.projectwimsy.service.FormService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class FormEndpoint {

	@Autowired
	FormService formService;
	
	@PostMapping(path="containers")
	public void newForm(@RequestBody Form form) {
		this.formService.save(form);
    }
	
}