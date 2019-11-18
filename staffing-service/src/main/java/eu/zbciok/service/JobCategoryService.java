package eu.zbciok.service;

import eu.zbciok.dao.entity.JobCategoryModel;
import eu.zbciok.dao.entity.JobCategoryRepository;
import eu.zbciok.dto.JobCategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobCategoryService {

    @Autowired JobCategoryRepository jobCategoryRepository;


    public JobCategoryDTO createJobCategory(final JobCategoryDTO jobCategoryDTO) {
    	JobCategoryModel jobCategoryModel = new JobCategoryModel();
        BeanUtils.copyProperties(jobCategoryDTO, jobCategoryModel);
        jobCategoryModel = jobCategoryRepository.save(jobCategoryModel);
        JobCategoryDTO jobCategoryData = new JobCategoryDTO();
        BeanUtils.copyProperties(jobCategoryModel, jobCategoryData);

        return jobCategoryData;
    }

    public List<JobCategoryDTO> getJobCategories() {
        List<JobCategoryModel> jobCategories = new ArrayList<>();
        jobCategoryRepository.findAll().forEach(jobCategories::add);

        List<JobCategoryDTO> jaboCategoryList = new ArrayList<>();
        for (JobCategoryModel jobCategoryModel : jobCategories) {
        	JobCategoryDTO jobCategoryDTO = new JobCategoryDTO();
            BeanUtils.copyProperties(jobCategoryModel, jobCategoryDTO);
            jaboCategoryList.add(jobCategoryDTO);
        }

        return jaboCategoryList;
    }

    public JobCategoryDTO getJobCategory(Long id) {

        Optional<JobCategoryModel> jobCategory = jobCategoryRepository.findById(id);
        JobCategoryDTO jobCategoryData = new JobCategoryDTO();
        BeanUtils.copyProperties(jobCategory.get(), jobCategoryData);
        return jobCategoryData;
    }

    public void deleteJobCategory(Long id) {
        jobCategoryRepository.deleteById(id);
    }
}
