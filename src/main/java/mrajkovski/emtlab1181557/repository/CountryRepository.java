package mrajkovski.emtlab1181557.repository;

import mrajkovski.emtlab1181557.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
