package org.example;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/title")
public class IndexController {
    @GetMapping("/index")
    public String getIndex(@RequestParam(value = "id", required = false) String id,
                           @RequestParam(value = "num", required = false) String num,
                            Model model){
        System.out.println(id + " " + num);
        model.addAttribute("id",id);
        model.addAttribute("num",num);
        return "index";
    }

    @GetMapping("/index2")
    public String getIndex(){
        return "index2";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam(value = "value") int value,
                            @RequestParam(value = "val1") String val1,
                            @RequestParam(value = "val2") String val2,
                            Model model){
        model.addAttribute("value",value);
        model.addAttribute("val1",val1);
        model.addAttribute("val2",val2);
        if(val1.equals("rub")){
            switch (val2){
                case("euro"):
                    model.addAttribute("val",value*0.0102);
                    break;
                case ("tenge"):
                    model.addAttribute("val",value*5.0696);
            }
        } else if (val1.equals("euro")) {
            switch (val2){
                case("rub"):
                    model.addAttribute("val",value*97.8745);
                    break;
                case ("tenge"):
                    model.addAttribute("val",value*496.1826);
            }
        } else if (val1.equals("tenge")) {
            switch (val2){
                case("euro"):
                    model.addAttribute("val",value*0.0020);
                    break;
                case ("rub"):
                    model.addAttribute("val",value*0.1973);
            }
        }
        else{
            model.addAttribute("val","errorroorororororor");
        }
        return "converter";
    }
}


