package com.ourTestProjectFive.controller;

import com.ourTestProjectFive.context.BooleanPropertyEditor;
import com.ourTestProjectFive.context.DatePropertyEditor;
import com.ourTestProjectFive.manager.MemberManager;
import com.ourTestProjectFive.model.Member;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author Kent Yeh
 */
@ControllerAdvice 
public class ControlBinder {
    @Autowired
    private MemberManager memberManager;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DatePropertyEditor());
        binder.registerCustomEditor(Boolean.class, new BooleanPropertyEditor());
        binder.registerCustomEditor(Member.class, memberManager);
    }
}
