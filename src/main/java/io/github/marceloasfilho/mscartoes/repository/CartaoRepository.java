package io.github.marceloasfilho.mscartoes.repository;

import io.github.marceloasfilho.mscartoes.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    @Query(value = "SELECT * FROM cartao WHERE renda <=:renda", nativeQuery = true)
    List<Cartao> findByRendaLessThanEqual(@Param("renda") BigDecimal renda);
}
