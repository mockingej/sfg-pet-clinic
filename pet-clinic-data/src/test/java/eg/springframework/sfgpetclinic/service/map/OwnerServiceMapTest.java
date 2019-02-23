package eg.springframework.sfgpetclinic.service.map;

import eg.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());

    }

    @Test
    void saveNoId() {
        Owner saved = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saved);
        assertNotNull(saved.getId());
    }

    @Test
    void findByLastName() {
        Owner saved = ownerServiceMap.findByLastName(lastName);
        assertNotNull(saved);

        assertEquals(lastName, saved.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner saved = ownerServiceMap.findByLastName("foo");
        assertNull(saved);
    }
}