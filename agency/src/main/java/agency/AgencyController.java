package agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgencyController {

	@Autowired
	TravelAgent travelAgent;

	@RequestMapping("/")
	public String hello(Model model) {
        String message = travelAgent.getGuide();
        model.addAttribute("guideMessage", String.format("Your guide will be: %s", message));
		return "index";
	}

}
