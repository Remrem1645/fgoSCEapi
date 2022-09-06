package com.remsfgosim.rest.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.remsfgosim.rest.Models.*;
import com.remsfgosim.rest.Repo.*;
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
        return "Updated Servant ID: " + id;
    }

    @DeleteMapping(value = "/removeServant/{id}")
    public String removeServant(@PathVariable long id){
        Servants removeServant = servantRepo.findById(id).get();
        servantRepo.delete(removeServant);
        return "Removed Servant ID: " + id;
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
    List<Servants> getServantsByType(@PathVariable("type") String type) {   
        List<Servants> list = servantRepo.findByType(type);              
        return list;
    }

    @RequestMapping(value = "/servants/rarity/{rarity}/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    List<Servants> getServantsByRarityAndType(@PathVariable("rarity") int rarity, @PathVariable("type") String type){
        List<Servants> list = servantRepo.findByRarity(rarity);
        list = servantRepo.findByType(type);
        return list;
    }

    //CE DATA
    @GetMapping(value = "/ces")
    public List<CraftEssences> getCraftEssences() {
        return craftEssencesRepo.findAll();
    }

    @PostMapping(value = "/saveCe")
    public String saveCraftEssence(@RequestBody CraftEssences craftEssences){
        craftEssencesRepo.save(craftEssences);
        return "Added " + craftEssences.getName();
    }

    @PutMapping(value = "/updateCes/{id}")
    public String updateCe(@PathVariable long id, @RequestBody CraftEssences craftEssences){
        CraftEssences updatedCe = craftEssencesRepo.findById(id).get();
        updatedCe.setName(craftEssences.getName());
        updatedCe.setRarity(craftEssences.getRarity());
        updatedCe.setType(craftEssences.getType());
        updatedCe.setImgLink(craftEssences.getImgLink());
        craftEssencesRepo.save(updatedCe);
        return "Updated CE ID: " + id;
    }

    @DeleteMapping(value = "/removeCe/{id}")
    public String removeCe(@PathVariable long id){
        CraftEssences removeCe = craftEssencesRepo.findById(id).get();
        craftEssencesRepo.delete(removeCe);
        return "Removed CE ID: " + id;
    }

    @RequestMapping(value="/ces/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    CraftEssences getCeById(@PathVariable("id") long itemid) {   
        CraftEssences i = craftEssencesRepo.findById(itemid).get();              
        return i;
    }

    @RequestMapping(value="/ces/rarity/{rarity}", method = RequestMethod.GET)
    public @ResponseBody
    List<CraftEssences> getCesByRarity(@PathVariable("rarity") int rarity) {   
        List<CraftEssences> list = craftEssencesRepo.findByRarity(rarity);              
        return list;
    }

    @RequestMapping(value="/ces/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    List<CraftEssences> getCesByType(@PathVariable("type") String type) {   
        List<CraftEssences> list = craftEssencesRepo.findByType(type);              
        return list;
    }

    @RequestMapping(value = "/ces/rarity/{rarity}/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    List<CraftEssences> getCesByRarityAndType(@PathVariable("rarity") int rarity, @PathVariable("type") String type){
        List<CraftEssences> list = craftEssencesRepo.findByRarity(rarity);
        list = craftEssencesRepo.findByType(type);
        return list;
    }
}
