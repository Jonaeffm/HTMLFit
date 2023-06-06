package de.htmlfit.run;


import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;
import de.htmlfit.services.ExerciseService;
import de.htmlfit.services.MuscleService;



@Controller
public class HtmlfitController {
	ArrayList<Muscle> musclesAsObject = new ArrayList<Muscle>();
	
	@Autowired
	private MuscleService muscleService;
	@Autowired
	private ExerciseService exerciseService;
	
	ArrayList<Muscle> musclesForSelect = new ArrayList<Muscle>();
	ArrayList<Exercise> selectedExercises = new ArrayList<Exercise>();
	
	void selectExercise()
	{
		musclesForSelect=musclesAsObject;
		int i=0;
		int j=0;
		int exerc=4;
		Exercise toAdd=new Exercise();
		ArrayList<Exercise> exercises = (ArrayList<Exercise>) exerciseService.findAll();
		for(int k=0;k<exerc;k++)
		{
			for (Exercise element : exercises){
		    	for(Muscle mElement: musclesForSelect ) {
		    		if(element.getMuscles().contains(mElement)) {
		    			i++;
		    		}
		    	}
		    	if(i>j) {
	    			toAdd=element;
	    			j=i;
	    			i=0;
	    		}
			}

/*			for (Muscle mElement2:musclesForSelect) {
				if(toAdd.getMuscles().contains(mElement2)) {
					musclesForSelect.remove(mElement2);
				}
			}*/
			
			Iterator<Muscle> iter = musclesForSelect.iterator();

			while (iter.hasNext()) {
			    Muscle m = iter.next();

			    if(toAdd.getMuscles().contains(m)) {
			        iter.remove();
			    }
			}
			
			if(musclesForSelect.size()==0) {
				musclesForSelect=musclesAsObject;
			}
			selectedExercises.add(toAdd);
		}
	}
	
	
	@RequestMapping(value = "/select/", method = RequestMethod.GET)
	public String addImage2Get(Model model) {
		
		List<Muscle> muscleList;
		muscleList = muscleService.findAll();
		model.addAttribute("muscles", muscleList);
		
		Muscle muscleForResult=new Muscle();
		model.addAttribute("muscle",muscleForResult);
		return "selectMuscle";
	}
	
	/**
	 *    @PostMapping
    public String save(Order order, Model model) {
        model.addAttribute("order", order);
        return "saved";
	 * @param muscleList
	 * @return@ModelAttribute("images") Image imageToAdd
	 */
	@RequestMapping(value = "/select/", method = RequestMethod.POST)
	public String addImage2Post(@ModelAttribute("muscle") Muscle muscleForResult) { 
		Optional<Muscle> m =muscleService.findById(muscleForResult.getId());
		/*for(int i=0;i<muscles.size();i++) {
			Optional<Muscle> m = muscleService.findById((long)( muscles.get(i)));
			musclesAsObject.add(m.get());
			System.out.println(i);
		}*/
		musclesAsObject.add(m.get());
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
	
	@GetMapping(value = "/exerc/")
	public String showExerc(Model model) {
		selectExercise();
		model.addAttribute("exercises",selectedExercises);
		String returnStr = "showExerciss";
		
		return returnStr;
	}
	
}
