package de.htmlfit.run;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.picsheep.domain.Album;
import de.picsheep.domain.Image;
import de.picsheep.domain.ImagePath;

@Controller
public class HtmlfitController {
	@RequestMapping(value = "/addImage2", method = RequestMethod.GET)
	public String addImage2Get(Model model) {
		
		MuscleList = albumService.findAll();
		model.addAttribute("albums", AlbumList);
		return "insert2";
	}

	@RequestMapping(value = "/addImage2", method = RequestMethod.POST)
	public String addImage2Post(@ModelAttribute("images") Image imageToAdd,
			@ModelAttribute("imagePath") ImagePath path) {
		Album a = albumService.findById(path.getAlbumId()).get();
		cImage.setAlbum(a);
		cImage.setName(imageToAdd.getName());
		imageService.save(cImage);
		System.out.print("test " + path.getPath());
		System.out.println("Name: " + imageToAdd.getName());
		System.out.println("Album: " + path.getAlbumId());
		String returnStr = "redirect:/";
		return returnStr;
	}
}
