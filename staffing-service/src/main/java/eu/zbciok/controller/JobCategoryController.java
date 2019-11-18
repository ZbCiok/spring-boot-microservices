package eu.zbciok.controller;

import eu.zbciok.dto.JobCategoryDTO;
import eu.zbciok.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/job-categories")
public class JobCategoryController {

    @Autowired JobCategoryService jobCategoryService;
    
    @Value("${spring.datasource.url}")
    private String url;   
    
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;     
    
    @Value("${spring.datasource.username}")
    private String username;   
    
    @Value("${spring.datasource.password}")
    private String password;     
    
    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;       
    
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;        
    
    @GetMapping
    public ResponseEntity<List<JobCategoryDTO>> getJobCategories() {
        List<JobCategoryDTO> jobCategoriesData = jobCategoryService.getJobCategories();
        return new ResponseEntity<>(jobCategoriesData, HttpStatus.OK);
    }

    @PostMapping(value = "/job-category")
    public ResponseEntity<JobCategoryDTO> createJobCategory(@RequestBody JobCategoryDTO jobCategory) {
        final JobCategoryDTO jobCategoryData = jobCategoryService.createJobCategory(jobCategory);
        return new ResponseEntity<>(jobCategoryData, HttpStatus.CREATED);
    }

    @DeleteMapping("/job-category/{id}")
    public ResponseEntity<String> deleteJobCategory(@PathVariable Long id) {
        jobCategoryService.deleteJobCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/job-category/{id}")
    public ResponseEntity<JobCategoryDTO> getJobCategory(@PathVariable Long id) {
    	JobCategoryDTO jobCategoryData = jobCategoryService.getJobCategory(id);
        return new ResponseEntity<>(jobCategoryData, HttpStatus.OK);
    }
    
    @GetMapping("/showConfig")
    @ResponseBody
    public String showConfig() {
        String configInfo = "<br /> url = " +this.url +
        					"<br /> driverClassName = " + this.driverClassName +
        					"<br /> username = " + this.username + 
        					"<br /> password = " + this.password +
        					"<br /> databasePlatform = " + this.databasePlatform +
        					"<br /> hbm2ddlAuto = " + this.hbm2ddlAuto;        
        return configInfo;
    }    
}
