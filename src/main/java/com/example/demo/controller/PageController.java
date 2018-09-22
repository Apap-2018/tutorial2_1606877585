package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import com.example.demo.Util.Util;

/**
 * Page controller used as a controller for the page
 */
@Controller
public class PageController {

    /**
     * Method that handling the mapping for /viral
     * Return viral.html
     * @return
     */
    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }
    /**
     * Method that handling the mapping for /challenge
     * Require param name that will be used in html
     * Returning challenge.html , the param name also will be parse in html
     * @return
     */
    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value = "name")String name , Model model){
        model.addAttribute("name", name);
        return "challenge";
    }

    /**
     * Method that handling the mapping for /challenge or /challenge/[certain String]
     * If [certain string] is present that name will be use in the html
     * Otherwise the name will be "KB"
     * Return challenge.html
     * @return
     */
    @RequestMapping(value = {"challenge","challenge/{name}"})
    public String challengePath(@PathVariable Optional<String> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name",name.get());
        }
        else {
            model.addAttribute("name","KB");
        }

        return "challenge";
    }
    /**
     * Method that handling the mapping for /generator
     * Asking two parameter for a and b which is the value of our text
     * a representing how many letter m in the text
     * b representing how many text will be presented in the html
     * If one or both parameter is absent , the default value will be 0 and only one
     * letter each null value of the parameter will be presented
     * If the input is a string that can't converted to Integer then 0 default value
     * will be used.
     * Returning generator.html
     * @return
     */
    @RequestMapping("/generator")
    public String generator(@RequestParam(value = "a",required = false) String a,@RequestParam(value = "b",required = false) String b,Model model){
        if (a==null)
            a="0";
        if (b==null)
            b="0";
        int aNum = 0,bNum = 0;
        try {
            aNum = Integer.parseInt(a);
            bNum = Integer.parseInt(b);
        }catch (NumberFormatException e){
            a= "0" ;
            b = "0";
        }
        String res ;
        String m = "m";
        if (aNum>0){
            m = Util.generateStringTimes(aNum,m);
        }
        res = "h"+m;
        if (bNum>0){
            res = Util.generateStringTimes(bNum,res+ " ");
        }
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("res",res);

        return "generator";
    }


}
