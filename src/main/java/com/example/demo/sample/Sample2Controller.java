package com.example.demo.sample;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.DataObject;

@Controller
public class Sample2Controller {
	@RequestMapping(value="/sample2", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
		Random random = new Random();
		int randomValue = random.nextInt(100);
		mav.addObject("check", randomValue % 2 == 0);
		mav.addObject("msg", randomValue + "は偶数です");
		mav.addObject("msg2", randomValue + "は奇数です");
		mav.setViewName("sample2");
        return mav;
    }
}
