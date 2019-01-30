package eg.springframework.sfgpetclinic.service.map;

import eg.springframework.sfgpetclinic.model.Pet;
import eg.springframework.sfgpetclinic.model.Visit;
import eg.springframework.sfgpetclinic.service.PetService;
import eg.springframework.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = {"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    private final VisitService visitService;

    public PetServiceMap(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {

        if (object.getVisits().size() > 0) {
            object.getVisits().forEach(visit -> {
                if (visit.getId() == null) {
                    Visit savedVisit = visitService.save(visit);
                    visit.setId(savedVisit.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
