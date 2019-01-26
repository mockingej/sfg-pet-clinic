package eg.springframework.sfgpetclinic.bootstrap;

import eg.springframework.sfgpetclinic.model.Owner;
import eg.springframework.sfgpetclinic.model.Pet;
import eg.springframework.sfgpetclinic.model.PetType;
import eg.springframework.sfgpetclinic.model.Vet;
import eg.springframework.sfgpetclinic.service.OwnerService;
import eg.springframework.sfgpetclinic.service.PetTypeService;
import eg.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Baker St.");
        owner1.setCity("New York");
        owner1.setTelephone("1234098921");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenane");
        owner2.setAddress("123 Baker St.");
        owner2.setCity("New York");
        owner2.setTelephone("1234098321");

        Pet fionaCat = new Pet();
        fionaCat.setName("catty");
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setOwner(owner2);
        fionaCat.setPetType(savedCatPetType);

        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets");


    }
}
