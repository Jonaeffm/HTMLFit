package de.htmlfit.run;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import de.htmlfit.domain.Muscle;
import de.htmlfit.services.MuscleService;


@Controller
public class HtmlfitController {
	ArrayList<Muscle> musclesAsObject = new ArrayList<Muscle>();
	
	@Autowired
	private MuscleService muscleService;
	
	@RequestMapping(value = "/select/", method = RequestMethod.GET)
	public String addImage2Get(Model model) {
		
		List<Muscle> muscleList;
		muscleList = muscleService.findAll();
		model.addAttribute("muscles", muscleList);
		
		List<Integer> m = new ArrayList<Integer>();
		model.addAttribute("resultMuscles",m);
		return "selectMuscle";
	}

	@RequestMapping(value = "/select/", method = RequestMethod.POST)
	public String addImage2Post(@ModelAttribute("resultMuscles") ArrayList<Integer> muscles) {
		
		
		for(int i=0;i<muscles.size();i++) {
			Optional<Muscle> m = muscleService.findById((long) muscles.get(i));
			musclesAsObject.add(m.get());
		}
		String returnStr="redirect:/show/";
		return returnStr;
	}

	@GetMapping(value = "/")
	public String test() {
		
		
		return "success";
	}
	
	@GetMapping(value = "/hiit/")
	public String time() {
		
		
		return "time";
	}
	@GetMapping(value = "/show/")
	public String show(Model model) {
		model.addAttribute("resultMuscles",musclesAsObject);
		String returnStr = "showMuscles";
		
		return returnStr;
	}
}
