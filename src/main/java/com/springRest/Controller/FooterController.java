package com.springRest.Controller;

import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("footer")
public class FooterController
{
    @GetMapping("/pharmacy")
    public String getPharmacyPage()
    {
        return "pharmacy/pharmacy";
    }

    @GetMapping("/api")
    public String getAPI()
    {
        return "API/api";
    }
    @GetMapping("/emergency")
    public String getEmergencyPage()
    {
        return "emergency/emergency";
    }

    @GetMapping("/nursing")
    public String getNursingPage()
    {
        return "nursing/nursing";
    }

    @GetMapping("/team")
    public String getTeamPage()
    {
        return "Team/team";
    }

    @GetMapping("/career")
    public String getCareerPage()
    {
        return "career/career";
    }
}

