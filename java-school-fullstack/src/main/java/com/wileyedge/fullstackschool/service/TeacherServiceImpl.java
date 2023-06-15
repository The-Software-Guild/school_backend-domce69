package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.TeacherDao;
import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    //YOUR CODE ENDS HERE

    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE 	
        return teacherDao.getAllTeachers();
        //YOUR CODE ENDS HERE
    }

    public Teacher getTeacherById(int id) {
        //YOUR CODE STARTS HERE
    	
    	Teacher t = teacherDao.findTeacherById(id);
        return t;

        //YOUR CODE ENDS HERE
    }

    public Teacher addNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE
    	Teacher t = teacherDao.createNewTeacher(teacher);
        return t;

        //YOUR CODE ENDS HERE
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {
        //YOUR CODE STARTS HERE
    	
    	if(id == teacher.getTeacherId()) {
    		teacherDao.updateTeacher(teacher);
    	} else {
    		teacher.setTeacherFName("IDs do not match, teacher not updated");
    		teacher.setTeacherLName("IDs do not match, teacher not updated");
    	}
 
    	return teacher;
        //YOUR CODE ENDS HERE
    }

    public void deleteTeacherById(int id) {
        //YOUR CODE STARTS HERE

    	teacherDao.deleteTeacher(id);

        //YOUR CODE ENDS HERE
    }
}
