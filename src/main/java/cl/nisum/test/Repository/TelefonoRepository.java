package cl.nisum.test.Repository;

import cl.nisum.test.Entity.Telefono;
import cl.nisum.test.VO.ResponseVO;
import cl.nisum.test.VO.TelefonoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TelefonoRepository  extends JpaRepository<Telefono, Integer> {
    @Query("select new cl.nisum.test.VO.TelefonoVO(r.number, r.citycode, r.countrycode) " +
            "from Telefono r " +
            "where r.idsuario.id = :id")
    List<TelefonoVO> getByIdUsuario(@Param("id") UUID id);
}
