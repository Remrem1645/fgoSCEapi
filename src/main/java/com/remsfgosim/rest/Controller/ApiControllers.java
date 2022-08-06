package com.remsfgosim.rest.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.remsfgosim.rest.Models.CraftEssences;
import com.remsfgosim.rest.Models.Servants;
import com.remsfgosim.rest.Repo.CraftEssencesRepo;
import com.remsfgosim.rest.Repo.ServantRepo;
import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private ServantRepo servantRepo;
    private CraftEssencesRepo craftEssencesRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "FgoServantCEapi";
    }
    
    //SERVANT DATA
    @GetMapping(value = "/servants")
    public List<Servants> getServants() {
        return servantRepo.findAll();
    }

    @PostMapping(value = "/saveServants")
    public String saveServants(@RequestBody Servants servant){
        servantRepo.save(servant);
        return "Added " + servant.getName();
    }

    @PutMapping(value = "/updateServant/{id}")
    public String updateServant(@PathVariable long id, @RequestBody Servants servant){
        Servants updatedServants = servantRepo.findById(id).get();
        updatedServants.setName(servant.getName());
        updatedServants.setRarity(servant.getRarity());
        updatedServants.setType(servant.getType());
        updatedServants.setImgLink(servant.getImgLink());
        servantRepo.save(updatedServants);
        return "Updated ID: " + id;
    }

    @DeleteMapping(value = "/removeServant/{id}")
    public String removeServant(@PathVariable long id){
        Servants removeServant = servantRepo.findById(id).get();
        servantRepo.delete(removeServant);
        return "Removed ID:" + id;
    }

    @RequestMapping(value="/servants/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Servants getServantById(@PathVariable("id") long itemid) {   
        Servants i = servantRepo.findById(itemid).get();              
        return i;
    }

    @RequestMapping(value="/servants/rarity/{rarity}", method = RequestMethod.GET)
    public @ResponseBody
    List<Servants> getServantsByRarity(@PathVariable("rarity") int rarity) {   
        List<Servants> list = servantRepo.findByRarity(rarity);              
        return list;
    }

    @RequestMapping(value="/servants/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    List<Servants> getServantsByRarity(@PathVariable("type") String type) {   
        List<Servants> list = servantRepo.findByType(type);              
        return list;
    }

    @RequestMapping(value = "/servants/rarity/{rarity}/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    List<Servants> getServantsByRarityAndRarity(@PathVariable("rarity") int rarity, @PathVariable("type") String type){
        List<Servants> list = servantRepo.findByRarity(rarity);
        list = servantRepo.findByType(type);
        return list;
    }

    //CE DATA
    @GetMapping(value = "/ces")
    public List<CraftEssences> getCraftEssences() {
        return craftEssencesRepo.findAll();
    }

    @PostMapping(value = "/saveCes")
    public String saveServants(@RequestBody CraftEssences craftEssences){
        craftEssencesRepo.save(craftEssences);
        return "Added " + craftEssences.getName();
    }

}
