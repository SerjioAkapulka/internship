package com.intership.repositories;

import com.intership.models.Mobile;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface MobileRepository extends CrudRepository<Mobile, UUID> {

}
