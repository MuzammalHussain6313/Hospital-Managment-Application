package com.springRest.Controller;

//import com.springRest.DAO.MedicineRepository;
import com.springRest.enitity.Medicine;
import com.springRest.enitity.Patient;
import com.springRest.service.MedicineService;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
import javax.persistence.EntityManager;
import java.util.List;


@Controller
@RequestMapping("/medicines")
public class MedicineController
{
    private MedicineService medicineService;
    private List<Medicine> themedicines;

    @Autowired
    private EntityManager em;

    public MedicineController(MedicineService medicineService)
    {
        //this.medicineRepository = medicineRepository;
        this.medicineService = medicineService;
    }

    @GetMapping("/list")
    public String listmedicines(Model theModel)
    {
        //HttpServletRequest request,
//        int page = 0; //default page number is 0 (yes it is weird)
//        int size = 10; //default page size is 10
//
//        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//            page = Integer.parseInt(request.getParameter("page")) - 1;
//        }
//
//        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//            size = Integer.parseInt(request.getParameter("size"));
//        }
        themedicines = medicineService.getAllmedicines();
        //medicineRepository.findAll(PageRequest.of(page, size))
        theModel.addAttribute("medicines", themedicines);
        return "medicine/list-medicines";
    }

    @GetMapping("/addMedicine")
    public String getmedicineForm(Model model)
    {
        Medicine themedicine = new Medicine();
        model.addAttribute("medicine",themedicine);
        return "medicine/addMedicine";
    }

    @PostMapping("/save")
    public String savemedicine(@ModelAttribute("medicine") Medicine themedicine)
    {
        medicineService.save(themedicine);
        return "redirect:/medicines/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("medicineId") int theID,Model model)
    {
        Medicine medicine = medicineService.findById(theID);
        model.addAttribute("medicine",medicine);
        return "medicine/addMedicine";
    }

    @GetMapping("/delete")
    public String deletemedicine(@RequestParam("medicineId") int theID)
    {
        Medicine a = em.find(Medicine.class, theID);
        for (Patient b : a.getPatientList()) {
            if (b.getMedicineList().size() == 1) {
                em.remove(b);
            } else {
                b.getMedicineList().remove(a);
            }
        }
        em.remove(a);
        medicineService.deleteById(theID);
        return "redirect:/medicines/list";
    }


}









