package productcrudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/printing")
	public String home() {
		return "printing";
	}
	@RequestMapping("/str")
	@ResponseBody
	public String home1() {
		return "hii string is printed";
	}

}
