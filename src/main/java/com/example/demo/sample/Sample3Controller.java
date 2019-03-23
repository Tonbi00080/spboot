package com.example.demo.sample;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.DataObject;

@Controller
public class Sample3Controller {
	@RequestMapping(value="/sample3", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(1,"sample1さん"));
 		data.add(new DataObject(2,"sample2さん"));
 		data.add(new DataObject(3,"sample3さん"));
 		mav.addObject("data", data);
		mav.setViewName("sample3");
        return mav;
    }
}
