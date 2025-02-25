package de.htmlfit.run;


import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.ExerciseBuild;
import de.htmlfit.domain.Muscle;
import de.htmlfit.domain.NumberBean;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.domain.TrainingEquipment;
import de.htmlfit.services.ExerciseBuildService;
import de.htmlfit.services.ExerciseService;
import de.htmlfit.services.MuscleService;
import de.htmlfit.services.TrainingDayService;
import de.htmlfit.services.TrainingEquipmentService;



@Controller
public class HtmlfitController {
	ArrayList<Muscle> musclesAsObject;
	
	@Autowired
	private MuscleService muscleService;
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseBuildService exerciseBuildService;
	
	@Autowired
	private TrainingDayService trainingDaysService;
	
	@Autowired
	private TrainingEquipmentService trainingEquipmentService;
	
	private int countEx;
	
	ArrayList<Muscle> musclesForSelect = new ArrayList<Muscle>();
	Collection<TrainingEquipment> selectedEq = new ArrayList<TrainingEquipment>();
	Collection<Exercise> selectedExercises = new ArrayList<Exercise>();
	Collection<ExerciseBuild> selectedExercisesBuild = new ArrayList<ExerciseBuild>();
	ArrayList<Muscle> musclesSelected = new ArrayList<Muscle>();
	ArrayList<Muscle> musclesSelected2 = new ArrayList<Muscle>();
	ArrayList<TrainingDay> trainingDays=new ArrayList<TrainingDay>();

	void selectExercise()
	{
		musclesForSelect=musclesSelected2;
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
		    	
		    	if(i>=j) {
	    			toAdd=element;
	    			
	    			j=i;
	    			i=0;
	    		}
			}
			boolean test = exercises.remove(exerciseService.findById(toAdd.getId()).get());
			System.out.println("Test:gelöscht="+test);
			j=0;

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
	
	void deleteExercisesWithNotSelectedEq()
	{
		ArrayList<ExerciseBuild> exercisesBuild = (ArrayList<ExerciseBuild>) exerciseBuildService.findAll();
		for (ExerciseBuild element : exercisesBuild){
			
		  
			
			for (TrainingEquipment te : element.getTrainingEquipment()) {
				if (!selectedEq.contains(te)){
					exercisesBuild.remove(element);
					System.out.println(element.getName()+" deleted");
				}
				
			}
		}
	}
	
	void selectExerciseBuild()
	{
		musclesForSelect=musclesSelected;
		int i=0;
		int j=0;
		int exerc=countEx;
		ExerciseBuild toAdd=new ExerciseBuild();
		
		//TODO: delete exercises with not selected equipment
		ArrayList<ExerciseBuild> exercisesBuild = (ArrayList<ExerciseBuild>) exerciseBuildService.findAll();
		
		
		for(int k=0;k<exerc;k++)
		{
			
			for (ExerciseBuild element : exercisesBuild){
		    	for(Muscle mElement: musclesForSelect ) {
		    		if(element.getMuscles().contains(mElement)) {
		    			i++;
		    		}
		    	}
		    	
		    	if(i>=j) {
	    			toAdd=element;
	    			
	    			
	    			j=i;
	    			i=0;
	    		}
			}
			
			boolean test = exercisesBuild.remove(exerciseBuildService.findById(toAdd.getId()).get());
			
			System.out.println("Test:gelöscht="+test);
			j=0;
			
			/*Iterator<Muscle> iter = musclesForSelect.iterator();

			while (iter.hasNext()) {
			    Muscle m = iter.next();

			    if(toAdd.getMuscles().contains(m)) {
			        //todo:
			    	//und wenn keine weiteren Übungen mit entspr. Muskel
			    	iter.remove();
			    }
			}
			
			if(musclesForSelect.size()==0) {
				musclesForSelect=musclesAsObject;
			}*/
			selectedExercisesBuild.add(toAdd);
		}
	}
	
	@RequestMapping(value = "/select/", method = RequestMethod.GET)
	public String addImage2Get(Model model) {
		

		if(selectedExercises.size()>0) {
			selectedExercises=new ArrayList<Exercise>();
		}
		
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
		musclesSelected.add(m.get());
		musclesSelected2.add(m.get());
		musclesAsObject.add(m.get());
		String returnStr="redirect:/show/";
		return returnStr;
	}
	
	@RequestMapping(value = "/selectTE/", method = RequestMethod.GET)
	public String selectTrainingEquipmentGet(Model model) {
		

		/*if(selectedEq.size()>0) {
			selectedEq=new ArrayList<TrainingEquipment>();
		}*/
		
		List<TrainingEquipment> eqList;
		eqList = trainingEquipmentService.findAll();
		model.addAttribute("equipment", eqList);
		
		TrainingEquipment eqForResult=new TrainingEquipment();
		model.addAttribute("eqRes",eqForResult);
		return "selectEq";
	}
	
	@RequestMapping(value = "/selectTE/", method = RequestMethod.POST)
	public String selectTrainingEquipment(@ModelAttribute("muscle") TrainingEquipment eqForResult) { 
		Optional<TrainingEquipment> e =trainingEquipmentService.findById(eqForResult.getId());
		/*for(int i=0;i<muscles.size();i++) {
			Optional<Muscle> m = muscleService.findById((long)( muscles.get(i)));
			musclesAsObject.add(m.get());
			System.out.println(i);
		}*/
		selectedEq.add(e.get());
		//musclesSelected.add(m.get());
		//musclesSelected2.add(m.get());
		//musclesAsObject.add(m.get());
		String returnStr="redirect:/showEq/";
		return returnStr;
	}

	@GetMapping(value = "/")
	public String start() {
		
		musclesAsObject  = new ArrayList<Muscle>();
		musclesForSelect = new ArrayList<Muscle>();
		selectedExercises = new ArrayList<Exercise>();
		selectedExercisesBuild = new ArrayList<ExerciseBuild>();
		musclesSelected = new ArrayList<Muscle>();
		musclesSelected2 = new ArrayList<Muscle>();
		trainingDays=new ArrayList<TrainingDay>();
		String returnStr="redirect:/select/";
		
		return returnStr;
	}
	
	@GetMapping(value = "/hiit/")
	public String time(Model model) {
		model.addAttribute("exercises",selectedExercises);
		return "time";
	}
	
	@RequestMapping(value = "/show/", method = RequestMethod.GET)
	public String showGet(Model model) {
		NumberBean nB=new NumberBean();
		model.addAttribute("count",nB);
		model.addAttribute("resultMuscles",musclesAsObject);
		return "showMuscles";
	}
	
	@RequestMapping(value = "/show/", method = RequestMethod.POST) 
	public String show(@ModelAttribute("count") NumberBean count) {

		countEx = count.getCount();
		String returnStr = "redirect:/exerc/";
		System.out.println("eingegeben :"+count.getCount() );
		return returnStr;
	}
	
	@RequestMapping(value = "/showEq/", method = RequestMethod.GET)
	public String showGetEq(Model model) {
		NumberBean nB=new NumberBean();
		model.addAttribute("count",nB);
		model.addAttribute("resultEq",selectedEq);
		return "showEquipment";
	}
	
	@RequestMapping(value = "/showEq/", method = RequestMethod.POST) 
	public String showEq() {


		String returnStr = "redirect:/select/";

		return returnStr;
	}
	
	@GetMapping(value = "/delete/")
	public String delete() {
		//musclesAsObject=new ArrayList<Muscle>();
		String returnStr="redirect:/select/";
		return returnStr;
	}
	
	@RequestMapping(value = "/exerc/",method = RequestMethod.GET)
	public String showExerc(Model model) {
		String returnStr = "showExerciss";
		if (musclesAsObject.size()>0)
		{
			
			model.addAttribute("resultMusclesA",musclesSelected);
			
			selectExercise();

			model.addAttribute("exercises",selectedExercises);
			
			selectExerciseBuild();
			model.addAttribute("exercisesBuild",selectedExercisesBuild);
			
			TrainingDay trDay = new TrainingDay();
			ArrayList<Exercise> ExTrDay = new ArrayList<Exercise>();
			ArrayList<ExerciseBuild> ExBTrDay = new ArrayList<ExerciseBuild>();
			
			/*ExTrDay = selectedExercises;
			ExBTrDay = selectedExercisesBuild;*/
			trDay.setExercise(selectedExercises);
			
			trDay.setExerciseBuild(selectedExercisesBuild);
			
			
			trainingDaysService.save(trDay);

			
		}
		
		return returnStr;
	}
	
	@RequestMapping(value = "/tDays/",method = RequestMethod.GET)
	public String showTDays(Model model) {
		String returnStr = "showTrainingDays";
		trainingDays = (ArrayList<TrainingDay>) trainingDaysService.findAll();
		model.addAttribute("trainingDays",trainingDays);
		return returnStr;
	}
	
	/*@GetMapping(value = "/exercB/")
	public String showExercB(Model model) {
		String returnStr = "showExerciss";
		
			model.addAttribute("resultMusclesA",musclesSelected);
			
			model.addAttribute("exercises",selectedExercises);

			model.addAttribute("exercisesBuild",selectedExercisesBuild);
		
		return returnStr;
	}
	*/
	@GetMapping("/show/{id}")
	public String showTd(@PathVariable("id") long id, Model model) {
		String returnStr = "showExercissWithoutMuscles";
		Optional<TrainingDay> td =trainingDaysService.findById(id);
		model.addAttribute("exercises",td.get().getExercise());
		model.addAttribute("exercisesBuild",td.get().getExerciseBuild());
		return returnStr;
	}
	
}
