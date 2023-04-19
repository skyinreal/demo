package com.example.demo.controller;

import com.example.demo.model.Act;
import com.example.demo.model.Locomotive;
import com.example.demo.service.ActService;
import com.example.demo.service.LocomotiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActController {
    private final ActService actService;
    private final LocomotiveService locomotiveService;

    @Autowired
    public ActController(ActService actService, LocomotiveService locomotiveService) {
        this.actService = actService;
        this.locomotiveService = locomotiveService;
    }

    @GetMapping("/certificate")
    public String certificatePage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "certificate";
    }

    @GetMapping("/certificate/show")
    public String showAllActs(Model model){
        Iterable<Act> acts = actService.getActs();
        model.addAttribute("acts", acts);
        return "showActs";
    }

    @GetMapping("/certificate/add")
    public String addActHTML(Model model){
        return "addAct";
    }

    @GetMapping("/certificate/show/{number}")
    public String editActHTML(@PathVariable(value = "number") String number,Model model){
        ArrayList<Act> acts = new ArrayList<>();
        acts.add(getAct(number));
        model.addAttribute("acts", acts);
        return "showAct";
    }

    @GetMapping(value = "/certificate/show/{number}", params = {"number"})
    public Act getAct(@PathVariable(value = "number") @RequestParam String number){
        Act act = actService.getByNumber(number);
        List<Act> acts = new ArrayList<>();
        acts.add(act);
        return act;
    }

    @PostMapping("/certificate/add")
    public String createAct(@RequestParam String number, @RequestParam String date, @RequestParam String company, @RequestParam String kind_of_work, @RequestParam String series, @RequestParam String factory_name, @RequestParam String section_index, @RequestParam String home_depot, @RequestParam String work_fact ,Model model){
        Locomotive locomotive = new Locomotive(series,factory_name,section_index,home_depot,work_fact);
        Act act = new Act(locomotive,number,date,company,kind_of_work);
        locomotiveService.save(locomotive);
        actService.save(act);
        return "redirect:/certificate";
    }

    @GetMapping("/certificate/show/{number}/edit")
    public String editHTML(@PathVariable(value = "number") String number,Model model) {
        System.out.println(actService.getByNumber(number));
        ArrayList<Act> acts = new ArrayList<>();
        acts.add(actService.getByNumber(number));
        model.addAttribute("act", acts);
        return "edit";
    }

}
