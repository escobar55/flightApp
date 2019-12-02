package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ObjectUtils;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listFlight(Model model){
       model.addAttribute("flights", flightRepository.findAll());
       return "list";
    }

    //Add the search list here (lets add it and comment) ***
    @PostMapping("/searchlist")
    public String search(Model model, @RequestParam("search") String search){
        model.addAttribute("flights", flightRepository.findBydepartingAirportContainingIgnoreCaseOrAirlineContainingIgnoreCase(search, search));
        return "searchlist";
    }
    //its added *******

    @GetMapping("/add")
    public String flightForm(Model model){
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute Flight flight, BindingResult result,
                              @RequestParam("file")MultipartFile file){
        if(result.hasErrors()){
            return "flightform";
        }
        if(file.isEmpty()){
            return "redirect:/add";
        }
        try {
            Map uploadResults = cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
        }
    }
}
