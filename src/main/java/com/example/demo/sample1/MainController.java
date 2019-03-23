package com.example.demo.sample1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.DataObject;

@Controller
public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "お名前を書いて送信してください");
		DataObject obj = new DataObject(2,"sampleさん");
		mav.addObject("object", obj);
        return mav;
    }
	
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("text1")String str,ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "こんにちは" + str + "さん");
		mav.addObject("value", str);
		DataObject obj = new DataObject(2,"sampleさん");
		mav.addObject("object", obj);
		mav.setViewName("index");
        return mav;
    }
}
